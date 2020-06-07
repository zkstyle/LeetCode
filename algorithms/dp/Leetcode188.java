package dp;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: dp
 * @Author: elvis
 * @CreateTime: 2020-06-05 09:38
 * @Description: 买卖股票的最佳时机4
 */
public class Leetcode188 {

    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (k > n / 2) {
            int dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE;
            for (int i = 1; i <= n; i++) {
                //算dp_i_1时，原来的dp_i_0被可能修改了，
                int tmp = dp_i_0;
                // dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i])
                dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i - 1]);
                // dp[i][1] = max(dp[i-1][1], dp[i-1][0] - prices[i])
                dp_i_1 = Math.max(dp_i_1, tmp - prices[i - 1]);
            }
            return dp_i_0;
        }
        int[][] dp_i = new int[k + 1][2];
        for (int j = 0; j <= k; j++) {
            dp_i[j][0] = 0;
            dp_i[j][1] = Integer.MIN_VALUE;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                // dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + prices[i])
                dp_i[j][0] = Math.max(dp_i[j][0], dp_i[j][1] + prices[i - 1]);
                // dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i])
                dp_i[j][1] = Math.max(dp_i[j][1], dp_i[j - 1][0] - prices[i - 1]);
            }
        }
        return dp_i[k][0];
    }
}
