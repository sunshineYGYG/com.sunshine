package com.sunshine.Algorithm;

import org.junit.Test;

public class LeftRotateStringClass {
    @Test
    public void test(){
        System.out.print(LeftRotateString("abcdef",2));
    }
    public String LeftRotateString(String str,int n) {
        if(str.length()<n){
            return "";
        }
        return str.substring(n)+str.substring(0,n);
    }
}
