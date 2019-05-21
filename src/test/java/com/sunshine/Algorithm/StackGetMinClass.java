package com.sunshine.Algorithm;


import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class StackGetMinClass {

    Stack<Integer> stack = new Stack<>();

    List<Integer> heap = new ArrayList<>();

    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
//        while(true) {
        int nextInt = scanner.nextInt();
        StackGetMinClass stackGetMinClass=new StackGetMinClass();
        stackGetMinClass.push(nextInt);
        int min = stackGetMinClass.min();
        System.out.println(min);
//        }
    }

    @Test
    public void test(){
        push(1);
        push(2);
        push(3);
        push(-3);
        int min = min();
        System.out.println(min);
    }

    //自己的答案--维护一个最小堆
    private void adjustUpHeap(int pos) {
        if (null == heap || 0 == heap.size()) {
            return;
        }
        while (pos > 0) {
            int parent = parent(pos);
            if (heap.get(parent) > heap.get(pos)) {
                swap(parent, pos);
            }
            pos = parent;
        }
    }

    private void adjustDownHeap(int node) {
        if (null == heap || 0 == heap.size()) {
            return;
        }
        int pos = 0;
        for (int i = 0; i < heap.size(); i++) {
            if (heap.get(i) == node) {
                heap.remove(i);
                pos = i;
                break;
            }
        }
        int size = heap.size();
        for (int i = pos; i < size; i++) {
            adjustUpHeap(i);
        }
    }


    private int parent(int pos) {
        return (pos - 1) / 2;
    }

    private void swap(int i, int j) {
        Integer tmp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, tmp);
    }


    public void push(int node) {
        stack.push(node);
        heap.add(node);
        adjustUpHeap(heap.size()-1);
    }

    public void pop() {
        Integer pop = stack.pop();
        adjustDownHeap(pop);
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return heap.get(0);
    }

    @Test
    public void test1(){
        push2(1);
        push2(2);
        push2(3);
        push2(3);
        int min = min2();
        System.out.println(min);
    }

    //优解，维护堆，当出栈时成本太大。
    //充分利用了栈的 先进后出 特性。辅助栈只存比当前栈顶值小的新进值。
    private Stack<Integer> s1=new Stack<>();
    private Stack<Integer> s2=new Stack<>();

    public void push2(int node) {
        s1.push(node);
        if(s2.empty()){
            s2.push(node);
        }else if(node <= s2.peek()){
            s2.push(node);
        }
    }

    public void pop2() {
        if(s1.peek() == s2.peek()){
            s2.pop();
        }
        s1.pop();
    }

    public int min2() {
        return s2.peek();
    }
}
