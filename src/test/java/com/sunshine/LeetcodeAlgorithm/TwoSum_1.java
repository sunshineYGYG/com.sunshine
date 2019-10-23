package com.sunshine.LeetcodeAlgorithm;

import org.junit.Test;

import java.util.Arrays;

public class TwoSum_1 {

    @Test
    public void test(){
        int[] ints = {3, 6, 11, 22};
        int[] ints1 = twoSum(ints, 9);
        for (int i : ints1) {
            System.out.println(i);
        }
    }


    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }
}
