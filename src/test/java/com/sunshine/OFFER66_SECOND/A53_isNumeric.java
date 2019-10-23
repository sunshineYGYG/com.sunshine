package com.sunshine.OFFER66_SECOND;

import org.junit.Test;

public class A53_isNumeric {

    @Test
    public void test() {
        String number = "5e2";
        String[] numbers = {"+100", "5e2", "-123", "3.1416", "-1E-16"};
        for (String s : numbers) {
            boolean numeric = isNumeric2(s.toCharArray());
            System.out.println(numeric);
        }
        System.out.println();
        String[] numbers2 = {"12e", "1a3.14", "1.2.3", "+-5", "12e+4.3"};
        for (String s : numbers2) {
            boolean numeric = isNumeric2(s.toCharArray());
            System.out.println(numeric);
        }
    }

    public boolean isNumeric(char[] str) {
        int pm1 = 1;
        int pm2 = 1;
        boolean e = false;
        int point = -1;
        int a = 0;
        double b = 0;
        int c = 0;
        for (int i = 0; i < str.length; i++) {
            if (str[i] == '+') {
                if (i == 0) {
                    pm1 = 1;
                } else if (i - 1 >= 0 && (str[i - 1] == 'e' || str[i - 1] == 'E')) {
                    pm2 = 1;
                } else {
                    return false;
                }
            } else if (str[i] == '-') {
                if (i == 0) {
                    pm1 = -1;
                } else if (i - 1 >= 0 && (str[i - 1] == 'e' || str[i - 1] == 'E')) {
                    pm2 = -1;
                } else {
                    return false;
                }
            } else if (str[i] == 'e' || str[i] == 'E') {
                e = true;
                if (i == str.length - 1) {
                    return false;
                }
            } else if (!e) {
                if (str[i] == '.') {
                    if (point != -1) {
                        return false;
                    }
                    point = i;
                } else if (point != -1) {
                    if (str[i] >= '0' && str[i] <= '9') {
                        a = a * 10 + str[i] - '0';
                    } else {
                        return false;
                    }
                } else {
                    if (str[i] >= '0' && str[i] <= '9') {
                        b += (str[i] - '0') * 1.0 / ((i - point) * 10);
                    } else {
                        return false;
                    }
                }
            } else {
                if (str[i] >= '0' && str[i] <= '9') {
                    c = c * 10 + str[i] - '0';
                } else {
                    return false;
                }
            }
        }
        return true;
    }
    //其他优解
    public boolean isNumeric2(char[] str) {
        String string = String.valueOf(str);
        return string.matches("[\\+\\-]?\\d*(\\.\\d+)?([eE][\\+\\-]?\\d+)?");
    }
    /**
     * [\\+\\-]?            -> 正或负符号出现与否
     * \\d*                 -> 整数部分是否出现，如-.34 或 +3.34均符合
     * (\\.\\d+)?           -> 如果出现小数点，那么小数点后面必须有数字；
     *                         否则一起不出现
     * ([eE][\\+\\-]?\\d+)? -> 如果存在指数部分，那么e或E肯定出现，+或-可以不出现，
     *                         紧接着必须跟着整数；或者整个部分都不出现
     */
}
