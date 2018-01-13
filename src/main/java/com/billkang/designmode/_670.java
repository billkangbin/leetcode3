package com.billkang.designmode;

/**
 * Created by Kangbin on 2017/9/5.
 */
public class _670 {
    public int maximumSwap(int num) {
        if (num <= 10) {
            return num;
        }
        //转成字符串，更方便处理。
        char[] strArr = String.valueOf(num).toCharArray();
        char max = '0';
        int[] dp = new int[strArr.length];//dp[i]存储 i 后面的最大的数字。
        dp[strArr.length - 1] = strArr.length - 1;

        for (int i = strArr.length - 1; i >= 0; i--) {
            if (max < strArr[i]) { // 不选择等于。（只有比其大的数才有交换意义）
                max = strArr[i];
                dp[i] = i;
            } else {
                dp[i] = dp[i-1];
            }
        }

        for (int i = 0; i < dp.length; i++) {
            if (dp[i] > i && strArr[i] != strArr[dp[i]]) {
                char tmp = strArr[i];
                strArr[i] = strArr[dp[i]];
                strArr[dp[i]] = tmp;
                break; //忘记加，导致bug.
            }
        }
        return Integer.valueOf(new String(strArr));

    }
}
