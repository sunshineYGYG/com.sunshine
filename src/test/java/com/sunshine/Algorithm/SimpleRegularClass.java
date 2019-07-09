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

    //我的错误答案，无法判断*的使用
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

    @Test
    public void test3() {
//        char[] str = {'a', 'a', 'a'};
//        char[] pattern = {'a', 'b', '*', 'a', 'c', '*', 'a'};
        char[] str = {'b', 'b', 'b', 'b', 'a'};
        char[] pattern = {'.', '*', 'a', '*', 'a'};
        boolean match = match2(str, pattern);
        System.out.println(match);
    }
    //正确答案
    public boolean match2(char[] str, char[] pattern) {
        return solve(str, 0, pattern, 0);
    }

    public boolean solve(char[] str, int pos, char[] pattern, int cur) {
        if (pos == str.length && cur == pattern.length) {
            return true;
        }
        if (pos != str.length && cur == pattern.length) {
            return false;
        }
        //下一个字符是*的情况
        if (cur + 1 < pattern.length && pattern[cur + 1] == '*') {
            //匹配成功时，走三种情况1、匹配0次2、只匹配一次，3、匹配多次
            if (pos < str.length && (pattern[cur] == str[pos] || pattern[cur] == '.')) {
                return solve(str, pos + 1, pattern, cur + 2) ||
                        solve(str, pos + 1, pattern, cur) ||
                        solve(str, pos, pattern, cur + 2);
            }
            //匹配失败，只能走匹配0次
            else {
                return solve(str, pos, pattern, cur + 2);
            }
        }
        //下一个字符不是*的情况
        else {
            //匹配成功，走下一个字符
            if (pos < str.length && (pattern[cur] == str[pos] || pattern[cur] == '.')) {
                return solve(str, pos + 1, pattern, cur + 1);
            }
            //匹配失败，return false
            else {
                return false;
            }
        }
    }

}
