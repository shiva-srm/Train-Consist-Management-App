import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// Bogie class to represent passenger bogies
class Bogie {
    private String name;
    private int capacity;

    public Bogie(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public String toString() {
        return name + " (" + capacity + " seats)";
    }
}

public class TrainConsistApp {

    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App ===");
        System.out.println("UC8: Filter Passenger Bogies Using Streams\n");

        // Step 1: Create a list of passenger bogies (reusing UC7 concept)
        List<Bogie> passengerBogies = new ArrayList<>();
        passengerBogies.add(new Bogie("Sleeper", 72));
        passengerBogies.add(new Bogie("AC Chair", 60));
        passengerBogies.add(new Bogie("First Class", 50));
        passengerBogies.add(new Bogie("Pantry Car", 30)); // low-capacity special purpose

        System.out.println("Original Bogie List:");
        passengerBogies.forEach(System.out::println);

        // Step 2: Filter bogies with capacity > 60 using Stream API
        List<Bogie> highCapacityBogies = passengerBogies.stream()
                .filter(b -> b.getCapacity() > 60)
                .collect(Collectors.toList());

        System.out.println("\nFiltered Bogies (Capacity > 60):");
        highCapacityBogies.forEach(System.out::println);

        // Step 3: Verify original list is unchanged
        System.out.println("\nOriginal Bogie List After Filtering (Unchanged):");
        passengerBogies.forEach(System.out::println);
    }
}