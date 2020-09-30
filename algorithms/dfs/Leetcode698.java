package dfs;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: dfs
 * @Author: elvis
 * @CreateTime: 2020-09-30 14:38
 * @Description: 划分等和子集
 * 给定一个整数数组  nums 和一个正整数 k，找出是否有可能把这个数组分成 k 个非空子集，其总和都相等。
 *
 * 示例 1：
 *
 * 输入： nums = [4, 3, 2, 3, 5, 2, 1], k = 4
 * 输出： True
 * 说明： 有可能将其分成 4 个子集（5），（1,4），（2,3），（2,3）等于总和。
 *  
 *
 * 提示：
 *
 * 1 <= k <= len(nums) <= 16
 * 0 < nums[i] < 10000
 */
public class Leetcode698 {

    public boolean canPartitionKSubsets(int[] nums, int k) {
        // 注意nums[i] > 0
        int sum = 0, maxNum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (maxNum < nums[i]) maxNum = nums[i];
        }
        if (sum % k != 0 || maxNum > sum/k) return false;
        return dfs(nums, k, sum/k, 0, 0, new boolean[nums.length]);
    }

    /**
     * 深度搜索　首先求和　判断是否可以划分为k份　或者最大的数是否大于均值
     * 若cur==target　说明找到了一份子集　继续搜索　used记录当前元素是否已经被使用
     * @param nums　给定数组
     * @param k　　划分份数
     * @param target　均值
     * @param cur　当前和
     * @param start　当前搜索下标起始位置
     * @param used　数据是否已经访问
     * @return 布尔
     */
    private boolean dfs(int[] nums, int k, int target, int cur, int start, boolean[] used) {
        // 返回条件
        if (k == 0) return true;
        if (cur == target) {
            // 构建下一个集合
            return dfs(nums, k-1, target, 0, 0, used);
        }
        for (int i = start; i < nums.length; i++) {
            if (!used[i] && cur+nums[i] <= target) {
                used[i] = true;
                if (dfs(nums, k, target, cur+nums[i], i+1, used)) return true;
                used[i] = false;
            }
        }
        return false;
    }
}
