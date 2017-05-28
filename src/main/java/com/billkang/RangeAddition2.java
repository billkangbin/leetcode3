package com.billkang;

/**[leetcode]598. Range Addition II
 * Given an m * n matrix M initialized with all 0's and several update operations.

Operations are represented by a 2D array, and each operation is represented by an array with two positive integers a and b, which means M[i][j] should be added by one for all 0 <= i < a and 0 <= j < b.

You need to count and return the number of maximum integers in the matrix after performing all the operations.

Example 1:
Input: 
m = 3, n = 3
operations = [[2,2],[3,3]]
Output: 4
Explanation: 
Initially, M = 
[[0, 0, 0],
 [0, 0, 0],
 [0, 0, 0]]

After performing [2,2], M = 
[[1, 1, 0],
 [1, 1, 0],
 [0, 0, 0]]

After performing [3,3], M = 
[[2, 2, 1],
 [2, 2, 1],
 [1, 1, 1]]

So the maximum integer in M is 2, and there are four of it in M. So return 4.
 * @author binkang
 * @date May 28, 2017
 */
public class RangeAddition2 {
	/**
	 * 思路：

	要求统计矩阵最大值的个数，可以发现，矩阵越靠近左上角的元素值越大，因为要加1的元素 行和列索引是从0开始的。
	那么只需要找到操作次数最多的元素位置即可。而操作次数最多的元素肯定是偏向于靠近矩阵左上角的。
	
	其实就是求a和b的最小值，然后框定的范围内的值一定都是最大的，个数就是n*m。
	 * @param m
	 * @param n
	 * @param ops
	 * @return
	 */
	public int maxCount(int m, int n, int[][] ops) {
		int len = ops.length;
		if(len<1) {
			return m*n;
		}
		
		int min_a = Integer.MAX_VALUE;
		int min_b = Integer.MAX_VALUE;
		for(int i=0;i<len;i++) {
			int a = ops[i][0];
			int b = ops[i][1];
			min_a = Math.min(a, min_a);
			min_b = Math.min(b, min_b);
		}
		return min_a * min_b;
	}
}