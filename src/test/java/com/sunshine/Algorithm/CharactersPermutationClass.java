package com.sunshine.Algorithm;

import org.junit.Test;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;

public class CharactersPermutationClass {
    /****
     * 这是典型的递归求解问题，递归算法有四个特性：
     * 必须有可达到的终止条件，否则程序陷入死循环
     * 子问题在规模上比原问题小
     * 子问题可通过再次递归调用求解
     * 子问题的解应能组合成整个问题的解
     */

    @Test
    public void test() {
        String str = "abc";
        String str2 = "alibaba";
        Permutation(str2);
        System.out.println(ansNum);
        for (String an : ans) {
            System.out.println(an);
        }
    }
    //优解

    private char[] chars;
    private int len;
    private int ansNum = 0;
    private ArrayList<String> ans = new ArrayList<>();

    public ArrayList<String> Permutation(String str) {
        chars = str.toCharArray();
        len = str.length();
        solve(0);
        Collections.sort(ans);
        return ans;
    }

    private void solve(int pos) {
        if (pos + 1 == len) {
            ans.add(new String(chars));
            ansNum++;
            return;
        } else {
            for (int i = pos; i < len; i++) {
                if (!isNeed(pos, i)) {
                    continue;
                }
                swap(pos, i);
                solve(pos + 1);
                swap(pos, i);
            }
        }
    }

    private boolean isNeed(int pos, int end) {
        for (int i = pos; i < end; i++) {
            if (chars[i] == chars[end]) {
                return false;
            }
        }
        return true;
    }

    private void swap(int x, int y) {
        char aChar = chars[x];
        chars[x] = chars[y];
        chars[y] = aChar;
    }
}
