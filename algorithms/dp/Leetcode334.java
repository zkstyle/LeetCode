package dp;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: dp
 * @Author: elvis
 * @CreateTime: 2020-09-28 23:21
 * @Description: 递增的三元子序列
 * 给定一个未排序的数组，判断这个数组中是否存在长度为 3 的递增子序列。
 *
 * 数学表达式如下:
 *
 * 如果存在这样的 i, j, k,  且满足 0 ≤ i < j < k ≤ n-1，
 * 使得 arr[i] < arr[j] < arr[k] ，返回 true ; 否则返回 false 。
 * 说明: 要求算法的时间复杂度为 O(n)，空间复杂度为 O(1) 。
 *
 * 示例 1:
 *
 * 输入: [1,2,3,4,5]
 * 输出: true
 * 示例 2:
 *
 * 输入: [5,4,3,2,1]
 * 输出: false
 */
public class Leetcode334 {

    public boolean increasingTriplet(int[] nums) {
        int n = nums.length;
        if (n < 3) return false;
        int[] dp = new int[n];
        dp[0] = 1;
        int max = 1;
        for (int i = 1; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            max = Math.max(dp[i], max);
            if (max >= 3) return true;
        }
        return false;
    }

    /**
     * 采用两个变量min1和min2分别记录已访问到的最小值和次小值，分别初始化为Integer.MAX_VALUE，
     * 当出现一个值大于次小值时，必然存在三个元素的递增子序列。内在逻辑：此时既然min2存在,在min2之前必然存在比min2小的min1,
     * 再加上访问到的比min2大的数nums[i]，可构成三元递增子序列。
     */
    public boolean increasingTriplet2(int[] nums) {
        int n = nums.length;
        if (n < 3) return false;
        int m1 = Integer.MAX_VALUE, m2 = Integer.MAX_VALUE;
        for (int a : nums) {
            if (m1 >= a) m1 = a;
            else if (m2 >= a) m2 = a;
            else return true;
        }
        return false;

    }
}
