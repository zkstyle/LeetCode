package dp;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: com.elvis.leetcode.dp
 * @Author: Elvis
 * @CreateTime: 2019-04-26 13:26
 * Description:
 * 给定两个单词 word1 和 word2，计算出将 word1 转换成 word2 所使用的最少操作数 。
 *
 * 你可以对一个单词进行如下三种操作：
 *
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 * 示例 1:
 *
 * 输入: word1 = "horse", word2 = "ros"
 * 输出: 3
 * 解释:
 * horse -> rorse (将 'h' 替换为 'r')
 * rorse -> rose (删除 'r')
 * rose -> ros (删除 'e')
 * 示例 2:
 *
 * 输入: word1 = "intention", word2 = "execution"
 * 输出: 5
 * 解释:
 * intention -> inention (删除 't')
 * inention -> enention (将 'i' 替换为 'e')
 * enention -> exention (将 'n' 替换为 'x')
 * exention -> exection (将 'n' 替换为 'c')
 * exection -> execution (插入 'u')
 */
public class Leetcode72 {

    /**
     * 【思路】
     * 令dp[i][j]为：当遍历到字符串word1的第i个字符，遍历到字符串word2的第j个字符时，转换所需要的最少操作次数为dp[i][j]
     * 若word1[i]==word2[j]，那么当前不需要进行任何操作，有dp[i][j]=dp[i-1][j-1]
     * 若word1[i]!=word2[j]不相等，j就有三种操作：
     * 如果把字符word1[i] 替换成与 word2[j] 相等，则有 dp[i][j] = dp[i-1][j-1] + 1
     * 如果在字符串word1末尾插入一个与word2[j]相等的字符，则有dp[i][j] = dp[i][j-1] + 1
     * 如果把字符word1[i]删除，则有dp[i][j]=dp[i-1][j]+1
     * 那么我们应该选择一种操作，使得dp[i][j]的值最小，即有dp[i][j] = min(dp[i-1][j-1]，dp[i][j-1]，dp[[i-1][j]]) + 1
     */
    public static int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (i == 0 || j == 0) {
                    dp[i][j] = i + j;
                    continue;
                }
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j]));
                }
            }
        }
        return dp[m][n];
    }

}
