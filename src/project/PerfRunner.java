package project;

import java.util.Random;

public class PerfRunner {

    private static CountingInt[] generateData(int size, int seed) {
        Random rand = new Random(seed);
        CountingInt[] data = new CountingInt[size];
        for (int i = 0; i < size; i++) {
            data[i] = new CountingInt(rand.nextInt(1_000_000));
        }
        return data;
    }

    private static long timeSort(Runnable sort) {
        long start = System.nanoTime();
        sort.run();
        return (System.nanoTime() - start) / 1_000_000; // ms
    }

    public static void runPerformanceTest() {
        int baseSize = 1000;
        int seed = 42;

        // Header row with wider spacing
        System.out.printf("%-20s", "Size");
        for (int i = 1; i <= 10; i++) {
            System.out.printf("%12d", i * baseSize);
        }
        System.out.println("\n");

        String[] names = {"Insertion", "Selection", "Quick", "Merge"};

        for (String name : names) {
            // Comparisons
            System.out.printf("%-20s", name + " comparisons");
            for (int i = 1; i <= 10; i++) {
                int size = i * baseSize;
                CountingInt[] data = generateData(size, seed);
                CountingInt.resetCounter();

                switch (name) {
                    case "Insertion" -> Sorts.insertionSort(data);
                    case "Selection" -> Sorts.selectionSort(data);
                    case "Quick"     -> Sorts.quickSort(data);
                    case "Merge"     -> Sorts.mergeSort(data);
                }

                System.out.printf("%12d", CountingInt.comparisonCount);
            }
            System.out.println("\n");

            // Milliseconds
            System.out.printf("%-20s", name + " ms");
            for (int i = 1; i <= 10; i++) {
                int size = i * baseSize;
                CountingInt[] data = generateData(size, seed);
                CountingInt.resetCounter();

                long ms = timeSort(() -> {
                    switch (name) {
                        case "Insertion" -> Sorts.insertionSort(data);
                        case "Selection" -> Sorts.selectionSort(data);
                        case "Quick"     -> Sorts.quickSort(data);
                        case "Merge"     -> Sorts.mergeSort(data);
                    }
                });

                System.out.printf("%12d", ms);
            }
            System.out.println("\n"); // blank line between algorithms
        }
    }
}
