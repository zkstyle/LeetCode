package dp;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: com.elvis.leetcode.dp
 * @Author: Elvis
 * @CreateTime: 2019-05-17 11:30
 * Description:
 * 编写一个程序，找出第n个丑数。
 *
 * 丑数就是只包含质因数  2, 3, 5的正整数。
 *
 * 示例:
 *
 * 输入: n = 10
 *  输出: 12
 *  解释:1, 2, 3, 4, 5, 6, 8, 9, 10, 12是前10个丑数。
 * 说明:
 *
 * 1 是丑数。
 * n 不超过 1690。
 */
public class Leetcode264 {

    /**
     * 动态规划: 首先定义三个指针i2 i3 i5　每次更新指针
     * 让我们从数组中只包含一个丑数数字 1 开始，使用三个指针i2 i3 i5，标记所指向丑数要乘以的因子。
     *
     * 算法很简单：在2×nums[i]，3×nums[i],5×nums[i]
     * 选出最小的丑数并添加到数组中。并将该丑数对应的因子指针往前走一步。
     * @param n
     * @return
     */
    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        int i2 = 0, i3 = 0, i5 = 0;
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            dp[i] = Math.min(Math.min(dp[i2] * 2, dp[i3] * 3), dp[i5] * 5);
            if (dp[i] == dp[i2] * 2) i2++;
            if (dp[i] == dp[i3] * 3) i3++;
            if (dp[i] == dp[i5] * 5) i5++;
        }
        return dp[n - 1];
    }


}
