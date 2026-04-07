import java.util.HashMap;
import java.util.Map;

public class TrainConsistApp {

    public static void main(String[] args) {
        // Welcome message
        System.out.println("=== Train Consist Management App ===");
        System.out.println("UC6: Map Bogie to Capacity (HashMap)\n");

        // Create a HashMap to store bogie-capacity info
        Map<String, Integer> bogieCapacityMap = new HashMap<>();

        // Insert capacities for passenger bogies
        bogieCapacityMap.put("Sleeper", 72);
        bogieCapacityMap.put("AC Chair", 60);
        bogieCapacityMap.put("First Class", 50);

        // Insert capacities for goods bogies (load capacity in tons)
        bogieCapacityMap.put("Rectangular Goods", 30);
        bogieCapacityMap.put("Cylindrical Goods", 25);

        // Display bogie capacities
        System.out.println("Bogie Capacities:");
        for (Map.Entry<String, Integer> entry : bogieCapacityMap.entrySet()) {
            System.out.println("Bogie: " + entry.getKey() + ", Capacity: " + entry.getValue());
        }
    }
}