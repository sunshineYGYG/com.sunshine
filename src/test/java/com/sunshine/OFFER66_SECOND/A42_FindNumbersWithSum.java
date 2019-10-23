package com.sunshine.OFFER66_SECOND;

import org.junit.Test;

import java.util.ArrayList;

public class A42_FindNumbersWithSum {

    @Test
    public void test() {
        int[] arr = {1, 2, 3, 4};
        ArrayList<Integer> arrayList = FindNumbersWithSum(arr, 5);
        arrayList.forEach(a -> System.out.print(a + " "));
        ArrayList<Integer> arrayList1 = FindNumbersWithSum2(arr, 5);
        arrayList1.forEach(a -> System.out.print(a + " "));
    }

    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        if (array.length < 2) {
            return new ArrayList<>();
        }
        ArrayList<Integer> ans = new ArrayList<>();
        int ans1 = 0;
        int ans2 = 0;
        for (int j = 0; j < array.length; j++) {
            for (int i = j + 1; i < array.length; i++) {
                if (array[i] + array[j] == sum) {
                    if (ans.isEmpty() || ans1 * ans2 > array[i] * array[j]) {
                        ans1 = array[j];
                        ans2 = array[i];
                        ans.add(ans1);
                        ans.add(ans2);
                    }
                } else if (array[i] + array[j] > sum) {
                    break;
                }
            }
        }
        return ans;
    }
    //其他人解。
    //两端夹逼，两数差越大积越小，所以找到的第一个和为sum的两数即为答案。
    //此时我产生了一个疑问，left右移数值增大，right左移数值减小，同时left左移也是减小，right右移也是增大啊，是怎么排除的？
    //后来终于想通了。
    //举例：
    // a,b,c,d,e,f
    // b+e>sum   ->    b+d>sum  那么,b与d及其右边的数所有和都大于sum,疑问来了：left左移和right左移都会使和减小，为什么只需判断right左移的情况呢？
    // b+e>sum   ->    b+d<sum  那么,b一定不是答案之一,右移
    //疑问：a<b,b+d>sum,那么a+d呢？是不是遗漏了？
    //解：a+d<sum,因为a->b的原因是 a+(大于d的一个数)<sum 导致left右移。
    public ArrayList<Integer> FindNumbersWithSum2(int[] array, int sum) {
        if (array.length < 2) {
            return new ArrayList<>();
        }
        int left = 0;
        int right = array.length - 1;
        ArrayList<Integer> ans = new ArrayList<>();
        while (left < right) {
            if (array[left] + array[right] == sum) {
                ans.add(array[left]);
                ans.add(array[right]);
                break;
            }else if(array[left] + array[right] > sum){
                right--;
            }else{
                left++;
            }
        }
        return ans;
    }
}
