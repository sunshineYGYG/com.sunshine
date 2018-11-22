package com.sunshine.Algorithm;

import org.junit.Test;

public class GetNumberOfK {
    @Test
    public void test(){
        int[] arr={2,2,2,2,3,4,5,6,7,8,9};
        System.out.println(getNumberOfK(arr,3));
    }
    public int getNumberOfK(int [] array , int k) {
        if(null==array||array.length==0){
            return 0;
        }
        int pos=binarySearch(array,k);
        if(pos==-1) {
            return 0;
        }
        int i=pos;
        int ans=0;
        while(i<array.length&&array[i++]==k){
            ans++;
        }
        pos--;
        while(pos>=0&&array[pos--]==k){
            ans++;
        }
        return  ans;
    }
    private int binarySearch(int[] array,int x){
        int l=0;
        int r=array.length-1;
        while(l<=r){
            int m=(l+r)>>1;
            if(array[m]==x){
                return m;
            }else if(array[m]<x){
                l=m+1;
            }else{
                r=m-1;
            }
        }
        return -1;
    }
}
