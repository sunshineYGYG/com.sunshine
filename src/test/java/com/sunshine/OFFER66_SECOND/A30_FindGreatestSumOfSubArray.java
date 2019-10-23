package com.sunshine.OFFER66_SECOND;

import org.junit.Test;

public class A30_FindGreatestSumOfSubArray {

    @Test
    public void test() {
        int[] arr = new int[]{6,-3,-2,7,-15,1,2,2};
        int ans = FindGreatestSumOfSubArray(arr);
        System.out.println(ans);
    }


    public int FindGreatestSumOfSubArray(int[] array) {
        //保证至少长度为1
        int ans = array[0];
        int curMax = array[0];
        for (int i = 1; i < array.length; i++) {
            curMax += array[i];
            if (curMax > ans) {
                ans = curMax;
            }
            if (curMax < 0) {
                curMax = 0;
            }
        }
        return ans;
    }
}