package swordmeansoffer;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: swordmeansoffer
 * @Author: elvis
 * @CreateTime: 2020-05-04 08:35
 * @Description: 面试题60. n个骰子的点数
 * 把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率。
 *
 * 你需要用一个浮点数数组返回答案，其中第 i 个元素代表这 n 个骰子所能掷出的点数集合中第 i 小的那个的概率。　
 *
 * 示例 1:
 *
 * 输入: 1
 * 输出: [0.16667,0.16667,0.16667,0.16667,0.16667,0.16667]
 * 示例 2:
 *
 * 输入: 2
 * 输出: [0.02778,0.05556,0.08333,0.11111,0.13889,0.16667,0.13889,0.11111,0.08333,0.05556,0.02778]
 *　
 * 限制：
 *
 * 1 <= n <= 11
 */
public class SMO60 {

    /**
     * 解题思路
     * n个骰子，每个骰子6个面，总情况数为6^n
     * 设F(n,s)F(n,s)为当骰子数为n，和为s的情况数量。
     * 当n=1时，F(1,s)=1,其中s=1,2,3,4,5,6当n=1时，F(1,s)=1,其中s=1,2,3,4,5,6
     *
     * 当n>=2时，F(n,s)=F(n-1,s-1)+F(n-1,s-2)+F(n-1,s-3)+F(n-1,s-4)+F(n-1,s-5)+F(n-1,s-6)
     *
     *  F(n−1,s−d)，为了使得 s−d ≥ n−1 因为2个色子最小为2
     * 最后概率为P(n,s)=F(n,s)/6^n
     */
    public double[] twoSum(int n) {
        int[][] dp = new int[n + 1][6 * n + 1];
        //边界条件
        for (int s = 1; s <= 6; s++) dp[1][s] = 1;
        for (int i = 2; i <= n; i++) {
            for (int s = i; s <= 6 * i; s++) {
                //求dp[i][s]
                for (int d = 1; d <= 6; d++) {
                    if (s - d < i - 1) break;//为0了
                    dp[i][s] += dp[i - 1][s - d];
                }
            }
        }
        double total = Math.pow((double) 6, (double) n);
        double[] ans = new double[5 * n + 1];
        for (int i = n; i <= 6 * n; i++) {
            ans[i - n] = ((double) dp[n][i]) / total;
        }
        return ans;
    }
}
