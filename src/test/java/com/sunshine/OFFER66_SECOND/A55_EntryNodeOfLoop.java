package com.sunshine.OFFER66_SECOND;

import org.junit.Test;

public class A55_EntryNodeOfLoop {

    @Test
    public void test(){
        ListNode n1=new ListNode(1);
        ListNode n2=new ListNode(2);
        ListNode n3=new ListNode(3);
        ListNode n4=new ListNode(4);
        ListNode n5=new ListNode(5);
        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n5;
        n5.next=n3;
        ListNode listNode = EntryNodeOfLoop(n1);
        System.out.println(listNode.val);
    }

    public ListNode EntryNodeOfLoop(ListNode pHead) {
        ListNode p = pHead;
        ListNode q = pHead;

        while (true) {
            if (null != p.next && null != p.next.next) {
                p = p.next.next;
            } else {
                return null;
            }
            q = q.next;
            if (q == p) {
                break;
            }
        }
        p = pHead;
        while (p != q) {
            q = q.next;
            p = p.next;
        }
        return p;
    }
}
