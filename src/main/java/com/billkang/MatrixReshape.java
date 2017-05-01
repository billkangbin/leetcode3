package com.billkang;

/**
 * @author binkang
 * @date May 1, 2017
 */
public class MatrixReshape {
	
	/**
	 * 566. Reshape the Matrix
	 * n MATLAB, there is a very useful function called 'reshape', 
	 * which can reshape a matrix into a new one with different size 
	 * but keep its original data.
	 * You're given a matrix represented by a two-dimensional array, 
	 * and two positive integers r and c representing the row number 
	 * and column number of the wanted reshaped matrix, respectively.
	 * The reshaped matrix need to be filled with all the elements of the 
	 * original matrix in the same row-traversing order as they were.
	 * If the 'reshape' operation with given parameters is possible and legal,
	 * output the new reshaped matrix; Otherwise, output the original matrix.
	 */
	public int[][] matrixReshape(int[][] nums, int r, int c) {
		int original_r = nums.length;
		int original_c = nums[0].length;
		if (original_r * original_c == r * c) {
			int[][] result = new int[r][c];
			for (int i = 0; i < r * c; i++) {
				result[i / c][i % c] = nums[i / original_c][i % original_c];
			}
			return result;
		} else {
			return nums;
		}
	}
}
