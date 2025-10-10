package com.shiv.trees;

public class SegmentTree {

    public static void main(String[] args){
        int[] arr = {3,8,6,7,-2,-8,4,9};
        SegmentTree tree = new SegmentTree(arr);
        tree.display();

        System.out.println("Query(1,3) = " + tree.query(1,3)); // expected 8+6+7 = 21
        tree.update(2, 10); // change arr[2] from 6 to 10
        System.out.println("After update arr[2]=10");
        tree.display();
        System.out.println("Query(1,3) = " + tree.query(1,3)); // expected 8+10+7 = 25
    }

    private static class Node{
        int data;
        int startInterval;
        int endInterval;
        Node left;
        Node right;

        public Node(int startInterval,int endInterval){
            this.startInterval = startInterval;
            this.endInterval = endInterval;
        }
    }

    private Node root;

    public SegmentTree(int[] arr){
        if (arr == null || arr.length == 0) {
            root = null;
        } else {
            this.root = constructTree(arr, 0, arr.length - 1);
        }
    }

    private Node constructTree(int[] arr, int start, int end){
        Node node = new Node(start, end);

        if (start == end){
            node.data = arr[start];
            return node;
        }

        int mid = start + (end - start) / 2;
        node.left = constructTree(arr, start, mid);        // <-- fixed: use start (not 0)
        node.right = constructTree(arr, mid + 1, end);
        node.data = (node.left != null ? node.left.data : 0) + (node.right != null ? node.right.data : 0);
        return node;
    }

    public void display(){
        if (this.root == null) {
            System.out.println("Empty tree");
            return;
        }
        display(this.root);
    }

    private void display(Node node){
        if (node == null) return;

        StringBuilder str = new StringBuilder();

        if(node.left != null){
            str.append("interval=[").append(node.left.startInterval).append("-").append(node.left.endInterval)
                    .append("] and data: ").append(node.left.data).append(" => ");
        } else {
            str.append("no left child => ");
        }

        str.append("interval=[").append(node.startInterval).append("-").append(node.endInterval)
                .append("] and data: ").append(node.data).append(" => ");

        if(node.right != null){
            str.append("interval=[").append(node.right.startInterval).append("-").append(node.right.endInterval)
                    .append("] and data: ").append(node.right.data);
        } else {
            str.append("no right child");
        }

        System.out.println(str.toString() + "\n");

        display(node.left);
        display(node.right);
    }

    public int query(int qsi,int qei){
        if (this.root == null) return 0;
        if (qsi > qei) return 0;
        return this.query(this.root, qsi, qei);
    }

    private int query(Node node,int qsi,int qei){
        if (node == null) return 0;

        // completely inside query range
        if(node.startInterval >= qsi && node.endInterval <= qei){
            return node.data;
        }

        // completely outside query range
        if(node.endInterval < qsi || node.startInterval > qei){
            return 0;
        }

        // partial overlap
        return this.query(node.left, qsi, qei) + this.query(node.right, qsi, qei);
    }

    public void update(int index,int val){
        if (this.root == null) return;
        update(this.root, index, val);
    }

    private int update(Node node,int index,int val){
        if (node == null) return 0;

        // index not in this node's interval -> no change
        if (index < node.startInterval || index > node.endInterval) {
            return node.data;
        }

        // leaf node
        if(node.startInterval == node.endInterval && node.startInterval == index){
            node.data = val;
            return node.data;
        }

        // internal node: propagate to children
        int leftVal = update(node.left, index, val);
        int rightVal = update(node.right, index, val);
        node.data = leftVal + rightVal;
        return node.data;
    }
}
