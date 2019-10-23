package com.sunshine.OFFER66_SECOND;

import org.junit.Test;

public class A56_deleteDuplication {


    @Test
    public void test() {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(1);
        ListNode n3 = new ListNode(2);
        ListNode n4 = new ListNode(3);
        ListNode n5 = new ListNode(3);
        ListNode n6 = new ListNode(4);
        ListNode n7 = new ListNode(5);
        ListNode n8 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        n7.next = n8;
        ListNode pos = n1;
        while (pos != null) {
            System.out.print(pos.val + "->");
            pos = pos.next;
        }
        System.out.println();
        ListNode listNode = deleteDuplication(n1);
        pos = listNode;
        while (pos != null) {
            System.out.print(pos.val + "->");
            pos = pos.next;
        }
    }
    //其他人解
    public ListNode deleteDuplication(ListNode pHead) {
        if (null == pHead || null == pHead.next) {
            return pHead;
        }
        ListNode pre = new ListNode(0);
        ListNode ans = pre;
        pre.next = pHead;
        ListNode cur = pHead;
        while (cur != null) {
            if (cur.next != null && cur.next.val == cur.val) {
                while (cur.next != null && cur.next.val == cur.val) {
                    cur = cur.next;
                }
                cur = cur.next;
                pre.next = cur;
            } else {
                pre = cur;
                cur = cur.next;
            }
        }
        return ans.next;
    }
}
