package com.sunshine.OFFER66_SECOND;

import org.junit.Test;

public class A9_JumpFloorII {

    @Test
    public void test() {
        System.out.println(JumpFloorII(4));
        System.out.println(JumpFloorII2(4));
        System.out.println(JumpFloorII3(4));
    }

    //没做深层次总结
    public int JumpFloorII(int target) {
        if (2 >= target) {
            return target;
        }
        int[] ans = new int[target + 1];
        ans[0] = 0;
        ans[1] = 1;
        ans[2] = 2;
        for (int i = 3; i <= target; i++) {
            int m = i - 1;
            ans[i] = 1;
            while (m > 0) {
                ans[i] += ans[m];
                m--;
            }
        }
        return ans[target];
    }

    //其他人解
    public int JumpFloorII2(int target) {
        if (target == 1) {
            return 1;
        }
        return 2 * JumpFloorII2(target - 1);
    }

    public int JumpFloorII3(int target) {
        return (int)Math.pow(2.0,target - 1.0);
    }
}
