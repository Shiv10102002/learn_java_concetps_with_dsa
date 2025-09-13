package com.shiv.string;

import java.util.ArrayList;

public class Permutation {

    public static void main(String[] args){
        permutation("","abc");
        System.out.println(permutations("","abc"));
    }

    static void permutation(String ans,String s){
        if(s.isEmpty()){
            System.out.println(ans);
            return;
        }
        char ch = s.charAt(0);
        for(int i=0; i<=ans.length(); i++){
            String f= ans.substring(0,i);
            String l = ans.substring(i);
            permutation(f+ch+l,s.substring(1));
        }
    }

    static ArrayList<String> permutations(String ans, String s){
        if(s.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            list.add(ans);
            return list;
        }
        ArrayList<String> res = new ArrayList<>();
        char ch = s.charAt(0);
        for(int i=0; i<=ans.length(); i++){
            String f= ans.substring(0,i);
            String l = ans.substring(i);
          res.addAll(permutations(f+ch+l,s.substring(1)));
        }
        return res;
    }
}
