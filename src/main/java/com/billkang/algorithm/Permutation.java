package com.billkang.algorithm;

import java.util.Arrays;

/**
 * 给定两个字符串，确定一个字符串重新排列后能否变成另一个字符串
 *
 * @author Kangbin
 * @date 2018-11-17
 */
public class Permutation {
    // 分析：两个字符串的长度都不相同时，不可能是变位词

    /**
     * 检查两个字符串都排好序时是否相等
     *
     * @param s
     * @param t
     * @return
     */
    public boolean permutation1(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        return sort(s).equals(sort(t));
    }

    private String sort(String s) {
        char[] content = s.toCharArray();
        Arrays.sort(content);
        return new String(content);
    }

    /**
     * 检查两个字符串每个字符是否相等
     *
     * @param s
     * @param t
     * @return
     */
    public boolean permutation2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] letters = new int[256];

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            letters[c]++;
        }

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (--letters[c] < 0) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        System.out.println(new Permutation().permutation1("abc", "abcd"));
        System.out.println(new Permutation().permutation1("abc", "abc"));

        System.out.println(new Permutation().permutation2("abc", "abd"));
        System.out.println(new Permutation().permutation2("abc", "abc"));
    }
}
