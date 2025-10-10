package com.shiv.linkedlists;

public class HappyNumber {

    public static void main(String[] args){
        System.out.println(isHappy(2));
        System.out.println(isHappy(12));
        System.out.println(isHappy(19));
    }

    public static boolean isHappy(int n){
        int s = n;
        int f = n;
        do{
            s = findSquare(s);
            f = findSquare(findSquare(f));
        }while(s != f);

        if(s == 1){
            return true;
        }else{
            return false;
        }

    }

    public static int findSquare(int num){
        int sum = 0;
        while(num>0){
            int r = num%10;
            sum += r*r;
            num = num/10;
        }
        return sum;
    }
}
