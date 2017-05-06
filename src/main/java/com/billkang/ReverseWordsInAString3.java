package com.billkang;

/**
 * @author binkang
 * @date May 6, 2017
 * 557. Reverse Words in a String III
 */
public class ReverseWordsInAString3 {
	/**
	 * Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.

	Example 1:
	Input: "Let's take LeetCode contest"
	Output: "s'teL ekat edoCteeL tsetnoc"
	Note: In the string, each word is separated by single space and there will not be any extra space in the string.
	 * @param s
	 * @return
	 */
	public String reverseWords(String s) {
		String[] ss = s.split(" ");
		String result = "";
		for(int i=0;i<ss.length-1;i++) {
			result += reverse(ss[i]) + " ";
		}
		return result+=reverse(ss[ss.length-1]);
	}
	
	private String reverse(String temp) {
		String rev = "";
		for(int j = temp.length()-1;j>=0;j--) {
			rev +=temp.charAt(j);
		}
		return rev;
	}
}
