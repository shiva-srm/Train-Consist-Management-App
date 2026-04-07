import java.util.LinkedHashSet;
import java.util.Set;

public class TrainConsistApp {

    public static void main(String[] args) {
        // Welcome message
        System.out.println("=== Train Consist Management App ===");
        System.out.println("UC5: Preserve Insertion Order of Bogies (LinkedHashSet)\n");

        // Create a LinkedHashSet to store bogies
        Set<String> trainFormation = new LinkedHashSet<>();

        // Attach bogies (duplicates will be ignored)
        trainFormation.add("Engine");
        trainFormation.add("Sleeper");
        trainFormation.add("Cargo");
        trainFormation.add("Guard");
        trainFormation.add("Sleeper"); // duplicate attempt

        // Display the final formation
        System.out.println("Final train formation (ordered & unique): " + trainFormation);
    }
}