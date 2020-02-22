package SwordMeansOffer;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: SwordMeansOffer
 * @Author: elvis
 * @CreateTime: 2020-02-22 10:42
 * @Description: 剑指Offer面试题03
 * 找出数组中重复的数字。
 *
 *
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 *
 * 示例 1：
 *
 * 输入：
 * [2, 3, 1, 0, 2, 5, 3]
 * 输出：2 或 3
 *  
 *
 * 限制：
 *
 * 2 <= n <= 100000
 */
public class SMO03 {
    public int findRepeatNumber(int[] nums) {
        int[] count = new int[nums.length];
        //以空间换时间　声明等长数组　统计各个数字个数　
        for (int n : nums){
            if (count[n] == 1) return n;
            count[n]++;
        }
        return 0;
    }
}
