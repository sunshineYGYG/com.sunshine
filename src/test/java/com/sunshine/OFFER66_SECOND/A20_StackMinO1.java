package com.sunshine.OFFER66_SECOND;


import org.junit.Test;

import java.util.Stack;


public class A20_StackMinO1 {

    @Test
    public void test(){
        push(2);
        push(2);
        push(1);
        push(3);
        System.out.println(min());
        push(0);
        System.out.println(min());
        pop();
        System.out.println(min());

    }

    Stack<Integer> base = new Stack<>();
    Stack<Integer> minNum = new Stack<>();

    public void push(int node) {
        base.push(node);
        if(minNum.empty()||minNum.peek()>=node){
            minNum.push(node);
        }
    }

    public void pop() {
        Integer node = base.pop();
        if(minNum.peek() == node){
            minNum.pop();
        }
    }

    public int top() {
        return base.peek();
    }

    public int min() {
        return minNum.peek();
    }
}
