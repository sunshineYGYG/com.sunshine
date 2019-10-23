package com.sunshine.OFFER66_SECOND;

import org.junit.Test;

import java.util.*;

public class A28_MoreThanHalfNum_Solution {

    @Test
    public void test() {
        int[] arr = new int[]{2, 3, 2, 2, 2, 5, 4, 2, 10};
        int i = MoreThanHalfNum_Solution(arr);
        System.out.println(i);
        int j = MoreThanHalfNum_Solution2(arr);
        System.out.println(j);
    }


    public int MoreThanHalfNum_Solution(int[] array) {
        Map<Integer, Integer> re = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            if (re.containsKey(array[i])) {
                Integer count = re.get(array[i]);
                re.put(array[i], count + 1);
            } else {
                re.put(array[i], 1);
            }
        }
        Iterator<Map.Entry<Integer, Integer>> iterator = re.entrySet().iterator();
        int midCount = array.length / 2;
        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> num = iterator.next();
            if (midCount < num.getValue()) {
                return num.getKey();
            }
        }
        return 0;
    }

    //其他人解
    public int MoreThanHalfNum_Solution2(int[] array) {
        Arrays.sort(array);
        if (array.length == 0) {
            return 0;
        }
        int cur = array[0];
        int ans = cur;
        int max = 1;
        int count = 1;
        for (int i = 1; i < array.length; i++) {
            if (array[i] == cur) {
                count++;
            } else {
                if (count > max) {
                    max = count;
                    ans = cur;
                }
                count = 1;
                cur = array[i];
            }
        }
        if (array.length/2 < max) {
            return ans;
        }
        return 0;
    }
}
