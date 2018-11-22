package com.sunshine.Algorithm;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class LastRemainingClass {
    @Test
    public void test(){
        System.out.println(LastRemaining_Solution(5,3));
    }

    public int LastRemaining_Solution(int n, int m) {
        if(m==0||n==0){
            return -1;
        }
        List<Integer> arr=new ArrayList<>();
        for(int i=0;i<n;i++){
            arr.add(i);
        }
        int tn=n;
        int cur=0;
        while(tn>1){
            cur = (m+cur-1) % tn;
            arr.remove(cur);
            tn--;
        }
        return arr.get(0);
    }
}
