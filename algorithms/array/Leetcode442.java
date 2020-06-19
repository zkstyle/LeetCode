package array;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: array
 * @Author: elvis
 * @CreateTime: 2020-06-17 16:56
 * @Description: 数组中的重复数据
 * 给定一个整数数组 a，其中1 ≤ a[i] ≤ n （n为数组长度）, 其中有些元素出现两次而其他元素出现一次。
 *
 * 找到所有出现两次的元素。
 *
 * 你可以不用到任何额外空间并在O(n)时间复杂度内解决这个问题吗？
 *
 * 示例：
 *
 * 输入:
 * [4,3,2,7,8,2,3,1]
 *
 * 输出:
 * [2,3]
 */
public class Leetcode442 {

    /**
     * 解题思路　不太符合题意
     * 利用数组存储nums中元素出现次数
     */
    public List<Integer> findDuplicates(int[] nums) {
        int[] arr = new int[nums.length + 1];
        List<Integer> list = new ArrayList<Integer>();

        for (int num : nums) {
            if (arr[num] == 1) {
                list.add(num);
            } else {
                arr[num] = 1;
            }
        }
        return list;
    }


    /**
     * 找到数字i时，将位置i-1处的数字翻转为负数。
     * 如果位置i-1 上的数字已经为负，则i是出现两次的数字。
     */
    public List<Integer> findDuplicates2(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; ++i) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] < 0)
                res.add(Math.abs(index + 1));
            nums[index] = -nums[index];
        }
        return res;
    }
}
