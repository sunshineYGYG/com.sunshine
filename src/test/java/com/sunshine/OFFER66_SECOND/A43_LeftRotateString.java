package com.sunshine.OFFER66_SECOND;

import org.junit.Test;

public class A43_LeftRotateString {

    @Test
    public void test(){
        String str="abcXYZdef";
        String string = LeftRotateString(str, 3);
        System.out.println(string);
        String string2 = LeftRotateString2(str, 3);
        System.out.println(string2);
    }

    public String LeftRotateString(String str, int n) {
        if (null == str || "".equals(str)) {
            return "";
        }
        return str.substring(n)+str.substring(0,n);
    }
    public String LeftRotateString2(String str, int n) {
        if (null == str || "".equals(str)) {
            return "";
        }
        StringBuilder stringBuilder=new StringBuilder();
        for(int i=n;i<str.length();i++){
            stringBuilder.append(str.charAt(i));
        }
        for(int i=0;i<n;i++){
            stringBuilder.append(str.charAt(i));
        }
        return stringBuilder.toString();
    }
}
