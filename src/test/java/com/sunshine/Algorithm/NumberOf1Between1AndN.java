package com.sunshine.Algorithm;

import org.junit.Test;

public class NumberOf1Between1AndN {
    @Test
    public void test(){
        System.out.println(NumberOf1Between1AndN_Solution(16));
    }

    public int NumberOf1Between1AndN_Solution(int n) {
        int i=1;
        int sum=0;
        while(i<=n){
            int j=i;
            while(j>0){
                if(j%10==1){
                    sum++;
                }
                j/=10;
            }
            i++;
        }
        return sum;
    }
}
