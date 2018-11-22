package com.sunshine.Algorithm;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class DeleteDuplicationClass {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    @Test
    public void test(){
        ListNode pHead=new ListNode(1);
        pHead.next=new ListNode(1);
        pHead.next.next=new ListNode(1);
        pHead.next.next.next=new ListNode(1);
        pHead.next.next.next.next=new ListNode(1);
        print(pHead);
        ListNode ans = deleteDuplication(pHead);
        print(ans);
    }

    private void print(ListNode root){
        while(root!=null){
            System.out.println(root.val);
            root=root.next;
        }
        System.out.println("====");
    }

    public ListNode deleteDuplication(ListNode pHead) {
        if (null==pHead){
            return null;
        }
        Set<Integer> allNode=new HashSet<>();
        Set<Integer> duplicationNode=new HashSet<>();
        ListNode p=pHead;
        while(null!=p){
            if (allNode.contains(p.val)){
                duplicationNode.add(p.val);
            }else {
                allNode.add(p.val);
            }
            p=p.next;
        }
        ListNode ans=null;
        ListNode tempNode=null;
        while(null!=pHead){
            if(duplicationNode.contains(pHead.val)){

            }else {
                if(ans==null){
                    ans=pHead;
                }else {
                    tempNode.next=pHead;
                }
                tempNode=pHead;
            }
            pHead=pHead.next;
        }
        if(tempNode!=null){
            tempNode.next=pHead;
        }

        return ans;
    }
}
