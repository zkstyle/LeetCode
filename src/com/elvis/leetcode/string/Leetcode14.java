package com.elvis.leetcode.string;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: com.elvis.leetcode.string
 * @Author: Elvis
 * @CreateTime: 2019-04-15 13:02
 * Description:
 */
public class Leetcode14 {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length < 1) return "";
        if (strs.length == 1) return strs[0];
        StringBuilder match = new StringBuilder(strs[0]);
        for (int i = 1; i < strs.length; i++) {
            while (!strs[i].startsWith(match.toString())) {
                match.deleteCharAt(match.length() - 1);
                if (match.length() < 1) return "";
            }
        }
        return match.toString();
    }
}
