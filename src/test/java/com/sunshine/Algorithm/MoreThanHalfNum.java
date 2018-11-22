package com.sunshine.Algorithm;

import org.junit.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MoreThanHalfNum {
    @Test
    public void test(){
        int[] array={1,2,3,2,4,2,5,2,3};
        System.out.println(MoreThanHalfNum_Solution(array));
    }

    public int MoreThanHalfNum_Solution(int [] array) {
        if(null==array||0==array.length){
            return 0;
        }
        double halfNum=array.length/2.0;
        Map<Integer,Integer> numMap=new HashMap<>();
        for(int a:array){
            if(numMap.containsKey(a)){
                Integer num = numMap.get(a);
                numMap.put(a,++num);
            }else{
                numMap.put(a,1);
            }
        }
        Iterator<Map.Entry<Integer, Integer>> iterator = numMap.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<Integer, Integer> next = iterator.next();
            if(next.getValue()>halfNum){
                return next.getKey();
            }
        }
        return 0;
    }
}
