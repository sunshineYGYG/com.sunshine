package com.sunshine.OFFER66_SECOND;

import org.junit.Test;

public class A11_NumberOf1 {

    @Test
    public void test() {
//        int n = 127;
//        System.out.println(NumberOf1(n));
//        System.out.println(NumberOf12(n));

//        System.out.println((1<<31)-1);
        System.out.println(NumberOf1(214748367));
        System.out.println(NumberOf12(214748367));
        System.out.println(NumberOf13(214748367));
//        printBinary(214748367);
//
//        printBinary(m1);
//        printBinary(m2);
//        printBinary(m4);
//        printBinary(h01);
    }

    private void printBinary(int n) {
        int i = 0;
        while (n > 0) {
            System.out.print(n & 1);
            n >>= 1;
            if (++i % 8 == 0) {
                System.out.print(" ");
            }
        }
        System.out.println();
    }


    final int m1 = 0x55555555; //binary: 0101...
    final int m2 = 0x33333333; //binary: 00110011..
    final int m4 = 0x0f0f0f0f; //binary:  4 zeros,  4 ones ...
    final int h01 = 0x01010101;

    //未过答案。
    public int NumberOf1(int n) {
        int ans = 0;
        if (n >= 0) {
            while (n != 0) {
                ans += n & 1;
                n >>= 1;
            }
        } else {
            int m = -n;
            boolean flag = false;
            while (m != 0) {
                int re = m & 1;
                if (!flag) {
                    if (1 == re) {
                        flag = true;
                    } else {
                        ans++;
                    }
                } else if (flag && 1 == re) {
                    ans++;
                }
                m >>= 1;
            }
            ans = 32 - ans;
        }
        return ans;
    }

    //汉明重量
    public int NumberOf12(int n) {
        int n1 = (n & m1) + ((n >> 1) & m1);
        int n2 = (n1 & m2) + ((n1 >> 2) & m2);
        int n3 = (n2 & m4) + ((n2 >> 4) & m4);
        int ans = (n3 * h01) >> 24;
        return ans;
    }

    //其他人解
    public int NumberOf13(int n) {
        int ans = 0;
        while (n != 0) {
            ans++;
            n &= (n - 1);
        }
        return ans;
    }

}
