package com.sunshine.Algorithm;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class MoveWindowMaxClass {

    @Test
    public void test() {
        int[] arr = {2, 3, 4, 2, 6, 2, 5, 1};
        ArrayList<Integer> arrayList = maxInWindows2(arr, 3);
        arrayList.forEach(a -> System.out.print(a + ","));
    }

    //自己的水答案
    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> answer = new ArrayList<>();
        if (null == num || 0 == num.length || 0 == size) {
            return answer;
        }
        int len = num.length - size + 1;
        for (int i = 0; i < len; i++) {
            int curMax = num[i];
            for (int j = i + 1; j < size + i; j++) {
                if (num[j] > curMax) {
                    curMax = num[j];
                }
            }
            answer.add(curMax);
        }
        return answer;
    }

    //优解，模拟窗口滑动，核心：保证新元素的前面没有比新元素的大的值，这样就能一直保持deque首位是最大值
    //deque存
    public ArrayList<Integer> maxInWindows2(int[] num, int size) {
        ArrayList<Integer> answer = new ArrayList<>();
        if (null == num || 0 == num.length || 0 == size) {
            return answer;
        }

        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < num.length; i++) {
            while (deque.size() > 0 && num[deque.peekLast()] <= num[i]) {
                deque.removeLast();
            }
            while (deque.size() > 0 && i - size >= deque.peekFirst()) {
                deque.removeFirst();
            }
            deque.addLast(i);
            if (i + 1 >= size) {
                answer.add(num[deque.peekFirst()]);
            }
        }
        return answer;
    }
}
