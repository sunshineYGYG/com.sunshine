package com.sunshine.Algorithm;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Stack;

public class BinaryTreePathSumClass {
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
        n1.left = n2;
        n1.right = n3;
        ArrayList<ArrayList<Integer>> answer = FindPath2(n1, 3);
        answer.forEach(a -> a.forEach(b -> System.out.print(" -> " + b)));
    }

    //自己的答案
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> answer = new ArrayList<>();
        if (null == root) {
            return answer;
        }
        ArrayList<Integer> path = new ArrayList<>();
        path.add(root.val);
        solve(root, path, root.val, target, answer);
        return answer;
    }

    private void solve(TreeNode cur, ArrayList<Integer> path, Integer sum, Integer target, ArrayList<ArrayList<Integer>> answer) {
        if (null == cur.right && null == cur.left && sum == target) {
            ArrayList<Integer> re = new ArrayList<>(path);
            answer.add(re);
            return;
        }
        if (sum >= target) {
            return;
        }
        if (null != cur.left) {
            TreeNode left = cur.left;
            path.add(left.val);
            sum += left.val;
            solve(left, path, sum, target, answer);
            sum -= left.val;
            path.remove(path.size() - 1);
        }

        if (null != cur.right) {
            TreeNode right = cur.right;
            path.add(right.val);
            sum += right.val;
            solve(right, path, sum, target, answer);
            sum -= right.val;
            path.remove(path.size() - 1);
        }
    }

    private ArrayList<ArrayList<Integer>> answer = new ArrayList<>();
    ArrayList<Integer> path = new ArrayList<>();

    //优解
    public ArrayList<ArrayList<Integer>> FindPath2(TreeNode root, int target) {
        if (null == root) {
            return answer;
        }
        path.add(root.val);
        target -= root.val;
        if (null == root.left && null == root.right && 0 == target) {
            answer.add(new ArrayList<>(path));
        }
        FindPath2(root.left, target);
        FindPath2(root.right, target);
        path.remove(path.size() - 1);
        return answer;
    }
}
