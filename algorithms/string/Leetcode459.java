package string;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: string
 * @Author: elvis
 * @CreateTime: 2020-10-04 22:40
 * @Description: 重复的子字符串
 * 给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。给定的字符串只含有小写英文字母，并且长度不超过10000。
 *
 * 示例 1:
 *
 * 输入: "abab"
 *
 * 输出: True
 *
 * 解释: 可由子字符串 "ab" 重复两次构成。
 * 示例 2:
 *
 * 输入: "aba"
 *
 * 输出: False
 * 示例 3:
 *
 * 输入: "abcabcabcabc"
 *
 * 输出: True
 *
 * 解释: 可由子字符串 "abc" 重复四次构成。 (或者子字符串 "abcabc" 重复两次构成。)
 */
public class Leetcode459 {

    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        char[] ch = s.toCharArray();
        for (int k = 2; k <= n; k++) {
            if (n % k != 0) continue;
            if (isRepeated(ch, n / k, k)) return true;
        }
        return false;
    }

    /**
     * 对每一个分段进行判断　一共p段　每次将第一段与　2~p段比较是否相等
     * @param ch 数组
     * @param len　截取长度
     * @param p　截取段数
     * @return 布尔
     */
    private boolean isRepeated(char[] ch, int len, int p) {
        for (int i = 0; i < p; i++) {
            int q = 0;
            for (int j = i * len; j < (i + 1) * len && q < len; j++) {
                if (ch[q++] != ch[j]) return false;
            }
        }
        return true;
    }
}
