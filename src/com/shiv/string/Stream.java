package com.shiv.string;

public class Stream {
    public static void main(String[] args){
        skip("","baaccdah");//ans should be "bccdh"
        System.out.println(skip("baaccdah"));

        System.out.println(skipApple("bapplech"));
    }
   // remove all 'a' from the string
    static void skip(String res,String up){
        if(up.isEmpty()){
            System.out.println(res);
            return;
        }
        char ch = up.charAt(0);
        if(ch == 'a'){
            skip(res,up.substring(1));
        }else{
            skip(res + ch,up.substring(1));
        }
    }

    static String skip(String up){
        if(up.isEmpty()){

            return "";
        }
        char ch = up.charAt(0);
        if(ch == 'a'){
           return skip(up.substring(1));
        }else{
           return ch + skip(up.substring(1));
        }
    }

    static String skipApple(String s){
        if(s.isEmpty()){
            return "";
        }
        if(s.startsWith("apple")){
            return skipApple(s.substring(5));
        }else{
            return s.charAt(0) + skipApple(s.substring(1));
        }
    }
}
