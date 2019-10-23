package com.sunshine.OFFER66_SECOND;

import org.junit.Test;

public class A4_reConstructBinaryTree {

    @Test
    public void test() {
        int[] pre = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] in = {4, 7, 2, 1, 5, 3, 8, 6};
        TreeNode root = reConstructBinaryTree(pre, in);
        TreeUtility.printTreeOfLine(root);
    }


    int[] pre;
    int[] in;
    int pos = 0;

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (in.length == 0 || pre.length == 0) {
            return null;
        }
        this.pre = pre;
        this.in = in;
        TreeNode root = createTreeNode(0, in.length - 1);
        return root;
    }

    private TreeNode createTreeNode(int left, int right) {
        if (left > right) {
            pos--;
            return null;
        }
        if (left == right) {
            TreeNode newCode = new TreeNode(in[left]);
            return newCode;
        }
        for (int i = left; i <= right; i++) {
            if (pre[pos] == in[i]) {
                TreeNode cur = new TreeNode(pre[pos]);
                pos++;
                cur.left = createTreeNode(left, i - 1);
                pos++;
                cur.right = createTreeNode(i + 1, right);
                return cur;
            }
        }
        return null;
    }
}
