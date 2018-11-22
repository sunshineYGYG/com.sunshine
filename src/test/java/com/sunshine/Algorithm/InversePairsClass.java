package com.sunshine.Algorithm;

import org.junit.Test;

public class InversePairsClass {
    @Test
    public void test(){
        int[] arr=new int[]{1,2,3,4,5,6,7,0};
        System.out.println(InversePairs(arr));
    }
    public int InversePairs(int [] array) {
        if(null==array||array.length<=1){
            return 0;
        }
        int ans=0;
        for(int i=1;i<array.length;i++){
            int j=i-1;
            int temp=array[i];
            while(j>=0&&temp<array[j]){
                array[j+1]=array[j];
                j--;
                ans++;
                ans%=1000000007;
            }
            array[j+1]=temp;
        }
        return ans;
    }
}
