package com.shiv.string;

import java.util.ArrayList;
import java.util.List;

public class SubSeq {

    public static void main(String[] args){
        subseq("","abc");
        System.out.println(subseq2("","abc"));
        int[] arr = {1,2,3};
        System.out.println(subseq3(arr));
        long maxMemory = Runtime.getRuntime().maxMemory();
        System.out.println("Max Heap Size (bytes): " + maxMemory);

    }
    static void subseq(String seq,String s){
        if(s.isEmpty()){
            System.out.println(seq);
            return;
        }
        char ch = s.charAt(0);
        subseq(seq,s.substring(1));
        subseq(seq+ch,s.substring(1));
    }

    static ArrayList<String> subseq2(String ans,String s){
        if(s.isEmpty()){
            ArrayList<String> anslist = new ArrayList<>();
            anslist.add(ans);
            return anslist;
        }
        char ch = s.charAt(0);
        ArrayList<String>left = subseq2(ans+ch,s.substring(1));
        ArrayList<String>right = subseq2(ans,s.substring(1));
        left.addAll(right);
        return left;
    }

    static List<List<Integer>> subseq3(int[] arr){
        List<List<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());
        for(int num:arr){
            int n = outer.size();
            for(int i=0; i<n; i++){
                List<Integer> internal = new ArrayList<>(outer.get(i));
                internal.add(num);
                outer.add(internal);
            }
        }

        return outer;
    }

}
