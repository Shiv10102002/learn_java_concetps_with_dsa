package com.shiv.string;

import java.util.ArrayList;
import java.util.List;

public class UniqueSubSeq {

    public static void main(String[] args){
        int[] arr = {1,2,2};
        List<List<Integer>> ans = uniqueSubSeq(arr);
        for(List<Integer> list : ans){
            System.out.println(list);
        }
    }
    static List<List<Integer>>uniqueSubSeq(int[] arr){
        List<List<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());

        int start =0;
        int end=0;
        for(int i=0; i<arr.length; i++){
            start =0;
            if(i>0 && arr[i] == arr[i-1]){
                start = end+1;
            }
            end = outer.size()-1;
            for(int j=start ; j<outer.size(); j++){
                List<Integer> internal = new ArrayList<>(outer.get(j));
                internal.add(arr[i]);
                outer.add(internal);
            }

        }
        return outer;
    }
}
