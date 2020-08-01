package hashmap;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: com.elvis.leetcode.hashmap
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

    public String minWindow(String s, String t) {

        int sLen = s.length();
        int tLen = t.length();
        //特判
        if (sLen == 0 || tLen == 0 || sLen < tLen) {
            return "";
        }

        char[] charArrS = s.toCharArray();
        char[] charArrT = t.toCharArray();

        //滑动窗口
        int[] winFreq = new int[128];//ascii码
        int[] tFreq = new int[128];
        for (char c : charArrT) {
            tFreq[c]++;
        }

        //滑动窗口内部包含多少T中的字符，当对应字符频数超过时不重复计算
        int distance = 0;//类似汉明距离
        int minLen = sLen + 1;
        int begin = 0;

        int left = 0;//滑动窗口左开右闭区间
        int right = 0;
        while (right < sLen) {
            if (tFreq[charArrS[right]] == 0) {//t中不存在的字符
                right++;
                continue;
            }

            if (winFreq[charArrS[right]] < tFreq[charArrS[right]]) { //滑动窗口大小的 特定字符数量<t中字符数量
                distance++;
            }
            winFreq[charArrS[right]]++;
            right++;


            while (distance == tLen) { //当滑动窗口字符串满足包含t中所有字符条件时，左指针移动

                if (right - left < minLen) {
                    minLen = right - left;
                    begin = left;
                }

                if (tFreq[charArrS[left]] == 0) {
                    left++;
                    continue;
                }

                if (winFreq[charArrS[left]] == tFreq[charArrS[left]]) {
                    distance--;
                }

                winFreq[charArrS[left]]--;
                left++;//滑动窗口左指针移动
            }
        }

        //返回结果
        if (minLen == sLen + 1) {
            return "";
        } else {
            return s.substring(begin, begin + minLen);
        }
    }
}
