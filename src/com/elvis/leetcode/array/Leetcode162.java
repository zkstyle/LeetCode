package com.elvis.leetcode.array;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: com.elvis.leetcode.array
 * @Author: Elvis
 * @CreateTime: 2019-05-20 10:33
 * Description:
 * 峰值元素是指其值大于左右相邻值的元素。
 *
 * 给定一个输入数组 nums，其中 nums[i] ≠ nums[i+1]，找到峰值元素并返回其索引。
 *
 * 数组可能包含多个峰值，在这种情况下，返回任何一个峰值所在位置即可。
 *
 * 你可以假设 nums[-1] = nums[n] = -∞。
 *
 * 示例 1:
 *
 * 输入: nums = [1,2,3,1]
 * 输出: 2
 * 解释: 3 是峰值元素，你的函数应该返回其索引 2。
 * 示例 2:
 *
 * 输入: nums = [1,2,1,3,5,6,4]
 * 输出: 1 或 5
 * 解释: 你的函数可以返回索引 1，其峰值元素为 2；
 *      或者返回索引 5， 其峰值元素为 6。
 */
public class Leetcode162 {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        if (n == 1) return 0;
        if (nums[0] > nums[1]) return 0;
        if (nums[n - 1] > nums[n - 2]) return n - 1;
        // n >= 3
        int low = 0, high = n - 1, mid;
        while (low <= high){
            mid = (low + high) / 2;
            if (mid == 0) mid++;
            if (mid == n - 1) mid--;
            if (( nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1])){
                return mid;
            } else if (nums[mid] < nums[mid - 1]){
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    class solution{
        public int findPeakElement(int[] nums) {
            int left = 0, right = nums.length - 1;
            while (left < right) {
                int mid = (left + right) / 2;
                if (nums[mid+1] > nums[mid]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            return left;
        }
    }

    public static void main(String[] args) {
        int[] nums = {3,4,3,2,1};
        new Leetcode162().findPeakElement(nums);
    }
}
