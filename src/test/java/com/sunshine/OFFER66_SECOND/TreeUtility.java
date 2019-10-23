package com.sunshine.OFFER66_SECOND;

import java.util.LinkedList;

public class TreeUtility {

    //按行打印
    public static void printTreeOfLine(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        LinkedList<TreeNode> nextQueue = new LinkedList<>();
        queue.add(root);
        nextQueue.add(root);
        while (!nextQueue.isEmpty()) {
            nextQueue.clear();
            while (!queue.isEmpty()) {
                TreeNode cur = queue.poll();
                if(null == cur){
                    System.out.print("#" + " ");
                    continue;
                }
                System.out.print(cur.val + " ");
                nextQueue.add(cur.left);
                nextQueue.add(cur.right);
            }
            queue.addAll(nextQueue);
            System.out.println();
        }

    }

    public static void printTreeOfLine(BalanceTreeNode root) {
        LinkedList<BalanceTreeNode> queue = new LinkedList<>();
        LinkedList<BalanceTreeNode> nextQueue = new LinkedList<>();
        queue.add(root);
        nextQueue.add(root);
        while (!nextQueue.isEmpty()) {
            nextQueue.clear();
            while (!queue.isEmpty()) {
                BalanceTreeNode cur = queue.poll();
                if(null == cur){
                    System.out.print("#" + " ");
                    continue;
                }
                System.out.print(cur.val + " ");
                nextQueue.add(cur.left);
                nextQueue.add(cur.right);
            }
            queue.addAll(nextQueue);
            System.out.println();
        }

    }
}
