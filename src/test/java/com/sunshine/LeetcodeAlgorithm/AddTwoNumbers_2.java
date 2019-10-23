package com.sunshine.LeetcodeAlgorithm;

import org.junit.Test;

public class AddTwoNumbers_2 {

    @Test
    public void test() {
        ListNode n1 = new ListNode(2);
        ListNode n2 = new ListNode(4);
        ListNode n3 = new ListNode(3);
        ListNode m1 = new ListNode(5);
        ListNode m2 = new ListNode(6);
        ListNode m3 = new ListNode(4);
        n1.next = n2;
        n2.next = n3;
        m1.next = m2;
        m2.next = m3;
        ListNode listNode = addTwoNumbers(n1, m1);
        while (listNode != null) {
            System.out.print(listNode.val);
            listNode = listNode.next;
        }
    }

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode root = null;
        ListNode cur = null;
        int v0 = 0;
        while (l1 != null || l2 != null || 0 != v0) {
            int v1 = 0;
            int v2 = 0;
            if (l1 != null) {
                v1 = l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                v2 = l2.val;
                l2 = l2.next;
            }
            int v = v1 + v2 + v0;
            v0 = v / 10;
            ListNode node = new ListNode(v % 10);
            if (null == root) {
                root = node;
                cur = node;
            } else {
                cur.next = node;
                cur = cur.next;
            }
        }
        return root;
    }
}
