package com.sunshine.OFFER66_SECOND;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class A3_printListFromTailToHead {


    @Test
    public void test(){
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        node1.next=node2;
        node2.next=node3;
        ArrayList<Integer> arrayList = printListFromTailToHead(node1);
        arrayList.forEach(a->System.out.println(a));
        ArrayList<Integer> arrayList2 = printListFromTailToHead2(node1);
        arrayList2.forEach(a->System.out.println(a));
    }

    //栈
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> answer = new ArrayList<>();
        Stack<Integer> stack=new Stack<>();
        while(null !=listNode){
            stack.push(listNode.val);
            listNode=listNode.next;
        }
        while(!stack.empty()){
            answer.add(stack.pop());
        }
        return answer;
    }
    //集合库
    public ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
        ArrayList<Integer> answer = new ArrayList<>();
        while(null !=listNode){
            answer.add(listNode.val);
            listNode=listNode.next;
        }
        Collections.reverse(answer);
        return answer;
    }
    //其他还有递归等
}
