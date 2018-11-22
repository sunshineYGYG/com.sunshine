package com.sunshine.Algorithm;

import org.junit.Test;

public class StrToIntClass {
    @Test
    public void test(){
        System.out.println(StrToInt("22w2"));
    }
    public int StrToInt(String str) {
        int flag=0;
        int ans=0;
        for(int i=0;i<str.length();i++){
            char c = str.charAt(i);
            if(i==0){
                if(c=='+'){
                    flag=1;
                }else if(c=='-'){
                    flag=-1;
                }else if(c>='0'&&c<='9'){
                    flag=1;
                    ans=ans*10+c-'0';
                }else{
                    return 0;
                }
                continue;
            }
            if(c>='0'&&c<='9'){
                ans=ans*10+c-'0';
            }else{
                return 0;
            }
        }
        if(flag==-1){
            ans=-ans;
        }
        return ans;
    }
}
