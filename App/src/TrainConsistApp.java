import java.util.ArrayList;
import java.util.List;

// Simple class to represent a Goods Bogie for this UC
class GoodsBogie {
    String type; // e.g., "Cylindrical", "Rectangular"
    String cargo; // e.g., "Petroleum", "Coal", "Chemicals"

    public GoodsBogie(String type, String cargo) {
        this.type = type;
        this.cargo = cargo;
    }

    public String getType() { return type; }
    public String getCargo() { return cargo; }
}

public class TrainConsistApp {

    public static void main(String[] args) {
        // Step 1: Create a list of goods bogies (Simulating a train consist)
        List<GoodsBogie> consist = new ArrayList<>();
        consist.add(new GoodsBogie("Rectangular", "Coal"));
        consist.add(new GoodsBogie("Cylindrical", "Petroleum"));
        consist.add(new GoodsBogie("Rectangular", "Iron Ore"));
        consist.add(new GoodsBogie("Cylindrical", "Petroleum"));

        System.out.println("--- Train Consist Management System: UC12 (Safety Check) ---");

        // Step 2: Use Streams to validate safety rules
        // Rule: If type is "Cylindrical", cargo must be "Petroleum"
        boolean isSafe = consist.stream().allMatch(bogie -> {
            if (bogie.getType().equalsIgnoreCase("Cylindrical")) {
                return bogie.getCargo().equalsIgnoreCase("Petroleum");
            }
            return true; // Non-cylindrical bogies pass this specific safety check
        });

        // Step 3: Display Results
        displaySafetyStatus(isSafe);

        // Scenario 2: Unsafe Train
        System.out.println("\nAdding unsafe bogie (Cylindrical with Coal)...");
        consist.add(new GoodsBogie("Cylindrical", "Coal"));

        boolean isSafeAfterViolation = consist.stream().allMatch(bogie ->
                !bogie.getType().equalsIgnoreCase("Cylindrical") ||
                        bogie.getCargo().equalsIgnoreCase("Petroleum")
        );

        displaySafetyStatus(isSafeAfterViolation);
    }

    private static void displaySafetyStatus(boolean isSafe) {
        if (isSafe) {
            System.out.println("✅ SAFETY COMPLIANCE: PASSED");
            System.out.println("Result: The train formation is safe for departure.");
        } else {
            System.out.println("❌ SAFETY COMPLIANCE: FAILED");
            System.out.println("Result: Hazard detected! Cylindrical bogies must only carry Petroleum.");
        }
    }
}