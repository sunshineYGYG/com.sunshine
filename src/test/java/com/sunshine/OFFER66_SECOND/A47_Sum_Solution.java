package com.sunshine.OFFER66_SECOND;

import org.junit.Test;

public class A47_Sum_Solution {

    @Test
    public void test() {
        int i = Sum_Solution(100);
        System.out.println(i);
        int i1 = Sum_Solution2(100);
        System.out.println(i1);
    }

    public int Sum_Solution(int n) {
        return ((n + 1) * n) >> 1;
    }

    public int Sum_Solution2(int n) {
        return ((int) Math.pow(n, 2) + n) >> 1;
    }

    //其他人解
    public int Sum_Solution3(int n) {
        int cur =n;
        boolean b = cur > 0 && (cur += Sum_Solution(n - 1)) > 0;
        return cur;
    }
}
