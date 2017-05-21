package com.billkang;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * [leetcode]594. Longest Harmonious Subsequence
 * We define a harmonious array is an array where the difference between its maximum value and its minimum value is exactly 1.

	Now, given an integer array, you need to find the length of its longest harmonious subsequence among all its possible subsequences.
	
	Example 1:
	Input: [1,3,2,2,5,2,3,7]
	Output: 5
	Explanation: The longest harmonious subsequence is [3,2,2,2,3].
	思路：定义一个map，记录数组中数字出现的次数，连续两个数字出现次数的和即为harmonious subsequence。在求最大的harmonious subsequence.
 * @author binkang
 * @date May 21, 2017
 */
public class LongestHarmoniousSubsequence {

	public int findLHS(int[] nums) {
		if(nums.length<1) return 0;
		Arrays.sort(nums);
		Map<Integer, Integer> map = new LinkedHashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (map.get(nums[i]) == null) {
				map.put(nums[i], 1);
			} else {
				int temp = map.get(nums[i]);
				map.put(nums[i], temp + 1);
			}
		}
		
		
		int beforeKey = 0;
		int beforeValue = 0;
		int result = 0;
		for(Map.Entry<Integer, Integer> entry:map.entrySet()) {
			if(beforeValue == 0) {
				beforeKey = entry.getKey();
				beforeValue = entry.getValue();
			} else {
				if(entry.getKey()-beforeKey == 1) {
					result = Math.max(beforeValue+entry.getValue(), result);
				}
				beforeKey = entry.getKey();
				beforeValue = entry.getValue();
			}
		}
		return result;
		
	}
}
