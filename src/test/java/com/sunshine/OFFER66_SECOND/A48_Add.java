package com.sunshine.OFFER66_SECOND;

import org.junit.Test;

public class A48_Add {

    @Test
    public void test(){
        int add = Add(6, 3);
        System.out.println(add);
    }

    public int Add(int num1, int num2) {
        int x = num1 & num2;
        int y = num2 ^ num1;
        while (x != 0) {
            x<<=1;
            int tmp = x & y;
            y = x ^ y;
            x=tmp;
        }
        return y;
    }
}
