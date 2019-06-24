package com.sunshine.Algorithm;

import org.junit.Test;

public class UglyNumber {

    @Test
    public void test(){
        int i = GetUglyNumber_Solution(10);
        System.out.println(i);
    }

    //优解。前面的都是丑数，所以后面也是丑数，哈哈。
    public int GetUglyNumber_Solution(int index) {
        if (index <= 0) {
            return 0;
        }
        int i2 = 0;
        int i3 = 0;
        int i5 = 0;
        int i = 0;
        int[] uglyNum = new int[index];
        uglyNum[i++] = 1;
        while (i < index) {
            int cur = min(2 * uglyNum[i2], 3 * uglyNum[i3], 5 * uglyNum[i5]);
            uglyNum[i++] = cur;
            while (2 * uglyNum[i2] <= cur) {
                i2++;
            }
            while (3 * uglyNum[i3] <= cur) {
                i3++;
            }
            while (5 * uglyNum[i5] <= cur) {
                i5++;
            }
        }
        return uglyNum[index - 1];
    }

    private int min(int a, int b, int c) {
        int x = a > b ? b : a;
        x = x > c ? c : x;
        return x;
    }
}
