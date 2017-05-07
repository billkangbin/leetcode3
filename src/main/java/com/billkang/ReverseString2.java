package com.billkang;

/**
 * @author binkang
 * @date May 7, 2017
 * 541. Reverse String II
 */
public class ReverseString2 {
	/**
	 * Given a string and an integer k, you need to reverse the first k characters for every 2k characters counting from the start of the string. If there are less than k characters left, reverse all of them. If there are less than 2k but greater than or equal to k characters, then reverse the first k characters and left the other as original.
	Example:
	Input: s = "abcdefg", k = 2
	Output: "bacdfeg"
	Restrictions:
	The string consists of lower English letters only.
	Length of the given string and k will in the range [1, 10000]
	 * @param s
	 * @param k
	 * @return
	 */
	public String reverseStr(String s, int k) {
		StringBuilder sb = new StringBuilder();  
        int start = 0;  
        while(start <= s.length()){  
            int i = 0,j = 0;  
            if(s.length() - start <= k){  
                i = s.length() - 1;  
                j = s.length();  
            }else{  
                i = start + k - 1;  
                j = start + k;  
            }  
            for( ;i >= start; i--) sb.append(s.charAt(i));  
            for(; j < s.length() && j < start + 2*k; j ++)sb.append(s.charAt(j));  
            start += 2*k;  
        }  
          
        return sb.toString();  
	}
}
