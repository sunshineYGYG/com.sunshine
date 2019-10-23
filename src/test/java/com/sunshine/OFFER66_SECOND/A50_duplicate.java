package com.sunshine.OFFER66_SECOND;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class A50_duplicate {

    @Test
    public void test() {
        int[] arr = {2, 3, 1, 0,1};
        int[] ans = new int[1];
        boolean duplicate = duplicate2(arr, arr.length, ans);
        if (duplicate) {
            for (int an : ans) {
                System.out.println(an);
            }
        }
    }

    // Parameters:
    //    numbers:     an array of integers
    //    length:      the length of array numbers
    //    duplication: (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
    //                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
    //    这里要特别注意~返回任意重复的一个，赋值duplication[0]
    // Return value:       true if the input is valid, and there are some duplications in the array number
    //                     otherwise false
    public boolean duplicate(int numbers[], int length, int[] duplication) {
        if (null == numbers || numbers.length < 1) {
            duplication[0] = -1;
            return false;
        }
        Set<Integer> count = new HashSet<>();
        for (int number : numbers) {
            if (count.contains(number)) {
                duplication[0] = number;
                return true;
            }
            count.add(number);
        }
        return false;
    }
    //其他人解。利用数组中数字只有0~n-1的特性，在原数组中做标志位。
    public boolean duplicate2(int numbers[], int length, int[] duplication) {
        if (null == numbers || numbers.length < 1) {
            duplication[0] = -1;
            return false;
        }
        for (int i = 0; i < length; i++) {
            int num = numbers[i] >= length ? numbers[i] - length : numbers[i];
            if (numbers[num] > length) {
                duplication[0] = num;
                return true;
            }
            numbers[num] += length;
        }
        return false;
    }
}
