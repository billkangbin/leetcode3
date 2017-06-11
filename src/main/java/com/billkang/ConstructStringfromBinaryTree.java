package com.billkang;

/**
 * @author binkang
 * @date Jun 4, 2017
 */
public class ConstructStringfromBinaryTree {

	public String tree2str(TreeNode2 t) {
		if (t == null) {
			return "";
		}
		StringBuilder sbl = new StringBuilder();
		sbl.append(t.val);
		if(t.left != null && t.right ==null) {
			sbl.append("(").append(tree2str(t.left)).append(")");
		} else if(t.right != null) {
			sbl.append("(").append(tree2str(t.left)).append(")")
			.append("(").append(tree2str(t.right)).append(")");
		}
		return sbl.toString();
	}

	public static void main(String[] args) {
		TreeNode2 t = new TreeNode2(1);
		TreeNode2 t2 = new TreeNode2(2);
		TreeNode2 t3 = new TreeNode2(3);
		TreeNode2 t4 = new TreeNode2(4);
		t.left = t2;
		t.right = t3;
		t.left.right = t4;
		
		String s = new ConstructStringfromBinaryTree().tree2str(t);
		System.out.println(s);
	}
}

class TreeNode2 {
	int val;
	TreeNode2 left;
	TreeNode2 right;

	TreeNode2(int x) {
		val = x;
	}
}
