package com.elvis.leetcode.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: com.elvis.leetcode.hashtable
 * @Author: Elvis
 * @CreateTime: 2018-12-15 09:55
 * Description:
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: "pwwkew" "jbpnbwwd"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */
public class leetcode03_plus {

    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        int maxLength = 0;
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0 ,j = 0 ; i < s.length(); i++) {
                if (map.containsKey(s.charAt(i))){
                    j = Math.max(j, map.get(s.charAt(i))+1);
                }
                map.put(s.charAt(i), i);
                maxLength = Math.max(maxLength, i - j + 1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        int length = lengthOfLongestSubstring("jbpnbwwd");
        System.out.println(length);
    }
}
