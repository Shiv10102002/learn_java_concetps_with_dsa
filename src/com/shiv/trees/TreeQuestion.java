package com.shiv.trees;

import java.util.*;

public class TreeQuestion {
    public static void main(String[] args) {

    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();

        if (root == null) {
            return ans;
        }

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currentLevelList = new ArrayList<>();
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                currentLevelList.add(currentNode.val);
                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                }

            }
            ans.add(currentLevelList);
        }
        return ans;
    }

//Average of Levels in Binary Tree

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            Double currentLevelSum = 0.0;
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                currentLevelSum += currentNode.val;
                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }

                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                }
            }

            Double avg = currentLevelSum / (double) levelSize;
            ans.add(avg);
        }
        return ans;
    }

    public TreeNode findSuccessor(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode currentNode = queue.poll();
            if (currentNode.left != null) {
                queue.add(currentNode.left);
            }
            if (currentNode.right != null) {
                queue.add(currentNode.right);
            }
            if (currentNode.val == key) {
                break;
            }
        }
        return queue.peek();
    }
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }

        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        boolean  reverse = false;
        while(!queue.isEmpty()){
            int levelSize = queue.size();
            List<Integer> currentList = new ArrayList<>();
            for(int i= 0; i<levelSize; i++){
                if(!reverse){
                    TreeNode currentNode = queue.pollFirst();
                    currentList.add(currentNode.val);
                    if(currentNode.left != null){
                        queue.addLast(currentNode.left);
                    }
                    if(currentNode.right!=null){
                        queue.addLast(currentNode.right);
                    }

                }else{
                    TreeNode currentNode = queue.pollLast();
                    currentList.add(currentNode.val);
                    if(currentNode.right!=null){
                        queue.addFirst(currentNode.right);
                    }
                    if(currentNode.left != null){
                        queue.addFirst(currentNode.left);
                    }

                }

            }
            ans.add(currentList);
            reverse = !reverse;
        }
        return ans;
    }


    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return null;

        }

        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left,right)+1;
    }

}

