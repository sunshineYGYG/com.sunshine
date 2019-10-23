package com.sunshine.OFFER66_SECOND;

import org.junit.Test;

public class A8_JumpFloor {

    @Test
    public void test() {
        System.out.println(JumpFloor(4));
        System.out.println(JumpFloor2(4));
    }

    int ans;

    public int JumpFloor(int target) {
        ans = 0;
        jump(target);
        return ans;
    }

    public void jump(int n) {
        if (0 == n) {
            ans++;
            return;
        }
        if (0 > n) {
            return;
        }
        jump(n - 1);
        jump(n - 2);
        return;
    }


    //他人解
    public int JumpFloor2(int target) {
        if (target == 1) {
            return 1;
        } else if (target == 2) {
            return 2;
        }
        return JumpFloor2(target - 1) + JumpFloor2(target - 2);
    }
}
