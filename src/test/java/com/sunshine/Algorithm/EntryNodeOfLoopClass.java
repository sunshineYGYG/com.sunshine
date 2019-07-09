package com.sunshine.Algorithm;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class EntryNodeOfLoopClass {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    @Test
    public void test() {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n1;
        n4.next = n1;
        ListNode listNode = EntryNodeOfLoop(n4);
        ListNode listNode2 = EntryNodeOfLoop2(n4);
        System.out.println(listNode.val);
        System.out.println(listNode2.val);
    }
    //我的答案
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        ListNode head = pHead;
        ListNode ans = null;
        Set<ListNode> nodes = new HashSet<>();
        while (null != head) {
            if (nodes.contains(head)) {
                ans = head;
                break;
            }
            nodes.add(head);
            head = head.next;
        }
        return ans;
    }
    //优解。
    public ListNode EntryNodeOfLoop2(ListNode pHead) {
        ListNode fastNode = pHead;
        ListNode slowNode = pHead;
        while (fastNode.next != null && fastNode.next.next != null) {
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
            if (slowNode == fastNode) {
                ListNode oneNode = pHead;
                while (oneNode != slowNode) {
                    slowNode = slowNode.next;
                    oneNode = oneNode.next;
                }
                if (slowNode == oneNode) {
                    return oneNode;
                }
                break;
            }
        }
        return null;
    }
}
