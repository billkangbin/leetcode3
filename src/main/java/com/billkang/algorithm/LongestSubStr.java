package com.billkang.algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个字符串，取不重复字符的最长子串
 * 如abaacd, 最长不重复字符子串是acd
 *
 * @author Kangbin
 * @date 2018-12-01
 */
public class LongestSubStr {
    public String getLongestSubStr(String str) {
        char[] chars = str.toCharArray();
        Map<Character, Integer> hashMap = new HashMap<Character, Integer>(str.length());
        List<Character> result = new ArrayList<Character>();

        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (hashMap.get(c) != null) {
                int position = hashMap.get(c);
                result = result.subList(position + 1, result.size());
            }
            hashMap.put(c, i);
            result.add(c);
        }

        return result.toString();

    }

    public static void main(String[] args) {
        System.out.println(new LongestSubStr().getLongestSubStr("abaacd"));
    }
}
