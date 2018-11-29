package com.billkang.algorithm.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 *
 * @author Kangbin
 * @date 2018-11-29
 */
public class BubbleSort {
    public void bubbleSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        new BubbleSort().bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
