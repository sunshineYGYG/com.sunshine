package com.sunshine.OFFER66_SECOND;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Stack;

public class A59_Print {

    @Test
    public void test(){
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
        ArrayList<ArrayList<Integer>> print = Print(n1);
        for (ArrayList<Integer> arrayList : print) {
            for (Integer integer : arrayList) {
                System.out.print(integer+" ");
            }
            System.out.println();
        }
    }



    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        if(null == pRoot){
            return ans;
        }
        Stack<TreeNode> s1=new Stack<>();
        s1.push(pRoot);
        Stack<TreeNode> s2=new Stack<>();
        while(!s1.empty()||!s2.empty()){
            ArrayList<Integer> row=new ArrayList<>();
            if(!s1.empty()){
                while(!s1.empty()){
                    TreeNode node = s1.pop();
                    row.add(node.val);
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
                    row.add(node.val);
                    if(null!=node.right){
                        s1.push(node.right);
                    }
                    if(null!=node.left){
                        s1.push(node.left);
                    }
                }
            }
            ans.add(row);
        }
        return ans;
    }
}
