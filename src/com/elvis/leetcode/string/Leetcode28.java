package com.elvis.leetcode.string;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: com.elvis.leetcode.string
 * @Author: Elvis
 * @CreateTime: 2019-03-16 09:06
 * Description: Implement strStr()
 * Implement strStr().
 *
 * Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 *
 * Example 1:
 *
 * Input: haystack = "hello", needle = "ll"
 * Output: 2
 * Example 2:
 *
 * Input: haystack = "aaaaa", needle = "bba"
 * Output: -1
 * Clarification:
 *
 * What should we return when needle is an empty string? This is a great question to ask during an interview.
 *
 * For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().
 */
public class Leetcode28 {

    public int strStr(String haystack, String needle) {
        if (needle.length() == 0){
            return 0;
        }
        int m = haystack.length();
        int n = needle.length();
        String cmp;
        for (int i = 0; i <= m - n; i++){
            cmp = haystack.substring(i, i + n);
            if (cmp.equals(needle)){
                return i;
            }
        }
        return -1;
    }
}
