package com.sunshine.Algorithm;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TreeConvertListClass {
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
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;
        Convert(n1);
        System.out.println();
        order.forEach(order->System.out.print(" -> "+order.val));
    }

    private List<TreeNode> order = new ArrayList<>();
    //自己的答案
    public TreeNode Convert(TreeNode pRootOfTree) {
        if(null == pRootOfTree){
            return null;
        }
        solve(pRootOfTree);
        int size = order.size();
        for (int i = 0; i < size; i++) {
            TreeNode treeNode = order.get(i);
            treeNode.left = i - 1 >= 0 ? order.get(i - 1) : null;
            treeNode.right = i + 1 < size ? order.get(i + 1) : null;
        }
        return order.get(0);
    }

    public void solve(TreeNode cur) {
        if (null == cur) {
            return;
        }
        solve(cur.left);
        System.out.print(" -> " + cur.val);
        order.add(cur);
        solve(cur.right);
    }

    @Test
    public void test2() {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        n1.left = n2;
        n1.right = n3;
        TreeNode treeNode = Convert3(n1);
        System.out.println();
        while(null != treeNode){
            System.out.print(" -> "+treeNode.val);
            treeNode=treeNode.right;
        }
    }

    //优解
    TreeNode head = null;
    TreeNode realHead = null;
    public TreeNode Convert3(TreeNode pRootOfTree) {
        ConvertSub(pRootOfTree);
        return realHead;
    }

    private void ConvertSub(TreeNode pRootOfTree) {
        if(pRootOfTree==null) return;
        ConvertSub(pRootOfTree.left);
        if (head == null) {
            head = pRootOfTree;
            realHead = pRootOfTree;
        } else {
            head.right = pRootOfTree;
            pRootOfTree.left = head;
            head = pRootOfTree;
        }
        ConvertSub(pRootOfTree.right);
    }
}
