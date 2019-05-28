package dp;

import java.util.Arrays;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: com.elvis.leetcode.dp
 * @Author: Elvis
 * @CreateTime: 2019-05-19 09:12
 * Description:
 */
public class Leetcode322 {

    /**
     * dp
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        int max = amount + 1;
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 0; i < coins.length; i++) {
            for (int j = 1; j <= amount; j++) {
                if (j - coins[i] >= 0) {
                    dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
                }

            }
        }
        return (dp[amount] > amount) ? -1 : dp[amount];
    }

    class Solution {
        private int result;
        public int coinChange(int[] coins, int amount) {
            result = Integer.MAX_VALUE;
            Arrays.sort(coins);
            min(coins, amount, coins.length-1, 0);
            return result == Integer.MAX_VALUE ? -1 : result;
        }

        private void min(int[] coins, int left, int pos, int res) {
            int coin = coins[pos];
            if (pos == 0) {
                if (left % coin == 0) {
                    result = Math.min(result, left/coin + res);
                }
            } else {
                for (int i = left / coin; i >= 0 && res + i < result; i--) {
                    min(coins, left - i*coin, pos-1, res + i);
                }
            }
        }
    }
}
