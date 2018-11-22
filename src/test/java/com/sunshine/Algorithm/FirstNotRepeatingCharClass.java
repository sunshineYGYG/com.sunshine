package com.sunshine.Algorithm;

import org.junit.Test;

import java.util.*;

public class FirstNotRepeatingCharClass {
    @Test
    public void test(){
        System.out.println(FirstNotRepeatingChar("aacbb"));
    }


    public int FirstNotRepeatingChar(String str) {
        if(null==str||str.length()==0){
            return -1;
        }
        Map<String,Integer> map=new LinkedHashMap<>();
        for(int i=0;i<str.length();i++){
            char c=str.charAt(i);
            if(map.containsKey(c+"")){
                map.put(c+"",-2);
            }else{
                map.put(c+"",i);
            }
        }
        if(map.size()!=0){
            Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();
            while(iterator.hasNext()){
                Map.Entry<String, Integer> next = iterator.next();
                if(next.getValue()!=-2){
                    return next.getValue();
                }
            }
        }
        return -1;
    }

    private void print(Map<String,Integer> map){
        System.out.println("=====");
        Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<String, Integer> next = iterator.next();
            System.out.println("key: "+next.getKey()+" value: "+next.getValue());
        }
        System.out.println("=====");
    }
}
