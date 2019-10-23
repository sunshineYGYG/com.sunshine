package com.sunshine.OFFER66_SECOND;

import org.junit.Test;

public class A15_ReverseList {

    @Test
    public void test() {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        n1.next = n2;
//        n2.next = n3;
        ListNode listNode = ReverseList(n1);
        while (null != listNode) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }


    public ListNode ReverseList(ListNode head) {
        if (null == head) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode pre = head.next;
        ListNode aft = head;
        head.next = null;

        while (null != pre) {
            ListNode next = pre.next;
            pre.next = aft;
            aft = pre;
            pre = next;
        }
        return aft;
    }
}
