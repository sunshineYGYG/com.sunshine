package com.sunshine.OFFER66_SECOND;

import org.junit.Test;

public class A52_match {

    @Test
    public void test() {
        char[] str = {'a', 'a', 'a'};
        char[] pattern = {'a', 'b', '*', 'a'};
        boolean match = match(str, pattern);
        System.out.println(match);
    }

    public boolean match(char[] str, char[] pattern) {
        return judge(str, 0, pattern, 0);
    }

    public boolean judge(char[] str, int cur, char[] pattern, int pos) {
        if (pos == pattern.length && cur == str.length) {
            return true;
        }
        if (pos == pattern.length && cur < str.length) {
            return false;
        }
        if (pos < pattern.length && cur == str.length) {
            if (pos + 1 < pattern.length && pattern[pos + 1] == '*') {
                return judge(str, cur, pattern, pos + 2);
            }
            return false;
        }

        if (pattern[pos] == '.' || str[cur] == pattern[pos]) {
            if (pos + 1 < pattern.length && pattern[pos + 1] == '*') {
                return judge(str, cur + 1, pattern, pos) || judge(str, cur + 1, pattern, pos + 2) || judge(str, cur, pattern, pos + 2);
            } else {
                return judge(str, cur + 1, pattern, pos + 1);
            }
        }
        if (pattern[pos] != str[cur] && pos + 1 < pattern.length && pattern[pos + 1] == '*') {
            return judge(str, cur, pattern, pos + 2);
        }
        return false;
    }
}
