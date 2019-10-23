package com.sunshine.OFFER66_SECOND;

import org.junit.Test;

import java.util.ArrayList;

public class A32_PrintMinNumber {

    @Test
    public void test(){
        int[] arr=new int[]{3,32,321};
        String s = PrintMinNumber(arr);
        System.out.println(s);
    }

    public String PrintMinNumber(int[] numbers) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int number : numbers) {
            list.add(number);
        }
        list.sort((a, b) -> {
            char[] as = a.toString().toCharArray();
            char[] bs = b.toString().toCharArray();
            int len = as.length > bs.length ? as.length : bs.length;
            for (int i = 0; i < len; i++) {
                if (i < as.length && i < bs.length) {
                    if (as[i] == bs[i]) {
                        continue;
                    }
                    return as[i] - bs[i];
                } else if (i < as.length && i >= bs.length) {
                    if (as[i] == bs[bs.length - 1]) {
                        continue;
                    }
                    return as[i] - bs[bs.length - 1];
                } else if (i >= as.length && i < bs.length) {
                    if (as[as.length - 1] == bs[i]) {
                        continue;
                    }
                    return as[as.length - 1] - bs[i];
                }
            }
            return 0;
        });
        //其他人重写比较器，简单好多
//        list.sort((a, b) -> {
//            String c = "" + a + b;
//            String d = "" + b + a;
//            return c.compareTo(d);
//        });
        StringBuilder ans=new StringBuilder();
        list.forEach(a -> ans.append(a));
        return ans.toString();
    }
}
