package array;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: com.elvis.leetcode.array
 * @Author: Elvis
 * @CreateTime: 2019-03-15 09:01
 * Description:
 * Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
 *
 * Your algorithm's runtime complexity must be in the order of O(log n).
 *
 * If the target is not found in the array, return [-1, -1].
 *
 * Example 1:
 *
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 * Example 2:
 *
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 */
public class Leetcode34 {

    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};
        int low = 0, high = nums.length - 1, mid;
        while (low <= high){
            mid = (low + high) / 2;
            if (nums[mid] == target){
                int tmp = mid;
                while (mid > -1 && nums[mid] == target){
                    result[0] = mid--;
                }
                while (tmp < nums.length && nums[tmp] == target){
                    result[1] = tmp++;
                }
                return result;
            }else if (nums[mid] > target){
                high = mid - 1;
            }else {
                low = mid + 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1};
        new Leetcode34().searchRange(nums,1);
    }
}
