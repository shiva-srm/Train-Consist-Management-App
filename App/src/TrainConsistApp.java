import java.util.ArrayList;
import java.util.List;

public class TrainConsistApp {

    public static void main(String[] args) {
        // Welcome message
        System.out.println("=== Train Consist Management App ===");

        // Initialize ArrayList to hold passenger bogies
        List<String> passengerBogies = new ArrayList<>();

        // Add passenger bogies
        passengerBogies.add("Sleeper");
        passengerBogies.add("AC Chair");
        passengerBogies.add("First Class");

        // Print list after insertion
        System.out.println("Bogies after addition: " + passengerBogies);

        // Remove one bogie (AC Chair)
        passengerBogies.remove("AC Chair");

        // Check if Sleeper bogie exists
        boolean hasSleeper = passengerBogies.contains("Sleeper");
        System.out.println("Does Sleeper bogie exist? " + hasSleeper);

        // Print final list state
        System.out.println("Final bogie list: " + passengerBogies);

        // Program continues...
    }
}