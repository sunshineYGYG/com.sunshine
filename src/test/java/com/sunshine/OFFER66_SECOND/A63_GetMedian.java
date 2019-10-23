package com.sunshine.OFFER66_SECOND;

import org.junit.Test;

public class A63_GetMedian {

    @Test
    public void test() {
        //[5,2,3,4,1,6,7,0,8]
        //5.00 3.50 3.00 3.50 3.00 3.50 4.00 3.50 4.00
        Insert(5);
        Insert(2);
        Insert(3);
        Insert(4);
        Insert(1);
        Insert(6);
        Insert(7);
        Insert(0);
        Insert(8);

    }

    private BalanceTreeNode root = null;

    public void Insert(Integer num) {
        root = Insert(root, num);
        Double ans = GetMedian();
        System.out.println(ans);
        TreeUtility.printTreeOfLine(root);
        System.out.println("==========");
    }

    public Double GetMedian() {
        if (null == root) {
            return 0.0;
        }
        int leftTreeHeight = getTreeHeight(root.left);
        int rightTreeHeight = getTreeHeight(root.right);
        if (leftTreeHeight == rightTreeHeight) {
            return root.val + 0.0;
        } else {
            if (leftTreeHeight > rightTreeHeight) {
                BalanceTreeNode tmp = root.left;
                while (null != tmp.right) {
                    tmp = tmp.right;
                }
                return (root.val + tmp.val) / 2.0;
            } else {
                BalanceTreeNode tmp = root.right;
                while (null != tmp.left) {
                    tmp = tmp.left;
                }
                return (root.val + tmp.val) / 2.0;
            }
        }
    }


    private int getTreeHeight(BalanceTreeNode node) {
        if (null == node) {
            return 0;
        }
        return node.height;
    }

    private int getBalanceFactor(BalanceTreeNode node) {
        if (null == node) {
            return 0;
        }
        return getTreeHeight(node.left) - getTreeHeight(node.right);
    }

    private int getMax(BalanceTreeNode cur) {
        if(null == cur){
            return 0;
        }
        int leftHeight = getTreeHeight(cur.left);
        int rightHeight = getTreeHeight(cur.right);
//        return leftHeight > rightHeight ? leftHeight + 1 : rightHeight + 1;
        return leftHeight + rightHeight + 1;
    }

    private BalanceTreeNode Insert(BalanceTreeNode cur, Integer num) {
        if (null == cur) {
            cur = new BalanceTreeNode(num);
            return cur;
        }
        if (cur.val >= num) {
            cur.left = Insert(cur.left, num);
        } else if (cur.val < num) {
            cur.right = Insert(cur.right, num);
        }

        cur.height = getMax(cur);
        int balanceFactor = getBalanceFactor(cur);
        if (balanceFactor > 1) {
            //LL
            if (num < cur.left.val) {
                return LLRotate(cur);
            }
            //LR
            else {
                return LRRotate(cur);
            }
        }
        if (balanceFactor < -1) {
            //RR
            if (num > cur.right.val) {
                return RRRotate(cur);
            }
            //RL
            else {
                return RLRotate(cur);
            }
        }
        return cur;
    }

    private BalanceTreeNode LLRotate(BalanceTreeNode cur) {
        BalanceTreeNode tmp = cur.left;
        BalanceTreeNode preTmp = null;
//        tmp.height = cur.height + 1;
//        cur.height = getTreeHeight(tmp.right) + getTreeHeight(cur.right) + 1;
//        cur.left = tmp.right;
//        tmp.right = cur;
        while (null != tmp.right) {
            tmp.height--;
            preTmp = tmp;
            tmp = tmp.right;
        }
        if (tmp != cur.left) {
            preTmp.right = tmp.left;
            tmp.left = cur.left;
        }
        tmp.right = cur;
        cur.left = null;

        tmp.height = cur.height + 1;
        cur.height = getMax(cur);
        if(null != preTmp) {
            preTmp.height = getMax(preTmp);
        }
        return tmp;
    }

    private BalanceTreeNode LRRotate(BalanceTreeNode cur) {
        cur.left = RRRotate(cur.left);
        cur = LLRotate(cur);
        return cur;
    }

    private BalanceTreeNode RRRotate(BalanceTreeNode cur) {
        BalanceTreeNode tmp = cur.right;
        BalanceTreeNode preTmp = null;
//        tmp.height = cur.height + 1;
//        cur.height = getTreeHeight(tmp.left) + getTreeHeight(cur.left) + 1;
//        cur.right = tmp.left;
//        tmp.left = cur;
        while (null != tmp.left) {
            tmp.height--;
            preTmp = tmp;
            tmp = tmp.left;
        }
        if (tmp != cur.right) {
            preTmp.left = tmp.right;
            tmp.right = cur.right;
        }
        tmp.left = cur;
        cur.right = null;

        tmp.height = cur.height + 1;
        cur.height = getMax(cur);
        if(null != preTmp) {
            preTmp.height = getMax(preTmp);
        }
        return tmp;
    }

    private BalanceTreeNode RLRotate(BalanceTreeNode cur) {
        cur.right = LLRotate(cur.right);
        cur = RRRotate(cur);
        return cur;
    }


}
