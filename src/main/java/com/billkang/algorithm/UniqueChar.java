package com.billkang.algorithm;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Kangbin
 * @date 2018-11-17
 */
public class UniqueChar {
    /**
     * 判断一个字符串的所有字符是否全部不同
     * @param str
     * @return
     */
    public boolean isUniqueChar(String str) {
        Set<Character> charSet = new HashSet<Character>(str.length());

        for(int i =0;i<str.length();i++) {
            Character c = str.charAt(i);
            if(charSet.contains(c)) {
                return false;
            }
            charSet.add(c);
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new UniqueChar().isUniqueChar("abc"));
        System.out.println(new UniqueChar().isUniqueChar("abca"));
        System.out.println(new UniqueChar().isUniqueChar("abcad"));
    }
}
