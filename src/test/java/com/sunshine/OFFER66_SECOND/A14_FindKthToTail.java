package com.sunshine.OFFER66_SECOND;

import org.junit.Test;

public class A14_FindKthToTail {

    @Test
    public void test() {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        ListNode listNode = FindKthToTail(n1, 4);
        System.out.println(listNode.val);
    }
    //两个节点
    public ListNode FindKthToTail(ListNode head, int k) {
        ListNode pre = head;
        ListNode ans = head;
        while (null != pre) {
            while (k > 0 && pre != null) {
                pre = pre.next;
                k--;
            }
            if (k > 0) {
                return null;
            }
            if(null == pre){
                break;
            }
            pre = pre.next;
            ans = ans.next;
        }
        if (k > 0 || null != pre) {
            return null;
        }
        return ans;
    }
}
