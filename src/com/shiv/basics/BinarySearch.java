package com.shiv.basics;

/**
 * BinarySearch class contains implementations of:
 *  - binary search to find the index of a target element in a sorted array,
 *  - ceiling function to find the smallest element >= target,
 *  - floor function to find the largest element <= target.
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {2, 4, 5, 7, 9, 23, 47};

        // Search for target 5 in the array using binary search
        int indexOftarget = binarySearch(arr, 5);
        System.out.println("5 found in array at index : " + indexOftarget);

        // Get the index of the ceiling of 6 in the array
        System.out.println("ceiling of 6 in the array is at index " + ceiling(arr, 6));

        // Get the index of the floor of 6 in the array
        System.out.println("floor of 6 in the array is at index " + floor(arr, 6));
    }

    /**
     * Performs binary search on a sorted integer array to find the index of the target element.
     *
     * @param arr    The sorted array in which to search.
     * @param target The target value to search for.
     * @return The index of the target if found, otherwise -1.
     */
    public static int binarySearch(int[] arr, int target) {
        int ans = -1;
        int start = 0, end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] == target) {
                ans = mid;
                break;
            } else if (arr[mid] > target) {
                end = mid - 1; // Search left half
            } else {
                start = mid + 1; // Search right half
            }
        }
        return ans;
    }

    /**
     * Finds the ceiling of the target in a sorted array.
     * The ceiling is the smallest element in the array greater than or equal to the target.
     *
     * @param arr    The sorted array.
     * @param target The target value.
     * @return The index of the ceiling element, or -1 if there is no ceiling in the array.
     */
    public static int ceiling(int[] arr, int target) {
        // If target is larger than the largest element, no ceiling exists
        if (target > arr[arr.length - 1]) return -1;

        int start = 0, end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] > target) {
                end = mid - 1; // Move left to look for smaller ceiling candidate
            } else if (arr[mid] < target) {
                start = mid + 1; // Move right to find ceiling >= target
            } else {
                return mid; // Exact match is the ceiling
            }
        }
        // Start is positioned at ceiling index after loop ends
        return start;
    }

    /**
     * Finds the floor of the target in a sorted array.
     * The floor is the largest element in the array less than or equal to the target.
     *
     * @param arr    The sorted array.
     * @param target The target value.
     * @return The index of the floor element, or -1 if there is no floor in the array.
     */
    public static int floor(int[] arr, int target) {
        // If target is larger than the largest element, floor is the last element
        if (target > arr[arr.length - 1]) return arr.length - 1;

        int start = 0, end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] < target) {
                start = mid + 1; // Move right to find larger floor candidate
            } else if (arr[mid] > target) {
                end = mid - 1; // Move left
            } else {
                return mid; // Exact match is the floor
            }
        }
        // End is positioned at floor index after loop ends
        return end;
    }
}
