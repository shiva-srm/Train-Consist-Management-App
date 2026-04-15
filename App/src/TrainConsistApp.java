import java.util.Arrays;

public class TrainConsistApp {

    public static void main(String[] args) {
        // Step 1: Initialize an array of bogie type names
        String[] bogieNames = {
                "Sleeper",
                "AC Chair",
                "First Class",
                "General",
                "Luxury"
        };

        System.out.println("--- UC17: Library-Based Sorting (Arrays.sort) ---");
        System.out.println("Before Sorting: " + Arrays.toString(bogieNames));

        // Step 2: Use Java's built-in sorting utility
        // Strings are sorted in their "Natural Order" (Alphabetical)
        Arrays.sort(bogieNames);

        // Step 3: Display the sorted result
        System.out.println("After Sorting:  " + Arrays.toString(bogieNames));

        // Demonstrating duplicate handling
        String[] duplicateConsist = {"Sleeper", "AC Chair", "Sleeper", "General"};
        Arrays.sort(duplicateConsist);
        System.out.println("\nSorted with Duplicates: " + Arrays.toString(duplicateConsist));

        System.out.println("-------------------------------------------------");
    }
}