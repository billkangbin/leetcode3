package com.billkang;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**575. Distribute Candies
 * Given an integer array with even length, where different numbers in this array represent different kinds of candies. Each number means one candy of the corresponding kind. You need to distribute these candies equally in number to brother and sister. Return the maximum number of kinds of candies the sister could gain.

	Example 1:
	Input: candies = [1,1,2,2,3,3]
	Output: 3
	Explanation:
	There are three different kinds of candies (1, 2 and 3), and two candies for each kind.
	Optimal distribution: The sister has candies [1,2,3] and the brother has candies [1,2,3], too. 
	The sister has three different kinds of candies. 
	Example 2:
	Input: candies = [1,1,2,3]
	Output: 2
	Explanation: For example, the sister has candies [2,3] and the brother has candies [1,1]. 
	The sister has two different kinds of candies, the brother has only one kind of candies. 
	Note:
	
	The length of the given array is in range [2, 10,000], and will be even.
	The number in given array is in range [-100,000, 100,000].
 * @author binkang
 * @date May 20, 2017
 */
public class DistributeCandies {
	/**
	 * 需要额外的存储空间
	 * @param candies
	 * @return
	 */
	public int distributeCandies(int[] candies) {
		Set<Integer> s = new HashSet<Integer>();
		for(int i=0;i<candies.length;i++) {
			if(!s.contains(candies[i])) {
				s.add(candies[i]);
			}
		}
		return s.size()<(candies.length/2) ? s.size():(candies.length/2);
	}
	
	/**
	 * 不需要额外的存储空间
	 * @param candies
	 * @return
	 */
	public int distributeCandies2(int[] candies) {
		Arrays.sort(candies);
		int res = 0;
		for(int i=0;i<candies.length;i++) {
			if(i==0 || candies[i]!=candies[i-1]) {
				res++;
			}
		}
		return Math.min(res, candies.length/2);
	}
}
