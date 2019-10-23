package com.sunshine.OFFER66_SECOND;


import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class A36_FindFirstCommonNode {

    @Test
    public void test() {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode m1 = new ListNode(11);
        ListNode m2 = new ListNode(12);
        ListNode o = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = o;
        m1.next = m2;
        m2.next = o;
        ListNode listNode = FindFirstCommonNode(n2, m1);
        System.out.println(listNode.val);
        ListNode listNode2 = FindFirstCommonNode2(n1, m1);
        System.out.println(listNode2.val);
    }

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        Set<ListNode> remember = new HashSet<>();
        while (pHead1 != null || pHead2 != null) {
            if (pHead1 != null) {
                if (remember.contains(pHead1)) {
                    return pHead1;
                }
                remember.add(pHead1);
                pHead1 = pHead1.next;
            }
            if (pHead2 != null) {
                if (remember.contains(pHead2)) {
                    return pHead2;
                }
                remember.add(pHead2);
                pHead2 = pHead2.next;
            }
        }
        return null;
    }

    //其他人解，比较出长度差，让长的链表先走
    public ListNode FindFirstCommonNode2(ListNode pHead1, ListNode pHead2) {

        ListNode p1 = pHead1;
        ListNode p2 = pHead2;
        int len1 = 0;
        int len2 = 0;
        while (null != p1) {
            len1++;
            p1 = p1.next;
        }
        while (null != p2) {
            len2++;
            p2 = p2.next;
        }
        if (len1 - len2 == 0) {

        } else if (len1 - len2 > 0) {
            int count = len1 - len2;
            while (count-- > 0) {
                pHead1 = pHead1.next;
            }
        } else {
            int count = len2 - len1;
            while (count-- > 0) {
                pHead2 = pHead2.next;
            }
        }
        while (pHead1 != null && pHead2 != null) {
            if (pHead1 == pHead2) {
                return pHead1;
            }
            pHead1 = pHead1.next;
            pHead2 = pHead2.next;
        }
        return null;
    }
}
