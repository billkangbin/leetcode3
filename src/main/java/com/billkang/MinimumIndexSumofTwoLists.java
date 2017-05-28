package com.billkang;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**599. Minimum Index Sum of Two Lists
 * Suppose Andy and Doris want to choose a restaurant for dinner, and they both have a list of favorite restaurants represented by strings.

You need to help them find out their common interest with the least list index sum. If there is a choice tie between answers, output all of them with no order requirement. You could assume there always exists an answer.

Example 1:
Input:
["Shogun", "Tapioca Express", "Burger King", "KFC"]
["Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"]
Output: ["Shogun"]
Explanation: The only restaurant they both like is "Shogun".
Example 2:
Input:
["Shogun", "Tapioca Express", "Burger King", "KFC"]
["KFC", "Shogun", "Burger King"]
Output: ["Shogun"]
Explanation: The restaurant they both like and have the least index sum is "Shogun" with index sum 1 (0+1).
 * @author binkang
 * @date May 28, 2017
 */
public class MinimumIndexSumofTwoLists {
	/**
	 * 思路：借用一个Map和Set, map的key为String, value为String在list1和list2中出现的索引。 Set中盛放最终结果，再把Set转化输出需要的String[]
	 * @param list1
	 * @param list2
	 * @return
	 */
	public String[] findRestaurant(String[] list1, String[] list2) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		for(int i=0;i<list1.length;i++) {
			map.put(list1[i], i);
		}
		
		Set<String> set = new HashSet<String>();
		int min = Integer.MAX_VALUE;
		for(int j=0;j<list2.length;j++) {
			if(map.get(list2[j])!=null) {
				int i = map.get(list2[j]);
				map.put(list2[j], i+j);
				if(i+j==min) {
					set.add(list2[j]);
				} else if(i+j<min) {
					set.clear();
					set.add(list2[j]);
					min = i+j;
				}
			}
		}
		
		String[] result = new String[set.size()];
		int i=0;
		for(String s : set) {
			result[i++] = s;
		}
		return result;
	}
}