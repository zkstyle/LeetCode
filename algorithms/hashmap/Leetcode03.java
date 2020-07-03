package hashmap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: com.elvis.leetcode.hashmap
 * @Author: Elvis
 * @CreateTime: 2020-2-26 18:55
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
public class Leetcode03 {
    /**
     * 算法思路： 首先定义一个hashmap存放字符与下标　每次存放不同字符与对应标
     *          并且一旦出现重复字符　需要对起始位置下标start进行更新　
     *          而为了防止start出现倒退现象　比如abba 当遍历到第二个a时
     *          若不进行比较start = Math.max(start, map.get(s.charAt(i))+1)
     *          则起始位置start会从2倒退到0 显然不符合题意，而且start这个参数只能增长不能后退
     *          它标志着起始位置　以abcabcbb为例　当遍历到第二个a时(下标为3)　start位置应当为第一个a的下一位也就是b(下标为1)
     * @param s
     * @return
     * ex: abcabcbb abba
     */
    public int lengthOfLongestSubstringPlus(String s) {
        if (s.length() == 0) return 0;
        int maxLength = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0 ,start = 0 ; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))){
                //防止起始位置后退　以abba为例
                start = Math.max(start, map.get(s.charAt(i))+1);
            }
            map.put(s.charAt(i), i);
            //更新最大长度
            maxLength = Math.max(maxLength, i - start + 1);
        }
        return maxLength;
    }

    /**
     * 数组hash 访问更快
     */
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        int maxlength = 0;
        int start = 0;
        int[] dict = new int[128];
        Arrays.fill(dict, -1);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (dict[c] != -1) {
                start = Math.max(dict[c] + 1, start);
            }
            dict[c] = i;
            maxlength = Math.max(maxlength, i - start + 1);
        }
        return maxlength;
    }

}
