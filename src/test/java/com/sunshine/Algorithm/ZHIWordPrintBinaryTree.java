package com.sunshine.Algorithm;

import java.util.ArrayList;
import java.util.Stack;

public class ZHIWordPrintBinaryTree {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
    public ArrayList<ArrayList<Integer>> Print2(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        if(null==pRoot){
            return ans;
        }
        Stack<TreeNode> s1=new Stack<>();
        s1.push(pRoot);
        Stack<TreeNode> s2=new Stack<>();
        while(!s1.empty()||!s2.empty()){
            ArrayList<Integer> curRow=new ArrayList<>();
            if(!s1.empty()){
                while(!s1.empty()){
                    TreeNode node = s1.pop();
                    curRow.add(node.val);
                    if(null!=node.left){
                        s2.push(node.left);
                    }
                    if(null!=node.right){
                        s2.push(node.right);
                    }
                }
            }else{
                while(!s2.empty()){
                    TreeNode node = s2.pop();
                    curRow.add(node.val);
                    if(null!=node.right){
                        s1.push(node.right);
                    }
                    if(null!=node.left){
                        s1.push(node.left);
                    }

                }
            }
            ans.add(curRow);
        }
        return ans;
    }

    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        if(null==pRoot){
            return ans;
        }
        Stack<TreeNode> curStack=new Stack<>();
        curStack.push(pRoot);
        getStack(curStack,ans);
        return ans;
    }
    private void getStack(Stack<TreeNode> curStack,ArrayList<ArrayList<Integer>> ans){
        if(curStack.empty()){
            return;
        }
        ArrayList<Integer> curRow=new ArrayList<>();
        Stack<TreeNode> curNodeStack=new Stack<>();
        while(!curStack.empty()){
            TreeNode node = curStack.pop();
            curRow.add(node.val);
            if((ans.size()&1)==0){
                if(null!=node.left){
                    curNodeStack.push(node.left);
                }
                if(null!=node.right){
                    curNodeStack.push(node.right);
                }
            }else{
                if(null!=node.right){
                    curNodeStack.push(node.right);
                }
                if(null!=node.left){
                    curNodeStack.push(node.left);
                }
            }

        }
        ans.add(curRow);
        getStack(curNodeStack,ans);
        return ;
    }

}
