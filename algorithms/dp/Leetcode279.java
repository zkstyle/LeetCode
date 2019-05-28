package dp;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: com.elvis.leetcode.dp
 * @Author: Elvis
 * @CreateTime: 2019-05-18 11:34
 * Description:
 * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
 *
 * 示例 1:
 *
 * 输入: n = 12
 * 输出: 3
 * 解释: 12 = 4 + 4 + 4.
 * 示例 2:
 *
 * 输入: n = 13
 * 输出: 2
 * 解释: 13 = 4 + 9.
 */
public class Leetcode279 {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;

        for(int i = 1; i<= n ; i++){
            dp[i] = i; //默认其最大值组合，1+1+1+1+...
            for(int j = 1; i-j*j >= 0; j++){
                dp[i] = Math.min(dp[i], dp[i-j*j]+1);
            }
        }

        return dp[n];
    }


}
