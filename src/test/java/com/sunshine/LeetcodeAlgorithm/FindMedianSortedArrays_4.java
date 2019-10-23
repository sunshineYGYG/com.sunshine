package com.sunshine.LeetcodeAlgorithm;

import org.junit.Test;

public class FindMedianSortedArrays_4 {

    @Test
    public void test(){
        int[] nums1={1,3};
        int[] nums2={2};
        double medianSortedArrays = findMedianSortedArrays(nums1, nums2);
        System.out.println(medianSortedArrays);
    }


    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i = 0, j = nums1.length - 1;
        int m = 0, n = nums2.length - 1;
        while (!(j - i == 1 && n - m < 0) || (n - m == 1 && j - i < 0) || (n - m < 1 && j - i < 1)) {
            if (nums1[i] <= nums2[m]) {
                i++;
            } else {
                m++;
            }
            if (nums1[j] >= nums2[n]) {
                j--;
            } else {
                n--;
            }
        }
        if (j - i == 1) {
            return (nums1[i] + nums1[j]) / 2.0;
        }
        if (n - m == 1) {
            return (nums2[n] + nums2[m]) / 2.0;
        }
        if (j - i == 0 && n - m == 0) {
            return (nums1[i] + nums2[m]) / 2.0;
        }
        if (j - i < 0 && n - m == 0) {
            return nums2[m]*1.0;
        }
        if (j - i == 0 && n - m < 0) {
            return nums1[i]*1.0;
        }
        return 0.0;
    }
}
