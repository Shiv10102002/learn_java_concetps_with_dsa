package com.shiv.basics;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayClass {

    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);

        // 1. One-dimensional array declaration and initialization
        int[] arr1 = new int[5]; // Declares an array of size 5 with default values 0
        int[] arr2 = {10, 20, 30, 40, 50}; // Array initialized with values directly

        // 2. Taking input for an array from user
        System.out.println("Enter the size of the array:");
        int n = inp.nextInt();
        int[] inputArray = new int[n]; // Create array with user-defined size

        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) {
            inputArray[i] = inp.nextInt();
        }

        // 3. Printing array elements using loop
        System.out.println("Printing array using loop:");
        for (int i = 0; i < n; i++) {
            System.out.print(inputArray[i] + " ");
        }
        System.out.println();

        // 4. Printing array elements using Arrays.toString()
        System.out.println("Printing array using Arrays.toString():");
        System.out.println(Arrays.toString(inputArray));

        // 5. Multi-dimensional arrays (2D array)
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        System.out.println("2D Array (Matrix):");
        for (int i = 0; i < matrix.length; i++) { // Iterate rows
            for (int j = 0; j < matrix[i].length; j++) { // Iterate columns
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        // 6. Creating a 2D array dynamically with user input
        System.out.println("Enter rows and columns for 2D array:");
        int rows = inp.nextInt();
        int cols = inp.nextInt();
        int[][] userMatrix = new int[rows][cols];
        System.out.println("Enter elements for 2D array:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                userMatrix[i][j] = inp.nextInt();
            }
        }

        System.out.println("User input 2D Array:");
        for (int i = 0; i < rows; i++) {
            System.out.println(Arrays.toString(userMatrix[i]));
        }

        // 7. Common operations with arrays
        // Finding max and min elements
        int max = inputArray[0];
        int min = inputArray[0];
        for (int i = 1; i < n; i++) {
            if (inputArray[i] > max) max = inputArray[i];
            if (inputArray[i] < min) min = inputArray[i];
        }
        System.out.println("Maximum element: " + max);
        System.out.println("Minimum element: " + min);

        // Sorting an array
        Arrays.sort(inputArray);
        System.out.println("Sorted array: " + Arrays.toString(inputArray));

        // Searching in an array using binary search (array must be sorted)
        int key = 20; // element to search
        int searchResult = Arrays.binarySearch(inputArray, key);
        if (searchResult >= 0) {
            System.out.println(key + " found at index " + searchResult);
        } else {
            System.out.println(key + " not found in the array.");
        }

        // 8. Copying arrays
        int[] copiedArray = Arrays.copyOf(inputArray, inputArray.length);
        System.out.println("Copied Array: " + Arrays.toString(copiedArray));

        // 9. Array with default values for other types (example: boolean)
        boolean[] boolArray = new boolean[3]; // defaults to false
        System.out.println("Boolean array default values: " + Arrays.toString(boolArray));

        // 10. Using enhanced for-loop ("for-each") to iterate over array elements
        System.out.println("Using for-each loop:");
        for (int element : inputArray) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
}
