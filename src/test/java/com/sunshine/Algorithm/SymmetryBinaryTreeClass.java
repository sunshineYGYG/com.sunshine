package com.sunshine.Algorithm;

import org.junit.Test;

public class SymmetryBinaryTreeClass {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    @Test
    public void test(){
        TreeNode node1 =new TreeNode(1);
        TreeNode node2 =new TreeNode(2);
        TreeNode node3 =new TreeNode(2);
        node1.left=node2;
        node1.right=node3;
        boolean symmetrical = isSymmetrical(node1);
        System.out.println(symmetrical);
    }

    boolean isSymmetrical(TreeNode pRoot) {
        return solve(pRoot,pRoot);
    }

    boolean solve(TreeNode nl,TreeNode nr){
        if(nl == null && nr == null){
            return true;
        }
        if((nl ==null && nr != null)||(nl != null && nr == null)){
            return false;
        }
        if(nl.val != nr.val){
            return false;
        }
        return solve(nl.left,nr.right)&&solve(nl.right,nr.left);
    }

}
