package dp;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: dp
 * @Author: elvis
 * @CreateTime: 2020-08-22 19:55
 * @Description: 判断子序列
 * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 *
 * 你可以认为 s 和 t 中仅包含英文小写字母。字符串 t 可能会很长（长度 ~= 500,000），而 s 是个短字符串（长度 <=100）。
 *
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 *
 * 示例 1:
 * s = "abc", t = "ahbgdc"
 *
 * 返回 true.
 *
 * 示例 2:
 * s = "axc", t = "ahbgdc"
 *
 * 返回 false.
 *
 * 后续挑战 :
 *
 * 如果有大量输入的 S，称作S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。在这种情况下，你会怎样改变代码？
 */
public class Leetcode392 {

    /**
     * 动态规划　dp[i][j] 表示　s 的前i个字符　匹配　t　的前j个字符
     * 处理好边界　然后　dp[i][j]=dp[i][j - 1] || (dp[i - 1][j - 1] && s.charAt(i - 1) == t.charAt(j - 1))
     * 表示 若想要dp[i][j]匹配　那么只需要dp[i-1][j]匹配（s的前i-1个字符与t的前j个字符，说明第i字符不管是什么都可以匹配）
     * 或者　dp[i - 1][j - 1] && s.charAt(i - 1) == t.charAt(j - 1)　说明s的前i-1个字符与t的前j-1个字符匹配　并且　
     * s的第i个字符等于t的第j个字符
     */
    public boolean isSubsequence(String s, String t) {
        int m = s.length();
        int n = t.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 0; i <= m; i++)
            for (int j = 1; j <= n; j++) {
                if (i == 0) dp[i][j] = true;
                else dp[i][j] = dp[i][j - 1] || (dp[i - 1][j - 1] && s.charAt(i - 1) == t.charAt(j - 1));
            }
        return dp[m][n];
    }

    /**
     * 双指针法　一一进行比对　若最终i==n　说明完全匹配
     */
    public boolean isSubsequence2(String s, String t) {
        int n = s.length(), m = t.length();
        int i = 0, j = 0;
        while (i < n && j < m) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == n;
    }

    /**
     * 利用内置函数　依次查找s中的单个字符
     */
    public boolean isSubsequence3(String s, String t) {
        int index = -1;
        for (char c : s.toCharArray()) {
            index = t.indexOf(c, index + 1);
            if (index == -1) {
                return false;
            }
        }
        return true;
    }
}
