import java.util.Scanner;

// 1. Custom Runtime Exception
class CargoSafetyException extends RuntimeException {
    public CargoSafetyException(String message) {
        super(message);
    }
}

class GoodsBogie {
    private String shape; // "Cylindrical" or "Rectangular"
    private String currentCargo = "Empty";

    public GoodsBogie(String shape) {
        this.shape = shape;
    }

    // Method to assign cargo with safety logic
    public void assignCargo(String cargo) {
        System.out.println(">>> System: Validating assignment of " + cargo + " to " + shape + " bogie.");

        // Safety Rule: Petroleum MUST NOT go in Rectangular bogies
        if (shape.equalsIgnoreCase("Rectangular") && cargo.equalsIgnoreCase("Petroleum")) {
            throw new CargoSafetyException("SAFETY VIOLATION: Petroleum requires specialized Cylindrical bogies!");
        }

        this.currentCargo = cargo;
        System.out.println("✔ Assignment Successful.");
    }

    @Override
    public String toString() {
        return "Bogie[Shape=" + shape + ", Cargo=" + currentCargo + "]";
    }
}

public class TrainConsistApp {
    public static void main(String[] args) {
        GoodsBogie rectangularBogie = new GoodsBogie("Rectangular");

        System.out.println("--- UC15: Safe Cargo Assignment (try-catch-finally) ---");

        // Scenario: Attempting unsafe assignment
        processAssignment(rectangularBogie, "Petroleum");

        System.out.println();

        // Scenario: Attempting safe assignment
        processAssignment(rectangularBogie, "Coal");

        System.out.println("\nFinal State: " + rectangularBogie);
        System.out.println("-------------------------------------------------------");
    }

    public static void processAssignment(GoodsBogie bogie, String cargo) {
        try {
            bogie.assignCargo(cargo);
        } catch (CargoSafetyException e) {
            // Handle the runtime error gracefully
            System.out.println("❌ ERROR CAUGHT: " + e.getMessage());
            System.out.println("Action: Cargo rejected. Alerting logistics manager.");
        } finally {
            // Mandatory logic that always runs (logging/cleanup)
            System.out.println("[LOG]: Cargo validation cycle completed.");
        }
    }
}