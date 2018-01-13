package com.billkang.designmode;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two lists Aand B, and B is an anagram of A. B is an anagram of A means B is made by randomizing the order of the elements in A.
 * We want to find an index mapping P, from A to B. A mapping P[i] = j means the ith element in A appears in B at index j.
 * These lists A and B may contain duplicates. If there are multiple answers, output any of them.
 * For example, given
 * A = [12, 28, 46, 32, 50]
 * B = [50, 12, 32, 46, 28]
 * We should return
 * [1, 4, 3, 2, 0]
 * as P[0] = 1 because the 0th element of A appears at B[1], and P[1] = 4 because the 1st element of A appears at B[4], and so on.
 *
 * @author Kangbin
 * @date 2018/1/13
 */
public class _760FindAnagramMap {

    public int[] anagramMappings(int[] A, int[] B) {
        int n = A.length;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; ++i) {
            map.put(B[i], i);
        }
        int[] ans = new int[n];
        for (int i = 0; i < n; ++i) {
            ans[i] = map.get(A[i]);
        }
        return ans;
    }

    public int[] anagramMappings2(int[] A, int[] B) {
        int[] result = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                if(A[i]==B[j]) {
                    result[i]=j;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
