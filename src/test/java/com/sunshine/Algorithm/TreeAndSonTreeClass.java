package com.sunshine.Algorithm;

import org.junit.Test;

public class TreeAndSonTreeClass {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    @Test
    public void test() {
        TreeNode n1 = new TreeNode(8);
        TreeNode n2 = new TreeNode(8);
        TreeNode n3 = new TreeNode(7);
        TreeNode n4 = new TreeNode(9);
        TreeNode n5 = new TreeNode(3);
        TreeNode n6 = new TreeNode(4);
        TreeNode n7 = new TreeNode(7);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n5.left = n6;
        n5.right = n7;

        TreeNode nn2 = new TreeNode(8);
        TreeNode nn4 = new TreeNode(9);
        TreeNode nn5 = new TreeNode(2);
        nn2.left = nn4;
        nn2.right = nn5;

        boolean re = HasSubtree(n1, nn2);
        System.out.println(re);
        System.out.println(answer);
    }

    //自己的答案
    private boolean answer = false;
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if(null == root2){
            return false;
        }
        if (answer) {
            return answer;
        }
        if (solve(root1, root2)) {
            answer = true;
            return true;
        }
        if(null !=root1) {
            boolean b = HasSubtree(root1.left, root2);
            if (b) {
                return true;
            }
            boolean b1 = HasSubtree(root1.right, root2);
            if (b1) {
                return true;
            }
        }
        return answer;
    }

    public boolean solve(TreeNode source, TreeNode target) {
        if (null == target) {
            return true;
        }

        if (null == source) {
            return false;
        }

        if (source.val != target.val) {
            return false;
        }

        return solve(source.left, target.left)&&solve(source.right, target.right);
    }

    //优解把一些flag简化。

}
