package com.billkang;

public class SecondMaxNumber {

	public int secondMaxNum(int[] a) {
		int n = a.length;
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < n - i - 1; j++) {
				if (a[j] > a[j + 1]) {
					swap(a, j, j + 1);
				}
			}
		}
		return a[n - 2];
	}

	public int find2Max(int[] a) {
		int max1 = 0;
		int max2 = 0;
		for (int i = 1; i < a.length; i++) {
			if (a[i] > a[max1]) {
				max2 = max1;
				max1 = i;
			} else if (a[i] > a[max2] && a[i] < a[max1])
				max2 = i;
		}
		return max2;
	}

	private void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
}
