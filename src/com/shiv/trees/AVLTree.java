package com.shiv.trees;
public class AVLTree {

    public class Node{
        private int value;
        private int height;
        private Node left;
        private Node right;
        public Node(int value){
            this.value = value;
        }

        public int getValue(){
            return value;
        }
    }

    private Node root;

    public AVLTree(){

    }
    public int height(){
        return height(root);
    }

    private int height(Node node){
        if(node == null){
            return -1;
        }
        return node.height;
    }

    public boolean isEmpty(){
        return root == null;
    }


    public void insert(int val){
        root = insert(val,root);
    }

    private Node insert(int val,Node node){
        if(node == null){
            node = new Node(val);
            return node;
        }
        if(val<node.value){
            node.left  = insert(val,node.left);
        }
        if(val>node.value){
            node.right = insert(val,node.right);
        }
        node.height = Math.max(height(node.left),height(node.right))+1;
        return rotate(node);
    }

    private Node rotate(Node node){
        if(height(node.left)-height(node.right)>1){
            // left-heavy case
            if(height(node.left.left)-height(node.left.right)>0){
                // left -left case
                return rightRotate(node);
            }
            if(height(node.left.left)-height(node.left.right)<0){
                // left -right case
                node.left = leftRotate(node.left);
                return rightRotate(node);
            }
        }

        if(height(node.left)-height(node.right)<-1){
            // right-heavy case
            if(height(node.right.left)-height(node.right.right)<0){
                // right  -right case
                return leftRotate(node);
            }
            if(height(node.right.left)-height(node.right.right)>0){
                // right -left case
                node.right = rightRotate(node.right);
                return leftRotate(node);
            }
        }
        return node;
    }

    private Node rightRotate(Node p){
        Node c= p.left;
        Node t= c.right;

        c.right = p;
        p.right = t;
        c.height = Math.max(height(c.right),height(c.left)+1);
        p.height = Math.max(height(p.right),height(p.left)+1);
        return c;
    }

    private Node leftRotate(Node c){
        Node p = c.right;
        Node t= p.left;
        p.left = c;
        c.right = t;
        c.height = Math.max(height(c.right),height(c.left)+1);
        p.height = Math.max(height(p.right),height(p.left)+1);
        return p;
    }

    public void display(){
        display(root,"Root Node: ");
    }

    private void display(Node node,String details){
        if(node == null){
            return;
        }

        System.out.println(details+node.getValue());

        display(node.left,"Left child of "+ node.getValue() + " : ");
        display(node.right,"Right child of "+ node.getValue() + " : ");

    }

    private boolean balanced(Node node){
        if(node == null){
            return true;
        }
        return Math.abs(height(node.left)-height(node.right))<=1 && balanced(node.left)&& balanced(node.right);

    }

    public void populate(int[] nums){
        for(int i =0; i<nums.length; i++){
            this.insert(nums[i]);
        }
    }

}

