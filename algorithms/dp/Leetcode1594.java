package dp;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: dp
 * @Author: elvis
 * @CreateTime: 2020-09-25 14:08
 * @Description: 矩阵中最大非负积
 * 给你一个大小为 rows x cols 的矩阵 grid 。最初，你位于左上角 (0, 0) ，每一步，你可以在矩阵中 向右 或 向下 移动。
 *
 * 在从左上角 (0, 0) 开始到右下角 (rows - 1, cols - 1) 结束的所有路径中，找出具有 最大非负积 的路径。路径的积是沿路径访问的单元格中所有整数的乘积。
 *
 * 返回 最大非负积 对 109 + 7 取余 的结果。如果最大积为负数，则返回 -1 。
 *
 * 注意，取余是在得到最大积之后执行的。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：grid = [[-1,-2,-3],
 *              [-2,-3,-3],
 *              [-3,-3,-2]]
 * 输出：-1
 * 解释：从 (0, 0) 到 (2, 2) 的路径中无法得到非负积，所以返回 -1
 * 示例 2：
 *
 * 输入：grid = [[1,-2,1],
 *              [1,-2,1],
 *              [3,-4,1]]
 * 输出：8
 * 解释：最大非负积对应的路径已经用粗体标出 (1 * 1 * -2 * -4 * 1 = 8)
 * 示例 3：
 *
 * 输入：grid = [[1, 3],
 *              [0,-4]]
 * 输出：0
 * 解释：最大非负积对应的路径已经用粗体标出 (1 * 0 * -4 = 0)
 * 示例 4：
 *
 * 输入：grid = [[ 1, 4,4,0],
 *              [-2, 0,0,1],
 *              [ 1,-1,1,1]]
 * 输出：2
 * 解释：最大非负积对应的路径已经用粗体标出 (1 * -2 * 1 * -1 * 1 * 1 = 2)
 *  
 *
 * 提示：
 *
 * 1 <= rows, cols <= 15
 * -4 <= grid[i][j] <= 4
 */
public class Leetcode1594 {

    int mod=1000000007;

    /**
     *
     * @param grid
     * @return
     */
    public int maxProductPath(int[][] grid) {
        int row=grid.length;
        int col=grid[0].length;
        long[][][] dp=new long[row][col][2];

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(i==0||j==0){
                    if(i==0&&j==0){
                        dp[i][j][0]= dp[i][j][1]=grid[i][j];
                        continue;
                    } else if(i==0){
                        dp[i][j][0]= dp[i][j][1]=grid[i][j]*dp[i][j-1][0];
                        continue;
                    }else{
                        dp[i][j][0]= dp[i][j][1]=grid[i][j]*dp[i-1][j][0];
                        continue;
                    }
                }
                long a=dp[i-1][j][0]*grid[i][j];
                long b=dp[i][j-1][0]*grid[i][j];
                long c=dp[i-1][j][1]*grid[i][j];
                long d=dp[i][j-1][1]*grid[i][j];
                dp[i][j][0]=Math.max(Math.max(a,b),Math.max(c,d));
                dp[i][j][1]=Math.min(Math.min(a,b),Math.min(c,d));

            }
        }

        return dp[row-1][col-1][0]<0?-1:(int)(dp[row-1][col-1][0]%mod);
    }
}
