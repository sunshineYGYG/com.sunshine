package com.sunshine.Algorithm;

import org.junit.Test;

import java.util.Stack;

public class StackOrderClass {

    @Test
    public void test(){
        int[] pushA={1,2,3,4,5};
        int[] popA={4,5,3,2,1};
        boolean b = IsPopOrder(pushA, popA);
        System.out.println(b);
    }

    //优解、自己的答案
    public boolean IsPopOrder(int[] pushA, int[] popA) {
        if (null == pushA || 0 == pushA.length) {
            return true;
        }
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        int j = 0;
        while (i < pushA.length) {
            stack.push(pushA[i++]);
            while (!stack.empty() && stack.peek().equals(popA[j])) {
                j++;
                stack.pop();
            }
        }
        return stack.empty();
    }
}
