package binarysearch;

import java.util.Arrays;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: binarysearch
 * @Author: elvis
 * @CreateTime: 2020-06-07 09:03
 * @Description: 寻找重复数
 */
public class Leetcode287 {

    /**
     * 先排序数组
     * 根据题意　若不存在重复数　则nums[m]==m+1
     * 所以二分查找　nums[m] < m+1 则重复数在左边
     * 否则重复数在右边
     */
    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (nums[m] < m + 1) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return nums[l];
    }
}
