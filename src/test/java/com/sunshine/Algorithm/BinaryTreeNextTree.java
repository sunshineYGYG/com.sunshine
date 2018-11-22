package com.sunshine.Algorithm;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeNextTree {
    public class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }

    public static TreeLinkNode testNode;

    @Test
    public void createTree() {
        int[] arr = {1, 2, 3, 4};
        TreeLinkNode root = new TreeLinkNode(arr[0]);
        initTree(root, arr, 1);
        midTraverse2(root);
    }

    @Test
    public void queueTree() {
        int[] arr = {8, 6, 10, 5, 7, 9, 11};
        TreeLinkNode root = initTree2(arr);
        midTraverse2(root);
        System.out.println();
        TreeLinkNode ans = GetNext(testNode);
        if(null!=ans){
            System.out.println(ans.val);
        }else{
            System.out.println("null");
        }

    }

    public void midTraverse(TreeLinkNode node, TreeLinkNode pNode, boolean flag, TreeLinkNode ans) {
        if (null == node) {
            return;
        }
        if (null != node.left) {
            midTraverse(node.left, pNode, flag, ans);
        }
        if (flag) {
            ans = node;
        }
        if (node == pNode) {
            flag = true;
        }
        midTraverse(node.right, pNode, flag, ans);

    }
    public void midTraverse2(TreeLinkNode node) {
        if (null == node) {
            return;
        }
        if (null != node.left) {
            midTraverse2(node.left);
        }
        if(node.val==11){
            testNode=node;
        }
        System.out.print(node.val+" ");
        midTraverse2(node.right);

    }

    public TreeLinkNode initTree2(int[] arr) {
        Queue<TreeLinkNode> queue = new LinkedList<>();
        TreeLinkNode node = new TreeLinkNode(arr[0]);
        queue.add(node);
        for (int i = 1; i < arr.length; i++) {
            TreeLinkNode lchild = new TreeLinkNode(arr[i]);
//            System.out.println(queue.size());
            TreeLinkNode treeLinkNode = queue.poll();
//            System.out.println(queue.size());
            treeLinkNode.left = lchild;
            queue.add(lchild);
            if (i + 1 < arr.length) {
                TreeLinkNode rchild = new TreeLinkNode(arr[++i]);
                treeLinkNode.right = rchild;
                queue.add(rchild);
            }
        }
        return node;
    }

    public void initTree(TreeLinkNode node, int[] arr, int pos) {
        if (pos >= arr.length) {
            return;
        }
        TreeLinkNode lchild;
        TreeLinkNode rchild;
        if (null == node.left && pos < arr.length) {
            lchild = new TreeLinkNode(arr[pos++]);
            node.left = lchild;
        }
        if (null == node.right && pos < arr.length) {
            rchild = new TreeLinkNode(arr[pos++]);
            node.right = rchild;
        }
        initTree(node.left, arr, pos);
        initTree(node.right, arr, pos);
    }

    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        TreeLinkNode curNode=pNode;
        if (curNode.right == null) {
            TreeLinkNode lastNode=curNode.next;
            while(null!=lastNode&&curNode==lastNode.right){
                curNode=lastNode;
                lastNode=lastNode.next;
            }
            if(null!=lastNode&&curNode==lastNode.left){
                return lastNode;
            }
        } else {
            curNode=curNode.right;
            while (null != curNode.left) {
                curNode = curNode.left;
            }
            return curNode;
        }
        return null;
    }
}
