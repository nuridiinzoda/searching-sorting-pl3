package project;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Linear Search");
            System.out.println("2. Binary Search");
            System.out.println("3. O(n^2) Sorting");
            System.out.println("4. O(n log n) Sorting");
            System.out.println("5. Sorting Performance");
            System.out.println("6. Quit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1 -> linearSearch(sc);
                case 2 -> System.out.println("Choice 2 not implemented.");
                case 3 -> System.out.println("Choice 3 not implemented.");
                case 4 -> System.out.println("Choice 4 not implemented.");
                case 5 -> System.out.println("Choice 5 not implemented.");
                case 6 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice.");
            }
        } while (choice != 6);
    }

    private static void linearSearch(Scanner sc) {
        int[] arr = {0,1,2,3,4,5,6,7,8,9};
        System.out.print("Enter value to search: ");
        int val = sc.nextInt();
        boolean found = false;
        for (int x : arr) {
            if (x == val) {
                found = true;
                break;
            }
        }
        System.out.println(found ? "Value found!" : "Value not found.");
    }
}
