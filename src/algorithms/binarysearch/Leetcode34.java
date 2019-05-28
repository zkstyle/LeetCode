package algorithms.binarysearch;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: com.elvis.leetcode.binarysearch
 * @Author: Elvis
 * @CreateTime: 2019-04-15 13:58
 * Description:
 * 在排序数组中查找元素的第一个和最后一个位置
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 *
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 * 如果数组中不存在目标值，返回 [-1, -1]。
 *
 * 示例 1:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 * 示例 2:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: [-1,-1]
 */
public class Leetcode34 {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null) {
            return new int[]{ -1, -1 };
        }
        int firstTarget = getNumIndex(nums, target, true);
        int lastTarget = getNumIndex(nums, target, false);
        return new int[]{ firstTarget, lastTarget };
    }

    public int getNumIndex(int[] nums, int target, boolean small) {
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                if (small == true) {
                    if (mid == 0 || (mid > 0 && nums[mid - 1] != target)) {
                        return mid;
                    } else {
                        right = mid - 1;
                    }
                } else {
                    if (mid == nums.length - 1 || (mid < nums.length - 1 && nums[mid + 1] != target)) {
                        return mid;
                    } else {
                        left = mid + 1;
                    }
                }
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        new Leetcode34().searchRange(nums, 8);
    }
}
