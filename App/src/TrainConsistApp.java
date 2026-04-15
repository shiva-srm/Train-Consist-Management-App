import java.util.Arrays;
import java.util.Scanner;

public class TrainConsistApp {

    public static void main(String[] args) {
        // Step 1: Input data (may be unsorted)
        String[] bogieIds = {"BG309", "BG101", "BG550", "BG205", "BG412"};
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- UC19: Binary Search (Optimized Lookup) ---");

        // Step 2: Precondition - Data MUST be sorted for Binary Search
        Arrays.sort(bogieIds);
        System.out.println("Sorted Bogies for Search: " + Arrays.toString(bogieIds));

        System.out.print("Enter Bogie ID to find: ");
        String searchKey = scanner.nextLine();

        // Step 3: Execute Binary Search
        int resultIndex = binarySearch(bogieIds, searchKey);

        // Step 4: Display Results
        if (resultIndex != -1) {
            System.out.println("✔ Found: Bogie " + searchKey + " is at index " + resultIndex);
        } else {
            System.out.println("❌ Not Found: Bogie " + searchKey + " does not exist in the consist.");
        }

        scanner.close();
    }

    /**
     * Optimized Binary Search implementation for String IDs
     */
    public static int binarySearch(String[] array, String key) {
        int low = 0;
        int high = array.length - 1;

        while (low <= high) {
            // Find the middle point
            int mid = low + (high - low) / 2;

            // Compare the key with the middle element
            int comparison = key.compareTo(array[mid]);

            if (comparison == 0) {
                return mid; // Match found!
            }
            else if (comparison > 0) {
                low = mid + 1; // Key is in the right half
            }
            else {
                high = mid - 1; // Key is in the left half
            }
        }
        return -1; // Exhausted search range without a match
    }
}