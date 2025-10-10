package com.shiv.backtracking;

import java.util.ArrayList;
import java.util.Arrays;

public class Maze {

    public static void main(String[] args){
        // return total number of ways to reach from top left corner of mage to bottom right corner
       int res =  count(3,3);
       System.out.println(res);

       printpath("",3,3);

        ArrayList<String> res2 = returnAllPath("",3,3);
        System.out.println(res2);

        ArrayList<String> res3 = returnAllPathIncDiagonal("",3,3);
        System.out.println(res3);

        boolean[][] arr = {
        {true,true,true},
        {true,false,true},
        {true,true,true}
        };

        ArrayList<String>res4 = pathWithRestriction("",arr,0,0);
        System.out.println(res4);
    }
    static int count(int r,int c){
        if(r==1 || c==1){
            return 1;
        }
        int left = count(r-1,c);
        int up = count(r,c-1);
        return left+up;
    }


    static void printpath(String p,int r,int c){
        if(r==1 && c==1){
            System.out.println(p);
            return;
        }
        if(r>1){
            printpath(p+'D',r-1,c);
        }
        if(c>1){
            printpath(p+'R',r,c-1);
        }
    }

    static ArrayList<String> returnAllPath(String p,int r,int c){
        if(r==1 && c==1){
          ArrayList<String> res = new ArrayList<>();
          if(p.isEmpty()){
              return res;
          }else{
              res.add(p);
              return res;
          }
        }
        ArrayList<String>res = new ArrayList<>();
        if(r>1){
          res.addAll( returnAllPath(p+'D',r-1,c));
        }
        if(c>1){
           res.addAll(returnAllPath(p+'R',r,c-1));
        }

        return res;
    }
    // return all the path when diagonal travel also allowed
    static ArrayList<String> returnAllPathIncDiagonal(String p,int r,int c){
        if(r==1 && c==1){
            ArrayList<String> res = new ArrayList<>();
            if(p.isEmpty()){
                return res;
            }else{
                res.add(p);
                return res;
            }
        }
        ArrayList<String>res = new ArrayList<>();
        if(r>1){
            res.addAll( returnAllPathIncDiagonal(p+'V',r-1,c));
        }
        if(c>1){
            res.addAll(returnAllPathIncDiagonal(p+'H',r,c-1));
        }

        if(r>1 && c>1){
            res.addAll(returnAllPathIncDiagonal(p+'D',r-1,c-1));
        }

        return res;
    }


    static ArrayList<String> pathWithRestriction(String p,boolean[][] maze,int r,int c){
        if(r == maze.length-1 && c== maze[0].length-1){
            ArrayList<String> res = new ArrayList<>();
            if(p.isEmpty()){
                return res;
            }else{
                res.add(p);
                return res;
            }

        }
        ArrayList<String> res = new ArrayList<>();
        if(!maze[r][c]){
            return   new ArrayList<>();
        }
        if(r<maze.length-1){
           res.addAll( pathWithRestriction(p+'D',maze,r+1,c));
        }
        if(c<maze[0].length-1){
           res.addAll(pathWithRestriction(p+'R',maze,r,c+1));
        }
        return res;
    }

    // allow all the path top,bottom,left,right

    static ArrayList<String> allPath(String p,boolean[][]maze,int r,int c){
        if(r == maze.length-1 && c== maze[0].length-1){
            ArrayList<String> res = new ArrayList<>();
            if(p.isEmpty()){
                return res;
            }else{
                res.add(p);
                return res;
            }

        }
        ArrayList<String> res = new ArrayList<>();
        if(!maze[r][c]){
            return   new ArrayList<>();
        }
        if(r<maze.length-1){
            res.addAll( allPath(p+'D',maze,r+1,c));
        }
        if(c<maze[0].length-1){
            res.addAll(allPath(p+'R',maze,r,c+1));
        }
        if(r>0){
            res.addAll(allPath(p+'U',maze,r-1,c));
        }
        if(c>0){
            res.addAll(allPath(p+'L',maze,r,c-1));
        }
        return res;
    }
}
