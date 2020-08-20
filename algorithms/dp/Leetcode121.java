package dp;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: com.elvis.leetcode.dp
 * @Author: Elvis
 * @CreateTime: 2019-05-05 10:20
 * Description:
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
 *
 * 注意你不能在买入股票前卖出股票。
 *
 * 示例 1:
 *
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
 * 示例 2:
 *
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 */
public class Leetcode121 {

    /**
     * 定义最小价格变量minValue 保存当前最小价格
     * 若当前价格prices[i] < minValue 那么显然当前最大值dp[i]=dp[i-1]
     * 否则　price[i] - minValue > max(最大利润)　更新max
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            max = Math.max(max, prices[i] - min);
        }
        return max > 0 ? max : 0;
    }

    /**
     * dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + prices[i])
     *               max(   选择 rest  ,             选择 sell      )
     * 解释：今天我没有持有股票，有两种可能：
     *
     * 要么是我昨天就没有持有，然后今天选择 rest，所以我今天还是没有持有；
     *
     * 要么是我昨天持有股票，但是今天我 sell 了，所以我今天没有持有股票了。
     *
     * dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i])
     *               max(   选择 rest  ,           选择 buy         )
     * 解释：今天我持有着股票，有两种可能：
     *
     * 要么我昨天就持有着股票，然后今天选择 rest，所以我今天还持有着股票；
     *
     * 要么我昨天本没有持有，但今天我选择 buy，所以今天我就持有股票了。
     *
     * dp[-1][k][0] = 0
     * 解释：因为 i 是从 0 开始的，所以 i = -1 意味着还没有开始，这时候的利润当然是 0 。
     * dp[-1][k][1] = -infinity
     * 解释：还没开始的时候，是不可能持有股票的，用负无穷表示这种不可能。
     * dp[i][0][0] = 0
     * 解释：因为 k 是从 1 开始的，所以 k = 0 意味着根本不允许交易，这时候利润当然是 0 。
     * dp[i][0][1] = -infinity
     * 解释：不允许交易的情况下，是不可能持有股票的，用负无穷表示这种不可能。
     * 把上面的状态转移方程总结一下：
     * base case：
     * dp[-1][k][0] = dp[i][0][0] = 0
     * dp[-1][k][1] = dp[i][0][1] = -infinity
     *
     * 状态转移方程：
     * dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + prices[i])
     * dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i])
     */
    public int maxProfit2(int[] prices) {
        int n=prices.length;
        if(n==0) return 0;
        int[][][] dp=new int[n][2][2];
        dp[0][0][0]=0;
        dp[0][0][1]=0;
        dp[0][1][0]=0;
        dp[0][1][1]=-prices[0];
        for(int i=1;i<prices.length;i++){
            dp[i][1][0]=Math.max(dp[i-1][1][0],dp[i-1][1][1]+prices[i]);
            dp[i][1][1]=Math.max(dp[i-1][1][1],dp[i-1][0][0]-prices[i]);
        }
        return Math.max(0,dp[n-1][1][0]);
    }

    /**
     * 因为状态转移方程：
     *       dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + prices[i])
     *       dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i])
     *
     * dp[i][1][0] = max(dp[i-1][1][0], dp[i-1][1][1] + prices[i])
     * dp[i][1][1] = max(dp[i-1][1][1], dp[i-1][0][0] - prices[i])
     *             = max(dp[i-1][1][1], -prices[i])
     * 解释：k = 0 的 base case，所以 dp[i-1][0][0] = 0。
     *
     * 现在发现 k 都是 1，不会改变，即 k 对状态转移已经没有影响了。
     * 可以进行进一步化简去掉所有 k：
     * dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i])
     * dp[i][1] = max(dp[i-1][1], -prices[i])
     */
    public int maxProfit3(int[] prices) {
        int n=prices.length;
        if(n==0) return 0;
        int[][] dp=new int[n][2];
        dp[0][0]=0;
        dp[0][1]=-prices[0];
        for(int i=1;i<prices.length;i++){
            dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
            dp[i][1]=Math.max(dp[i-1][1],-prices[i]);
        }
        return Math.max(0,dp[n-1][0]);
    }

    /**
     *状态转移方程，新状态只和相邻的一个状态有关，其实不用整个 dp 数组，
     * 只需要一个变量储存相邻的那个状态就足够了，这样可以把空间复杂度降到 O(1):
     */
    public int maxProfit4(int[] prices) {
        int n = prices.length;
        // base case: dp[-1][0] = 0, dp[-1][1] = -infinity
        int dp_i_0 = 0, dp_i_1 = -prices[0];
        for (int i = 1; i < n; i++) {
            // dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i])
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            // dp[i][1] = max(dp[i-1][1], -prices[i])
            dp_i_1 = Math.max(dp_i_1, -prices[i]);
        }
        return dp_i_0;
    }
}
