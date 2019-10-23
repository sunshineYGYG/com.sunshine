package com.sunshine.OFFER66_SECOND;

import org.junit.Test;

public class A51_multiply {

    @Test
    public void test() {
        int[] A = {1, 2, 3, 4};
        int[] multiply = multiply(A);
        for (int i : multiply) {
            System.out.println(i);
        }
    }

    public int[] multiply(int[] A) {
        int left = 1;
        int right = 1;
        int[] B = new int[A.length];
        for (int i = 0; i < B.length; i++) {
            B[i] = 1;
        }
        for (int i = 1; i < A.length; i++) {
            left *= A[i - 1];
            B[i] *= left;
        }
        for (int i = A.length - 2; i >= 0; i--) {
            right *= A[i + 1];
            B[i] *= right;
        }
        return B;
    }
}
