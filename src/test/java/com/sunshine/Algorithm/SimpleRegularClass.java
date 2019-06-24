package com.sunshine.Algorithm;

import org.junit.Test;

public class SimpleRegularClass {

    @Test
    public void test() {
//        char[] str = {'a', 'a', 'a'};
//        char[] pattern = {'a', 'b', '*', 'a', 'c', '*', 'a'};
        char[] str = {'a', 'a', 'a'};
        char[] pattern = {'a', 'b', '*', 'a', '*', 'c', '*', 'a'};
        boolean match = match(str, pattern);
        System.out.println(match);
    }

    public boolean match(char[] str, char[] pattern) {
        if (null == str || null == pattern) {
            return false;
        }

        int j = 0;
        int i = 0;
        int strLen = str.length;
        char[] neatPattern = neatPattern(pattern);
        int patLen = neatPattern.length;
        while (j < patLen) {
            if ('*' == neatPattern[j]) {
                j++;
                continue;
            }
            if (i < strLen) {
                if (neatPattern[j] == str[i]) {
                    i++;
                    j++;
                    continue;
                }
                if ('.' == neatPattern[j]) {
                    i++;
                    j++;
                    continue;
                }
                if (j - 2 >= 0 && '*' == neatPattern[j - 1] && (neatPattern[j - 2] == str[i] || '.' == neatPattern[j - 2])) {
                    i++;
                    continue;
                }
            }
            if (j + 1 < patLen && neatPattern[j + 1] == '*') {
                j += 2;
                continue;
            }
            return false;
        }
        int e = j - 2;
        while (i < strLen && e >= 0 && '*' == neatPattern[e + 1] && (neatPattern[e] == str[i] || '.' == neatPattern[e])) {
            i++;
        }
        if (i < strLen) {
            return false;
        }
        return true;
    }

    private char[] neatPattern(char[] pattern) {
        char[] result = new char[pattern.length];
        int j = 0;
        int pos = -1;
        for (int i = 0; i < pattern.length; i++) {
            if (pos - 1 >= 0 && pattern[pos - 1] == pattern[i]) {
                continue;
            }
            pos = -1;
            if ('*' == pattern[i]) {
                pos = i;
            }
            result[j++] = pattern[i];
        }
        char[] nre = new char[j];
        for (int h = 0; h < j; h++) {
            nre[h] = result[h];
        }
        return nre;
    }

    @Test
    public void test2() {
        char[] pat = {'a', '*', 'a'};
        compare(pat);
    }

    private void compare(char[] pat) {
        if (pat[0] == pat[2]) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }
}
