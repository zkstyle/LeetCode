package dp;

import java.util.List;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: com.elvis.leetcode.dp
 * @Author: Elvis
 * @CreateTime: 2019-05-07 10:24
 * Description:
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 *
 * 例如，给定三角形：
 *
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 *
 * 说明：
 *
 * 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。
 */
public class Leetcode120 {

    /**
     * 自底向上动态规划思路　dp[i]表示由下一行dp结果结合当前行　获得的最小路径和　i指代列数
     * dp[i] = Math.min(dp[i],dp[i-1])+ triangle.get(level).get(i)
     * 这里左边dp[i]所在行数比右边dp[i] dp[i+1]行数小1
     * 每一行都更新dp[i] 长度也从row-1 ~ 0
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        int row = triangle.size();
        int[] dp = new int[row + 1];
        for (int level = row - 1; level >= 0; level--) {
            for (int i = 0; i <= level; i++) {   //第i行有i+1个数字
                dp[i] = Math.min(dp[i], dp[i + 1]) + triangle.get(level).get(i);
            }
        }
        return dp[0];
    }

}
