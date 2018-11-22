package com.sunshine.Algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class PrintBinaryTree {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        if(null==pRoot){
            return new ArrayList<>();
        }
        Queue<TreeNode> q1=new LinkedList<>();
        Queue<TreeNode> q2=new LinkedList<>();
        q1.add(pRoot);
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        while(!q1.isEmpty()||!q2.isEmpty()){
            ArrayList<Integer> arrayList=new ArrayList<>();
            if(!q1.isEmpty()) {
                while (!q1.isEmpty()) {
                    TreeNode node = q1.poll();
                    arrayList.add(node.val);
                    if (node.left != null) {
                        q2.add(node.left);
                    }
                    if (node.right != null) {
                        q2.add(node.right);
                    }
                }
            }else{
                while (!q2.isEmpty()) {
                    TreeNode node = q2.poll();
                    arrayList.add(node.val);
                    if (node.left != null) {
                        q1.add(node.left);
                    }
                    if (node.right != null) {
                        q1.add(node.right);
                    }
                }
            }
            ans.add(arrayList);
        }
        return ans;
    }

}
