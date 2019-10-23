package com.sunshine.OFFER66_SECOND;

import org.junit.Test;

public class A7_Fibonacci {

    @Test
    public void test() {
        System.out.println(Fibonacci(0));
    }

    public int Fibonacci(int n) {
        if(0 == n){
            return 0;
        }
        int a = 0;
        int b = 1;
        int ans = 1;
        n--;
        while (n > 0) {
            ans = a + b;
            a = b;
            b = ans;
            n--;
        }
        return ans;
    }
}
