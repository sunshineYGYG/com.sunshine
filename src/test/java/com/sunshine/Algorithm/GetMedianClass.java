package com.sunshine.Algorithm;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class GetMedianClass {
    @Test
    public void test(){
        int[] arr={5,2,3,4,1,6,7,0,8};
        for(int i=0;i<arr.length;i++){
            Insert(arr[i]);
            System.out.println(" median =  "+GetMedian());
        }
    }

    List<Integer> list=new ArrayList<>();

    public void Insert(Integer num) {
        int size=list.size();
        if(list.isEmpty()){
            list.add(num);
        }
        for(int i=0;i<size;i++){
            if(list.get(i)>num){
                list.add(i,num);
                break;
            }else if(i==size-1){
                list.add(num);
            }
        }
        print(list);
    }

    public Double GetMedian() {
        if(list.size()%2==1){
            return list.get(list.size()>>1)+0.0;
        }else{
            int pos = list.size() >> 1;
            return (list.get(pos)+list.get(pos-1))/2.0;
        }
    }

    private void print(List<Integer> list){
        System.out.println("===");
        list.forEach(a->System.out.print(a+" "));
        System.out.println();
    }
}
