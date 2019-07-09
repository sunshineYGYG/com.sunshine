package com.sunshine.Algorithm;

import org.junit.Test;

public class IsNumericClass {

    @Test
    public void test() {
        char[] a = {'1', '2', '3', '.', '4', '5', 'e', '+', '6'};
        char[] b = {'-', '.', '2'};
        boolean numeric = isNumeric(b);
        boolean numeric2 = isNumeric2(b);
        boolean numeric3 = isNumeric3(a);
        System.out.println(numeric);
        System.out.println(numeric2);
        System.out.println(numeric3);
    }

    //自己的答案
    public boolean isNumeric(char[] str) {
        String num = new String(str);
        String newNum = num.toUpperCase();
        String[] es = newNum.split("E");
        try {
            double iNum = Double.parseDouble(es[0]);
            System.out.println(iNum);
            Integer dNum = null;
            if (es.length > 1 && es[1].length() > 0) {
                dNum = Integer.parseInt(es[1]);
                System.out.println(dNum);
            }
            if (newNum.charAt(str.length - 1) == 'E' && null == dNum) {
                throw new RuntimeException();
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    //最优解
    public boolean isNumeric2(char[] str) {
        String s = String.valueOf(str);
        return s.matches("[+-]?[0-9]*(\\.[0-9]*)?([Ee][+-]?[0-9]+)?");
    }

    //穷举解
    public boolean isNumeric3(char[] str) {
        boolean sign = false;
        boolean decimal = false;
        boolean hasE = false;
        for (int i = 0; i < str.length; i++) {
            if ('+' == str[i] || '-' == str[i]) {
                if (sign && 'e' != str[i - 1] && 'E' != str[i - 1]) {
                    return false;
                }
                if (!sign && i > 0 && 'e' != str[i - 1] && 'E' != str[i - 1]) {
                    return false;
                }
                sign = true;
            } else if ('.' == str[i]) {
                if (hasE || decimal) {
                    return false;
                }
                decimal = true;
            } else if ('e' == str[i] || 'E' == str[i]) {
                if (hasE) {
                    return false;
                }
                if (i + 1 == str.length) {
                    return false;
                }
                hasE = true;
            } else if (str[i] < 48 || str[i] > 57) {
                return false;
            }
        }
        return true;
    }
}
