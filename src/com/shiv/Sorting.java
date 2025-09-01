package com.shiv;

import java.util.Arrays;

public class Sorting {
    public static void main(String [] args){
        int[] arr = {5,4,3,2,1};
        // Uncomment any sorting algorithm call to test

//        selectionSort(arr);         // Sort by repeatedly selecting the max element and placing at the end (O(n^2))
//        insertionSort(arr);         // Builds sorted array one element at a time by inserting current element at right place (O(n^2))
//        selectionSort2(arr);        // Sort by repeatedly selecting the min element and placing at the start (O(n^2))
//        bubbleSort(arr);            // Repeatedly swaps adjacent elements if they are in wrong order (O(n^2))
//        cyclicSort(arr);            // Efficient for arrays containing elements from 1 to N, placing each element at its correct index (O(n))
//        mergeSort(arr);             // Divide and conquer algorithm, splits array and merges sorted halves (O(n log n))
//        mergeSortInPlace(arr,0,arr.length); // In-place variant of merge sort (O(n log n))
//        quickSort(arr,0,arr.length - 1);     // Efficient divide and conquer sorting using pivot (average O(n log n))

        // Print the sorted array
        for (int j : arr) {
            System.out.println(j);
        }
    }

    // Selection sort version 1 (select max element and swap to end)
    public static void selectionSort(int [] arr){
        for(int i=arr.length-1; i>=0; i--){
            int maxind = i;       // assume last element is max
            int last = i;
            for(int j=0; j<=last; j++){
                if(arr[j]>arr[maxind]){
                    maxind = j;    // find actual max index
                }
            }
            swap(arr,last,maxind); // swap max to the current end of unsorted section
        }
    }

    // Selection sort version 2 (select min element and swap to start)
    public static void selectionSort2(int[] arr){
        for(int i=0; i<arr.length -1; i++){
            int minInd = i;         // assume current index is min
            for(int j= i+1; j<arr.length; j++){
                if(arr[j]<arr[minInd]){
                    minInd = j;    // find the min element index in unsorted part
                }
            }
            swap(arr,i,minInd);   // swap min element to the sorted section
        }
    }

    // Utility swap method to swap two elements of array
    public static void swap(int[] arr, int first,int sec){
        int t = arr[first];
        arr[first]= arr[sec];
        arr[sec] = t;
    }

    // Insertion sort - builds sorted array by "inserting" elements into proper place
    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int j = i;
            // Swap backward until element is at correct place
            while (j > 0 && arr[j] < arr[j - 1]) {
                swap(arr, j, j - 1);
                j--;
            }
        }
    }

    // Bubble sort - repeatedly swaps adjacent elements if in wrong order
    public static void bubbleSort(int[] arr){
        for(int i=0; i<arr.length; i++){
            // Last i elements are already sorted
            for(int j=0; j<arr.length-i-1; j++){
                if(arr[j]>arr[j+1]){
                    swap(arr,j,j+1);
                }
            }
        }
    }

    // Cyclic sort - efficient for array having elements from 1 to N (unique), places each element at correct index
    public static void cyclicSort(int[] arr){
        int i=0;
        while(i<arr.length){
            if(arr[i] != i+1){
                swap(arr,i,arr[i]-1);
            }else{
                i++;
            }
        }
    }

    // Merge sort - recursive divide and conquer, splits array, sorts halves, and merges sorted arrays
    static int[] mergeSort(int[] arr){
        if(arr.length == 1){
            return  arr;
        }
        int mid  = arr.length/2;
        int[] left = mergeSort(Arrays.copyOfRange(arr,0,mid));
        int[] right = mergeSort(Arrays.copyOfRange(arr,mid,arr.length));
        return merge(left,right);
    }

    // Merge two sorted arrays into one sorted array
    public static int[] merge(int[] first,int[] seconds){
        int[] mix = new int[first.length + seconds.length];
        int i = 0;
        int j= 0;
        int k= 0;
        while(i<first.length && j<seconds.length){
            if(first[i]<seconds[j]){
                mix[k] = first[i];
                i++;
            }else{
                mix[k] = seconds[j];
                j++;
            }
            k++;
        }
        while(i<first.length){
            mix[k] = first[i];
            i++;
            k++;
        }
        while (j<seconds.length){
            mix[k] = seconds[j];
            j++;
            k++;
        }
        return mix;
    }

    // In-place Merge Sort to avoid extra copies - sorts array from index s to e (exclusive)
    static void mergeSortInPlace(int[] arr,int s,int e){
        if(e-s == 1){
            return;
        }
        int mid = (s+e)/2;
        mergeSortInPlace(arr,s,mid);
        mergeSortInPlace(arr,mid,e);
        mergeInPlace(arr,s,mid,e);
    }

    // In-place merge two sorted subarrays arr[s..m-1] and arr[m..e-1]
    private static void mergeInPlace(int[]arr,int s,int m,int e){
        int[] mix = new int[e-s];
        int i= s;
        int j= m;
        int k=0;
        while(i<m && j<e){
            if(arr[i]<arr[j]){
                mix[k] = arr[i];
                i++;
            }else{
                mix[k] = arr[j];
                j++;
            }
            k++;
        }
        while(j<e){
            mix[k] = arr[j];
            j++;
            k++;
        }
        while(i<m){
            mix[k] = arr[i];
            i++;
            k++;
        }

        for(int l=0; l<mix.length;l++){
            arr[s+l] = mix[l];
        }
    }

    // Quick sort - efficient divide and conquer sort, uses pivot element to partition array
    static void quickSort(int[]nums,int low,int hi){
        if(low>=hi){
            return;
        }
        int s= low;
        int e = hi;
        int m = s+ (e-s)/2;       // choose middle element as pivot
        int pivot = nums[m];

        // partition process
        while (s<=e){
            while(nums[s]<pivot){
                s++;
            }
            while(nums[e]>pivot){
                e--;
            }
            if(s<=e){
                int temp = nums[s];
                nums[s] = nums[e];
                nums[e] = temp;
                s++;
                e--;
            }
        }
        // recursively sort left and right partitions
        quickSort(nums,low,e);
        quickSort(nums,s,hi);
    }

}
