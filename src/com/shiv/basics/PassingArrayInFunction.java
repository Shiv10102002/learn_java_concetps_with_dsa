package com.shiv.basics;

import java.util.Arrays;

public class PassingArrayInFunction {

    public static void main(String[] args) {
        int[] a = {2, 3, 4, 5};
        System.out.println("Before changing, array is: " + Arrays.toString(a));
        changeSecondVal(a);  // Pass array to method, changes element at index 1
        System.out.println("After changing, array is: " + Arrays.toString(a));

        // Passing array and returning sum
        int sum = sumArray(a);
        System.out.println("Sum of array elements: " + sum);

        // Passing part of array using indices to a method
        int partialSum = sumPartialArray(a, 1, 3);  // sum elements from index 1 to 3
        System.out.println("Partial sum (index 1 to 3): " + partialSum);

        // Create and return new array from method
        int[] doubledArray = doubleArray(a);
        System.out.println("Doubled array: " + Arrays.toString(doubledArray));

        // Passing 2D array to method
        int[][] matrix = { {1, 2}, {3, 4}, {5, 6} };
        System.out.println("Sum of all elements in matrix: " + sum2DArray(matrix));
    }

    // Variant 1: Pass array to method and modify original array (passed by reference)
    public static void changeSecondVal(int[] b) {
        b[1] = 6;  // modifies original array element at index 1
    }

    // Variant 2: Pass array and compute sum of elements (read-only)
    public static int sumArray(int[] arr) {
        int sum = 0;
        for (int val : arr) {
            sum += val;
        }
        return sum;
    }

    // Variant 3: Pass part of array by indices and compute sum on that segment
    public static int sumPartialArray(int[] arr, int start, int end) {
        int sum = 0;
        for (int i = start; i <= end && i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }

    // Variant 4: Return a new array created based on input array
    public static int[] doubleArray(int[] arr) {
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result[i] = arr[i] * 2;
        }
        return result;
    }

    // Variant 5: Passing 2D array, return sum of all elements
    public static int sum2DArray(int[][] matrix) {
        int sum = 0;
        for (int[] row : matrix) {
            for (int val : row) {
                sum += val;
            }
        }
        return sum;
    }
}
