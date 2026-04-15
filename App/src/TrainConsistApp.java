import java.util.ArrayList;
import java.util.List;

public class TrainConsistApp {

    public static void main(String[] args) {
        // Scenario 1: Empty Train (State Violation)
        List<String> emptyConsist = new ArrayList<>();
        System.out.println("--- UC20: Defensive Programming (State Validation) ---");
        System.out.println("Scenario 1: Searching an empty train consist...");

        try {
            performSearch(emptyConsist, "BG101");
        } catch (IllegalStateException e) {
            System.out.println("❌ Caught Expected Exception: " + e.getMessage());
        }

        // Scenario 2: Valid Train (Standard Operation)
        List<String> activeConsist = new ArrayList<>();
        activeConsist.add("BG101");
        activeConsist.add("BG205");
        activeConsist.add("BG309");

        System.out.println("\nScenario 2: Searching a valid train consist...");
        try {
            boolean found = performSearch(activeConsist, "BG205");
            System.out.println("✔ Search Execution: Bogie found = " + found);
        } catch (IllegalStateException e) {
            System.out.println("❌ Error: " + e.getMessage());
        }

        System.out.println("-----------------------------------------------------");
    }

    /**
     * Searches for a bogie ID but validates system state first.
     * @throws IllegalStateException if the consist is empty.
     */
    public static boolean performSearch(List<String> bogies, String searchKey) {
        // 1. State Validation (Defensive Check)
        if (bogies == null || bogies.isEmpty()) {
            throw new IllegalStateException("Search Failed: No bogies present in the train formation.");
        }

        // 2. Logic execution (only if state is valid)
        // Using a simple linear search for demonstration
        return bogies.contains(searchKey);
    }
}