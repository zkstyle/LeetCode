package algorithms.hashtable;

import java.util.*;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: com.elvis.leetcode.hashtable
 * @Author: Elvis
 * @CreateTime: 2018-12-26 19:54
 * Description:
 * 给定一个字符串 S 和一个字符串 T，请在 S 中找出包含 T 所有字母的最小子串。
 *
 * 示例：
 *
 * 输入: S = "ADOBECODEBANC", T = "ABC"
 * 输出: "BANC"
 * 说明：
 * 子串没有重复字母　因为重复字母没有意义
 *
 * 如果 S 中不存这样的子串，则返回空字符串 ""。
 * 如果 S 中存在这样的子串，我们保证它是唯一的答案。
 */
public class Leetcode76 {
    /**
     * 3ms典范
     * @param s
     * @param t
     * @return
     */
    public String minWindow2(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }
        char[] chas1 = s.toCharArray();
        char[] chas2 = t.toCharArray();
        // HashMap<Character, Integer> map = new HashMap<>();
        int[] map = new int[256];
        for (int i = 0; i < chas2.length; i++) {
            map[chas2[i]]++;
        }
        int curLen = Integer.MAX_VALUE;
        int minLen = Integer.MAX_VALUE;
        int minL = 0;
        int minR = 0;
        int match = chas2.length;
        int left = 0;
        int right = 0;
        while (right < chas1.length) {
            map[chas1[right]]--;
            if (map[chas1[right]] >= 0) {  // 成功的一笔还款
                match--;
            }
            if (match == 0) {
                while (map[chas1[left]] < 0) { // left尽量右移
                    map[chas1[left]]++;
                    left++;
                }
                curLen = right - left + 1;
                if (curLen < minLen) {  // 记录最短窗口的位置
                    minLen = curLen;
                    minL = left;
                    minR = right;
                }
                // 一定要在if语句内，left不一定是每次都移动
                map[chas1[left++]]++; // left继续右移1位
                match++;  // 再次欠款！
            }
            right++;
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(minL, minR + 1);
    }


    /**
     * 2ms 典范
     * @param s
     * @param t
     * @return
     */
    public static String minWindow(String s, String t) {
        //记录每个字母出现的次数
        int[] count = new int['z' - 'A' + 1];
        int uniq = 0;
        for (int i = 0; i < t.length(); ++i) {
            if (++count[t.charAt(i) - 'A'] == 1) {
                uniq++;
            }
        }
        // expand
        int found = 0;
        int i = 0;
        int j = 0;
        int minLen = Integer.MAX_VALUE;
        int minJ = Integer.MAX_VALUE;
        while (found < uniq) {
            while (i < s.length()) {
                if (found >= uniq) {
                    break;
                }
                if (--count[s.charAt(i) - 'A'] == 0) {
                    found++;
                }
                i++;
            }
            if (found < uniq) {
                break;
            }
            // shorten
            while (j < i && count[s.charAt(j) - 'A'] < 0) {
                count[s.charAt(j++) - 'A']++;
            }
            if (i - j < minLen) {
                minLen = i - j;
                minJ = j;
            }
            count[s.charAt(j++) - 'A']++;
            found--;
        }
        if (minLen < Integer.MAX_VALUE) {
            return s.substring(minJ, minJ + minLen);
        }
        return "";
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        Collection<String> c = new ArrayList();

        System.out.println(minWindow(s,t));
    }
}
