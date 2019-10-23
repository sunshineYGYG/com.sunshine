package com.sunshine.OFFER66_SECOND;

import org.junit.Test;

public class A25_Clone {

    @Test
    public void test() {
        RandomListNode n1 = new RandomListNode(1);
        RandomListNode n2 = new RandomListNode(2);
        RandomListNode n3 = new RandomListNode(3);
        RandomListNode n4 = new RandomListNode(4);
        RandomListNode n5 = new RandomListNode(5);
        n1.next = null;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n1.random = n1;
        n2.random = n5;
        n3.random = null;
        n4.random = n2;
        n5.random = null;
        //1,2,3,4,5,3,5,#,2,#
        RandomListNode tmp = n1;
        while (tmp != null) {
            System.out.println(tmp + " " + tmp.label + " random: " + (tmp.random == null ? "null" : tmp.random.label));
            tmp = tmp.next;
        }
        System.out.println("--------------");

        RandomListNode clone = Clone(n1);
        while (clone != null) {
            System.out.println(clone + " " + clone.label + " random: " + (clone.random == null ? "null" : clone.random.label));
            clone = clone.next;
        }
    }


    public RandomListNode Clone(RandomListNode pHead) {
        if (null == pHead) {
            return null;
        }

        RandomListNode cur = pHead;
        while (cur != null) {
            RandomListNode tmp = new RandomListNode(cur.label);
            RandomListNode next = cur.next;
            cur.next = tmp;
            tmp.next = next;
            cur = next;
        }
        cur = pHead;
        while (cur != null) {
            RandomListNode next = cur.next;
            if (cur.random == null) {
                next.random = null;
            } else {
                next.random = cur.random.next;
            }
            cur = next.next;
        }
        cur = pHead;
        RandomListNode newHead = pHead.next;
        RandomListNode ans = pHead.next;
        while (cur != null) {
            cur.next = cur.next.next;
            newHead.next = newHead.next == null ? null : newHead.next.next;
            cur = cur.next;
            newHead = newHead.next;
        }
        return ans;
    }
}