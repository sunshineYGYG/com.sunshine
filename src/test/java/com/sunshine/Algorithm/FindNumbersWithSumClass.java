package com.sunshine.Algorithm;

import org.junit.Test;

import java.util.ArrayList;

public class FindNumbersWithSumClass {

    @Test
    public void test(){
        int[] arr={1,2,3,4,5,6,7,8,9};
        ArrayList<Integer> arrayList = FindNumbersWithSum(arr, 10);
        arrayList.forEach(System.out::print);
    }
    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        if(null==array||array.length<1){
            return new ArrayList<>();
        }
        int len = array.length;
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=0;i<len;i++){
            if(binarySearch(array,sum-array[i])==-1){
                continue;
            }
            if(ans.isEmpty()){
                ans.add(array[i]);
                ans.add(sum-array[i]);
            }else if(ans.get(0)*ans.get(1)>((sum-array[i])*array[i])){
                ans.set(0,array[i]);
                ans.set(1,sum-array[i]);
            }
        }
        return ans;
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
