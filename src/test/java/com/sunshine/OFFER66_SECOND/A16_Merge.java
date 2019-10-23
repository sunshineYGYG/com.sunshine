package com.sunshine.OFFER66_SECOND;

import org.junit.Test;

public class A16_Merge {

    @Test
    public void test() {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(3);
        ListNode n3 = new ListNode(5);
        ListNode m1 = new ListNode(2);
        ListNode m2 = new ListNode(4);
        ListNode m3 = new ListNode(6);
        n1.next = n2;
        n2.next = n3;
        m1.next = m2;
        m2.next = m3;
        ListNode merge = Merge(n1, m1);
        while (null != merge) {
            System.out.println(merge.val);
            merge = merge.next;
        }
    }


    public ListNode Merge(ListNode list1, ListNode list2) {
        ListNode ans = null;
        ListNode cur = null;
        while (list1 != null || list2 != null) {
            while (list1 != null && (list2 == null || list1.val <= list2.val)) {
                if (null != cur) {
                    cur.next = list1;
                    cur = cur.next;
                } else {
                    cur = list1;
                    ans = list1;
                }
                list1 = list1.next;
            }
            while (list2 != null && (list1 == null || list1.val >= list2.val)) {
                if (null != cur) {
                    cur.next = list2;
                    cur = cur.next;
                } else {
                    cur = list2;
                    ans = list2;
                }
                list2 = list2.next;
            }
        }
        return ans;
    }
}
