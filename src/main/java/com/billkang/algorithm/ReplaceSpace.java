package com.billkang.algorithm;

/**
 * 空格替换成20%
 * @author Kangbin
 * @date 2018-11-17
 */
public class ReplaceSpace {
    public String replaceSpaces1(String s) {
        return s.replace(" ", "20%");
    }

    public String replaceSpaces2(String s) {
        char[] strs = s.toCharArray();
        char[] str2 = replace(strs, s.length());
        return new String(str2);
    }

    private char[] replace(char[] strs, int length) {
        int spaceCount = 0;
        for (char c : strs) {
            if (c == ' ') {
                spaceCount++;
            }
        }

        int newLength = length + spaceCount * 2;
        char[] strs2 = new char[newLength];
        for (int i = length - 1; i >= 0; i--) {
            if (strs[i] == ' ') {
                strs2[newLength - 1] = '0';
                strs2[newLength - 2] = '2';
                strs2[newLength - 3] = '%';
                newLength = newLength - 3;
            } else {
                strs2[newLength - 1] = strs[i];
                newLength = newLength - 1;
            }
        }
        return strs2;
    }

    public static void main(String[] args) {
        System.out.println(new ReplaceSpace().replaceSpaces1("a bc def"));
        System.out.println(new ReplaceSpace().replaceSpaces2("a bc def"));
    }
}
