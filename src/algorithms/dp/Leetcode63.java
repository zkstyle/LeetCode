package algorithms.dp;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: com.elvis.leetcode.dp
 * @Author: Elvis
 * @CreateTime: 2019-04-25 10:42
 * Description:
 */
public class Leetcode63 {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        // 初始化
        for (int i = 0; i < m; i ++) {
            // 碰到障碍物后边就不可达，默认为0
            if (obstacleGrid[i][0] == 1) {
                break;
            }
            dp[i][0] = 1;
        }

        for (int i = 0; i < n; i ++) {
            if (obstacleGrid[0][i] == 1) {
                break;
            }
            dp[0][i] = 1;
        }

        for (int i = 1; i < m; i ++) {
            for (int j = 1; j < n; j ++) {
                // 直接跳过障碍物就好了，这样障碍物的位置默认为0
                if (obstacleGrid[i][j] != 1) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        int[][] a = {{0,0,0},{0,1,0},{0,0,0}};
        new Leetcode63().uniquePathsWithObstacles(a);

    }
}
