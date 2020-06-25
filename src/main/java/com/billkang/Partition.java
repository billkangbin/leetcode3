package com.billkang;

import java.util.ArrayList;
import java.util.List;


public class Partition {


    int dp[][];

    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList();

        if (s == null || s.length() == 0) {
            return res;
        }

        int length = s.length();

        dp = new int[length][length];
        for (int i = 0; i < length; i++) {
            dp[i][i] = 1;
        }

        List<String> tempList = new ArrayList();

        helper(res, tempList, s, length, 0);

        return res;
    }

    private void helper(List<List<String>> res, List<String> tempList, String s, int length, int index) {
        if (index == length) {
            res.add(new ArrayList(tempList));
        }

        for (int i = index; i < length; i++) {
            if (isPalindrome(s, index, i)) {
                tempList.add(s.substring(index, i + 1));
                helper(res, tempList, s, length, i + 1);
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int from, int to) {
        if (dp[from][to] == 1) {
            return true;
        } else if (dp[from][to] == 2) {
            return false;
        } else {
            for (int i = from, j = to; i < j; i++, j--) {
                if (s.charAt(i) != s.charAt(j)) {
                    dp[from][to] = 2;
                    return false;
                }
            }

            dp[from][to] = 1;
            return true;
        }
    }
}
