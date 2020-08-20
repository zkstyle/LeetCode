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
        int n = s1.length(), m = s2.length(), t = s3.length();
        if (n + m != t) {
            return false;
        }
        boolean[][] f = new boolean[n + 1][m + 1];
        f[0][0] = true;
        for (int i = 0; i <= n; ++i) {
            for (int j = 0; j <= m; ++j) {
                int p = i + j - 1;
                if (i > 0) {
                    f[i][j] = f[i][j] || (f[i - 1][j] && s1.charAt(i - 1) == s3.charAt(p));
                }
                if (j > 0) {
                    f[i][j] = f[i][j] || (f[i][j - 1] && s2.charAt(j - 1) == s3.charAt(p));
                }
            }
        }
        return f[n][m];
    }

    /**
     * dp动态规划　dp[i][j]表示s1的前i个字符与s2的前j个字符可以匹配s3的前i+j个字符(交错字符串)
     * dp[i][j]=(dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)) || (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1))
     */
    public boolean isInterleave2(String s1, String s2, String s3) {
        int n1 = s1.length();
        int n2 = s2.length();
        if (n1 + n2 != s3.length()) return false;
        boolean[][] dp = new boolean[n1 + 1][n2 + 1];
        dp[0][0] = true;
        for (int i = 1; i <= n1; i++) dp[i][0] = (dp[i - 1][0] && s1.charAt(i - 1) == s3.charAt(i - 1));
        for (int j = 1; j <= n1; j++) dp[0][j] = (dp[0][j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1));
        for (int i = 1; i <= n1; i++)
            for (int j = 1; j <= n2; j++) {
                dp[i][j] = (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)) || (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
            }
        return dp[n1][n2];
    }

    boolean interleave = false;
    char[] chars1, chars2, chars3;
    int len1, len2, len3;
    boolean[][] visited;

    public boolean isInterleave3(String s1, String s2, String s3) {
        len1 = s1.length();
        len2 = s2.length();
        len3 = s3.length();
        if (len1 + len2 != len3) return false;
        visited = new boolean[len1 + 1][len2 + 1];
        chars1 = s1.toCharArray();
        chars2 = s2.toCharArray();
        chars3 = s3.toCharArray();
        dfs(0, 0, 0);
        return interleave;
    }

    /**
     * 深度搜索 i j k三个指针分别指向s1 s2 s3
     * 比对chars1[i] == chars3[k] chars2[j] == chars3[k] 分别进行深度搜索
     * @param i
     * @param j
     * @param k
     */
    private void dfs(int i, int j, int k) {
        if (k == len3) interleave = true;
        if (interleave || visited[i][j]) return;
        if (i < len1 && chars1[i] == chars3[k]) dfs(i + 1, j, k + 1);
        if (j < len2 && chars2[j] == chars3[k]) dfs(i, j + 1, k + 1);
        visited[i][j] = true;
    }

}
