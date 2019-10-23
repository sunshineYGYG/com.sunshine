package com.sunshine.OFFER66_SECOND;

import org.junit.Test;

public class A12_Power {

    @Test
    public void test() {
        System.out.println(Power(0, 2));
        System.out.println(Power2(0,2));
    }

    public double Power(double base, int exponent) {
        return Math.pow(base, exponent);
    }

    public double Power2(double base, int exponent) {
        double ans = base;
        boolean flag = false;
        if (exponent < 0) {
            flag = true;
            exponent = -exponent;
        }
        if(base == 0 ){
            return 0;
        }else if ( exponent == 0) {
            return 1;
        } else if (exponent == 1) {
            return ans;
        } else if (exponent >= 2) {
            exponent--;
        }
        while (exponent > 0) {
            ans *= base;
            exponent--;
        }
        if (flag) {
            ans = 1 / ans;
        }
        return ans;
    }
}
