package com.sunshine.OFFER66_SECOND;

import org.junit.Test;

public class A33_GetUglyNumber_Solution {

    @Test
    public void test() {
        int i = GetUglyNumber_Solution(1);
        System.out.println(i);
    }

    public int GetUglyNumber_Solution(int index) {
        if (index < 1) {
            return 0;
        }
        int i2 = 0;
        int i3 = 0;
        int i5 = 0;
        int[] ans = new int[index];
        ans[0] = 1;
        for (int i = 1; i < index; i++) {
            int a2, a3, a5;
            while (i2 < i && ans[i2] * 2 <= ans[i - 1]) {
                i2++;
            }
            a2 = ans[i2] * 2;
            while (i3 < i && ans[i3] * 3 <= ans[i - 1]) {
                i3++;
            }
            a3 = ans[i3] * 3;
            while (i5 < i && ans[i5] * 5 <= ans[i - 1]) {
                i5++;
            }
            a5 = ans[i5] * 5;
            ans[i] = Math.min(a2, Math.min(a3, a5));
        }
        return ans[index - 1];
    }

}
