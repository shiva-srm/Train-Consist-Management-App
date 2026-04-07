import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

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
        System.out.println("UC7: Sort Bogies by Capacity (Comparator)\n");

        // Create a list of passenger bogies
        List<Bogie> passengerBogies = new ArrayList<>();
        passengerBogies.add(new Bogie("Sleeper", 72));
        passengerBogies.add(new Bogie("AC Chair", 60));
        passengerBogies.add(new Bogie("First Class", 50));

        System.out.println("Before sorting:");
        for (Bogie bogie : passengerBogies) {
            System.out.println(bogie);
        }

        // Sort passenger bogies by capacity in descending order
        passengerBogies.sort(Comparator.comparingInt(Bogie::getCapacity).reversed());

        System.out.println("\nAfter sorting by capacity (descending):");
        for (Bogie bogie : passengerBogies) {
            System.out.println(bogie);
        }
    }
}