package com.sunshine.Algorithm;

import org.junit.Test;

public class HasPathClass {

    @Test
    public void test() {
        char[] m = {'a', 'b', 'c', 'e', 's', 'f', 'c', 's', 'a', 'd', 'e', 'e'};
        char[] p1 = {'b', 'c', 'c', 'e', 'd'};
        boolean b = hasPath(m, 3, 4, p1);
        if (b) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }

    private int rs;
    private int cs;
    //自己的答案。
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        cs = cols;
        rs = rows;

        int p = 0;
        char[][] newMatrix = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                newMatrix[i][j] = matrix[p++];
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                boolean[][] flags = new boolean[rows][cols];
                if (solve(newMatrix, str, i, j, 0, flags)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean solve(char[][] matrix, char[] str, int x, int y, int pos, boolean[][] flags) {
        if (!checkNext(x, y, flags)) {
            return false;
        }
        if (matrix[x][y] != str[pos]) {
            return false;
        }
        if (pos + 1 == str.length) {
            return true;
        }
        flags[x][y] = true;
        //可以简写为 或 的短路。
        if (solve(matrix, str, x - 1, y, pos + 1, flags)) {
            return true;
        }
        if (solve(matrix, str, x + 1, y, pos + 1, flags)) {
            return true;
        }
        if (solve(matrix, str, x, y + 1, pos + 1, flags)) {
            return true;
        }
        if (solve(matrix, str, x, y - 1, pos + 1, flags)) {
            return true;
        }
        return false;
    }

    private boolean checkNext(int x, int y, boolean[][] flags) {
        return x >= 0 && x < rs && y >= 0 && y < cs && !flags[x][y];
    }
}
