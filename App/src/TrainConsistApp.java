import java.util.LinkedList;
import java.util.List;

public class TrainConsistApp {

    public static void main(String[] args) {
        // Welcome message
        System.out.println("=== Train Consist Management App ===");
        System.out.println("UC4: Maintain Ordered Bogie IDs (LinkedList)\n");

        // Initialize LinkedList to maintain order
        LinkedList<String> trainConsist = new LinkedList<>();

        // Add bogies in order
        trainConsist.add("Engine");
        trainConsist.add("Sleeper");
        trainConsist.add("AC");
        trainConsist.add("Cargo");
        trainConsist.add("Guard");

        System.out.println("Initial train consist: " + trainConsist);

        // Insert Pantry Car at position 2 (0-based index)
        trainConsist.add(2, "Pantry Car");
        System.out.println("After inserting Pantry Car at position 2: " + trainConsist);

        // Remove first and last bogie
        trainConsist.removeFirst();
        trainConsist.removeLast();
        System.out.println("After removing first and last bogie: " + trainConsist);

        // Final ordered train consist
        System.out.println("\nFinal ordered train consist: " + trainConsist);
    }
}