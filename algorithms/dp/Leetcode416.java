package dp;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: dp
 * @Author: elvis
 * @CreateTime: 2020-10-18 22:58
 * @Description: 分割等和子集
 * 给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 *
 * 注意:
 *
 * 每个数组中的元素不会超过 100
 * 数组的大小不会超过 200
 * 示例 1:
 *
 * 输入: [1, 5, 11, 5]
 *
 * 输出: true
 *
 * 解释: 数组可以分割成 [1, 5, 5] 和 [11].
 *
 *
 * 示例 2:
 *
 * 输入: [1, 2, 3, 5]
 *
 * 输出: false
 *
 * 解释: 数组不能分割成两个元素和相等的子集.
 */
public class Leetcode416 {

    /**
     * dp[j]代表当前下标位置是否可达　对于每一个元素　从sum/2-nums[i]判断到0 每次更新哪些值是可达的
     */
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        int t = sum / 2;
        if (sum % 2 != 0)
            return false;
        boolean[] dp = new boolean[t + 1];
        dp[0] = true;
        for (int i = 0; i < n; i++) {
            for (int j = t; j >= nums[i]; j--) {
                dp[j] = dp[j - nums[i]] || dp[j];
            }
        }

        return dp[t];
    }
}
