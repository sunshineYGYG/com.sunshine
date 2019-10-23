package com.sunshine.OFFER66_SECOND;

import org.junit.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class A54_FirstAppearingOnce {

    @Test
    public void test() {
        Insert('g');
        Insert('o');
        Insert('o');
        Insert('g');
        Insert('l');
        System.out.println(FirstAppearingOnce());
    }

    Map<Character, Integer> ans = new HashMap<>();
    int pos = -1;

    //Insert one char from stringstream
    public void Insert(char ch) {
        pos++;
        if (ans.containsKey(ch)) {
            ans.put(ch, -1);
        } else {
            ans.put(ch, pos);
        }
    }

    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        int pos = -1;
        char c = '#';
        Set<Map.Entry<Character, Integer>> entries = ans.entrySet();
        Iterator<Map.Entry<Character, Integer>> iterator = entries.iterator();
        while (iterator.hasNext()) {
            Map.Entry<Character, Integer> next = iterator.next();
            if (next.getValue() != -1 && (pos == -1 || next.getValue() < pos)) {
                pos = next.getValue();
                c = next.getKey();
            }
        }
        return c;
    }


}
