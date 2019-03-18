package com.sunshine.shine.Test;

import org.junit.Test;

import java.util.LinkedList;

public class DataSourceKeyHolderTest {

    private static final ThreadLocal<LinkedList<String>> holder = new ThreadLocal<LinkedList<String>>() {
        protected LinkedList<String> initialValue() {
            return new LinkedList();
        }
    };

    public DataSourceKeyHolderTest() {
    }

    public static void set(String key) {
        ((LinkedList) holder.get()).push(key);
    }

    public static void clear() {
        ((LinkedList) holder.get()).pop();
    }

    public static void clearAll() {
        ((LinkedList) holder.get()).clear();
    }

    public static String getCurrentKey() {
        return ((LinkedList) holder.get()).size() == 0 ? null : (String) ((LinkedList) holder.get()).getFirst();
    }

    public static boolean isNestedCall() {
        return ((LinkedList) holder.get()).size() > 1;
    }
    
    @Test
    public void test1(){
        LinkedList<String> strings = holder.get();
        System.out.println("--"+strings);
    }

}
