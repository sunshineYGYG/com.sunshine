package com.sunshine.Algorithm;

import org.junit.Test;

import java.awt.*;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class MovingCountClass {

    @Test
    public void test() {
        System.out.println(movingCount(10, 100, 100));
        System.out.println(movingCount2(10, 100, 100));
    }

    private int threshold;
    private int rows;
    private int cols;
    boolean[][] flags = null;

    public int movingCount(int threshold, int rows, int cols) {
        boolean[][] booleans = new boolean[rows][cols];
        flags = booleans;
        this.threshold = threshold;
        this.rows = rows;
        this.cols = cols;
        int dfs = dfs(0, 0);
        return dfs;
    }

    private int dfs(int x, int y) {
        if (!check(x, y)) {
            return 0;
        }
        int re = 1;
        flags[x][y] = true;
        re += dfs(x - 1, y) + dfs(x + 1, y) + dfs(x, y - 1) + dfs(x, y + 1);
        return re;
    }

    private boolean check(int x, int y) {
        if (x >= 0 && x < rows && y >= 0 && y < cols && numSum(x) + numSum(y) <= threshold && !flags[x][y]) {
            return true;
        }
        return false;
    }

    private int numSum(int num) {
        int re = 0;
        while (num > 0) {
            re += num % 10;
            num /= 10;
        }
        return re;
    }

    public int movingCount2(int threshold, int rows, int cols) {
        boolean[][] booleans = new boolean[rows][cols];
        flags = booleans;
        this.threshold = threshold;
        this.rows = rows;
        this.cols = cols;
        int bfs = bfs();
        return bfs;
    }

    private int bfs() {
        LinkedList<PO> queue = new LinkedList<>();
        if(check(0,0)) {
            queue.addLast(new PO(0, 0));
            flags[0][0] = true;
        }
        int ans = 0;
        while (!queue.isEmpty()) {
            PO first = queue.pollFirst();
            int x = first.x;
            int y = first.y;
            ans++;
            if (check(x - 1, y)) {
                queue.addLast(new PO(x - 1, y));
                flags[x - 1][y] = true;
            }
            if (check(x + 1, y)) {
                queue.addLast(new PO(x + 1, y));
                flags[x + 1][y] = true;
            }
            if (check(x, y - 1)) {
                queue.addLast(new PO(x, y - 1));
                flags[x][y - 1] = true;
            }
            if (check(x, y + 1)) {
                queue.addLast(new PO(x, y + 1));
                flags[x][y + 1] = true;
            }
        }
        return ans;
    }

    class PO {
        int x;
        int y;

        public PO(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
