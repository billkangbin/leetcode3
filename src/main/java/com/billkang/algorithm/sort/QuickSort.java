package com.billkang.algorithm.sort;

import java.util.Arrays;

/**
 * 快速排序
 *
 * @author Kangbin
 * @date 2018-11-29
 */
public class QuickSort {
    public void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    public void quickSort(int[] arr, int left, int right) {
        int ltemp = left;
        int rtemp = right;
        int key = arr[(left + right) / 2];

        while (ltemp < rtemp) {
            while (arr[ltemp] < key) {
                ltemp++;
            }
            while (arr[rtemp] > key) {
                rtemp--;
            }

            while (ltemp <= rtemp) {
                int temp = arr[ltemp];
                arr[ltemp] = arr[rtemp];
                arr[rtemp] = temp;
                ltemp++;
                rtemp--;
            }
        }

        if (left < rtemp) {
            quickSort(arr, left, ltemp - 1);
        }
        if (ltemp < right) {
            quickSort(arr, rtemp + 1, right);
        }
    }

    public static void main(String[] args) {
        int[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        new QuickSort().quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
