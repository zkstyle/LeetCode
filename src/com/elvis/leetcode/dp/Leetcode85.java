package com.elvis.leetcode.dp;

import java.util.Arrays;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: com.elvis.leetcode.dp
 * @Author: Elvis
 * @CreateTime: 2019-05-05 10:05
 * Description:
 * 给定一个仅包含 0 和 1 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
 *
 * 示例:
 *
 * 输入:
 * [
 *   ["1","0","1","0","0"],
 *   ["1","0","1","1","1"],
 *   ["1","1","1","1","1"],
 *   ["1","0","0","1","0"]
 * ]
 * 输出: 6
 */
public class Leetcode85 {

        public  int maximalRectangle(char[][] matrix) {
            if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
                return 0;
            int m = matrix.length, n = matrix[0].length;
            int[] left = new int[n], right = new int[n], height = new int[n];
            Arrays.fill(right, n);

            int max = 0;
            for (int i = 0; i < m; i++) {
                int curLeft = 0;
                for (int j = 0; j < n; j++) {
                    if (matrix[i][j] == '1') {
                        height[j]++;
                        left[j] = Math.max(left[j], curLeft);
                    } else {
                        height[j] = 0;
                        left[j] = 0;
                        curLeft = j + 1;
                    }
                }

                int curRight = n;
                for (int j = n-1; j >= 0; j--) {
                    if (matrix[i][j] == '1') {
                        right[j] = Math.min(right[j], curRight);
                    } else {
                        right[j] = n;
                        curRight = j;
                    }
                }

                for (int j = 0; j < n; j++) {
                    max = Math.max(max, (right[j] - left[j]) * height[j]);
                }
            }

            return max;
        }

}
