package com.shiv;

/**
 * LinearSearch class to demonstrate the linear search algorithm.
 * Linear search sequentially checks each element of the array until the target is found.
 */
public class LinearSearch {

    /**
     * Main method to test the linearSearch method with a sample array and target value.
     */
    public static void main(String[] args) {
        int[] arr = {19, 72, 53, 24, 15};

        // Searching for 53 in the array using linear search
        int foundIndex = linearSearch(arr, 53);

        // Print the index where 53 is found, or -1 if not found
        System.out.println("53 found in array at index : " + foundIndex);
    }

    /**
     * Performs linear search on the given array to find the target element.
     * Iterates through each element one by one and compares with the target.
     *
     * @param a      The array to search through.
     * @param target The element to search for.
     * @return The index of the target if found; -1 if the target is not present in the array.
     */
    public static int linearSearch(int[] a, int target) {
        // Loop through each element in the array
        for (int i = 0; i < a.length; i++) {
            // If current element matches the target, return the current index
            if (a[i] == target) {
                return i;
            }
        }
        // If target is not found in the entire array, return -1
        return -1;
    }
}
