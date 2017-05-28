package com.billkang;

/**565. Array Nesting
 * A zero-indexed array A consisting of N different integers is given. The array contains all integers in the range [0, N - 1].

Sets S[K] for 0 <= K < N are defined as follows:

S[K] = { A[K], A[A[K]], A[A[A[K]]], ... }.

Sets S[K] are finite for each K and should NOT contain duplicates.

Write a function that given an array A consisting of N integers, return the size of the largest set S[K] for this array.

Example 1:
Input: A = [5,4,0,3,1,6,2]
Output: 4
Explanation: 
A[0] = 5, A[1] = 4, A[2] = 0, A[3] = 3, A[4] = 1, A[5] = 6, A[6] = 2.

One of the longest S[K]:
S[0] = {A[0], A[5], A[6], A[2]} = {5, 6, 2, 0}
Note:
N is an integer within the range [1, 20,000].
The elements of A are all distinct.
Each element of array A is an integer within the range [0, N-1].
 * @author binkang
 * @date May 28, 2017
 */
public class ArrayNesting {
	/**
	 * 思路：要求s[k]最多的元素个数， 利用一个boolean[]数组，判断每次循环s[k]的长度
	 * @param nums
	 * @return
	 */
	public int arrayNesting(int[] nums) {
		int len = nums.length;
		if(len == 1) {
			return 1;
		}
		
		boolean[] mark = new boolean[len];
		//init mark
//		for(int i=0;i<len;i++) {
//			mark[i] = false;
//		}
		
		int longest = 0;
		for(int i=0;i<len;i++) {
			int k=i;
			int count = 0;
			while(!mark[k]) {
				count++;
				mark[i] = !mark[k];
				k = nums[k];
			}
			longest = Math.max(longest, count);
		}
		return longest;
	}
}
