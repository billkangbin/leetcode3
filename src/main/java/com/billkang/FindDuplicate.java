package com.billkang;

/**
 * 寻找重复数
 * <p>
 * 给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,3,4,2,2]
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: [3,1,3,4,2]
 * 输出: 3
 * 说明：
 * <p>
 * 不能更改原数组（假设数组是只读的）。
 * 只能使用额外的 O(1) 的空间。
 * 时间复杂度小于 O(n2) 。
 * 数组中只有一个重复的数字，但它可能不止重复出现一次。
 */
public class FindDuplicate {
    public int findDuplicate(int[] nums) {
        int start = 1;
        int end = nums.length;
        while (start <= end) {
            //            取中值
            int middle = start + ((end - start) >> 1);
            //            计算从开始值到中值区间内有多少数字。
            int tempCount = countRange(nums, start, middle);
            //            如果已经区间已经缩小的到了只有一个数了，那么就可以判断在区间内的数字是不是有两个了。
            if (start == end) {
                if (tempCount > 1) {
                    return start;
                } else {
                    break;
                }
            }

            //            区间就是 中值- 开始值 + 1。然后开始和计数比较。
            int range = middle - start + 1;
            if (tempCount > range) {
                end = middle;
            } else if (tempCount <= range) {
                start = middle + 1;
            }
        }
        return -1;
    }

    //    计数比较，时间复杂度为O(n)
    private int countRange(int[] nums, int start, int end) {
        int count = 0;
        for (int item : nums) {
            if (item >= start && item <= end) {
                count++;
            }
        }
        return count;
    }
}
