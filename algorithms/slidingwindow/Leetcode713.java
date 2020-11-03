package slidingwindow;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: slidingwindow
 * @Author: elvis
 * @CreateTime: 2020-09-22 23:20
 * @Description: 乘积小于K的子数组
 *
 * 给定一个正整数数组 nums。
 *
 * 找出该数组内乘积小于 k 的连续的子数组的个数。
 *
 * 示例 1:
 *
 * 输入: nums = [10,5,2,6], k = 100
 * 输出: 8
 * 解释: 8个乘积小于100的子数组分别为: [10], [5], [2], [6], [10,5], [5,2], [2,6], [5,2,6]。
 * 需要注意的是 [10,5,2] 并不是乘积小于100的子数组。
 *
 * 说明:
 *
 *     0 < nums.length <= 50000
 *     0 < nums[i] < 1000
 *     0 <= k < 10^6
 */
public class Leetcode713 {

    /**
     * 类似于滑动窗口的双指针　先将right指针向右移动　若连续乘积大于等于k　则将left++
     */
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return 0;
        int left = 0, prod = 1, ans = 0;
        for (int right = 0; right < nums.length; right++) {
            prod *= nums[right];
            while (prod >= k) prod /= nums[left++];
            ans += right - left + 1;
        }
        return ans;
    }
}
