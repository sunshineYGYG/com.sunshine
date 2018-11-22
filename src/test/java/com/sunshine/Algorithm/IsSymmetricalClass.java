package com.sunshine.Algorithm;


import java.util.LinkedList;
import java.util.Queue;

public class IsSymmetricalClass {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
    boolean isSymmetrical(TreeNode pRoot){
        boolean flag=true;
        TreeNode node=pRoot;
        TreeNode lnode=null;
        TreeNode rnode=null;
        if(null==node.left&&null==node.right){
            return true;
        }else if(null!=node.left&&null!=node.right&&node.left.val==node.right.val){
            lnode=node.left;
            rnode=node.right;
        }else{
            return false;
        }
        while(flag){
            if(lnode.val!=rnode.val){
                return false;
            }
            if(null==lnode.left&&null==rnode.right){

            }
            if(null==lnode.right&&null==rnode.left){

            }
        }
        return false;
    }
    private boolean traverseTree(TreeNode node){
        return false;
    }
}
