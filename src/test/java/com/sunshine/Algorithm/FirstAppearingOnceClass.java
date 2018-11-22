package com.sunshine.Algorithm;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class FirstAppearingOnceClass {
    //Insert one char from stringstream
    Map<String,Integer> map=new LinkedHashMap<>();
    public void Insert(char ch)
    {
        if(map.containsKey(ch+"")){
            Integer sum = map.get(ch + "");
            map.put(ch+"",++sum);
        }else{
            map.put(ch+"",1);
        }
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
        Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<String, Integer> next = iterator.next();
            if (next.getValue()==1){
                return next.getKey().charAt(0);
            }
        }
        return '#';
    }
}
