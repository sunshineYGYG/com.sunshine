package com.sunshine.Algorithm;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class FindFirstCommonNodeClass {

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }


    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if(null==pHead1||null==pHead2){
            return null;
        }

        Set<ListNode> commonNode=new HashSet<>();
        while(pHead1!=null){
            commonNode.add(pHead1);
            pHead1=pHead1.next;
        }
        ListNode ans=null;
        while(pHead2!=null){
            if(commonNode.contains(pHead2)){
                ans=pHead2;
                break;
            }
            pHead2=pHead2.next;
        }
        return ans;
    }

    @Test
    public void test(){
        ListNode pHead1=new ListNode(1);
        ListNode phead2=new ListNode(2);

        pHead1.next=new ListNode(3);
        phead2.next=new ListNode(5);
        pHead1.next.next=phead2.next;

        System.out.println(FindFirstCommonNode2(pHead1,phead2).val);
    }

    public ListNode FindFirstCommonNode2(ListNode pHead1, ListNode pHead2){
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;
        while(p1!=p2){
            p1 = (p1==null ? pHead2 : p1.next);
            p2 = (p2==null ? pHead1 : p2.next);
        }
        return p1;
    }

}
