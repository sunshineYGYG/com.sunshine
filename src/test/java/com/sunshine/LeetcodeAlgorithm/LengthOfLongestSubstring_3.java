package com.sunshine.LeetcodeAlgorithm;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestSubstring_3 {

    @Test
    public void test() {
        String s = "auc";
        String s1 = "abcabcbb";
        int i = lengthOfLongestSubstring(s);
        int j = lengthOfLongestSubstring2(s);
        System.out.println(i);
        System.out.println(j);
    }

    public int lengthOfLongestSubstring(String s) {
        if (null == s || "".equals(s)) {
            return 0;
        }
        int ans = 1;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            Set<Character> con = new HashSet<>();
            con.add(chars[i]);

            for (int j = i + 1; j < chars.length; j++) {
                if (con.contains(chars[j])) {
                    int curLen = j - i;
                    if (curLen > ans) {
                        ans = curLen;
                    }
                    break;
                } else if (!con.contains(chars[j]) && (j + 1 == chars.length)) {
                    int curLen = j - i + 1;
                    if (curLen > ans) {
                        ans = curLen;
                    }
                }
                con.add(chars[j]);
            }

            con.clear();
        }
        return ans;
    }

    public int lengthOfLongestSubstring2(String s) {
        if (null == s || "".equals(s)) {
            return 0;
        }
        char[] chars = s.toCharArray();
        int pos = 0;
        int ans = 1;
        for (int i = 0; i < chars.length; i++) {
            for (int j = pos; j < i; j++) {
                if (chars[j] == chars[i]) {
                    if (i - pos > ans) {
                        ans = i - pos;
                    }
                    pos = j + 1;
                    break;
                } else if (j + 1 == i && i + 1 == chars.length && chars[j] != chars[i]) {
                    if (chars.length - pos > ans) {
                        ans = chars.length - pos;
                    }
                }
            }
        }
        return ans;
    }
}
