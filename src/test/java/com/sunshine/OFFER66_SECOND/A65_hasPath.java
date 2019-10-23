package com.sunshine.OFFER66_SECOND;

import org.junit.Test;

public class A65_hasPath {


    @Test
    public void test() {
        char[] matrix = new char[]{'a', 'b', 'c', 'e', 's', 'f', 'c', 's', 'a', 'd', 'e', 'e'};
        char[] str = {'b', 'c', 'c', 'e', 'd'};
        boolean b = hasPath(matrix, 3, 4, str);
        System.out.println(b);
    }

    int rows;
    int cols;
    boolean ans = false;

    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        this.rows = rows;
        this.cols = cols;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                boolean[] flags = new boolean[rows * cols];
                BFS(matrix, flags, i, j, str, 0);
                if (ans) {
                    return ans;
                }
            }
        }
        return ans;
    }

    private void BFS(char[] matrix, boolean[] flags, int x, int y, char[] str, int pos) {
        if (!check(flags, x, y) || ans || pos >= str.length) {
            return;
        }
        int cur = x * cols + y;
        if (matrix[cur] == str[pos]) {
            flags[cur] = true;
            if (pos + 1 == str.length) {
                ans = true;
                return;
            }
            BFS(matrix, flags, x + 1, y, str, pos + 1);
            BFS(matrix, flags, x - 1, y, str, pos + 1);
            BFS(matrix, flags, x, y + 1, str, pos + 1);
            BFS(matrix, flags, x, y - 1, str, pos + 1);
        }
        return;
    }

    private boolean check(boolean[] flags, int x, int y) {
        if (x >= 0 && x < rows && y >= 0 && y < cols && !flags[x * cols + y]) {
            return true;
        }
        return false;
    }
}
