package com.sunshine.Algorithm;

import org.junit.Test;



public class WordReverse {
    @Test
    public void test(){
        String s="student. a am I";
        System.out.println(ReverseSentence(s));
    }
    public String ReverseSentence(String str) {
        if(null==str) return "";
        if(str.trim().equals("")){
            return str;
        }
        String[] ss = str.split(" ");
        StringBuffer ans=new StringBuffer();
        for(int i=ss.length-1;i>=0;i--){
            ans.append(ss[i]);
            if(i!=0){
                ans.append(" ");
            }
        }
        return ans.toString();
    }
}
