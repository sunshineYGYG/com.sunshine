package com.sunshine.Algorithm;

import org.junit.Test;

public class MultiplyArrayClass {

    @Test
    public void test() {
        int[] arr = {1, 2, 0, 4, 5};
        int[] b = multiply2(arr);
        for (int i : b) {
            System.out.println(i);
        }
    }

    //自己的错误答案。题目要求不能用除法。
    public int[] multiply(int[] A) {
        int mul = getMulRe(A);
        int[] B = new int[A.length];
        for (int i = 0; i < B.length; i++) {
            if (0 == A[i]) {
                B[i] = getMulRe(A, i);
                continue;
            }
            B[i] = mul / A[i];
        }
        return B;
    }

    private int getMulRe(int[] arr) {
        int mul = 1;
        for (int i = 0; i < arr.length; i++) {
            mul *= arr[i];
            if (0 == mul) {
                break;
            }
        }
        return mul;
    }

    private int getMulRe(int[] arr, int pos) {
        int mul = 1;
        for (int i = 0; i < arr.length; i++) {
            if (i == pos) {
                continue;
            }
            mul *= arr[i];
            if (0 == mul) {
                break;
            }
        }
        return mul;
    }


    @Test
    public void test2() {
        int[] arr = {1, 2, 0, 4, 5};
        int[] b = multiply2(arr);
        for (int i : b) {
            System.out.println(i);
        }
    }

    //优解。上三角和下三角对应数组相乘就是B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。。。其中A[i]就是对角线。
    public int[] multiply2(int[] A) {
        int len = A.length;
        int[] B = new int[len];
        B[0] = 1;
        for (int i = 1; i < len; i++) {
            B[i] = B[i - 1] * A[i - 1];
        }
        int mul = 1;
        for (int i = len - 2; i >= 0; i--) {
            mul = mul * A[i + 1];
            B[i] *= mul;
        }
        return B;
    }
}
