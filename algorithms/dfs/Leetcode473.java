package dfs;

import java.util.Arrays;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: dfs
 * @Author: Elvis
 * @CreateTime: 2019-07-13 11:21
 * Description:
 * 输入为小女孩拥有火柴的数目，每根火柴用其长度表示。输出即为是否能用所有的火柴拼成正方形。
 *
 * 示例 1:
 *
 * 输入: [1,1,2,2,2]
 * 输出: true
 *
 * 解释: 能拼成一个边长为2的正方形，每边两根火柴。
 * 示例 2:
 *
 * 输入: [3,3,3,3,4]
 * 输出: false
 *
 * 解释: 不能用所有火柴拼成一个正方形。
 */
public class Leetcode473 {
    public boolean makesquare(int[] nums) {
        if (nums.length < 4)
            return false;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % 4 != 0) {
            return false;
        }
        Arrays.sort(nums);
        for (int i = 0; i < 4; i++) {
            if (!search(nums, nums.length - 1, 0, sum / 4)) {
                return false;
            }
        }
        return true;
    }

    private boolean search(int[] nums, int start, int sum, int target) {
        if (start < 0 || sum > target)
            return false;
        for (int i = start; i >= 0; i--) {
            if (nums[i] == 0)
                continue;
            int temp = nums[i];
            nums[i] = 0;
            if (sum + temp == target || search(nums, i - 1, sum + temp, target))
                return true;
            nums[i] = temp;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {2,2,2,3,4,4,4,5,6};
        new Leetcode473().makesquare(nums);
    }
}
