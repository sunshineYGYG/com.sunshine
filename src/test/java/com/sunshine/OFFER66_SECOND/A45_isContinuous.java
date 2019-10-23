package com.sunshine.OFFER66_SECOND;

import org.junit.Test;

import java.util.Arrays;

public class A45_isContinuous {

    @Test
    public void test() {
        int[] arr = {1, 0, 0, 0, 6};
        boolean continuous = isContinuous(arr);
        System.out.println(continuous);
    }

    public boolean isContinuous(int[] numbers) {
        if (numbers.length < 5) {
            return false;
        }
        Arrays.sort(numbers);
        int min = -1;
        int max = -1;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 0) {
                continue;
            }
            if (i - 1 >= 0 && numbers[i] != 0 && numbers[i] == numbers[i - 1]) {
                return false;
            }
            if (min == -1) {
                min = numbers[i];
            } else if (max == -1 || numbers[i] > max) {
                max = numbers[i];
            }
        }
        if (max == -1 || max - min <= 4) {
            return true;
        }
        return false;
    }
}
