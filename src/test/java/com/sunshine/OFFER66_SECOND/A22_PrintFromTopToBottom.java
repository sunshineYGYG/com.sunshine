package com.sunshine.OFFER66_SECOND;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;

public class A22_PrintFromTopToBottom {

    @Test
    public void test() {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;

        ArrayList<Integer> arrayList = PrintFromTopToBottom(n1);
        arrayList.forEach(a -> System.out.println(a + " "));
    }


    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        if (null == root) {
            return new ArrayList<>();
        }
        ArrayList<Integer> ans = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (queue.size() != 0) {
            TreeNode cur = queue.pop();
            ans.add(cur.val);
            if (cur.left != null) {
                queue.add(cur.left);
            }
            if (cur.right != null) {
                queue.add(cur.right);
            }
        }
        return ans;
    }


}
