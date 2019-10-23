package com.sunshine.OFFER66_SECOND;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;

public class A64_maxInWindows {

    @Test
    public void test() {
        int[] num = {2, 3, 4, 2, 6, 2, 5, 1};
        ArrayList<Integer> arrayList = maxInWindows(num, 3);
        for (Integer a : arrayList) {
            System.out.println(a);
        }
    }

    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (size == 0 || num.length < size) {
            return ans;
        }
        LinkedList<Integer> ansQ = new LinkedList<>();
        for (int i = 0; i < num.length; i++) {
            if (0 == i) {
                for (; i < size && i < num.length; i++) {
                    while (!ansQ.isEmpty() && ansQ.peekLast() < num[i]) {
                        ansQ.removeLast();
                    }
                    ansQ.addLast(num[i]);
                }
                i--;
            } else {
                while (!ansQ.isEmpty() && ansQ.peekLast() < num[i]) {
                    ansQ.removeLast();
                }
                ansQ.addLast(num[i]);
            }
            ans.add(ansQ.peekFirst());
            if (i - size + 1 >= 0 && ansQ.peekFirst() == num[i - size + 1]) {
                ansQ.removeFirst();
            }
        }
        return ans;
    }
}
