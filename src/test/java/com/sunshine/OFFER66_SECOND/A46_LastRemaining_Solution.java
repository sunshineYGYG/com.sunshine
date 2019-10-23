package com.sunshine.OFFER66_SECOND;

import org.junit.Test;

public class A46_LastRemaining_Solution {

    @Test
    public void test() {
        int i = LastRemaining_Solution(5, 3);
        System.out.println(i);
        int i1 = LastRemaining_Solution2(5, 3);
        System.out.println(i1);
    }

    public int LastRemaining_Solution(int n, int m) {
        if (n < 1 || m < 1) {
            return -1;
        }
        boolean[] children = new boolean[n];
        int count = n;
        int c = 0;
        while (count != 1) {
            for (int i = 0; i < n; i++) {
                if (!children[i]) {
                    c++;
                }
                if (c == m) {
                    children[i] = true;
                    count--;
                    c = 0;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (!children[i]) {
                return i;
            }
        }
        return -1;
    }

    //其他人解
    //F(1)=0
    //F(2)=F(1)+M
    //……
    //F(i)=(F(i-1)+M)%N
    public int LastRemaining_Solution2(int n, int m) {
        if (n == 0) {
            return -1;
        }
        if (n == 1) {
            return 0;
        }
        return (LastRemaining_Solution(n - 1, m) + m) % n;
    }
}
