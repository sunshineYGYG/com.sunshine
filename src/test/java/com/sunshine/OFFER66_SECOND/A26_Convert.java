package com.sunshine.OFFER66_SECOND;

import org.junit.Test;

public class A26_Convert {


    @Test
    public void test() {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);

        n4.left = n2;
        n2.left = n1;
        n2.right = n3;

        n4.right = n6;
        n6.left = n5;
        n6.right = n7;

        Convert(n4);
        System.out.println();
        TreeNode pre = first;
        while (null != first) {
            System.out.print(first.val + "->");
            pre = first;
            first = first.right;
        }
        System.out.println();
        while (pre != null) {
            System.out.print(pre.val + "->");
            pre = pre.left;
        }


    }
    //其他人解
    TreeNode first = null;
    TreeNode pre = null;

    public TreeNode Convert(TreeNode pRootOfTree) {
        if (null == pRootOfTree) {
            return null;
        }

        TreeToList(pRootOfTree);
        return pRootOfTree;
    }

    public void TreeToList(TreeNode cur) {
        if (null == cur) {
            return;
        }
        TreeToList(cur.left);
        cur.left = pre;
        if (null != pre) {
            pre.right = cur;
        }
        pre = cur;
        if (null == first) {
            first = cur;
        }
        TreeToList(cur.right);
    }


}
