package com.billkang.designmode.responsibility;

import java.util.ArrayList;
import java.util.List;

/**
 * A self-dividing number is a number that is divisible by every digit it contains.
 * <p>
 * For example, 128 is a self-dividing number because 128 % 1 == 0, 128 % 2 == 0, and 128 % 8 == 0.
 * <p>
 * Also, a self-dividing number is not allowed to contain the digit zero.
 * <p>
 * Given a lower and upper number bound, output a list of every possible self dividing number, including the bounds if possible.
 * <p>
 * Example 1:
 * Input:
 * left = 1, right = 22
 * Output: [1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22]
 * Note:
 * <p>
 * The boundaries of each input argument are 1 <= left <= right <= 10000
 *
 * @author Kangbin
 * @date 2018/1/13
 */
public class _728SelfDividingNumbers {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> res = new ArrayList<Integer>();
        for (int i = left; i <= right; i++) {
            if (isSelfDividNum(i)) {
                res.add(i);
            }
        }
        return res;
    }

    private boolean isSelfDividNum(int i) {
        String val = String.valueOf(i);
        for (char c : val.toCharArray()) {
            if (c == '0') {
                return false;
            }
            if (i % (c - '0') != 0) {
                return false;
            }
        }
        return true;
    }

    private boolean isSelfDividNum2(int num) {
        int n = num;
        while (num != 0) {
            int c = num % 10;
            if (c == 0) {
                return false;
            }
            if (n % c != 0) {
                return false;
            }

            num /= 10;
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
