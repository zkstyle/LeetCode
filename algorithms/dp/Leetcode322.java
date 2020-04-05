package dp;

import java.util.Arrays;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: com.elvis.leetcode.dp
 * @Author: Elvis
 * @CreateTime: 2019-05-19 09:12
 * Description:给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 *
 * 示例 1:
 *
 * 输入: coins = [1, 2, 5], amount = 11
 * 输出: 3
 * 解释: 11 = 5 + 5 + 1
 * 示例 2:
 *
 * 输入: coins = [2], amount = 3
 * 输出: -1
 * 说明:
 * 你可以认为每种硬币的数量是无限的。
 */
public class Leetcode322 {

    /**
     * dp动态规划　对于每一种零钱coins[i]都建立中间dp值
     *          比如刚开始对于coins[0]=1 dp[1]=1 dp[2]=dp[1]+1=2 ...dp[11]=11
     *          coins[1]=2 dp[2]=1 dp[3]=dp[1]+1=2 dp[4]=dp[2]+1=2(相较于上一次dp[4]=4发生了更新)dp[11]=dp[9]+1=6
     *          coins[2]=5 dp[5]=1 dp[6]=dp[6-5]+1=2(相较于上一次dp[6]=3发生了更新) dp[11]=dp[11-5]+1=dp[6]+1=3
     *          最后若无法兑换　因为第一步将dp[i]都赋值amount+1　所以dp[amount]=amount+1则无法兑换　否则返回dp[amount]
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        for(int i = 1; i <= amount; i ++){
            dp[i] = amount + 1;
        }
        for(int coin : coins){
            for(int i = coin; i <= amount; i ++){
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    /**
     * dfs深度搜索算法
     * @param coins　零钱数组
     * @param amount 兑换零钱总金额
     * @return
     */
    public int coinChange2(int[] coins, int amount) {
        if (amount < 1 || coins == null || coins.length == 0) return 0;
        Arrays.sort(coins);
        int[] ans = new int[]{Integer.MAX_VALUE};
        dfs(coins, amount, coins.length - 1, 0, ans);
        return ans[0] == Integer.MAX_VALUE ? -1 : ans[0];
    }

    /**
     * @param coins 待选的硬币面值
     * @param amount 需要凑够的金额
     * @param coinIdx 当前选择的硬币面值的索引
     * @param count 目前已选的硬币数量
     * @param ans 最终的答案
     */
    private void dfs(int[] coins, int amount, int coinIdx, int count, int[] ans) {
        /*
        整体策略：优先尽可能多地选择较大面值的硬币（假设要凑够的金额是amount，当前正在选择的硬币面值是coin）
        ① 如果凑够了amount，说明得到了一个潜在答案，计算出目前能凑够amount的最少硬币数量ans，剪枝
        ② 如果没凑够amount
            (1) 如果coin是最小面值，说明这个凑法不合理，剪枝
            (2) 如果(目前已选择的硬币数量 + 1) >= ans，说明继续往下凑，硬币数量不会小于ans，剪枝
            (3) 否则尝试选择面值比coin小的硬币去凑剩余的金额
            (4) 减少面值为coin的硬币数量，进入 ①
        */
        for (int c = amount / coins[coinIdx]; c >= 0; c--) {
            int remain = amount - c * coins[coinIdx];
            int curCount = count + c;
            if (remain == 0) {
                // 已经优先用面值较大的硬币了
                // 如果用面值较小的硬币，凑出来的数量只会更多
                // 所以直接剪枝，没必要尝试减少大面值硬币的数量，用小面值的硬币去凑
                ans[0] = Math.min(ans[0], curCount);
                return;
            }

            // 已经是最小面值了，如果还凑不够amount，说明不可能凑出这个数目，直接剪枝
            if (coinIdx == 0) return;

            // 继续往下凑，硬币数量不会小于ans，直接剪枝
            if (curCount + 1 >= ans[0]) return;

            // 选择较小的面值凑够剩余的金额
            dfs(coins, remain, coinIdx - 1, curCount, ans);
        }
    }

    // [1, 7, 10], 30
    // 3*10（刚好）, ans = 3

    // [1, 7, 10], 34
    // 3*10 -> 0*7 -> 4*1（刚好）, ans = 7
    // 2*10 -> 2*7（刚好）, ans = 4
    // 1*10 -> 3*7（没必要）, ans = 4
    // 0*10 -> 4*7（没必要）, ans = 4

    // [1, 10, 20, 25], 41
    // 1*25 -> 0*20 -> 1*10 -> 6*1（刚好）, ans = 8
    // 1*25 -> 0*20 -> 0*10 -> 16*1（刚好）, ans = 8
    // 0*25 -> 2*20 -> 0*10 -> 1*1（刚好）, ans = 3
    // 0*25 -> 1*20 -> 2*10（没必要）
    // 0*25 -> 0*20 -> 4*10（没必要）

    // [2, 5, 10], 21
    // 2*10 -> 0*5 -> 0*2（无法凑）, ans = MAX
    // 1*10 -> 2*5 -> 0*2（无法凑）, ans = MAX
    // 1*10 -> 1*5 -> 3*2（刚好）, ans = 5
    // 1*10 -> 0*5 -> 5*2（无法凑）, ans = 5
    // 0*10 -> 4*5（没必要）, ans = 5

    // [2, 4, 6], 11
    // 1*6 -> 1*4 -> 0*2（无法凑）, ans = MAX
    // 1*6 -> 0*4 -> 2*2（无法凑）, ans = MAX
    // 0*6 -> 2*4 -> 1*2（无法凑）, ans = MAX
    // 0*6 -> 1*4 -> 3*2（无法凑）, ans = MAX
    // 0*6 -> 0*4 -> 5*2（无法凑）, ans = MAX
}
