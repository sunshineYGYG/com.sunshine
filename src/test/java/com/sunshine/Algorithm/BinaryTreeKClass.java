package com.sunshine.Algorithm;

import org.junit.Test;

public class BinaryTreeKClass {
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
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        n2.left = n1;
        n2.right = n3;
        TreeNode treeNode = KthNode(n2, 3);
        System.out.println(treeNode.val);
    }

    //自己的答案
    private int n;
    private TreeNode answer;
    TreeNode KthNode(TreeNode pRoot, int k) {
        n=k;
        solve(pRoot);
        return answer;
    }

    void solve(TreeNode cur){
        if (null == cur || null != answer) {
            return;
        }
        solve(cur.left);
        n--;
        if(0 == n){
            answer=cur;
            return;
        }
        solve(cur.right);
    }

}
