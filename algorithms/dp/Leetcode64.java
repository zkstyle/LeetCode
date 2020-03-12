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

    /*
    *   时间复杂度　空间复杂度皆为　O(M*N)
    *   声明dp数组　初始化边界数据
    *   转移方程为dp[i][j] = grid[i][j]+Math.min(dp[i-1][j],dp[i][j-1]);
    *   dp[i][j]表示到当前位置的权值　要么是从左边过来要么从上面过来　取一个相对小的值
     */
    public int minPathSum2(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dp =new int[m+1][n+1];
        //初始化边界条件
        for(int i =0;i<=m;i++){
            dp[i][0] = Integer.MAX_VALUE;
        }
        for(int i =2;i<=n;i++){
            dp[0][i] = Integer.MAX_VALUE;
        }
        for (int i = 1; i<= m;i++)
            for(int j = 1;j<=n;j++){
                //转移方程
                dp[i][j] = grid[i-1][j-1]+Math.min(dp[i-1][j],dp[i][j-1]);
            }
        return dp[m][n];
    }

    /**
     * 优化算法　将空间复杂度优化到常数级别　因为存放权值数组本身也可能当做dp数组的空间
     * 对于第一行只有从左边一条路可走　所以直接加上左边的dp[i-1[j]权值
     * 对于第一列只有从上边一条路可走　所以直接加上面的dp[i1[j-1]权值
     * 转移方程　grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
     */
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        if(m == 0 || n == 0){
            return 0;
        }
        //初始化第一行　第一列边界
        for (int i = 1; i < m; i++){
            grid[i][0] += grid[i - 1][0];
        }
        for (int j = 1; j < n; j++){
            grid[0][j] += grid[0][j - 1];
        }

        for (int i = 1; i < m; i++)
            for(int j = 1; j < n; j++){
                //转移方程
                grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
            }

        return grid[m - 1][n - 1];
    }
}
