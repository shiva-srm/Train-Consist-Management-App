import java.util.Scanner;

public class TrainConsistApp {

    public static void main(String[] args) {
        // Step 1: Initialize an array of Bogie IDs (Unsorted)
        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};

        Scanner scanner = new Scanner(System.in);

        System.out.println("--- UC18: Linear Search (Bogie Identification) ---");
        System.out.println("Available Bogies: [BG101, BG205, BG309, BG412, BG550]");

        // Step 2: Accept a search key from the user
        System.out.print("Enter Bogie ID to search: ");
        String searchKey = scanner.nextLine();

        // Step 3: Execute Linear Search
        int resultIndex = linearSearch(bogieIds, searchKey);

        // Step 4: Display Result
        if (resultIndex != -1) {
            System.out.println("✔ Found: Bogie " + searchKey + " is located at position " + (resultIndex + 1) + ".");
        } else {
            System.out.println("❌ Not Found: Bogie " + searchKey + " is not in the consist.");
        }

        System.out.println("--------------------------------------------------");
        scanner.close();
    }

    /**
     * Performs a Linear Search to find a Bogie ID.
     * @return index of the found ID, or -1 if not found.
     */
    public static int linearSearch(String[] array, String key) {
        // Sequential Traversal: Visit every element from index 0 to N-1
        for (int i = 0; i < array.length; i++) {
            // Equality Comparison using .equals() for Strings
            if (array[i].equalsIgnoreCase(key)) {
                return i; // Early Termination: Stop as soon as a match is found
            }
        }
        return -1; // Match Not Found after full traversal
    }
}