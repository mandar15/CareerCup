package com.leetcode;

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class TreeZigZagTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        if(root == null) {
            return result;
        } else {
            List<TreeNode> tempList = new ArrayList<TreeNode>();
            tempList.add(root);
            
            List<Integer> currLevelNodeList = new ArrayList<Integer>();
            currLevelNodeList.add(root.val);
            
            boolean rightLeftTraversal = true;
            
            while(tempList.size() != 0) {
                result.add(currLevelNodeList); 
                currLevelNodeList = new ArrayList<Integer>();
                
                for(int j = tempList.size() - 1; j >= 0; j--) {
                    TreeNode left = tempList.get(j).left;
                    TreeNode right = tempList.get(j).right;
                    
                    if(rightLeftTraversal) {
                        if(right != null) {
                            currLevelNodeList.add(right.val);
                            tempList.add(right);
                        }
                        if(left != null) {
                            currLevelNodeList.add(left.val);
                            tempList.add(left);
                        }
                    } else {
                        if(left != null) {
                            currLevelNodeList.add(left.val);
                            tempList.add(left);
                        }
                        if(right != null) {
                            currLevelNodeList.add(right.val);
                            tempList.add(right);
                        }
                    }
                    tempList.remove(j);
                }

                rightLeftTraversal = !rightLeftTraversal;
            }
        }
        
        return result;
    }
    
    public static void main(String args[]) {
        TreeNode n3 = new TreeNode(3);
        TreeNode n9 = new TreeNode(9);
        TreeNode n20 = new TreeNode(20);
        TreeNode n15 = new TreeNode(15);
        TreeNode n7 = new TreeNode(7);
        
        n3.left = n9;
        n3.right = n20;
        n20.left = n15;
        n20.right = n7;
        
        TreeZigZagTraversal treeZigZagTraversal = new TreeZigZagTraversal();
        System.out.println(treeZigZagTraversal.zigzagLevelOrder(n3));
    }
}

