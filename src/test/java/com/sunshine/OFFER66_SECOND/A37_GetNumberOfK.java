package com.sunshine.OFFER66_SECOND;

import org.junit.Test;

public class A37_GetNumberOfK {

    @Test
    public void test() {
        int[] arr = new int[]{1};
        int i = GetNumberOfK(arr, 1);
        System.out.println(i);
        int j = GetNumberOfK2(arr, 1);
        System.out.println(j);
    }


    public int GetNumberOfK(int[] array, int k) {
        if (array.length == 0) {
            return 0;
        }
        if (array.length == 1 && array[0] == k) {
            return 1;
        }
        int ans = 0;
        int left = 0;
        int right = array.length - 1;
        while (left != right) {
            int mid = (left + right) >> 1;
            if (array[mid] == k) {
                for (int i = mid; i >= 0; i--) {
                    if (array[i] == k) {
                        ans++;
                    }
                }
                for (int i = mid + 1; i < array.length; i++) {
                    if (array[i] == k) {
                        ans++;
                    }
                }
                return ans;
            } else if (array[mid] > k) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return 0;
    }
    //其他人解，都是因为都是整数可以找k两边的位置
    public int GetNumberOfK2(int[] array, int k) {
        if (array.length == 0) {
            return 0;
        }
        return GetNumberPos(array, k + 0.5) - GetNumberPos(array, k - 0.5);
//        int right = GetNumberPos(array, k + 0.5);
//        int left = GetNumberPos(array, k - 0.5);
//        System.out.println("right=" + right + " left=" + left);
//        return right - left;
    }

    public int GetNumberPos(int[] array, double num) {
        int left = 0;
        int right = array.length - 1;
        while (left != right) {
            int mid = (left + right) >> 1;
            if (array[mid] < num) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        //确定返回num左边的位置
        if (array[left] < num) {
            return left;
        }
        return left - 1;
    }
}
