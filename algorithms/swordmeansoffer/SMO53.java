package swordmeansoffer;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: swordmeansoffer
 * @Author: elvis
 * @CreateTime: 2020-05-04 08:35
 * @Description: 面试题53 - II. 0～n-1中缺失的数字
 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。
 *
 * 在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。　
 *
 * 示例 1:
 *
 * 输入: [0,1,3]
 * 输出: 2
 * 示例 2:
 *
 * 输入: [0,1,2,3,4,5,6,7,9]
 * 输出: 8
 *
 *
 * 限制：
 *
 * 1 <= 数组长度 <= 10000
 */
public class SMO53 {

    /**
     * 异或运算　i^i==0 这样可以得出确实的数字
     */
    public int missingNumber(int[] nums) {
        int n = nums.length, sum = 0;
        for (int i = 0; i < n; i++) {
            sum ^= i ^ (nums[i]);
        }
        return sum ^ n;
    }
}
