package com.sunshine.OFFER66_SECOND;

import org.junit.Test;

public class A6_minNumberInRotateArray {

    @Test
    public void test() {
        int[] arr = {3, 1, 2};
        System.out.println(minNumberInRotateArray(arr));
        System.out.println(minNumberInRotateArray2(arr));
    }


    public int minNumberInRotateArray(int[] array) {
        if (0 == array.length) {
            return 0;
        }
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }

    //个人感觉描述的不是很清楚，非递减排序的数组为什么就是一个递增数组的一个旋转。。虽然样例如此。
    //优解。
    public int minNumberInRotateArray2(int[] array) {
        if (0 == array.length) {
            return 0;
        }
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (array[mid] > array[right]) {
                left = mid + 1;
            } else if (array[mid] < array[right]) {
                right = mid;
            } else {
                right--;
            }
        }
        return array[right];
    }
}
