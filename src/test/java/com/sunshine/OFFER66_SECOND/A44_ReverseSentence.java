package com.sunshine.OFFER66_SECOND;

import org.junit.Test;

public class A44_ReverseSentence {

    @Test
    public void test() {
        String str = "student. a am I";
        String str2 = " ";
        String s = ReverseSentence(str2);
        System.out.println(s);
    }

    public String ReverseSentence(String str) {
        if (null == str || "".equals(str)) {
            return "";
        }
        String[] split = str.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = split.length - 1; i >= 0; i--) {
            stringBuilder.append(split[i]);
            if (i != 0) {
                stringBuilder.append(" ");
            }
        }
        String ans = stringBuilder.toString();
        if("".equals(ans)){
            return str;
        }
        return ans;
    }
}
