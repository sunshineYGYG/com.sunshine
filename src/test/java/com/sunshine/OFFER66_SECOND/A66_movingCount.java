package com.sunshine.OFFER66_SECOND;

import org.junit.Test;

public class A66_movingCount {

    @Test
    public void test() {
        int i = movingCount(10, 1, 100);
        System.out.println(i);
    }

    int rows;
    int cols;
    int threshold;
    int ans = 0;

    public int movingCount(int threshold, int rows, int cols) {
        boolean[] flags = new boolean[rows * cols];
        this.rows=rows;
        this.cols=cols;
        this.threshold=threshold;
        BFS(flags, 0, 0);
        return ans;
    }

    private void BFS(boolean[] flags, int x, int y) {
        if (!check(flags, x, y)) {
            return;
        }
        int curSum = 0;
        int tx = x;
        while (tx > 0) {
            curSum += tx % 10;
            tx /= 10;
        }
        int ty = y;
        while (ty > 0) {
            curSum += ty % 10;
            ty /= 10;
        }
        if(curSum>threshold){
            return;
        }
        flags[x * cols + y] = true;
        ans++;
        BFS(flags, x + 1, y);
        BFS(flags, x - 1, y);
        BFS(flags, x, y + 1);
        BFS(flags, x, y - 1);
        return;
    }

    private boolean check(boolean[] flags, int x, int y) {
        if (x >= 0 && x < rows && y >= 0 && y < cols && !flags[x * cols + y]) {
            return true;
        }
        return false;
    }
}
