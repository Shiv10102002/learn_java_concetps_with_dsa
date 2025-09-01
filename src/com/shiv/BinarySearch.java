package com.shiv;

public class BinarySearch {
    public static void main(String[] args) {
        int [] arr = {2,4,5,7,9,23,47};
        int indexOftarget = binarySearch(arr,5);
        System.out.println("5 found in array at index : "+ indexOftarget);
        System.out.println("ceiling of 6 in the array is at index "+ ceiling(arr,6));
        System.out.println("floor of 6 in the array is at index "+ floor(arr,6));


    }

    public static int binarySearch(int[] arr,int target){
        int ans = -1;
        int start = 0,end = arr.length-1;
        while (start<=end){
            int mid = start + (end-start)/2;
            if(arr[mid]==target){
                ans = mid;
                break;
            }else if(arr[mid]>target){
                end = mid-1;
            }else{
                start = mid+1;
            }
        }

        return ans;
    }

    public static int ceiling(int[] arr, int target){
        if(target > arr[ arr.length -1])return -1;
        int start = 0,end = arr.length-1;
        while(start<=end){
            int mid = start + (end-start)/2;
            if(arr[mid]>target){
                end = mid-1;
            }else if(arr[mid]<target){
                start = mid+1;
            }else{
                return  mid;
            }
        }
        return  start;
    }
    public static int floor(int[] arr,int target){

        if(target > arr[ arr.length -1])return -1;
        int start = 0,end = arr.length -1;
        while (start<=end){
            int mid = start + (end-start)/2;
            if(arr[mid]<target){
                start = mid+1;
            }else if(arr[mid]>target){
                end = mid-1;
            }else{
                return  mid;
            }
        }
        return end;
    }


}
