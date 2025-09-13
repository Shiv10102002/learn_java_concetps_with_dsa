package com.shiv.string;

import java.util.ArrayList;

public class Dice {
    public static void main(String[] args){
        //return all the way to form target number using dice
        dice("",4);

     ArrayList<String> res = returnCombination("",4);
     System.out.println(res);
    }
    static void  dice(String p,int target){
        if(target == 0){
            System.out.println(p);
            return;
        }
        for(int i=1; i<=6 && i<=target; i++){
            dice(p+i,target-i);
        }

    }

    static ArrayList<String> returnCombination(String p,int target){
        if(target == 0){
           ArrayList<String> res = new ArrayList<>();
           if(p.isEmpty()){
               return res;
           }else{
                res.add(p);
                return res;
           }
        }
        ArrayList<String> res = new ArrayList<>();

        for(int i=1; i<=6 && i<=target; i++){
           res.addAll(returnCombination(p+i,target-i));
        }
        return res;
    }
}
