package com.sunshine.OFFER66_SECOND;

import org.junit.Test;

import java.util.Stack;

public class A21_IsPopOrder {


    @Test
    public void test() {
        int[] pushA = {1, 2, 3, 4, 5};
        int[] popA = {4, 3, 5, 2, 1};
        System.out.println(IsPopOrder(new int[]{}, new int[]{1}));
    }


    public boolean IsPopOrder(int[] pushA, int[] popA) {
        Stack<Integer> base = new Stack<>();
        int cur = 0;
        int pos = 0;
        while (cur < pushA.length) {
            base.push(pushA[cur++]);
            while (pos < popA.length && popA[pos] == base.peek()) {
                base.pop();
                pos++;
            }
        }
        if (!base.empty() || pos != popA.length) {
            return false;
        }
        return true;
    }
}
