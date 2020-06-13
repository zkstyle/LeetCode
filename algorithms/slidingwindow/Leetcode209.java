package slidingwindow;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: doublepointer
 * @Author: elvis
 * @CreateTime: 2020-06-09 09:28
 * @Description: 长度最小的子数组
 * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组，并返回其长度。如果不存在符合条件的连续子数组，返回 0。
 *
 * 示例: 
 *
 * 输入: s = 7, nums = [2,3,1,2,4,3]
 * 输出: 2
 * 解释: 子数组 [4,3] 是该条件下的长度最小的连续子数组。
 * 进阶:
 *
 * 如果你已经完成了O(n) 时间复杂度的解法, 请尝试 O(n log n) 时间复杂度的解法。
 */
public class Leetcode209 {

    /**
     * 双指针法+滑动窗口
     * left固定位置　移动right 直到满足sum>=s 这是以left为左侧窗口的最小子数组
     * 然后移动left　缩小窗口　left++ 后找寻下一个left的最小子数组
     */
    public int minSubArrayLen(int s, int[] nums) {
        int ret = Integer.MAX_VALUE;
        for (int left = 0, right = 0, sum = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum >= s) {
                ret = Math.min(right - left + 1, ret);
                sum -= nums[left++];
            }
        }
        return ret == Integer.MAX_VALUE ? 0 : ret;
    }


}
