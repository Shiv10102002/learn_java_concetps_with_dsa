package com.shiv;

public class LinearSearch {
    public static void main(String[] args) {
        int [] arr = { 19,72,53,24,15};
        int foundIndex = linearSearch(arr,53);
        System.out.println("53 found in array at index :"+foundIndex);
    }
    public  static  int linearSearch(int[] a , int target){
        for(int i=0 ; i<a.length; i++){
            if(a[i] == target){
                return  i;
            }
        }
        return -1;
    }
}
