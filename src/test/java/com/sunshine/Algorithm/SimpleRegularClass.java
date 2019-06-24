package com.sunshine.Algorithm;

import org.junit.Test;

public class SimpleRegularClass {

    @Test
    public void test() {
//        char[] str = {'a', 'a', 'a'};
//        char[] pattern = {'a', 'b', '*', 'a', 'c', '*', 'a', '.'};
        char[] str = {'a'};
        char[] pattern = {'.', '*'};
        boolean match = match(str, pattern);
        System.out.println(match);
    }

    public boolean match(char[] str, char[] pattern) {
        if (null == str || null == pattern) {
            return false;
        }
        int j = 0;
        int i = 0;
        while (i < str.length || j < pattern.length) {
            if (i < str.length) {
                if ('.' == pattern[j]) {
                    i++;
                    j++;
                } else if ('*' == pattern[j]) {
                    if (j - 1 >= 0 && ('.' == pattern[j - 1] || pattern[j - 1] == str[i])) {
                        i++;
                    } else {
                        j++;
                    }
                } else if (str[i] == pattern[j]) {
                    i++;
                    j++;
                } else {
                    return false;
                }
            }else{
                if (j + 1 < pattern.length && '*' == pattern[j + 1]) {
                    j += 2;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
