package binarysearch;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: binarysearch
 * @Author: Elvis
 * @CreateTime: 2019-07-23 13:10
 * Description:
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 *
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 *
 * 请找出其中最小的元素。
 *
 * 你可以假设数组中不存在重复元素。
 *
 * 示例 1:
 *
 * 输入: [3,4,5,1,2]
 * 输出: 1
 * 示例 2:
 *
 * 输入: [4,5,6,7,0,1,2]
 * 输出: 0
 */
public class Leetcode153 {

    public int findMin(int[] nums) {
        /*
         * 不得不吐槽一句，题目明明说了在某点旋转，给的测试用例[1, 2, 3]什么意思，这是在哪点旋
         * 转的？
         */
        if (nums.length == 1 || nums[0] < nums[nums.length - 1]) {
            return nums[0];
        }
        return backTrace(nums, 0, nums.length - 1);
    }
    /*
     * 说下大概思路，找个点二分数组，其中必有一个数组最后一个元素小于第一个元素，这时我们求的最小
     * 值就在其中，递归即可。当然会有种特殊情况，就是恰好分出来的数组都是有序的，那就说明最小值就
     * 是后一个数组的第一个值。所以运气够好的话，一次二分就能找到了，这也是复杂度为什么不足lgn的
     * 原因。
     */
    private int backTrace(int[] nums, int start, int end) {
        int mid = (start + end) / 2;
        if (nums[start] > nums[mid]) {
            return backTrace(nums, start, mid);
        }
        if (nums[mid + 1] > nums[end]) {
            return backTrace(nums, mid + 1, end);
        }
        return nums[mid + 1];
    }

    class Solution {
        public int findMin(int[] nums) {
            int low = 0;
            int high = nums.length - 1;

            while (low < high) {
                int mid = low + (high - low)/2;
                if (nums[mid] > nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }

            return nums[low];
        }
    }
}
