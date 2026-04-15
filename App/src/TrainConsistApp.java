import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Bogie {
    int id;
    int capacity;

    public Bogie(int id, int capacity) {
        this.id = id;
        this.capacity = capacity;
    }

    public int getCapacity() { return capacity; }
}

public class TrainConsistApp {

    public static void main(String[] args) {
        // 1. Prepare a large dataset (e.g., 100,000 bogies)
        List<Bogie> trainConsist = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            trainConsist.add(new Bogie(i, (int) (Math.random() * 100)));
        }

        System.out.println("--- UC13: Performance Benchmarking (Loops vs Streams) ---");
        System.out.println("Total Bogies to Process: " + trainConsist.size());
        System.out.println("Filtering Criteria: Capacity > 60\n");

        // 2. Benchmark Loop-Based Filtering
        long startTimeLoop = System.nanoTime();
        List<Bogie> filteredWithLoop = new ArrayList<>();
        for (Bogie b : trainConsist) {
            if (b.getCapacity() > 60) {
                filteredWithLoop.add(b);
            }
        }
        long endTimeLoop = System.nanoTime();
        long durationLoop = endTimeLoop - startTimeLoop;

        System.out.println("Traditional Loop Result Count: " + filteredWithLoop.size());
        System.out.println("Traditional Loop Time: " + durationLoop + " ns");

        // 3. Benchmark Stream-Based Filtering
        long startTimeStream = System.nanoTime();
        List<Bogie> filteredWithStream = trainConsist.stream()
                .filter(b -> b.getCapacity() > 60)
                .collect(Collectors.toList());
        long endTimeStream = System.nanoTime();
        long durationStream = endTimeStream - startTimeStream;

        System.out.println("\nStream API Result Count: " + filteredWithStream.size());
        System.out.println("Stream API Time: " + durationStream + " ns");

        // 4. Comparison Summary
        System.out.println("\n--- Analysis ---");
        if (durationLoop < durationStream) {
            System.out.println("Result: Traditional Loop was faster by " + (durationStream - durationLoop) + " ns.");
        } else {
            System.out.println("Result: Stream API was faster by " + (durationLoop - durationStream) + " ns.");
        }
    }
}