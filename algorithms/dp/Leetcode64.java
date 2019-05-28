package dp;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: com.elvis.leetcode.dp
 * @Author: Elvis
 * @CreateTime: 2019-05-05 09:31
 * Description:
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 *
 * 说明：每次只能向下或者向右移动一步。
 *
 * 示例:
 *
 * 输入:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * 输出: 7
 * 解释: 因为路径 1→3→1→1→1 的总和最小。
 */
public class Leetcode64 {

    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        if(m == 0 || n == 0){
            return 0;
        }
        for (int i = 0; i < m; i++){
            if (i > 0){
                grid[i][0] += grid[i - 1][0];
            }
        }
        for (int j = 0; j < n; j++){
            if (j > 0){
                grid[0][j] += grid[0][j - 1];
            }
        }

        for (int i = 1; i < m; i++)
            for(int j = 1; j < n; j++){
                grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
            }

        return grid[m - 1][n - 1];

    }
}
