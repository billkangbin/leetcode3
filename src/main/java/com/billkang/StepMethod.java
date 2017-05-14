package com.billkang;

public class StepMethod {
	/**
	 * [算法]n阶台阶，一次走一步或两步，有多少种走法？
	 */
	public int findStep(int n) {
		if(n==0 || n==1 || n==2) {
			return n;
		}
		
		return findStep(n-1)+findStep(n-2);
	}
}
