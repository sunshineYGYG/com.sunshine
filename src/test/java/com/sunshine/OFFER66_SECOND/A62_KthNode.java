package com.sunshine.OFFER66_SECOND;

import org.junit.Test;

public class A62_KthNode {

    @Test
    public void test() {
        TreeNode n1 = new TreeNode(5);
        TreeNode n2 = new TreeNode(3);
        TreeNode n3 = new TreeNode(7);
        TreeNode n4 = new TreeNode(2);
        TreeNode n5 = new TreeNode(4);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(8);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;
        TreeNode node = KthNode(n1, 3);
        System.out.println(node.val);
    }

    TreeNode ans = null;
    int pos = 0;

    TreeNode KthNode(TreeNode pRoot, int k) {
        if(null == pRoot){
            return null;
        }
        preTraverse(pRoot, k);
        return ans;
    }

    private void preTraverse(TreeNode cur, int k) {
        if (null != ans) {
            return;
        }
        if (null != cur.left) {
            preTraverse(cur.left, k);
        }
        pos++;
        if (pos == k && null == ans) {
            ans = cur;
            return;
        }
//        System.out.print(cur.val+"->");
        if (null != cur.right) {
            preTraverse(cur.right, k);
        }
    }
}
