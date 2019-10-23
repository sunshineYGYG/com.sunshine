package com.sunshine.OFFER66_SECOND;

import org.junit.Test;

public class A39_IsBalanced_Solution {

    @Test
    public void test(){
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        n1.left=n2;
//        n2.right=n3;
        n1.right=n4;
        n4.right=n5;
        n5.right=n3;
        boolean b = IsBalanced_Solution(n1);
        System.out.println(b);
    }

    public boolean IsBalanced_Solution(TreeNode root) {
        if (root == null) {
            return true;
        }
        TreeDepth(root);
        return ans;
    }

    boolean ans = true;

    public int TreeDepth(TreeNode root) {
        //剪枝
        if(!ans){
            return 0;
        }
        if (root == null) {
            return 0;
        }
        int leftDepth = TreeDepth(root.left);
        int rightDepth = TreeDepth(root.right);
        if (leftDepth - rightDepth < -1 || leftDepth - rightDepth > 1) {
            ans = false;
        }
        return (leftDepth > rightDepth ? leftDepth : rightDepth) + 1;
    }
}
