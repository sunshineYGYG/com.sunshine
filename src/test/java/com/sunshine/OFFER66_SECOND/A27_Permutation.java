package com.sunshine.OFFER66_SECOND;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class A27_Permutation {

    @Test
    public void test() {
        Permutation("abcd");
    }


    Set<String> anss = new HashSet<>();

    public ArrayList<String> Permutation(String str) {
        if("".equals(str)){
            return new ArrayList<>();
        }
        solve(str.toCharArray(), 0);
        ArrayList<String> arrayList = new ArrayList<>(anss);
        System.out.println(arrayList.size());
        arrayList.sort(String::compareTo);
        arrayList.forEach(a -> System.out.println(a));
        return arrayList;
    }
    //需要自己交换自己
    public void solve(char[] str, int pos) {
        anss.add(new String(str));
        for (int i = pos; i < str.length; i++) {
            swap(str, pos, i);
            solve(str, pos + 1);
            swap(str, pos, i);
        }

    }

    private void swap(char[] arr, int i, int j) {
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
