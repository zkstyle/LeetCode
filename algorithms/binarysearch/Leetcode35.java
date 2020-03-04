package binarysearch;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: com.elvis.leetcode.array
 * @Author: Elvis
 * @CreateTime: 2019-03-15 09:02
 * Description:
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
 *
 * You may assume no duplicates in the array.
 *
 * Example 1:
 *
 * Input: [1,3,5,6], 5
 * Output: 2
 * Example 2:
 *
 * Input: [1,3,5,6], 2
 * Output: 1
 * Example 3:
 *
 * Input: [1,3,5,6], 7
 * Output: 4
 * Example 4:
 *
 * Input: [1,3,5,6], 0
 * Output: 0
 */
public class Leetcode35 {

    /**
     * 典型的二分法题目　搜索核心在于如何处理边界条件
     * 首先while条件应该是<= 这样最后一次处理应该是下面两种情况
     * １　left==right 且nums[left] < target 最后left = mid + 1 left >right 且刚好是应当插入的位置
     * 2  left==right 且nums[left] > target 最后right = mid - 1 left > right 且left刚好是插入的位置
     * 故若查找不到　返回left 或者right+1
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert(int[] nums, int target) {
        if (nums.length == 0) return 0;
        int left =0 ,right = nums.length-1;
        while(left<=right){
            int mid = left + (right-left)/2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] < target){
                left = mid+1;
            }else{
                right = mid -1;
            }
        }
        return left;
    }
}
