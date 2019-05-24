package com.elvis.leetcode.dp;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: com.elvis.leetcode.dp
 * @Author: Elvis
 * @CreateTime: 2019-05-18 11:15
 * Description:
 * 在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。
 *
 * 示例:
 *
 * 输入:
 *
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 *
 * 输出: 4
 */
public class Leetcode221 {

    public int maximalSquare(char[][] matrix) {
        /**
         dp[i][j]表示以第i行第j列为右下角所能构成的最大正方形边长, 则递推式为:
         dp[i][j] = 1 + min(dp[i-1][j-1], dp[i-1][j], dp[i][j-1]);
         **/
        int m = matrix.length;
        if(m < 1) return 0;
        int n = matrix[0].length;
        int max = 0;
        int[][] dp = new int[m+1][n+1];

        for(int i = 1; i <= m; ++i) {
            for(int j = 1; j <= n; ++j) {
                if(matrix[i-1][j-1] == '1') {
                    dp[i][j] = 1 + Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]));
                    max = Math.max(max, dp[i][j]);
                }
            }
        }

        return max*max;
    }
}
