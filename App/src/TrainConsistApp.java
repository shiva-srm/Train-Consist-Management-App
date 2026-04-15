import java.util.*;
import java.util.stream.Collectors;

public class TrainConsistApp {

    // Inner Bogie class
    static class Bogie {
        private String type;
        private String name;

        public Bogie(String type, String name) {
            this.type = type;
            this.name = name;
        }

        public String getType() {
            return type;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return name + " (" + type + ")";
        }
    }

    public static void main(String[] args) {

        // Step 1: Create list of bogies
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Passenger", "Sleeper"));
        bogies.add(new Bogie("Passenger", "AC Chair"));
        bogies.add(new Bogie("Passenger", "Sleeper"));
        bogies.add(new Bogie("Passenger", "First Class"));
        bogies.add(new Bogie("Goods", "Cylindrical"));
        bogies.add(new Bogie("Goods", "Rectangular"));

        // Step 2: Group bogies using Stream API
        Map<String, List<Bogie>> groupedBogies =
                bogies.stream()
                        .collect(Collectors.groupingBy(Bogie::getName));

        // Step 3: Display grouped result
        System.out.println("=== Grouped Bogies by Type ===");

        for (Map.Entry<String, List<Bogie>> entry : groupedBogies.entrySet()) {
            System.out.println(entry.getKey() + " :");
            for (Bogie b : entry.getValue()) {
                System.out.println("   " + b);
            }
        }

        // Step 4: Verify original list remains unchanged
        System.out.println("\nOriginal List Size: " + bogies.size());
    }
}