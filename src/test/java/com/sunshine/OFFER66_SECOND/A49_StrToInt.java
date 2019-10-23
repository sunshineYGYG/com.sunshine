package com.sunshine.OFFER66_SECOND;

import org.junit.Test;

public class A49_StrToInt {

    @Test
    public void test() {
        String str = "+2147483647";
        String str2 = "-9";
        int i = StrToInt(str2);
        System.out.println(i);
    }

    public int StrToInt(String str) {
        if (null == str || "".equals(str)) {
            return 0;
        }
        int flag = 1;
        int ans = 0;
        int index = 10;
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (i == 0 && '-' == (chars[i])) {
                flag = -1;
            } else if (i == 0 && '+' == chars[i]) {
                flag = 1;
            } else if (chars[i] >= 48 && chars[i] <= 57) {
                ans = ans * index + (chars[i] - 48);
            } else {
                return 0;
            }
        }
        return ans * flag;
    }
}
