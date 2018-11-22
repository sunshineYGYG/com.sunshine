package com.sunshine.Algorithm;

import org.junit.Test;

public class ChildArraySum {
    @Test
    public void test(){
        int[] array={2,5,-10,5,6,7,3};
        System.out.println(FindGreatestSumOfSubArray(array));
    }
    public int FindGreatestSumOfSubArray(int[] array) {
        int sum=array[0];
        int max=sum;
        for(int i=1;i<array.length;i++){
            if(sum<0){
                sum=array[i];
            }else{
                sum+=array[i];
            }
            if(max<sum){
                max=sum;
            }
        }
        return max;
    }
}
