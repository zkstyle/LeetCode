package array;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: array
 * @Author: elvis
 * @CreateTime: 2020-06-30 17:21
 * @Description: 最大子数组平均和
 * 给定 n 个整数，找出平均数最大且长度为 k 的连续子数组，并输出该最大平均数。
 *
 * 示例 1:
 *
 * 输入: [1,12,-5,-6,50,3], k = 4
 * 输出: 12.75
 * 解释: 最大平均数 (12-5-6+50)/4 = 51/4 = 12.75
 *  
 *
 * 注意:
 *
 * 1 <= k <= n <= 30,000。
 * 所给数据范围 [-10,000，10,000]。
 */
public class Leetcode643 {

    /**
     * 通过前缀和计算任意一个区间数字之和　快速便捷　减少重复计算
     */
    public double findMaxAverage(int[] nums, int k) {
        if (nums.length < k) return 0d;
        for (int i = 1; i < nums.length; i++) nums[i] += nums[i - 1];
        int ans = nums[k - 1];
        for (int i = k; i < nums.length; i++) {
            ans = Math.max(ans, nums[i] - nums[i - k]);
        }
        return (double) ans / k;
    }
}
