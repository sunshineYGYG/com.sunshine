package com.sunshine.OFFER66_SECOND;


import org.junit.Test;

import java.util.ArrayList;

public class A19_printMatrix {

    @Test
    public void test() {
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16},
                {17,18,19,20}
        };
        int[][] matrix2 = {
                {1, 2, 3},
                {4, 5, 6}
        };
        int[][] matrix3 = {
                {1},
                {2},
                {3},
                {4},
                {5}
        };
        ArrayList<Integer> arrayList = printMatrix(matrix);
        arrayList.forEach(a -> System.out.print(a + " "));
    }

    //考虑一种单方向遍历完，另一种方向还是初始值会再次遍历的情况
    public ArrayList<Integer> printMatrix(int[][] matrix) {
        if (matrix.length == 0) {
            return new ArrayList<>();
        }
        ArrayList<Integer> ans = new ArrayList<>();
        int up = 0;
        int right = matrix[0].length - 1;
        int down = matrix.length - 1;
        int left = 0;
        int num = matrix.length * matrix[0].length;
        while (ans.size() < num) {
            if (up < matrix.length&& ans.size() < num) {
                for (int i = left; i <= right; i++) {
                    ans.add(matrix[up][i]);
                }
                up++;
            }
            if (right >= 0 && ans.size() < num) {
                for (int i = up; i <= down; i++) {
                    ans.add(matrix[i][right]);
                }
                right--;
            }
            if (down >= 0 && ans.size() < num) {
                for (int i = right; i >= left; i--) {
                    ans.add(matrix[down][i]);
                }
                down--;
            }
            if (left < matrix[0].length && ans.size() < num) {
                for (int i = down; i >= up; i--) {
                    ans.add(matrix[i][left]);
                }
                left++;
            }
        }
        return ans;
    }
}
