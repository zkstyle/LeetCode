package bit;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: math
 * @Author: Elvis
 * @CreateTime: 2019-08-16 10:38
 * Description:
 * 给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。
 *
 * 示例 1:
 *
 * 输入: [3,0,1]
 * 输出: 2
 * 示例 2:
 *
 * 输入: [9,6,4,2,3,5,7,0,1]
 * 输出: 8
 * 说明:
 * 你的算法应具有线性时间复杂度。你能否仅使用额外常数空间来实现?
 */
public class Leetcode268 {

    /**
     * 数学计算方法　用总和减去每一个数　最后得到的数一定是缺失的数
     */
    public int missingNumber1(int[] nums) {
        int n = nums.length;
        int res = n * (n + 1) / 2;
        for (int x : nums) res -= x;
        return res;
    }

    /**
     * 异或运算　有数字 nums[0~n] 缺失其中一个数　
     * 那么这n个数与下标0~n异或　相同的数相互抵消归零　最后剩下的就是缺失的数
     */
    public int missingNumber(int[] nums) {
        int res = nums.length;
        for (int i = 0; i < nums.length; i++){
            res ^= i ^ nums[i];
        }
        return res;
    }
}
