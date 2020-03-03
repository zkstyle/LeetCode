package binarysearch;

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

    /**
     * 二分查找　因为是查找目标值且在有序数组中　故使用二分查找
     * 因为查找的值可能是一个范围　受回文串题目思路启发　查找到目标值后
     * 使用中心扩展向两侧扩展　找寻边界目标值
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (target == nums[mid]) {
                res[0] = mid;
                res[1] = mid;
                //中心扩展　找到第一个下标不是目标值　再给下标加1或减1
                while (res[0] >= 0 && target == nums[res[0]]) res[0]--;
                res[0]++;
                while (res[1] < nums.length && target == nums[res[1]]) res[1]++;
                res[1]--;
                return res;
            } else if (target > nums[mid]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return res;
    }

    /**
     * 法二思路是直接搜索目标值的边界下标值　分别调用二分方法查找两个下标
     * 不同于法一　[5,7,7,8,8,8,8,8,10] 找寻8 这种方法是找寻３，７
     * 如果找到的目标值下标不是3,7 就继续二分查找
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange2(int[] nums, int target) {
        if (nums == null) {
            return new int[]{-1, -1};
        }
        int firstTarget = getNumIndex(nums, target, true);
        int lastTarget = getNumIndex(nums, target, false);
        return new int[]{firstTarget, lastTarget};
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
                        //如果找到的目标值下标不是边界值下标 就继续二分查找
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

}
