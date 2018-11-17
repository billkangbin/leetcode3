package com.billkang.designmode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Kangbin
 * @date 2018/2/4
 */
public class _771JewelsandStones {
    public int numJewelsInStones(String j, String s) {
        int result = 0;
        Set<Character> jc = new HashSet<Character>();
        for (Character i : j.toCharArray()) {
            jc.add(i);
        }

        for (Character i : s.toCharArray()) {
            if (jc.contains(i)) {
                result++;
            }
        }
        return result;
    }
}
