package com.billkang.algorithm.sort;

import java.util.Arrays;

/**
 * 归并排序
 * @author Kangbin
 * @date 2018-11-28
 */
public class MergeSort {

    public void mergeSort(int[] arr) {
        //在排序前，先建好一个长度等于原数组长度的临时数组，避免递归中频繁开辟空间
        int[] temp = new int[arr.length];
        sort(arr, 0, arr.length - 1, temp);
    }

    public void sort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            sort(arr, left, mid, temp);
            sort(arr, mid + 1, right, temp);
            merge(arr, left, mid, right, temp);
        }
    }

    private void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left; //左序列指针
        int j = mid + 1; //右序列指针
        int t = 0; //临时数组指针
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[t++] = arr[i++];
            } else {
                temp[t++] = arr[j++];
            }
        }

        //左边剩余元素放进temp
        while (i <= mid) {
            temp[t++] = arr[i++];
        }

        //右边剩余元素放进temp
        while (j <= right) {
            temp[t++] = arr[j++];
        }

        //将temp中排好序的元素copy到原数组中
        t = 0;
        while (left <= right) {
            arr[left++] = temp[t++];
        }

    }

    public static void main(String[] args) {
        int[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        new MergeSort().mergeSort(arr);
        System.out.println(Arrays.toString(arr));

    }
}
