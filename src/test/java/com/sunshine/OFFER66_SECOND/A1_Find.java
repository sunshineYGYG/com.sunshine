package com.sunshine.OFFER66_SECOND;

import org.junit.Test;

public class A1_Find {

    @Test
    public void test() {
        int[][] arr = {
                {
                        1, 2, 8, 9
                },
                {
                        2, 4, 9, 12
                },
                {
                        4, 7, 10, 13
                },
                {
                        6, 8, 11, 15
                }
        };
        //7,[[1,2,8,9],[2,4,9,12],[4,7,10,13],[6,8,11,15]]
        boolean find = Find(7, arr);
        System.out.println(find);
        boolean find2 = Find2(1, arr);
        System.out.println(find2);
        boolean find3 = Find3(16, arr);
        System.out.println(find3);
    }

    //暴力
    public boolean Find(int target, int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (target == array[i][j]) {
                    return true;
                }
                if (target < array[i][j]) {
                    break;
                }
            }
            if (array[i].length > 0 && target < array[i][0]) {
                break;
            }
        }
        return false;
    }

    //二分
    public boolean Find2(int target, int[][] array) {
        for (int i = 0; i < array.length; i++) {
            int l = 0;
            int r = array[i].length - 1;
            while (l <= r) {
                int mid = (l + r) >> 1;
                if (mid < 0) {
                    break;
                }
                if (target == array[i][mid]) {
                    return true;
                }
                if (target < array[i][mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
        }
        return false;
    }

    //利用数组有序性:左下角或右上角不同方向值增大或减小
    public boolean Find3(int target, int[][] array) {
        int i = 0;
        int j = array.length - 1;
        while (j >= 0 && i < array[0].length) {
            if (target == array[i][j]) {
                return true;
            }
            if (target < array[i][j]) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }
}