package dp;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: dp
 * @Author: Elvis
 * @CreateTime: 2019-07-13 10:39
 * Description:
 * 给定三个字符串 s1, s2, s3, 验证 s3 是否是由 s1 和 s2 交错组成的。
 *
 * 示例 1:
 *
 * 输入: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
 * 输出: true
 * 示例 2:
 *
 * 输入: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
 * 输出: false
 */
public class Leetcode97 {

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;
        Boolean[][] dp = new Boolean[s1.length()][s2.length()];
        return isInterleaveHelper(s1, 0, s2, 0, s3, 0, dp);
    }

    public boolean isInterleaveHelper(String s1, int i, String s2, int j, String s3, int k, Boolean[][] dp) {
        if (i == s1.length()) return s2.substring(j).equals(s3.substring(k));
        if (j == s2.length()) return s1.substring(i).equals(s3.substring(k));
        if (dp[i][j] != null) return dp[i][j];
        if (s1.charAt(i) != s3.charAt(k) && s2.charAt(j) != s3.charAt(k)) {
            dp[i][j] = false;
        } else if (s1.charAt(i) == s3.charAt(k) && s2.charAt(j) != s3.charAt(k)) {
            dp[i][j] = isInterleaveHelper(s1, i + 1, s2, j, s3, k + 1, dp);
        } else if (s1.charAt(i) != s3.charAt(k) && s2.charAt(j) == s3.charAt(k)) {
            dp[i][j] = isInterleaveHelper(s1, i, s2, j + 1, s3, k + 1, dp);
        } else {
            dp[i][j] = isInterleaveHelper(s1, i + 1, s2, j, s3, k + 1, dp) || isInterleaveHelper(s1, i, s2, j + 1, s3, k + 1, dp);
        }
        return dp[i][j];
    }
}
