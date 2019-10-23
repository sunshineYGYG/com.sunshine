package com.sunshine.OFFER66_SECOND;

import org.junit.Test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class A40_FindNumsAppearOnce {

    @Test
    public void test() {
        int[] arr = new int[]{1, 6, 3, 4, 5, 1, 3, 5};
        int[] num1 = new int[1];
        int[] num2 = new int[1];
        FindNumsAppearOnce(arr, num1, num2);
        System.out.println(num1[0] + " " + num2[0]);
        num1[0]=-1;
        num2[0]=-1;
        FindNumsAppearOnce2(arr,num1,num2);
        System.out.println(num1[0] + " " + num2[0]);
    }

    public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
        Set<Integer> ans = new HashSet<>();
        for (int i : array) {
            if (ans.contains(i)) {
                ans.remove(i);
            } else {
                ans.add(i);
            }
        }
        Iterator<Integer> iterator = ans.iterator();
        Integer next = iterator.next();
        num1[0] = next;
        Integer next1 = iterator.next();
        num2[0] = next1;
    }

    //其他人解。思路：多次^。
    //第一次循环^,找到两个数^的结果，即两个数在二进制上的不同，可以拿任意位置的一个1将数组分为该位置为1或0的两类数组。
    //第二次循环^,因为答案的两个数分别在两类数组中，所以可以^出两个结果。
    public void FindNumsAppearOnce2(int[] array, int num1[], int num2[]) {
        int re = 0;
        for (int i : array) {
            re ^= i;
        }
        int ans1 = 0;
        int ans2 = 0;
        int pos1 = 1;
        while (re > 0) {
            if ((re & 1) == 1) {
                break;
            }
            pos1 <<= 1;
            re>>=1;
        }
        for(int i:array){
            if((pos1&i)>0){
                ans1^=i;
            }else{
                ans2^=i;
            }
        }
        num1[0]=ans1;
        num2[0]=ans2;
    }
}
