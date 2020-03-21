package dp;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: dp
 * @Author: elvis
 * @CreateTime: 2020-03-21 22:22
 * @Description: 斐波那契数列
 * 斐波那契数，通常用 F(n) 表示，形成的序列称为斐波那契数列。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
 *
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 * 给定 N，计算 F(N)。
 *
 *
 *
 * 示例 1：
 *
 * 输入：2
 * 输出：1
 * 解释：F(2) = F(1) + F(0) = 1 + 0 = 1.
 * 示例 2：
 *
 * 输入：3
 * 输出：2
 * 解释：F(3) = F(2) + F(1) = 1 + 1 = 2.
 * 示例 3：
 *
 * 输入：4
 * 输出：3
 * 解释：F(4) = F(3) + F(2) = 2 + 1 = 3.
 *
 *
 * 提示：
 *
 * 0 ≤ N ≤ 30
 */
public class Leetcode509 {
    /**
     *最简单的动态规划　每一次的结果都依托上两次的结果
     */
    public int fib(int n) {
        int[] dp = new int[n+1];
        if (n<2) return n;
        dp[0]=0;
        dp[1]=1;
        for (int i =2;i<=n;i++){
            dp[i] = (dp[i-1]+dp[i-2]);
        }
        return dp[n];
    }
}
