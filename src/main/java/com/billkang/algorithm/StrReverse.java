package com.billkang.algorithm;

/**
 * 字符串反转
 *
 * @author Kangbin
 * @date 2018-11-17
 */
public class StrReverse {
    /**
     * 1.通过stringbuilder的reverse方法
     *
     * @param str
     * @return
     */
    public String reverse1(String str) {
        StringBuilder stb = new StringBuilder(str);
        return stb.reverse().toString();
    }

    /**
     * 2. 将str里的字符从后向前累加
     *
     * @param str
     * @return
     */
    public String reverse2(String str) {
        StringBuilder stb = new StringBuilder();
        for (int i = str.length()-1; i >= 0; i--) {
            stb.append(str.charAt(i));
        }
        return stb.toString();
    }

    /**
     * 3. 递归
     *
     * @param str
     * @return
     */
    public String reverse3(String str) {
        int length = str.length();
        if (length <= 1) {
            return str;
        }

        String left = str.substring(0, length / 2);
        String right = str.substring(length / 2, length);
        return reverse3(right) + reverse3(left);
    }

    public static void main(String[] args) {
        System.out.println(new StrReverse().reverse1("abcdefg"));
        System.out.println(new StrReverse().reverse2("abcdefg"));
        System.out.println(new StrReverse().reverse3("abcdefg"));
    }
}