package dp;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: com.elvis.leetcode.dp
 * @Author: Elvis
 * @CreateTime: 2019-05-21 11:17
 * Description:
 */
public class Leetcode494 {

    public int findTargetSumWays(int[] nums, int s) {
        int sum = 0;
        for (int n : nums)
            sum += n;
        // 两种情况找不到结果，找得到的话就用subsetSum去找，证书和是(s + sum) >>> 1，也就是除以2
        return sum < s || (s + sum) % 2 > 0 ? 0 : subsetSum(nums, (s + sum) >>> 1);
    }

    public int subsetSum(int[] nums, int s) {
        int[] dp = new int[s + 1];
        dp[0] = 1;// 初始记录0的位置为1
        for (int n : nums)
            // 对每个元素，看看他现有能和别的元素相加得到哪些位置的数
            for (int i = s; i >= n; i--)
                dp[i] += dp[i - n];
        return dp[s];
    }

    class Solution {
        int result = 0;

        public int findTargetSumWays(int[] nums, int S) {
            if (nums.length == 0) {
                return 0;
            }
            dfs(nums, S, 0, 0);
            return result;
        }

        public void dfs(int[] nums, int target, int calcVal, int pos) {
            if (pos == nums.length) {
                if (calcVal == target) {
                    result++;
                }
                return;
            }
            dfs(nums, target, calcVal + nums[pos], pos + 1);
            dfs(nums, target, calcVal - nums[pos], pos + 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,1,1};
        new Leetcode494().findTargetSumWays(nums, 3);
    }
}
