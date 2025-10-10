package com.shiv.stack;

import java.util.Arrays;

public class TwoStackGame {

    public static void main(String[] args){

    }
    public static int twoStack(int target,int[]a,int[]b){
           return maxRemoveCount(target,a,b,0,0);
    }

    public static int maxRemoveCount(int target,int[]a ,int[]b,int sum,int count){
        if(sum>target){
            return count;
        }

        if(a.length == 0||b.length==0){
            return count;
        }

        int ans1 = maxRemoveCount(target, Arrays.copyOfRange(a,1,a.length),b,sum+a[0],count+1);
        int ans2 = maxRemoveCount(target,a,Arrays.copyOfRange(b,1,b.length),sum+ b[0],count+1);

        return Math.max(ans1,ans2);
    }

}
