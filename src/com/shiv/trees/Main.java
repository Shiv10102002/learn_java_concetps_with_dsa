package com.shiv.trees;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
//        Scanner scanner = new Scanner(System.in);
//        BinaryTree tree = new BinaryTree();
//        tree.populate(scanner);
////        tree.display();
//        tree.prettyDisplay();


        AVLTree tree = new AVLTree();
        for(int i=0; i<1000; i++){
            tree.insert(i);
        }

        System.out.println(tree.height());
    }
}
