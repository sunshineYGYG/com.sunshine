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
        TreeNode node =new TreeNode(2);
        if(node.right == node.left){
            System.out.println("true");
        }
    }

    boolean isSymmetrical(TreeNode pRoot) {

        return true;
    }

    boolean solve(TreeNode nl,TreeNode nr){

        return false;
    }

    boolean compare(TreeNode nl,TreeNode nr){
        if(null ==nl && null == nr){
            return true;
        }
        if(null == nl && null != nr){
            return false;
        }
        if(null != nl && null == nr){
            return false;
        }
        if(nl.val != nr.val){
            return false;
        }
        return true;
    }
}
