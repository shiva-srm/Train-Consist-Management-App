import java.util.ArrayList;
import java.util.List;

// 1. Define the Custom Exception
class InvalidCapacityException extends Exception {
    public InvalidCapacityException(String message) {
        super(message);
    }
}

// 2. Domain Class with Validation Logic
class PassengerBogie {
    private String type;
    private int capacity;

    // Constructor enforces business rules
    public PassengerBogie(String type, int capacity) throws InvalidCapacityException {
        if (capacity <= 0) {
            // Throw custom exception if business rule is violated
            throw new InvalidCapacityException("Capacity must be greater than zero. Provided: " + capacity);
        }
        this.type = type;
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "Bogie[Type=" + type + ", Capacity=" + capacity + "]";
    }
}

public class TrainConsistApp {
    public static void main(String[] args) {
        List<PassengerBogie> consist = new ArrayList<>();

        System.out.println("--- UC14: Custom Exception Handling (Fail-Fast Validation) ---");

        // Scenario 1: Adding a Valid Bogie
        try {
            System.out.println("Attempting to add valid bogie...");
            PassengerBogie b1 = new PassengerBogie("Sleeper", 72);
            consist.add(b1);
            System.out.println("✔ Success: " + b1);
        } catch (InvalidCapacityException e) {
            System.out.println("❌ Error: " + e.getMessage());
        }

        // Scenario 2: Adding a Bogie with Zero Capacity
        try {
            System.out.println("\nAttempting to add bogie with 0 capacity...");
            PassengerBogie b2 = new PassengerBogie("AC Chair", 0);
            consist.add(b2);
        } catch (InvalidCapacityException e) {
            System.out.println("❌ Caught Expected Exception: " + e.getMessage());
        }

        // Scenario 3: Adding a Bogie with Negative Capacity
        try {
            System.out.println("\nAttempting to add bogie with negative capacity...");
            PassengerBogie b3 = new PassengerBogie("First Class", -10);
            consist.add(b3);
        } catch (InvalidCapacityException e) {
            System.out.println("❌ Caught Expected Exception: " + e.getMessage());
        }

        System.out.println("\nFinal Consist Size: " + consist.size());
        System.out.println("-------------------------------------------------------------");
    }
}