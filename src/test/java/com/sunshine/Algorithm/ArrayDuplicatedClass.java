package com.sunshine.Algorithm;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class ArrayDuplicatedClass {

    @Test
    public void test() {
        int[] arr = {2, 4, 3, 1, 3};
        int[] dd = new int[2];
        boolean duplicate = duplicate2(arr, arr.length, dd);
        System.out.println(duplicate);
        System.out.println(dd[0]);
    }

    //自己的答案
    public boolean duplicate(int numbers[], int length, int[] duplication) {
        Set<Integer> numSet = new HashSet<>();
        boolean re = false;
        for (int i = 0; i < length; i++) {
            if (numSet.contains(numbers[i])) {
                duplication[0] = numbers[i];
                re = true;
                break;
            }
            numSet.add(numbers[i]);
        }
        return re;
    }

    //优解。充分利用了题意数字是0 ~（n-1） 所以length很大。
    public boolean duplicate2(int numbers[], int length, int[] duplication) {
        boolean re = false;
        for (int i = 0; i < length; i++) {
            int j = numbers[i];
            if (j >= length) {
                j -= length;
            }
            if (numbers[j] >= length) {
                duplication[0] = j;
                re = true;
                break;
            }
            numbers[j] += length;
        }
        return re;
    }
}
