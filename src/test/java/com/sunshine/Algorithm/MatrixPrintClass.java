package com.sunshine.Algorithm;

import org.junit.Test;

import java.util.ArrayList;


public class MatrixPrintClass {

    @Test
    public void test() {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
//        int[][] matrix = {{1}, {2}, {3}, {4}, {5}};
        ArrayList<Integer> arrayList = printMatrix2(matrix);
        arrayList.forEach(a -> System.out.print(a + " "));
    }
    //自己的答案
    public ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> answer = new ArrayList<>();
        if (null == matrix || 0 == matrix.length) {
            return answer;
        }
        int rawSta = -1;
        int colSta = -1;
        int rawLen = matrix.length;
        int colLen = matrix[0].length;
        int x = 0;
        int y = 0;
        int sum = matrix.length * matrix[0].length;
        while (answer.size() < sum) {
            while (x < colLen) {
                answer.add(matrix[y][x]);
                x++;
            }
            if (answer.size() >= sum) {
                break;
            }
            x--;
            rawSta++;
            y++;
            while (y < rawLen) {
                answer.add(matrix[y][x]);
                y++;
            }
            if (answer.size() >= sum) {
                break;
            }
            y--;
            colLen--;
            x--;
            while (x > colSta) {
                answer.add(matrix[y][x]);
                x--;
            }
            if (answer.size() >= sum) {
                break;
            }
            x++;
            rawLen--;
            y--;
            while (y > rawSta) {
                answer.add(matrix[y][x]);
                y--;
            }
            if (answer.size() >= sum) {
                break;
            }
            y++;
            colSta++;
            x++;
        }
        return answer;
    }

    //优解。更好理解。
    public ArrayList<Integer> printMatrix2(int[][] matrix) {
        ArrayList<Integer> answer = new ArrayList<>();
        int raw = matrix.length;
        int col = matrix[0].length;
        int top = 0;
        int bottom = raw - 1;
        int left = 0;
        int right = col - 1;
        int size = raw * col;
        while (left <= right && top <= bottom) {
            for (int i = left; i <= right; i++) {
                answer.add(matrix[top][i]);
            }
            if (answer.size() >= size) {
                break;
            }
            for (int i = top + 1; i <= bottom; i++) {
                answer.add(matrix[i][right]);
            }
            if (answer.size() >= size) {
                break;
            }
            for (int i = right - 1; i >= left; i--) {
                answer.add(matrix[bottom][i]);
            }
            if (answer.size() >= size) {
                break;
            }
            for (int i = bottom - 1; i > top; i--) {
                answer.add(matrix[i][left]);
            }

            top++;
            bottom--;
            left++;
            right--;
        }
        return answer;
    }
}
