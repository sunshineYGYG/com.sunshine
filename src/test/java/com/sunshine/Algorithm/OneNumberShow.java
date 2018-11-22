package com.sunshine.Algorithm;

import org.junit.Test;

import java.util.Arrays;

public class OneNumberShow {
    @Test
    public void OneNumberShow() {
//        int[] arr={3,7,5,31,4,0,5,6,3,7,4,0,10};
//        Arrays.sort(arr);
//        Arrays.stream(arr).forEach(a->System.out.print(a+" "));
        int[] arr={2,4,3,6,3,2,5,5};
        int[] num1=new int[1];
        int[] num2=new int[2];
        FindNumsAppearOnce(arr,num1,num2);
        System.out.print(num1[0]+"   "+num2[0]);
        System.out.println();
        FastSort(arr,0,arr.length-1);
        for (int i : arr) {
            System.out.print(i+" ");
        }
    }
    private void FastSort(int[] arr,int left,int right){
        if(left>=right){
            return;
        }
        int cur=arr[left];
        int l=left;
        int r=right;
        while(l<r){
            while(r>l&&cur<=arr[r]){
                r--;
            }
            arr[l]=arr[r];
            while(l<r&&cur>=arr[l]){
                l++;
            }
            arr[r]=arr[l];
        }
        arr[l]=cur;
        FastSort(arr,left,l-1);
        FastSort(arr,l+1,right);
    }
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
//        Arrays.sort(array);
        FastSort(array,0,array.length-1);
        int len=array.length;
        int ans=0;
        for (int i=0;i<len; i++) {
            if(ans==2){return;}
            if(i+1<len){
                if(array[i]!=array[i+1]){
                    if(ans==0){
                        num1[0]=array[i];
                        ans++;
                    }else if(ans==1){
                        num2[0]=array[i];
                        ans++;
                    }
                }else{
                    i++;
                }
            }else{
                if(ans==1){
                    num2[0]=array[i];
                }
            }
        }
        return;
    }
}
