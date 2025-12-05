package project;

import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String choice;

        do {
            System.out.println("\nMenu of Searching and Sorting Testbed.\n");
            System.out.println("1)  Linear searching");
            System.out.println("2)  Binary searching");
            System.out.println("3)  O(n^2) type of sorting");
            System.out.println("4)  O(n * log(n) type of sorting");
            System.out.println("5)  Sorting performance");
            System.out.println("\nq/Q) Quit\n");
            System.out.print("Your choice: ");
            choice = sc.nextLine().trim();

            switch (choice) {
                case "1" -> linearSearch(sc);
                case "2" -> binarySearch(sc);
                case "3" -> n2Sorting();
                case "4" -> System.out.println("Choice 4 not implemented.");
                case "5" -> System.out.println("Choice 5 not implemented.");
                case "q", "Q" -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice.");
            }
        } while (!choice.equalsIgnoreCase("q"));
    }

    private static void linearSearch(Scanner sc) {
        int[] arr = {0,1,2,3,4,5,6,7,8,9};
        System.out.print("In the list are values 0, ..., 9; which value would you like to search with linear search? ");
        int val = Integer.parseInt(sc.nextLine().trim());
        boolean found = false;
        for (int x : arr) {
            if (x == val) {
                found = true;
                break;
            }
        }
        System.out.println(found ? "\nFound\n" : "\nNot found\n");
    }

    private static void binarySearch(Scanner sc) {
        int[] arr = {0,1,2,3,4,5,6,7,8,9};
        System.out.print("In the list are values 0, ..., 9; which value would you like to search with binary search? ");
        int val = Integer.parseInt(sc.nextLine().trim());

        int low = 0, high = arr.length - 1;
        boolean found = false;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == val) {
                found = true;
                break;
            } else if (arr[mid] < val) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        System.out.println(found ? "\nFound\n" : "\nNot found\n");
    }

    private static void n2Sorting() {
        int[] arr = new int[10];
        Random rand = new Random();

        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(201) - 100; // random values from -100 to 100
        }

        System.out.println("\nData set before insertion sorting:");
        for (int x : arr) System.out.print(x + " ");
        System.out.println();

        Sorts.insertionSort(arr);

        System.out.println("\nData set after insertion sorting:");
        for (int x : arr) System.out.print(x + " ");
        System.out.println("\n");
    }
}
