package com.sunshine.OFFER66_SECOND;


import org.junit.Test;

import java.util.Map;
import java.util.TreeMap;

public class A34_FirstNotRepeatingChar {

    @Test
    public void test() {
        String str = "google";
        int a = FirstNotRepeatingChar(str);
        System.out.println(a);
    }


    public int FirstNotRepeatingChar(String str) {
        Map<Character, Integer> count = new TreeMap<>();
        char[] chars = str.toCharArray();
        for (char c : chars) {
            if (count.containsKey(c)) {
                Integer cc = count.get(c);
                count.put(c, cc + 1);
            } else {
                count.put(c, 1);
            }
        }
        for (int i = 0; i < chars.length; i++) {
            if (count.get(chars[i]) == 1) {
                return i;
            }
        }
        return -1;
    }
}
