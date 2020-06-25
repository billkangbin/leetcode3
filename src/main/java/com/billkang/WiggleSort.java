package com.billkang;


import java.util.Arrays;

public class WiggleSort {

    /**
     * 先排序再穿插
     * O(nlogn)+O(n)=O(nlogn)
     */
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums); //排序

        int len = nums.length;

        int[] smaller = new int[len % 2 == 0 ? len / 2 : (len / 2 + 1)];
        int[] bigger = new int[len / 2];

        System.arraycopy(nums, 0, smaller, 0, smaller.length);
        System.arraycopy(nums, smaller.length, bigger, 0, bigger.length);

        //穿插
        int i = 0;
        for (; i < nums.length; i++) {
            nums[2 * i] = smaller[smaller.length - 1 - i];
            nums[2 * i + 1] = bigger[bigger.length - 1 - i];
        }

        if (len % 2 != 0) {
            nums[2 * i] = smaller[smaller.length - 1 - i];
        }
    }

    /**
     * 解法2
     */
    public void wiggleSort2(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            max = Math.max(num, max);
        }
        int[] tmp = new int[max + 2];
        for (int num : nums) {
            tmp[num]++;
        }
        int a = 0, b = 1, i;
        for (i = tmp.length - 1; i > 0; i--) {
            while (tmp[i] > 0 && b < nums.length) {
                nums[b] = i;
                b += 2;
                tmp[i]--;
            }
            if (b >= nums.length) {
                break;
            }
        }

        while (i >= 0) {
            while (tmp[i] > 0 && a < nums.length) {
                nums[a] = i;
                a += 2;
                tmp[i]--;
            }
            if (a >= nums.length) {
                break;
            }
            if (tmp[i] > 0) {
                for (; tmp[i] > 0 && a < nums.length; tmp[i]--) {
                    nums[a] = i;
                    a += 2;
                }

            }
            i--;
        }
    }
}
