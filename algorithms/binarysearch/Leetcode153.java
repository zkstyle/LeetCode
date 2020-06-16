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

    /**
     * 旋转排序数组 nums可以被拆分为 2 个排序数组 nums1 , nums2 ，
     * 并且 nums1任一元素 >= nums2任一元素；因此，考虑二分法寻找此两数组的分界点 nums[i] (即第 2 个数组的首个元素)。
     * 设置 left, right 指针在 nums数组两端，mid为每次二分的中点：
     * 当 nums[mid] > nums[right]时，mid 一定在第 1 个排序数组中，ii 一定满足 mid < i <= right，因此执行 left = mid + 1；
     * 当 nums[mid] < nums[right] 时，mid一定在第 2 个排序数组中，ii 一定满足 left < i <= mid，因此执行 right = mid；
     **/
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] > nums[high]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return nums[low];
    }
}
