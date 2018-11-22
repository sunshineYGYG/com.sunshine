package com.sunshine.Algorithm;

public class IsBalancedBinaryTree {
    public class TreeNode {
        TreeNode left = null;
        TreeNode right = null;
    }
    private boolean isBalancedTree=true;
    public boolean IsBalanced_Solution(TreeNode root) {
        getDepth(root);
        return isBalancedTree;
    }
    private int getDepth(TreeNode node){
        if(null==node){
            return 0;
        }
        int left=getDepth(node.left);
        int right=getDepth(node.right);
        if(Math.abs(left-right)>1){
            isBalancedTree=false;
        }
        return left>right?left+1:right+1;
    }
}
