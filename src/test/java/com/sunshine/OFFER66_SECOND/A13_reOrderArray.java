package com.sunshine.OFFER66_SECOND;

import org.junit.Test;

public class A13_reOrderArray {

    @Test
    public void test() {
        int[] arr = {2, 3, 4, 1, 5};
        reOrderArray(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }

    //空间换时间
    public void reOrderArray(int[] array) {
        int[] ans = new int[array.length];
        int pos = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 1) {
                ans[pos++] = array[i];
            }
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                ans[pos++] = array[i];
            }
        }
        for (int i = 0; i < array.length; i++) {
            array[i] = ans[i];
        }
        return;
    }

    //插入排序思想
}
