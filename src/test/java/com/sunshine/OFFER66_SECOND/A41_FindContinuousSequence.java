package com.sunshine.OFFER66_SECOND;

import org.junit.Test;

import java.util.ArrayList;

public class A41_FindContinuousSequence {

    @Test
    public void test(){
        ArrayList<ArrayList<Integer>> arrayLists = FindContinuousSequence(2);
        arrayLists.forEach(a->{
            a.forEach(b->System.out.print(b+" "));
            System.out.println();
        });
    }


    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        int curSum = 0;
        int left = 1;
        for (int i = 1; i <= (sum / 2 + 1); i++) {
            curSum += i;
            while (curSum > sum) {
                curSum -= left;
                left++;
            }
            if (curSum == sum) {
                if(i-left+1>=2) {
                    ArrayList<Integer> oneAns = new ArrayList<>();
                    for (int j = left; j <= i; j++) {
                        oneAns.add(j);
                    }
                    ans.add(oneAns);
                }
            }
        }
        return ans;
    }

    //其他人解，双指针，比sum小右边的指针++，比sum大左边指针++
    //本质是一样的就不赘述了。
}
