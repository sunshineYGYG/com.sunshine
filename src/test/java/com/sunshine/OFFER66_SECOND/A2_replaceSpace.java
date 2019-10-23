package com.sunshine.OFFER66_SECOND;

import org.junit.Test;

public class A2_replaceSpace {

    @Test
    public void test(){
        String str = "We Are Happy.";
        String s = replaceSpace2(new StringBuffer(str));
        System.out.println(s);
        String s1 = replaceSpace(new StringBuffer(str));
        System.out.println(s1);
    }


    //库函数
    public String replaceSpace(StringBuffer str) {
        int i = str.indexOf(" ");
        while(i>=0){
            str.replace(i,i+1,"%20");
            i = str.indexOf(" ",i+1);
        }
        return str.toString();
    }
    //库函数
    public String replaceSpace2(StringBuffer str) {
        String string = str.toString();
        return string.replaceAll(" ", "%20");
    }
}
