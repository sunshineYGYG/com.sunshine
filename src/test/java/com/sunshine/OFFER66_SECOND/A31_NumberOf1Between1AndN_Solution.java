package com.sunshine.OFFER66_SECOND;

import org.junit.Test;

public class A31_NumberOf1Between1AndN_Solution {

    @Test
    public void test() {
        int i = NumberOf1Between1AndN_Solution(13);
        System.out.println(i);
        int j = NumberOf1Between1AndN_Solution2(5);
        System.out.println(j);
    }

    public int NumberOf1Between1AndN_Solution(int n) {
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            int m = i;
            while (m > 0) {
                ans += m % 10 == 1 ? 1 : 0;
                m /= 10;
            }
        }
        return ans;
    }

    //其他人解，按各位分别统计，归纳总结
    public int NumberOf1Between1AndN_Solution2(int n) {
        int ans = 0;
        for (int i = 1; i <= n; i *= 10) {
            int a = n / (i * 10);
            int b = n % (i * 10);
            ans += a * i;
            if (b >= i * 2) {
                ans += i;
            } else if (b < i) {

            } else {
                ans += b - i + 1;
            }
        }
        return ans;
    }
}
