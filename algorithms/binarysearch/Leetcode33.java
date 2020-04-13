package binarysearch;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: com.elvis.leetcode.binarysearch
 * @Author: Elvis
 * @CreateTime: 2019-03-12 08:49
 * Description:
 *Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 *
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 *
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 *
 * You may assume no duplicate exists in the array.
 *
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * Example 1:
 *
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 * Example 2:
 *
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 */
public class Leetcode33 {

    /**
     * 简单暴力搜索　时间复杂度O(N)
     * 虽然不符合题意　但是在测试用例较少的情况　运行时间最短
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        for(int i=0;i<nums.length;i++)
            if(nums[i]==target)
                return i;
        return -1;
    }

    /**
     * 二分查找　利用nums[mid],nums[high]大小关系判断mid位于左右的哪部分
     * 首先分三种情况　1.nums[mid] == target
     * 在nums[mid] ！= target时　判断mid在旋转后的数组哪一侧　ai ai+1 ... an | a0 a1 ... ai-1
     *              2. nums[mid] < nums[high] 显然是在右侧　因为左侧的数都大于 nums[high]
     *              3. nums[mid] >= nums[low] 在左侧　因为右侧的数都小于nums[low]
     *              对于2,3两种情况　分别讨论左右两侧
     * @param nums
     * @param target
     * @return
     */
    public int search2(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target == nums[mid]) {
                return mid;
            } else if (nums[right] > nums[mid]) {
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                if (nums[mid] > target && target >= nums[left]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return -1;
    }

}
