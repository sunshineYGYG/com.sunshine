package com.sunshine.OFFER66_SECOND;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class A29_GetLeastNumbers_Solution {

    @Test
    public void test() {
        int[] arr = new int[]{4, 5, 1, 6, 2, 7, 3, 8};
        ArrayList<Integer> arrayList = GetLeastNumbers_Solution(arr, 4);
        arrayList.forEach(a -> System.out.println(a));
        ArrayList<Integer> arrayList1 = GetLeastNumbers_Solution2(arr, 4);
        arrayList1.forEach(a -> System.out.println(a));
    }

    //最大堆
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        if (input.length == 0 || input.length < k) {
            return new ArrayList<>();
        }
        ArrayList<Integer> ans = new ArrayList<>();
        CreateHeap(input, k);
        for (int i = k; i < input.length; i++) {
            if (input[i] < input[0]) {
                swap(input, 0, i);
                DownAdjust(input, 0, k);
            }
        }
        for (int i = 0; i < k; i++) {
            ans.add(input[i]);
        }
        return ans;
    }

    public int getParent(int pos) {
        return (pos - 1) / 2;
    }

    public int getLeft(int pos) {
        return (pos + 1) * 2 - 1;
    }

    public int getRight(int pos) {
        return (pos + 1) * 2;
    }

    public void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public void CreateHeap(int[] arr, int k) {
        for (int i = 0; i < k; i++) {
            UpAdjust(arr, i);
//            DownAdjust(arr, 0, k);
        }
    }

    public void UpAdjust(int[] arr, int pos) {
        while (getParent(pos) >= 0 && arr[getParent(pos)] < arr[pos]) {
            swap(arr, getParent(pos), pos);
            pos = getParent(pos);
        }
    }

    public void DownAdjust(int[] arr, int pos, int k) {
        while ((getLeft(pos) < k && arr[pos] < arr[getLeft(pos)]) || (getRight(pos) < k && arr[pos] < arr[getRight(pos)])) {
            if (getRight(pos) < k) {
                if (arr[getLeft(pos)] >= arr[getRight(pos)] && arr[getLeft(pos)] > arr[pos]) {
                    swap(arr, pos, getLeft(pos));
                    pos = getLeft(pos);
                } else if (arr[getLeft(pos)] <= arr[getRight(pos)] && arr[getRight(pos)] > arr[pos]) {
                    swap(arr, pos, getRight(pos));
                    pos = getRight(pos);
                }
            } else if (getLeft(pos) < k && arr[getLeft(pos)] > arr[pos]) {
                swap(arr, pos, getLeft(pos));
                pos = getLeft(pos);
            }
        }

    }

    //排序
    public ArrayList<Integer> GetLeastNumbers_Solution2(int[] input, int k) {
        if (input.length < k) {
            return new ArrayList<>();
        }
        Arrays.sort(input);
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            ans.add(input[i]);
        }
        return ans;
    }
}
