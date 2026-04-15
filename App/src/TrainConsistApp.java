import java.util.*;

public class TrainConsistApp {

    // Inner Bogie class
    static class Bogie {
        private String type;
        private String name;
        private int capacity;

        public Bogie(String type, String name, int capacity) {
            this.type = type;
            this.name = name;
            this.capacity = capacity;
        }

        public String getType() {
            return type;
        }

        public String getName() {
            return name;
        }

        public int getCapacity() {
            return capacity;
        }

        @Override
        public String toString() {
            return name + " (" + type + ") - Capacity: " + capacity;
        }
    }

    public static void main(String[] args) {

        // Step 1: Create list of bogies
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Passenger", "Sleeper", 72));
        bogies.add(new Bogie("Passenger", "AC Chair", 60));
        bogies.add(new Bogie("Passenger", "Sleeper", 72));
        bogies.add(new Bogie("Passenger", "First Class", 24));
        bogies.add(new Bogie("Goods", "Cylindrical", 0));
        bogies.add(new Bogie("Goods", "Rectangular", 0));

        // Step 2: Use Stream -> map -> reduce
        int totalSeats = bogies.stream()
                .map(b -> b.getCapacity())   // Extract capacity
                .reduce(0, Integer::sum);   // Sum all values

        // Step 3: Display total seating capacity
        System.out.println("=== Total Train Seating Capacity ===");
        System.out.println("Total Seats: " + totalSeats);

        // Step 4: Verify original list unchanged
        System.out.println("\nOriginal List Size: " + bogies.size());
    }
}