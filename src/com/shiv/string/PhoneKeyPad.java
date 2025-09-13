package com.shiv.string;

import java.util.ArrayList;

public class PhoneKeyPad {
    public static void main(String[] args){

        //Letter Combinations of a Phone Number
//        LetterCombination("","23");
        ArrayList<String> res = ReturnLetterCombination("","12");
        System.out.println(res);

        System.out.println(ReturnLetterCombinationCount("","12"));
    }

    public static void LetterCombination(String letter,String resInp){
        if(resInp.isEmpty()){
            System.out.println(letter);
            return;
        }
        int digit = resInp.charAt(0)-'0';// this will convert '2' to 2
        for(int i= (digit-1)*3 ; i<digit*3; i++){
            char ch = (char)('a'+i);
            LetterCombination(letter+ ch,resInp.substring(1));
        }
    }

    public static ArrayList<String> ReturnLetterCombination(String letter,String resInp){
        if(resInp.isEmpty()){
            ArrayList<String> ans = new ArrayList<>();
            ans.add(letter);
            return ans;
        }
        ArrayList<String> res = new ArrayList<>();
        int digit = resInp.charAt(0)-'0';// this will convert '2' to 2
        for(int i= (digit-1)*3 ; i<digit*3; i++){
            char ch = (char)('a'+i);
           res.addAll(ReturnLetterCombination(letter+ ch,resInp.substring(1)));
        }
        return res;
    }
    public static int ReturnLetterCombinationCount(String letter,String resInp){
        if(resInp.isEmpty()){
            if(letter.isEmpty()){
                return 0;
            }else{
                return 1;
            }
        }
        int res = 0;
        int digit = resInp.charAt(0)-'0';// this will convert '2' to 2
        for(int i= (digit-1)*3 ; i<digit*3; i++){
            char ch = (char)('a'+i);
            res = res +ReturnLetterCombinationCount(letter+ ch,resInp.substring(1));
        }
        return res;
    }


}
