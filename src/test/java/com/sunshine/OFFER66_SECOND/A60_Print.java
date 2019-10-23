package com.sunshine.OFFER66_SECOND;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;

public class A60_Print {


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


    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        if(null == pRoot){
            return ans;
        }
        LinkedList<TreeNode> q1=new LinkedList<>();
        q1.add(pRoot);
        LinkedList<TreeNode> q2=new LinkedList<>();
        while(!q1.isEmpty()||!q2.isEmpty()){
            ArrayList<Integer> row=new ArrayList<>();
            if(!q1.isEmpty()){
                while(!q1.isEmpty()){
                    TreeNode node = q1.pop();
                    row.add(node.val);
                    if(null!=node.left){
                        q2.add(node.left);
                    }
                    if(null!=node.right){
                        q2.add(node.right);
                    }
                }
            }else{
                while(!q2.isEmpty()){
                    TreeNode node = q2.pop();
                    row.add(node.val);
                    if(null!=node.left){
                        q1.add(node.left);
                    }
                    if(null!=node.right){
                        q1.add(node.right);
                    }
                }
            }
            ans.add(row);
        }
        return ans;
    }
}
