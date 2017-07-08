package com.billkang;

/**
 * Created by Kangbin on 2017/7/8.
 */
public class _633SumSquareNumbers {
    public boolean judgeSquareSum(int c) {
        for(int i=0;i<=c;i++) {
            for(int j=0;j<=c;j++) {
                if(i*i+j*j==c) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean judgeSquareSum2(int c) {
        int low = 0;
        int high = (int)Math.sqrt(c);
        while(low<=high) {
            int sum = low*low+high*high;
            if(sum<c) {
                low++;
            } else if(sum>c) {
                high--;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new _633SumSquareNumbers().judgeSquareSum(5));
        System.out.println(new _633SumSquareNumbers().judgeSquareSum(3));
    }
}
