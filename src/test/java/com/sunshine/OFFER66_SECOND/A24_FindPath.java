package com.sunshine.OFFER66_SECOND;

import org.junit.Test;

import java.util.ArrayList;

public class A24_FindPath {


    @Test
    public void test() {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(6);
        TreeNode n5 = new TreeNode(5);
        TreeNode n7 = new TreeNode(1);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n5.right = n7;

        ArrayList<ArrayList<Integer>> arrayLists = FindPath(n1, 9);
        arrayLists.forEach(a -> {
            a.forEach(b -> System.out.print(b + " ->"));
            System.out.println();
        });
    }


    ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if(root==null){
            return ans;
        }
        FindAnswers(root, target, new ArrayList<>());
        ans.sort((ArrayList<Integer> a, ArrayList<Integer> b) -> a.size() >= b.size() ? -1 : 1);
        return ans;
    }

    public void FindAnswers(TreeNode cur, int sum, ArrayList<Integer> path) {
        int count = sum - cur.val;
        path.add(cur.val);
        if (count == 0 ) {
            if(cur.right == null && cur.left == null) {
                ArrayList<Integer> onePath = new ArrayList<>(path);
                ans.add(onePath);
                return;
            }else{
                return;
            }
        }else if(count < 0){
            return;
        }
        if(null != cur.left){
            FindAnswers(cur.left, count, path);
            path.remove(path.size() - 1);
        }
        if(null != cur.right) {
            FindAnswers(cur.right, count, path);
            path.remove(path.size() - 1);
        }
    }


}
