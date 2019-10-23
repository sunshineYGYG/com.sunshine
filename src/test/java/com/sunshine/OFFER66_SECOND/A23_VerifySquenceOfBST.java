package com.sunshine.OFFER66_SECOND;

import org.junit.Test;

public class A23_VerifySquenceOfBST {

    @Test
    public void test() {
        int[] sequence = {1, 4, 3, 7, 8, 9, 5};
        int[] sequence2 = {1, 9,2, 3};
        System.out.println(VerifySquenceOfBST(sequence2));
    }


    public boolean VerifySquenceOfBST(int[] sequence) {
        if(null == sequence || sequence.length == 0){
            System.out.println("NO");
            return false;
        }
        boolean b = JudgeBST(sequence, 0, sequence.length - 1);
        if (b) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
        return b;
    }

    public boolean JudgeBST(int[] sequence, int left, int right) {
        if (left == right) {
            return true;
        }
        int mid = -1;
        int midNode = sequence[right];
        for (int i = left; i < right; i++) {
            if (sequence[i] > midNode && mid == -1) {
                mid = i;
            } else if (mid != -1 && sequence[i] <= midNode && i > mid) {
                return false;
            }
        }
        if (mid == -1 || mid == left) {
            return JudgeBST(sequence, left, right - 1);
        }
        return JudgeBST(sequence, left, mid - 1) && JudgeBST(sequence, mid, right - 1);
    }
}
