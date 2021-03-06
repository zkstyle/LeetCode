package math;

import java.util.Arrays;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: math
 * @Author: elvis
 * @CreateTime: 2020-06-19 22:01
 * @Description: 最小移动次数使数组元素相等
 * 给定一个长度为 n 的非空整数数组，找到让数组所有元素相等的最小移动次数。每次移动将会使 n - 1 个元素增加 1。
 *
 *  
 *
 * 示例:
 *
 * 输入:
 * [1,2,3]
 *
 * 输出:
 * 3
 *
 * 解释:
 * 只需要3次移动（注意每次移动会增加两个元素的值）：
 *
 * [1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]
 */
public class Leetcode453 {

    /**
     *n-1个数加1相当于第n个数减1 所以让所有数减至最小值
     */
    public int minMoves(int[] nums) {
        int moves = 0, min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            moves += nums[i];
            min = Math.min(min, nums[i]);
        }
        return moves - min * nums.length;
    }

    /**
     * 如果对数组进行排序得到有序数列 aa，可以有效地简化问题。考虑有序数组 aa，我们不考虑整个问题，而是将问题分解。假设，
     *
     * 直到 i-1 位置的元素都已经相等，我们只需要考虑 i 位的元素，将差值 diff=a[i]-a[i-1] 加到总移动次数上，使得第 i 位也相等。
     *
     * moves=moves+diff。
     *
     * 但当我们想要继续这一步时，a[i] 之后的元素也会被增加 diff，亦即 a[j]=a[j]+diff，其中 j>i。
     *
     * 但当实现本方法时，我们不需要对这样的 a[j] 进行增加。相反，我们把 moves 的数量增加到当前元素（a[i]）中，a'[i]=a[i]+moves。
     *
     * 简而言之，我们对数列进行排序，一直更新 moves 以使得直到当前的元素相等，而不改变除了当前元素之外的元素。在整个数组扫描完毕后,moves 即为答案。
     */
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int moves = 0;
        for (int i = 1; i < nums.length; i++) {
            int diff = (moves + nums[i]) - nums[i - 1];
            nums[i] += moves;
            moves += diff;
        }
        return moves;
    }
}
