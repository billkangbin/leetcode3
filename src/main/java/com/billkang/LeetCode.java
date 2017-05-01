package  com.billkang;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Queue;

public class LeetCode {
	
	/**
	 * 476. Number Complement
	 * @param num
	 * @return
	 */
//	public int findComplement(int num) {
//        
//    }
	
	public int hammingDistance(int x, int y) {
		int count = 0;
		int res = x^y;
		while(res>0) {
			if((res&1)!=0) {
				count++;
			}
			res>>=1;
		}
		return count;
    }
	
	// 50. Pow(x, n)
	public double myPow(double x, int n) {
//		if(n==0) {
//			return 1;
//		} 
//		if(n<0) {
//			return 1.0/myPow(x,-n);
//		}
//		return x*myPow(x,n-1);  //stackOverflow

		if (n == 0) {
			return 1.0;
		} else if(n>0) {
			double half = (double)myPow(x,n/2);
			if(n%2==0) {
				return half*half;
			} else {
				return half * half *x;
			}
		} else {
			if(n == Integer.MIN_VALUE) {
				double half = (double)myPow(x, n/2);
				return half*half;
			}
			
			n = -n;
			double half = (double)myPow(x, n/2);
			if(n%2==0) {
				return 1.0/(half*half);
			} else {
				return 1.0/(half*half*x);
			}
		}

	}
	
public boolean detectCapitalUse(String word) {
	if(word == null || word.length()==0) {
    	return false;
    } else if(word.length()==1) {
    	return true;
    }
    
    boolean isFirst = Character.isUpperCase(word.charAt(0));
    boolean isSecond = Character.isUpperCase(word.charAt(1));
    if(!isFirst && isSecond) {
    	return false;
    }
    boolean isAll = true;
    for(int i=1;i<word.length();i++) {
    	char c = word.charAt(i);
    	if(isSecond && Character.isUpperCase(c)) {
    		
    	} else if(!isSecond && !Character.isUpperCase(c)) {
    		
    	} else {
    		isAll = false;
    		break;
    	}
    }
    return isAll;
    }
	
	public String convertToBase7(int num) {
	       return Long.toString(Long.valueOf(num),7);
	    }
	 
	
	public String test(int num) {
		return Long.toString(Long.valueOf(num),7);
	}
	
	public int reversePairs(int[] nums) {
		nums = new int[]{2147483647,2147483647,2147483647,2147483647,2147483647,2147483647};
		int count = 0;
//		int minI = Integer.MAX_VALUE;
//		int minJ = Integer.MIN_VALUE;
		for(int i=0;i<nums.length-1;i++) {
			int minJ = Integer.MIN_VALUE;
			for(int j=i+1;j<nums.length;j++) {
				long b = (long)2*(long)nums[j];
				if((long)nums[i]>b) {
					count++;
				}
			}
		}
		return count;
	}
	
	/**
	 * 442. Find All Duplicates in an Array
	 * @param nums
	 * @return
	 */
	public List<Integer> findDuplicates(int[] nums) {
        int[]  aa = new int[nums.length];
        List<Integer> result = new ArrayList<Integer>();
        for(int i=0;i<nums.length;i++) {
        	if(aa[nums[i]]!=0) {
        		result.add(nums[i]);
        	} else {
        		aa[nums[i]] = 1;
        	}
        }
        return result;
    }
	
	/**14. Longest Common Prefix
	 * 
	 * @param strs
	 * @return
	 */
	public String longestCommonPrefix(String[] strs) {
		if(strs == null) {
			return null;
		} else if(strs.length==0) {
			return "";
		} else if(strs.length==1) {
			return strs[0];
		}
		
		int minLength = getMinLength(strs);
		int num = 0;
		char tmp;
		boolean isOver = false;
		while(num<minLength) {
			tmp = strs[0].charAt(num);
			for(int i=1;i<strs.length;i++) {
				if(strs[i].charAt(num)!=tmp) {
					isOver = true;
					break;
				}
			}
			if(isOver) {
				break;
			}
			num++;
		}
		return strs[0].substring(0,num);
	}
	
	private int getMinLength(String[] strs) {
		int len = strs[0].length();
		for(int i=1;i<strs.length;i++) {
			if(len>strs[i].length()) {
				len = strs[i].length();
			}
		}
		return len;
	}

	/**
	 * 438. Find All Anagrams in a String
	 */
	public List<Integer> findAnagrams(String s, String p) {
		List<Integer> result = new ArrayList<Integer>();
		int left = 0; // 窗口左指针
		int right = 0; //窗口右指针
		int numDeference = p.length(); //差异度
		
		int[] asciiChars = new int[256]; //记录P中字符有哪些及其数量的数组
		for(int i=0;i<p.length();i++) {
			asciiChars[p.charAt(i)]++;
		}
		
		for(;right<s.length();right++) { //滑动右窗口
			asciiChars[s.charAt(right)]--; //在该字符相应位置减一
			if(asciiChars[s.charAt(right)]>=0) { //如果加进来的那个在p中，NumberOfDeference减一
				numDeference--;
			}
			
			if(right-left ==p.length()-1) { //如果这时窗口大小为p.length()
				if(numDeference == 0) { //这时出现一次匹配，将左窗口加到result中
					result.add(left);
				}
				
				//滑动左窗口指针
				if(asciiChars[s.charAt(left)]>=0) {
					numDeference++; //如果被踢出的那个在p中，NumberOfDeference加一
				}
				asciiChars[s.charAt(left)]++; //数组中相应字符计数位置加回来，因为在一开始有asciiChars[s.charAt(right)]--;
				left++; //左窗口向右滑动
			}
		}
		
		return result;
	}
	
	/**
	 * 437. Path Sum III
	 */
	public int pathSum(TreeNode root, int sum) {
		if(root == null) {
			return 0;
		}
		return dfs(root, sum) +dfs(root.left, sum) + dfs(root.right, sum);
	}
	
	private int dfs(TreeNode root, int sum) {
		int res = 0;
		if(root == null) {
			return res;
		}
		
		if(root.val == sum) {
			res++;
		}
		res+=dfs(root.left, sum-root.val);
		res+=dfs(root.right, sum-root.val);
		return res;
	}
	
//	 public int pathSum(TreeNode root, int sum) {
//	        if(root == null)
//	            return 0;
//	        return dfs(root, sum)+pathSum(root.left, sum)+pathSum(root.right, sum);
//	    }
//
//	    private int dfs(TreeNode root, int sum){
//	        int res = 0;
//	        if(root == null)
//	            return res;
//	        if(sum == root.val)
//	            res++;
//	        res+=dfs(root.left,sum - root.val);
//	        res+=dfs(root.right,sum - root.val);
//	        return res;
//	    }

	/**
	 * 400. Nth Digit
	 */
	public int findNthDigit(int n) {
		//1. 找出n落在第几位范围内
		//2. 找出具体落在的数字上
		//3. 找出在这个数字的哪一位上
		int digit = 1;
		int ith = 1;
		int base = 9;
		
		while(n>base*digit) {
			n-=base*digit;
			digit++;
			ith += base;
			base*=10;
		}
		
		int num = ith+(n-1)/digit;
		char c = String.valueOf(num).charAt((n-1)%digit);
		return Integer.valueOf(""+c);
	}
	
	/**
	 * 278. First Bad Version
	 */
	public int firstBadVersion(int n) {
        int low = 1;
        int high = n;
        int ver = 0;
        while(low < high) {
        	ver = low+(high-low)/2;
        	
        	
        }
        return 0;
    }
	
	/**
	 * 303. Range Sum Query - Immutable
	 */
	class NumArray2 {

	    private int[] sums; 
	    
	    public NumArray2(int[] nums) {
			if (nums == null) {
				sums = null;
			} else if (nums.length == 0) {
				sums = new int[] { 0 };
			} else {
				sums = new int[nums.length];
				sums[0] = nums[0];
				for (int i = 1; i < nums.length; i++) {
					sums[i] = sums[i - 1] + nums[i];
				}
			}
	    }

		public int sumRange(int i, int j) {
			if (sums == null) {
				return 0;
			}
			if (i >= sums.length || j >= sums.length || i > j) {
				return 0;
			} else if (i == 0) {
				return sums[j];
			} else {
				return sums[j] - sums[i - 1];
			}
		}
	}
	
	/**
	 * 303. Range Sum Query - Immutable
	 */
	class NumArray {

	    private int[] nums; 
	    
	    public NumArray(int[] nums) {
	        this.nums = nums;
	    }

	    public int sumRange(int i, int j) {
	        int sum = 0;
	        for(int k=i;k<=j;k++) {
	            sum+=nums[k];
	        }
	        return sum;
	    }
	}
	
	/**
	 * 189. Rotate Array 
	 */
	public void rotate(int[] nums, int k) {
		if(nums==null) {
			return;
		}
		int n = nums.length;
		k = k%n;
		if(n<=1) {
			return;
		}
		
		int[] temp = new int[k];
		System.arraycopy(nums, n-k, temp, 0, k); //把后k个元素存到temp中
		System.arraycopy(nums, 0, nums, k, n-k); //把nums里的前n-k个元素挪到后面
		System.arraycopy(temp, 0, nums, 0, k); //把temp中的k个元素放加nums
	}
	
	/**
	 * 414. Third Maximum Number
	 */
	public int thirdMax(int[] nums) {
		// 分别代表当前第3大，第2大的，第3大,他会使用int的边界值，所以直接用long就好
        long tmp[] = {Long.MIN_VALUE,Long.MIN_VALUE,Long.MIN_VALUE};
        int i=0;
        int n=nums.length;
        //分三种情况来看
        for(int num:nums){
            if(num< tmp[1] && num>tmp[0]){
                tmp[0]=num;
            } 
            else if (num < tmp[2] && num > tmp[1]){
                tmp[0] = tmp[1];
                tmp[1] = num;
            } 
            else if (num > tmp[2]){
                tmp[0] = tmp[1];
                tmp[1] = tmp[2];
                tmp[2] = num;
            }
        }
        if(tmp[0] == Long.MIN_VALUE){
            return (int)tmp[2];
        }
        return (int)tmp[0];
	}
	
	class MyStack {
	    private Queue<Integer> queue1 = new LinkedList<Integer>();
	    private Queue<Integer> queue2 = new LinkedList<Integer>();
	    public void push(int x) {
	        queue1.offer(x);
	    }

	    // Removes the element on top of the stack.
	    public void pop() {
	        while(queue1.size()>1) {
	        	queue2.offer(queue1.poll());
	        	queue1.poll();
	        	
	        	Queue<Integer> temp = queue2;
	        	queue2 = queue1;
	        	queue1 = temp;
	        }
	    }

	    // Get the top element.
	    public int top() {
	    	while(queue1.size()>1) {
	    		queue2.offer(queue1.poll());
	    	}
	    	int x = queue1.poll();
	    	queue2.offer(x);
	    	Queue<Integer> temp = queue2;
	    	queue2 = queue1;
	    	queue1 = temp;
	        return x;
	    }

	    // Return whether the stack is empty.
	    public boolean empty() {
	        return queue1.isEmpty();
	    }
	}
	
	class Stack2<T> {
	    private List<T> list1 = new ArrayList<T>();
	    public void push(T obj) {
	        list1.add(obj);
	    }

	    // Removes the element on top of the stack.
	    public T pop() {
	    	T t = null;
	    	if(list1.size()>0) {
	    		t = list1.get(list1.size()-1);
	    		list1.remove(list1.size()-1);
	    	}
	        return t;
	    }
	    
	    public int size() {
	    	return list1.size();
	    }

	}
	
	/**
	 * 475. Heaters
	 */
	public int findRadius(int[] houses, int[] heaters) {
		Arrays.sort(heaters);
		
		int result = 0;
		for(int house:houses) {
			int index = Arrays.binarySearch(heaters, house);
			if(index<0) { //index<0,则说明在headers中没有该house,返回 (-(插入点) - 1),第一个大于此键的元素索引  
				index = ~index;
				int dist1 = index - 1 >= 0 ? house - heaters[index - 1] : Integer.MAX_VALUE;
	            int dist2 = index < heaters.length ? heaters[index] - house : Integer.MAX_VALUE;

	            result = Math.max(result, Math.min(dist1, dist2));
			}
			//index>=0,则说明在headers中找到了该house, 则说明取暖器位置和house位置重合，该house的最小半径为0,result还是result
		}
		return result;
	}
	
	/**
	 * 102. Binary Tree Level Order Traversal
	 */
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		if(root==null) {
			return list;
		}
		
		queue.offer(root);
		while(!queue.isEmpty()) {
			List<Integer> levelList = new ArrayList<Integer>();
			int num = queue.size();
			for(int i=0;i<num;i++) {
				if(queue.peek().left!=null) {
					queue.add(queue.peek().left);
				}
				if(queue.peek().right!=null) {
					queue.add(queue.peek().right);
				}
				levelList.add(queue.poll().val);
			}
			list.add(levelList);
		}
		return list;
	}
	
	/**
	 * 107 Binary Tree Level Order Traversal II
	 * @param root
	 * @return
	 */
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
        List<List<Integer>> list = new LinkedList<List<Integer>>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        if(root == null)
            return list;
        queue.offer(root);
        while(!queue.isEmpty()){
            int num = queue.size();
            List<Integer> levelList = new LinkedList<Integer>();
            for(int i = 0; i < num; i++){
                if(queue.peek().left != null)
                    queue.offer(queue.peek().left);
                if(queue.peek().right != null)
                    queue.offer(queue.peek().right);
                levelList.add(queue.poll().val);
            }
            list.add(0, levelList);
        }
        return list;
    }
	
	/**
	 * 434. Number of Segments in a String
	 * @param s
	 * @return
	 */
	public int countSegments(String s) {
		if(s==null || s.length()==0) {
			return 0;
		}
		
		int count = 0;
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i)!=' ') {
				if(i==0) {
					count++;
				} else if(s.charAt(i-1)==' '){
					count++;
				}
			}
		}
		return count;
	}
	
	public char findTheDifference(String s, String t) {
		char tmp = 0x00;
		for(int i=0;i<s.length();i++) {
			tmp = (char)(tmp ^ s.charAt(i));
		}
		
		for(int i=0;i<t.length();i++) {
			tmp = (char)(tmp ^ t.charAt(i));
		}
		return tmp;
    }
	
	/** 415 add String
	 * Given two non-negative numbers num1 and num2 represented as string, return the sum of num1 and num2.

		Note:
		
		The length of both num1 and num2 is < 5100.
		Both num1 and num2 contains only digits 0-9.
		Both num1 and num2 does not contain any leading zero.
		You must not use any built-in BigInteger library or convert the inputs to integer directly.
	 */
	public String addStrings(String num1, String num2) {
		StringBuffer sf = new StringBuffer();
		int len1 = num1.length();
		int len2 = num2.length();
		
		int carry = 0;
		for(int i=0;i<len1 || i<len2; i++) {
			int i1 = i<len1 ? num1.charAt(len1-1-i) - 48 : 0; //great than i situation
			int i2 = i<len2 ? num2.charAt(len2-1-i) - 48 : 0;
			int ans = i1 + i2 + carry;
			sf.append(ans%10);
			carry = ans /10;
		}
		if(carry > 0) {
			sf.append("1");
		}
        return sf.reverse().toString(); //remember reverse
    }
	
	/**
	 * 55. Jump Game  
		Given an array of non-negative integers, you are initially positioned at the first index of the array.
		
		Each element in the array represents your maximum jump length at that position.
		
		Determine if you are able to reach the last index.
		
		For example:
		A = [2,3,1,1,4], return true.
		
		A = [3,2,1,0,4], return false.
	 */
	// TODO can't understand
	public boolean canJump(int[] nums) {
		if(nums == null || nums.length <1) {
			return false;
		}
		
		int maxJump = -1;
		for(int i=0;i<nums.length;i++) {
			if(nums[i] > maxJump) {
				maxJump = nums[i];
			}
			
			if(maxJump >= nums.length - i-1) {
				return true;
			}
			
			if(maxJump == 0) {
				return false;
			}
			
			maxJump--;
		}
		return false;
	}
	
	/**
	 * 119. Pascal's Triangle II
		Given an index k, return the kth row of the Pascal's triangle.
		
		For example, given k = 3,
		Return [1,3,3,1].
	 * @param rowIndex
	 * @return
	 */
	public List<Integer> getRow(int rowIndex) {
		List<Integer> result = new ArrayList<Integer>(rowIndex + 1);
		result.add(1);
		if(rowIndex == 0) {
			return result;
		}
		
		result.add(1);
		if(rowIndex == 1) {
			return result;
		}
		
		for(int i = 2;i<= rowIndex; i++) {
			result.add(1);
			for(int j= i-1;j>0;j--){
				result.set(j, result.get(j)+result.get(j-1));
			}
		}
		return result; //TODO
	}
	
	public List<String> fizzBuzz(int n) {
		List<String> result = new ArrayList<String>(n);
		for(int i = 1;i<=n;i++) {
			if(i%3==0 && i%5==0) {
				result.add("FizzBuzz");
			} else if(i%3 == 0) {
				result.add("Fizz");
			} else if(i%5 == 0) {
				result.add("Buzz");
			} else {
				result.add(""+i);
			}
		}
		return result;
	}
	
	
//	  Definition for a binary tree node.
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	
	/**
	 * 404. Sum of Left Leaves  
		Find the sum of all left leaves in a given binary tree.
		Example:
		
		    3
		   / \
		  9  20
		    /  \
		   15   7
		
		There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.
	 */
	public int sumOfLeftLeaves(TreeNode root) {
		int sum = 0;
		if(root == null) {
			return 0;
		}
		
		if(root.left!=null && root.left.left==null && root.left.right == null) {
			return root.left.val + sumOfLeftLeaves(root.right);
		} else {
			return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
		}
	}
	
	/**
	 * 63. Unique Paths II 
		Follow up for "Unique Paths":
		Now consider if some obstacles are added to the grids. How many unique paths would there be?
		An obstacle and empty space is marked as 1 and 0 respectively in the grid.
		For example,
		There is one obstacle in the middle of a 3x3 grid as illustrated below.
		[
		  [0,0,0],
		  [0,1,0],
		  [0,0,0]
		]
		The total number of unique paths is 2.
	 */
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		
		return 0;
	}
	
	/**
	 * 383. Ransom Note
	 * Given an arbitrary ransom note string and another string containing 
	 * letters from all the magazines, 
	 * write a function that will return true if the ransom note 
	 * can be constructed from the magazines ; 
	 * otherwise, it will return false.

		Each letter in the magazine string can only be used once in your ransom note.
		
		Note:
		You may assume that both strings contain only lowercase letters.
		
		canConstruct("a", "b") -> false
		canConstruct("aa", "ab") -> false
		canConstruct("aa", "aab") -> true
	 */
	public boolean canConstruct(String ransomNote, String magazine) {
		
		//method1,ergodic
//		boolean result = true;
//		byte[] bytes = new byte[magazine.length()];
//		
//		for(int i=0;i<ransomNote.length();i++) {
//			char ri = ransomNote.charAt(i);
//			
//			boolean found = false;
//			for(int j=0;j<magazine.length();j++) {
//				if(bytes[j]==0 && magazine.charAt(j)==ri) {
//					found = true;
//					bytes[j]++;
//					break;
//				}
//			}
//			
//			if(!found){
//				result = false;
//				break;
//			}
//		}
//		return result;
		
		//method2, sort compare
//		boolean result = true;
//		char[] ra = ransomNote.toCharArray();
//		Arrays.sort(ra);
//		
//		char[] ma = magazine.toCharArray();
//		Arrays.sort(ma);
//		
//		int index = 0;
//		for(int i=0;i<ra.length;i++) {
//			char ri = ra[i];
//			boolean found = false;
//			
//			for(int j=index;j<ma.length;j++) {
//				if(ma[j]>ri) {
//					found = false;
//					break;
//				} else if(ma[j] == ri) {
//					found = true;
//					index++;
//					break;
//				} else {
//					index++;
//				}
//			}
//			
//			if(!found) {
//				result = false;
//				break;
//			}
//		}
		
		//method3, record character appear times
		boolean result = true;
		int[] times = new int[26];
		for(int i=0;i<magazine.length();i++) {
			times[magazine.charAt(i) - 'a']++;
		}
		
		for(int i=0;i<ransomNote.length();i++) {
			if(--times[ransomNote.charAt(i) - 'a'] < 0) {
				result = false;
				break;
			}
		}
		
		return result;
	}
	
	/**
	 * 409. Longest Palindrome
	 * Given a string which consists of lowercase or uppercase letters, 
	 * find the length of the longest palindromes that can be built with those letters.
		This is case sensitive, for example "Aa" is not considered a palindrome here.
		
		Note:
		Assume the length of given string will not exceed 1,010.
		Example:
		Input:
		"abccccdd"
		Output:
		7
		Explanation:
		One longest palindrome that can be built is "dccaccd", whose length is 7.
	 */
	public int longestPalindrome(String s) {
		int[] times = new int['z'-'A'+1];
		for(int i=0;i<s.length();i++) {
			times[s.charAt(i)-'A']++;
		}
		
		int result = 0;
		boolean isFirst = true;
		for(int i=0;i<times.length;i++) {
			if(times[i] % 2 == 0) {
				result +=times[i];
			}else {
				if(isFirst) {
					result +=1;
					isFirst = false;
				}
				result +=times[i] -1;
			}
		}
		return result;
	}
	
	/**
	 * 387. First Unique Character in a String
	 * Given a string, find the first non-repeating character in it and 
	 * return it's index. If it doesn't exist, return -1.
		Examples:
		s = "leetcode"
		return 0.
		s = "loveleetcode",
		return 2.
	 */
	public int firstUniqChar(String s) {
		List<Character> list = new ArrayList<Character>();
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		
		for(int i=0;i<s.length();i++) {
			Character cc = s.charAt(i);
			if(map.containsKey(cc)) {
				list.remove(cc);   //cc要用Character类型，不能是char，否则remove会报错
			} else {
				list.add(cc);
				map.put(cc, i);
			}
		}
		return list.size()==0?-1:map.get(list.get(0));
	}
	
	/**
	 * 349. Intersection of Two Arrays
	 * Given two arrays, write a function to compute their intersection.
		Example:
		Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].
		Note:
		Each element in the result must be unique.
		The result can be in any order.
	 */
	public int[] intersection(int[] nums1, int[] nums2) {
		//method1
//		Set<Integer> aa = new HashSet<Integer>();
//		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
//		for(int i=0;i<nums1.length;i++) {
//			map.put(nums1[i], i+1);
//		}
//		
//		for(int i=0;i<nums2.length;i++) {
//			if(map.get(nums2[i])!=null && map.get(nums2[i])>0) {
//				aa.add(nums2[i]);
//				map.remove(nums2[i]);
//			}
//		}
//		
//		int[] result = new int[aa.size()];
//		int j=0;
//		Iterator<Integer> iter = aa.iterator();
//		while(iter.hasNext()) {
//			result[j++] = iter.next();
//		}
		
		//method2
//		Set<Integer> set = new HashSet<Integer>();
//		for(int i=0;i<nums1.length;i++) {
//			set.add(nums1[i]);
//		}
//		
//		List<Integer> resultList = new ArrayList<Integer>();
//		for(int i=0;i<nums2.length;i++) {
//			if(set.contains(nums2[i])) {
//				resultList.add(nums2[i]);
//				set.remove(nums2[i]);
//			}
//		}
//		
//		int[] result = new int[resultList.size()];
//		int j=0;
//		for(int a : resultList) {
//			result[j++] = a;
//		}
		
		//method3
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		
		int i = 0;
		int j = 0;
		int nums1Size = nums1.length;
		int nums2Size = nums2.length;
		
		List<Integer> resultList = new ArrayList<Integer>();
		while(i<nums1Size && j<nums2Size) {
			if(nums1[i] == nums2[j]) {
				if(resultList.size()==0 || nums1[i]!=resultList.get(resultList.size()-1)) {
					resultList.add(nums1[i]);
					i++;
					j++;
				}
			} else if(nums1[i] <nums2[j]) {
				i++;
			} else {
				j++;
			}
		}
		
		int[] result = new int[resultList.size()];
		int k=0;
		for(int a : resultList) {
			result[k++] = a;
		}
		return result;
	}
	
	/**350. Intersection of Two Arrays II
	 * Given two arrays, write a function to compute their intersection.
		Example:
		Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].
		Note:
		Each element in the result should appear as many times as it shows in both arrays.
		The result can be in any order.
	 */
	public int[] intersect(int[] nums1, int[] nums2) {
        int i = 0;
		int j = 0;
		int nums1Size = nums1.length;
		int nums2Size = nums2.length;
		
		List<Integer> resultList = new ArrayList<Integer>();
		while(i<nums1Size && j<nums2Size) {
			if(nums1[i] == nums2[j]) {
				resultList.add(nums1[i]);
				i++;
				j++;
			} else if(nums1[i] <nums2[j]) {
				i++;
			} else {
				j++;
			}
		}
		
		int[] result = new int[resultList.size()];
		int k=0;
		for(int a : resultList) {
			result[k++] = a;
		}
		return result;
    }
	
	
	/**
	 * 401. Binary Watch
	 * A binary watch has 4 LEDs on the top which represent the hours (0-11), 
	 * and the 6 LEDs on the bottom represent the minutes (0-59).
		Each LED represents a zero or one, with the least significant bit on the right.
		For example, the above binary watch reads "3:25".
		Given a non-negative integer n which represents the number of LEDs that are 
		currently on, return all possible times the watch could represent.
		Example:
		Input: n = 1
		Return: ["1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08", "0:16", "0:32"]
	 */
	public List<String> readBinaryWatch(int num) {
		//method1, bianli
//		List<String> times = new ArrayList<String>();
//	    for (int h = 0; h < 12; h++)
//	        for (int m = 0; m < 60; m++)
//	            if (Integer.bitCount(h * 64 + m) == num)
//	                times.add(String.format("%d:%02d", h, m));
//	    return times;
		
		/**
		 * 解法二：动态规划。有n个led等，其中亮了k个时，可以有f(n,k)种可能性。
		 * 如何计算f(n,k)呢？当n=k时，n个led灯，n个都亮，很好理解，就只有1中可能。
		 * 当n>k时，如果第一个灯亮，那么就需要剩下的n-1个灯里，有k-1个灯亮，也就是f(n-1,k-1)；
		 * 当第一个灯不亮，那么就是剩下的n-1个灯里，有k个灯亮。就这两种可能。因此，计算f(n,k)的公式为： 
			f(n,k) = 1　　　　　　　　　　　当n=k时 
			f(n,k) = f(n-1,k-1) + f(n-1,k)　　　当n>k时
		 */
		// 特殊处理，当没有led亮时
		int hourCnt = 4;
	    int minCnt = 6;
	    List<String> res = new ArrayList<String>();

	    // 小时和分钟能亮灯个数的所有可能性
	    for (int i = num > minCnt? (num - minCnt) : 0; i <= Math.min(hourCnt, num); i++) {
	        List<Integer> hourList = getCombination(hourCnt, i);
	        List<Integer> minList = getCombination(minCnt, num - i);
	        for (Integer hour : hourList) {
	            if (hour >= 12) {
	                continue;
	            }
	            for (Integer min : minList) {
	                if (min <= 59) {
	                    res.add(String.format("%d:%02d", hour, min));
	                }
	            }
	        }
	    }
	    return res;
	}
	
	private List<Integer> getCombination(int ledCnt, int num) {
	    // 特殊处理，当没有led亮时
	    if(num <= 0) {
	        List<Integer> l = new ArrayList<Integer>();
	        l.add(0);
	        return l;
	    }
	    // 相等时，不需要再迭代处理
	    if (ledCnt == num) {
	        List<Integer> l = new ArrayList<Integer>();
	        int data = 0;
	        for (int i = 0; i < num; i++) {
	            data += 1 << i;
	        }
	        l.add(data);
	        return l;
	    } else {
	        List<Integer> l = new ArrayList<Integer>();

	        if (num > 1) {
	            List<Integer> subList = getCombination(ledCnt - 1, num - 1);
	            Integer []a = new Integer[subList.size()];
	            subList.toArray(a);
	            int high = 1 << (ledCnt - 1);
	            for (int i = 0; i < a.length; i++) {
	                l.add(a[i] + high);
	            }
	        }else {
	            l.add(1 << (ledCnt - 1));
	        }

	        l.addAll(getCombination(ledCnt - 1, num));
	        return l;
	    }
	}
	
	public String toHex(int num) {
		
		return null;//FIXME
	}
	
	
	/**257. Binary Tree Paths
	 * Given a binary tree, return all root-to-leaf paths.
		For example, given the following binary tree:
		   1
		 /   \
		2     3
		 \
		  5
		All root-to-leaf paths are:
		["1->2->5", "1->3"]
	 */
	public List<String> binaryTreePaths(TreeNode root) {
		List<String> result = new ArrayList<String>();
		if(root == null) {
			return result;
		}
		
		StringBuilder sr = new StringBuilder();
		rec(root, result, sr);
		
		return result;
	}
	
	private void rec(TreeNode root, List<String> result, StringBuilder sr) {
		if(root.left == null && root.right == null) {
			sr.append(root.val);
			result.add(sr.toString());
			return;
		}
		
		sr.append(root.val);
		sr.append("->");
		int oriLen = sr.length();
		
		if(root.left != null) {
			rec(root.left, result, sr);
		}
		sr.setLength(oriLen); //设置stringBuilder的长度，很重要
		
		if(root.right !=null) {
			rec(root.right, result, sr);
		}
	}
	
	
	/**447. Number of Boomerangs
	 * 
	 */
	public int numberOfBoomerangs(int[][] points) {
		int result =0;
		for(int i=0;i<points.length;i++) {
			Map<Integer, Integer> map = new HashMap<Integer, Integer>();
			for(int j=0;j<points.length;j++) {
				if(i==j) {
					continue;
				} else {
					int distance = getDistance(points[i], points[j]);
					int aa = map.get(distance) ==null?0:map.get(distance);
					map.put(distance, map.get(distance)+1);
				}
			}
			
			for(Integer val:map.values()) {
				result +=val*(val-1);
			}
			
		}
		return result;
	}

	private int getDistance(int[] is, int[] is2) {
		int x = is[0] - is2[0];
		int y = is[1] - is2[1];
		return x*x + y*y;
	}
	
	/**
	 * 463. Island Perimeter
	 */
	 public int islandPerimeter(int[][] grid) {
		if (grid.length == 0) {
			return 0;
		}

		int count = 0;
		int repeat = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 0) {
					continue;
				}
				count++;
				if (i != 0 && grid[i - 1][j] == 1) {
					repeat++;
				}
				if (j != 0 && grid[i][j - 1] == 1) {
					repeat++;
				}
			}
		}
		return count * 4 - repeat * 2;
	 }
	 
	public List<List<String>> partition(String s) {

		return null;//TODO
	}

	/**
	 * 
	 * @param nums
	 * @return
	 */
	public int minMoves(int[] nums) {
		Arrays.sort(nums);
		int result =0;
		for(int i=1;i<nums.length;i++) {
			result +=nums[i] - nums[0];
		}
		return result;
	}
	
	/**
	 * 125. Valid Palindrome
	 */
	public boolean isPalindrome(String s) {
		int i = 0;
		int j= s.length()-1;
		while(i<j) {
			if(!Character.isLetterOrDigit(s.charAt(i))) {
				i++;
			} else if(!Character.isLetterOrDigit(s.charAt(j))) {
				j--;
			} else if(Character.toLowerCase(s.charAt(i))!=Character.toLowerCase(s.charAt(j))) {
				return false;
			} else {
				i++;
				j--;
			}
		}
		return true;
	}
	
	/**
	 * 455. Assign Cookies
	 */
	public int findContentChildren(int[] g, int[] s) {
		Arrays.sort(g);
		Arrays.sort(s);
		
		int result = 0;
		int i=0;
		int j=0;
		while(i<g.length && j<s.length) {
			if(s[j]>=g[i]) {
				result ++;
				j++;
				i++;
			} else {
				j++;
			}
		}
		return result;
	}

	/**
	 * 363. Max Sum of Rectangle No Larger Than K
	 */
	public int maxSumSubmatrix(int[][] matrix, int k) {
		int sum = 0;
		for(int i=1;i<matrix.length;i++) {
			for(int j=1;j<matrix[0].length;j++) {
				
			}
		}
		return sum;
	}
	
	/**
	 * 459. Repeated Substring Pattern
	 */
	public boolean repeatedSubstringPattern(String str) {
		for(int i=1;i<=str.length()/2;i++) {
			if(str.length()%i!=0) {
				continue;
			}
			
			if(ok(str,i)) {
				return true;
			}
		}
		return false;
	}

	private boolean ok(String str, int i) {
		String sub = str.substring(0,i);
		for(int j=0;j<str.length();j+=i) {
			if(!sub.equals(str.substring(j,j+i))) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) throws Exception{
//		new LeetCode()
		String a = "abcde";
		String b = getString(a);
		a = "ddddd";
		
		System.out.println(b);
		System.out.println(a);
	}
	
	public long getMaxSunHao(long h) {
		//x+x2<=h
		double res = Math.floor(Math.sqrt(1+4*h)-1/2);
		return Double.doubleToLongBits(res);
	}
	
	public static String getString(String a) {
		String result = null;
		result = a;
		return result;
	}
}

class ListHelper<E> {
	public List<E> list = Collections.synchronizedList(new ArrayList<E>());
	
	public  boolean putIfAbsent(E x) {
		synchronized(list) {
			boolean absent = !list.contains(x);
			if(absent) {
				list.add(x);
			}
			return absent;
		}
	}
}

class ImprovedList<E> implements List<E> {
	private final List<E> list;
	
	public ImprovedList(List<E> list) {
		this.list = list;
	}
	
	public synchronized  boolean putIfAbsent(E x) {
			boolean absent = !list.contains(x);
			if(absent) {
				list.add(x);
			}
			return absent;
	}

	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean add(E e) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean addAll(Collection<? extends E> c) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean addAll(int index, Collection<? extends E> c) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	public void clear() {
		// TODO Auto-generated method stub
		
	}

	public E get(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	public E set(int index, E element) {
		// TODO Auto-generated method stub
		return null;
	}

	public void add(int index, E element) {
		// TODO Auto-generated method stub
		
	}

	public E remove(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	public int indexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int lastIndexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	public ListIterator<E> listIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	public ListIterator<E> listIterator(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<E> subList(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		return null;
	}
}
