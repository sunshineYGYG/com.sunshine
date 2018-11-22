package com.sunshine.Algorithm;

import org.junit.Test;

import java.util.Arrays;

public class IsContinuousClass {
    @Test
    public void test(){
        int[] arr={0,0,0,1,5};
        if(isContinuous(arr)){
            System.out.println("yes");
        }else{
            System.out.println("no");
        }
    }
    public boolean isContinuous(int [] numbers) {
        if(null==numbers||numbers.length==0){
            return false;
        }
        Arrays.sort(numbers);
        int flag = 0;
        for (int i = 0; i < 5; i++) {
            if (numbers[i] == 0) {
                flag++;
                continue;
            }
            if(i!=0&&numbers[i]==numbers[i-1]){
                return false;
            }
        }
        if(flag>0&&numbers[4]-numbers[flag]<=4){
            return true;
        }
        if(numbers[4]-numbers[0]==4){
            return true;
        }
        return false;
    }
}
