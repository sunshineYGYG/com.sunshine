package com.sunshine.Algorithm;

import org.junit.Test;

import java.util.ArrayList;

public class FindContinuousSequenceClass {
    @Test
    public void test(){
//        printSum(100);
//        System.out.println();
//        System.out.println("3/2+1::"+(3/2+1));
//        System.out.println("3>>1::"+(3>>1+1));
        ArrayList<ArrayList<Integer>> arrayLists = FindContinuousSequence(3);
        for(ArrayList<Integer> arrayList:arrayLists){
            System.out.print("答案：");
            for(Integer a:arrayList){
                System.out.print(a+" ");
            }
            System.out.println();
        }
    }
    public void printSum(int n){
        int sum=0;
        for(int i=1;i<=n;i++){
            sum+=i;
            System.out.print(i+": "+sum+" ");
        }
    }
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        if(sum==1){
            return new ArrayList<>();
        }
        int mid=(sum>>1)+1;
        int[] array=new int[mid+1];
        array[0]=0;
        for(int i=1;i<=mid;i++){
            array[i]=array[i-1]+i;
        }
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        for(int i=0;i<=mid;i++){
            int pos=binarySearch(array,array[i]+sum);
            if(pos==-1){
                continue;
            }
            int s=0;
            int j=i+1;
            ArrayList<Integer> curAns=new ArrayList<>();
            while(s<sum){
                curAns.add(j);
                s+=j++;
            }
            ans.add(curAns);
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
