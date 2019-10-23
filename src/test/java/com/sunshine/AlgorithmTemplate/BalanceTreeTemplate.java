package com.sunshine.AlgorithmTemplate;

import com.sunshine.OFFER66_SECOND.BalanceTreeNode;
import com.sunshine.OFFER66_SECOND.TreeUtility;
import org.junit.Test;

public class BalanceTreeTemplate {

    @Test
    public void test() {
        insert(5);
        insert(2);
        insert(3);
        insert(4);
        insert(1);
        insert(6);
        insert(7);
        insert(0);
        insert(8);
        delete(5);
        delete(6);
        delete(3);
    }

    public void insert(int num) {
        root = insert(root, num);
        TreeUtility.printTreeOfLine(root);
        System.out.println("==========");
    }

    public void delete(int num) {
        root = deleteNode(root, num);
        TreeUtility.printTreeOfLine(root);
        System.out.println("==========");
    }

    BalanceTreeNode root = null;

    private int getTreeHeight(BalanceTreeNode node) {
        if (null == node) {
            return 0;
        }
        return node.height;
    }

    private void setTreeHeight(BalanceTreeNode node) {
        if (null == node) {
            return;
        }
        int leftHeight = getTreeHeight(node.left);
        int rightHeight = getTreeHeight(node.right);
        node.height = 1 + (leftHeight > rightHeight ? leftHeight : rightHeight);
    }

    private int getBalanceFactor(BalanceTreeNode node) {
        return getTreeHeight(node.left) - getTreeHeight(node.right);
    }

    private int getMaxValue(BalanceTreeNode node){
        while(null != node.right){
            node = node.right;
        }
        return node.val;
    }

    private int getMinValue(BalanceTreeNode node){
        while(null != node.left){
            node = node.left;
        }
        return node.val;
    }

    private BalanceTreeNode LLRotate(BalanceTreeNode node) {
        BalanceTreeNode nodeLC = node.left;
        node.left = nodeLC.right;
        nodeLC.right = node;

        setTreeHeight(node);
        setTreeHeight(nodeLC);
        return nodeLC;
    }

    private BalanceTreeNode RRRotate(BalanceTreeNode node) {
        BalanceTreeNode nodeRC = node.right;
        node.right = nodeRC.left;
        nodeRC.left = node;

        setTreeHeight(node);
        setTreeHeight(nodeRC);
        return nodeRC;
    }

    private BalanceTreeNode LRRotate(BalanceTreeNode node) {
        node.left = RRRotate(node.left);
        return LLRotate(node);
    }

    private BalanceTreeNode RLRotate(BalanceTreeNode node) {
        node.right = LLRotate(node.right);
        return RRRotate(node);
    }

    public BalanceTreeNode insert(BalanceTreeNode cur, int val) {
        if (null == cur) {
            return new BalanceTreeNode(val);
        }
        if (val < cur.val) {
            cur.left = insert(cur.left, val);
        } else if (val > cur.val) {
            cur.right = insert(cur.right, val);
        } else {
            return cur;
        }

        return adjust(cur,val);
    }

    private BalanceTreeNode adjust(BalanceTreeNode cur,int val){
        if(null == cur){
            return cur;
        }
        setTreeHeight(cur);
        int balanceFactor = getBalanceFactor(cur);
        if (balanceFactor < -1) {
            //RR
            if (val > cur.right.val) {
                return RRRotate(cur);
            }
            //RL
            else {
                return RLRotate(cur);
            }
        }
        if (balanceFactor > 1) {
            //LL
            if (val < cur.left.val) {
                return LLRotate(cur);
            }
            //LR
            else {
                return LRRotate(cur);
            }
        }
        return cur;
    }

    public BalanceTreeNode deleteNode(BalanceTreeNode cur, int val) {
        if (cur == null) {
            return cur;
        }
        if (val < cur.val) {
            cur.left = deleteNode(cur.left,val);
        }else if(val>cur.val){
            cur.right = deleteNode(cur.right,val);
        }else{
            BalanceTreeNode tmp = cur;
            if(null == cur.left && null == cur.right){
                cur = null;
            }else if(null == cur.left){
                cur = cur.right;
            }else if(null == cur.right){
                cur = cur.left;
            }else {
                if(getBalanceFactor(cur)>=0){
                    int remVal = getMaxValue(cur.left);
                    cur.val = remVal;
                    cur.left = deleteNode(cur.left, remVal);
                }else{
                    int remVal = getMinValue(cur.right);
                    cur.val = remVal;
                    cur.right = deleteNode(cur.right, remVal);
                }
            }
        }

        return adjust(cur,val);
    }
}
