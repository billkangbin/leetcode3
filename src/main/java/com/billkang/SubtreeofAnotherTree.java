package com.billkang;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

/**
 * [leetcode]572. Subtree of Another Tree
 * Given two non-empty binary trees s and t, check whether tree t has exactly the same structure and node values with a subtree of s. A subtree of s is a tree consists of a node in s and all of this node's descendants. The tree s could also be considered as a subtree of itself.
	
	Example 1:
	Given tree s:
	
	     3
	    / \
	   4   5
	  / \
	 1   2
	Given tree t:
	   4 
	  / \
	 1   2
	Return true, because t has the same structure and node values with a subtree of s.
 * @author binkang
 * @date May 21, 2017
 */
public class SubtreeofAnotherTree {
	public boolean isSubtree(TreeNode s, TreeNode t) {
		StringBuilder sbd1 = new StringBuilder();
		StringBuilder sbd2 = new StringBuilder();

		preOrder(sbd1, s);
		preOrder(sbd2, t);
		return sbd1.toString().contains(sbd2);
	}

	private void preOrder(StringBuilder sbd, TreeNode t) {
		if(t == null) {
			sbd.append(",,");
			return;
		}
		
		sbd.append(",").append(t.val);
		preOrder(sbd, t.left);
		preOrder(sbd, t.right);
	}
}
