package com.sunshine.Algorithm;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

public class TreeDepthClass {
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
        int[] arr={8,6,10,5,7,9,11};
        TreeNode root = initTree(arr);
        System.out.println(TreeDepth(root));
    }
    public int TreeDepth(TreeNode root) {
        if(null==root){
            return 0;
        }
        int leftDepth=TreeDepth(root.left);
        int rightDepth=TreeDepth(root.right);
        return leftDepth>rightDepth?leftDepth+1:rightDepth+1;
    }

    public static int ans;
    public int TreeDepth2(TreeNode root) {
        if(null==root){
            return 0;
        }
        ans=0;
        AddDepth(root,1,1);
        return ans;
    }
    private void AddDepth(TreeNode node,int leftDepth,int rightDepth){
        if(null!=node.left){
            AddDepth(node.left,++leftDepth,rightDepth);
        }
        if(null!=node.right){
            AddDepth(node.right,leftDepth,++rightDepth);
        }
        int max=leftDepth>=rightDepth?leftDepth:rightDepth;
        ans=ans>=max?ans:max;
        return ;
    }

    public TreeNode initTree(int[] arr) {
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode node = new TreeNode(arr[0]);
        queue.add(node);
        for (int i = 1; i < arr.length; i++) {
            TreeNode lchild = new TreeNode(arr[i]);
//            System.out.println(queue.size());
            TreeNode treeLinkNode = queue.poll();
//            System.out.println(queue.size());
            treeLinkNode.left = lchild;
            queue.add(lchild);
            if (i + 1 < arr.length) {
                TreeNode rchild = new TreeNode(arr[++i]);
                treeLinkNode.right = rchild;
                queue.add(rchild);
            }
        }
        return node;
    }

}
