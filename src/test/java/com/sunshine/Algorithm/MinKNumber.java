package com.sunshine.Algorithm;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class MinKNumber {
    @Test
    public void getAns(){
        int[] arr={2,4,5,4,1,8,5,4};
        ArrayList<Integer> list = GetLeastNumbers_Solution2(arr, 3);
        list.forEach(System.out::println);
    }
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        if(input.length<k||k==0){
            return new ArrayList<>();
        }
        ArrayList<Integer> ans=new ArrayList<>();
        for(int i=0;i<k;i++){
            ans.add(input[i]);
        }
        ans.sort(Integer::compareTo);
        for(int i=k;i<input.length;i++){
            if(ans.get(k-1)>input[i]){
                ans.remove(k-1);
                ans.add(input[i]);
                ans.sort(Integer::compareTo);
            }
        }
        return ans;
    }
    public ArrayList<Integer> GetLeastNumbers_Solution2(int [] input, int k) {
        if(input.length<k||k==0){
            return new ArrayList<>();
        }
        ArrayList<Integer> ans=new ArrayList<>();
        for(int i=0;i<k;i++){
            ans.add(input[i]);
        }
        int curMax=getMax(ans);
        for(int i=k;i<input.length;i++){
            if(curMax>input[i]){
                ans.set(ans.indexOf(curMax),input[i]);
                curMax=getMax(ans);
            }
        }
        return ans;
    }
    private Integer getMax(ArrayList<Integer> ans) {
        Integer cur = ans.get(0);
        for (int i = 0; i < ans.size(); i++) {
            if(cur<ans.get(i)){
                cur=ans.get(i);
            }
        }
        return cur;
    }
}
