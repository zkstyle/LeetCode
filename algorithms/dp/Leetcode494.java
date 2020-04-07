package dp;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: com.elvis.leetcode.dp
 * @Author: Elvis
 * @CreateTime: 2019-05-21 11:17
 * Description: 给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。现在你有两个符号 + 和 -。对于数组中的任意一个整数，你都可以从 + 或 -中选择一个符号添加在前面。
 *
 * 返回可以使最终数组和为目标数 S 的所有添加符号的方法数。
 *
 * 示例 1:
 *
 * 输入: nums: [1, 1, 1, 1, 1], S: 3
 * 输出: 5
 * 解释:
 *
 * -1+1+1+1+1 = 3
 * +1-1+1+1+1 = 3
 * +1+1-1+1+1 = 3
 * +1+1+1-1+1 = 3
 * +1+1+1+1-1 = 3
 *
 * 一共有5种方法让最终目标和为3。
 * 注意:
 *
 * 数组非空，且长度不会超过20。
 * 初始的数组的和不会超过1000。
 * 保证返回的最终结果能被32位整数存下。
 */
public class Leetcode494 {

    public int findTargetSumWays(int[] nums, int S) {
        if (nums == null || nums.length <= 0 || S > 1000) return 0;
        int[] dp = new int[2001];
        dp[nums[0] + 1000] = 1;
        dp[-nums[0] + 1000] += 1;
        for (int i = 1; i < nums.length; i++) {
            int[] next = new int[2001];
            for (int sum = -1000; sum <= 1000; sum++) {
                if (dp[sum + 1000] > 0) {
                    next[nums[i] + sum + 1000] += dp[sum + 1000];
                    next[-nums[i] + sum + 1000] += dp[sum + 1000];
                }
            }
            dp = next;
        }
        return dp[S + 1000];
    }

    /**
     * 深度搜索dfs遍历　每次dfs两种情况 +nums[i]或者减去nums[i]
     */
    int result = 0;
    public int findTargetSumWays2(int[] nums, int S) {
        if (nums.length == 0) {
            return 0;
        }
        dfs(nums, S, 0, 0);
        return result;
    }

    public void dfs(int[] nums, int target, int calcVal, int pos) {
        if (pos == nums.length) {
            if (calcVal == target) {
                result++;
            }
            return;
        }
        dfs(nums, target, calcVal + nums[pos], pos + 1);
        dfs(nums, target, calcVal - nums[pos], pos + 1);
    }



}
