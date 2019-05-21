package com.sunshine.Algorithm;

import org.junit.Test;

public class InversePairsClass {
    @Test
    public void test() {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 0};
        System.out.println(InversePairs(arr));
    }

    //自己的答案。超时。
    public int InversePairs(int[] array) {
        if (null == array || array.length <= 1) {
            return 0;
        }
        int ans = 0;
        for (int i = 1; i < array.length; i++) {
            int j = i - 1;
            int temp = array[i];

            while (j >= 0 && temp < array[j]) {
                array[j + 1] = array[j];
                j--;
                ans++;
                ans %= 1000000007;
            }
            array[j + 1] = temp;
        }
        return ans;
    }

    @Test
    public void test2() {
        int[] arr = {2, 9, 7, 4, 3, 1, 0, 6, 5, 8};
        merge(arr, 0, arr.length - 1);
        for (int i : arr) {
            System.out.print(arr[i] + " ");
        }
        System.out.println(answer);
    }

    //看到归并后自己手写的。
    private int answer = 0;
    public int InversePairs2(int[] array) {
        if (null == array || array.length <= 1) {
            return 0;
        }
        merge(array, 0, array.length - 1);
        return answer;
    }

    public void merge(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = (left + right) / 2;
        merge(array, left, mid);
        merge(array, mid + 1, right);

        int i = left;
        int j = mid + 1;
        int[] temp = new int[right - left + 1];
        int k = 0;
        while (i <= mid || j <= right) {
            while (i <= mid && array[i] <= array[j]) {
                temp[k++] = array[i++];
            }
            if (i > mid) {
                while (j <= right) {
                    temp[k++] = array[j++];
                }
            }
            while (j <= right && array[j] <= array[i]) {
                temp[k++] = array[j++];
                answer += mid - i + 1;
                answer %= 1000000007;
            }
            if (j > right) {
                while (i <= mid) {
                    temp[k++] = array[i++];
                }
            }
        }
        k = 0;
        for (i = left; i <= right; i++) {
            array[i] = temp[k++];
        }
        return;
    }
}
