package com.elvis.leetcode.dp;

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

    // 动态规划
    // 状态定义 dp[i][j] 包含 dp[i][j]的最小值
    // 地推方程 dp[i][j] = min{dp[i + 1][j], dp[i + 1][j + 1] } + nums[i][j]
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.get(0) == null) return 0;
        int m = triangle.size(), n = triangle.size();
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = triangle.get(n - 1).get(i);
        for (int i = n - 2; i >= 0; i--) {
            List<Integer> cur = triangle.get(i);
            for(int j = 0; j < i + 1; j++) {
                a[j] = a[j] < a[j + 1] ? a[j]  : a[j + 1];
                a[j] += cur.get(j);
            }
        }
        return a[0];
    }
}
