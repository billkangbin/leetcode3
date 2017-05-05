package com.billkang;

/**
 * @author binkang
 * @date May 5, 2017
 * 563. Binary Tree Tilt
 */
public class BinaryTreeTilt {

	// Definition for a binary tree node.
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	private int sum = 0;

	public int findTilt(TreeNode root) {
		helper(root);
		return sum;
	}

	private int helper(TreeNode root) {
		if (root == null)
			return 0;
		int left = helper(root.left);
		int right = helper(root.right);
		sum += Math.abs(left - right);
		return root.val + left + right;
	}
}
