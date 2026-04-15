import java.util.Arrays;

public class TrainConsistApp {

    public static void main(String[] args) {
        // Step 1: Initialize an array of passenger bogie capacities
        int[] capacities = {72, 56, 24, 70, 60};

        System.out.println("--- UC16: Manual Sorting (Bubble Sort Algorithm) ---");
        System.out.println("Original Capacities: " + Arrays.toString(capacities));

        // Step 2: Implement Bubble Sort Algorithm
        bubbleSort(capacities);

        // Step 3: Display Sorted Result
        System.out.println("Sorted Capacities:   " + Arrays.toString(capacities));
        System.out.println("----------------------------------------------------");
    }

    /**
     * Sorts an array using the Bubble Sort technique.
     * Compares adjacent elements and swaps them if they are in the wrong order.
     */
    public static void bubbleSort(int[] array) {
        int n = array.length;
        boolean swapped;

        // Outer loop: controls the number of passes
        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            // Inner loop: compares adjacent elements
            // The last i elements are already in place after i passes
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    // Swap Logic: Use a temporary variable to exchange values
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                }
            }

            // Optimization: If no two elements were swapped in the inner loop, the array is sorted
            if (!swapped) break;
        }
    }
}