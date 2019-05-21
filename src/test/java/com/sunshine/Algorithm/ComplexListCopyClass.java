package com.sunshine.Algorithm;

import javafx.util.Pair;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class ComplexListCopyClass {
    public class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }

    public RandomListNode Clone(RandomListNode pHead) {
        Map<RandomListNode, RandomListNode> pairMap = new HashMap<>();
        Map<Integer, RandomListNode> kd = new HashMap<>();
        Map<Integer, RandomListNode> kd2 = new HashMap<>();
        Map<RandomListNode, Integer> dk = new HashMap<>();
        Map<RandomListNode, Integer> dk2 = new HashMap<>();

        RandomListNode ohead = pHead;
        RandomListNode nhead = null;
        RandomListNode head = null;
        RandomListNode cur = null;
        int i = 1;
        while (null != ohead) {
            nhead = new RandomListNode(ohead.label);
            if (null == head) {
                head = nhead;
                cur = nhead;
            } else {
                cur.next = nhead;
                cur = cur.next;
            }
            //记录关系
            kd.put(i, ohead);
            kd2.put(i, nhead);
            dk.put(ohead, i);
            dk2.put(nhead, i);
            pairMap.put(ohead, ohead.random);
            i++;
            //下一节点
            nhead = nhead.next;
            ohead = ohead.next;
        }
        ohead = pHead;
        nhead = head;
        while (null != nhead) {
            RandomListNode node = pairMap.get(ohead);
            if (null != node) {
                nhead.random = kd2.get(dk.get(node));
            }
            nhead = nhead.next;
            ohead = ohead.next;
        }
        return head;
    }

    @Test
    public void test() {
        RandomListNode n1 = new RandomListNode(1);
        RandomListNode n2 = new RandomListNode(2);
        RandomListNode n3 = new RandomListNode(3);
        RandomListNode n4 = new RandomListNode(4);
        RandomListNode n5 = new RandomListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n1.random = n3;
        n2.random = n5;
        n4.random = n2;
        printList(n1);
        RandomListNode clone = Clone2(n1);
        printList(clone);
        printList(n1);
    }

    private void printList(RandomListNode head) {
        System.out.println("next");
        RandomListNode thead = head;
        while (null != thead && null != thead.next) {
            System.out.println(thead.label + " -> " + thead.next.label);
            thead = thead.next;
        }
        thead = head;
        System.out.println("random");
        while (null != thead) {
            if (null != thead.random) {
                System.out.println(thead.label + " -> " + thead.random.label);
            }
            thead = thead.next;
        }
    }


    public RandomListNode Clone2(RandomListNode pHead) {
        if (null == pHead) {
            return null;
        }
        RandomListNode ohead = pHead;
        RandomListNode head = null;
        RandomListNode nhead;
        while (null != ohead) {
            nhead = new RandomListNode(ohead.label + 1000);
            if (null == head) {
                head = nhead;
            }
            nhead.next = ohead.next;
            nhead.random = ohead.random;
            ohead.next = nhead;

            //下一个节点
            ohead = nhead.next;
        }
        nhead = head;
        while (null != nhead.next) {
            nhead.random = nhead.random == null ? null : nhead.random.next;
            nhead = nhead.next.next;
        }
        nhead = head;
        ohead = pHead;
        while (null != nhead.next) {
            RandomListNode next = nhead.next;
            ohead.next = next;
            ohead = next;
            nhead.next = next.next;
            nhead = nhead.next;
        }
        ohead.next = null;
        return head;
    }
}
