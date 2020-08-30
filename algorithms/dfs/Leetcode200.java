package dfs;

import java.util.Scanner;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: dfs
 * @Author: Elvis
 * @CreateTime: 2019-08-04 08:41
 * Description:
 * 给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。
 *
 * 示例 1:
 *
 * 输入:
 * 11110
 * 11010
 * 11000
 * 00000
 *
 * 输出: 1
 * 示例 2:
 *
 * 输入:
 * 11000
 * 11000
 * 00100
 * 00011
 *
 * 输出: 3
 *
 */
public class Leetcode200 {

    /**
     * dfs 深度搜索　首先对于每一个字符进行遍历
     * 若grid[i][j]=='1' count++ 并且dfs修改所有相邻的grid[i][j]='0'
     * @param grid
     * @return
     */
    public static int numIslands(char[][] grid) {
        int cnt = 0;
        if (grid == null || grid.length == 0) return 0;
        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    cnt++;
                }
            }
        return cnt;
    }

    private static void dfs(char[][] grid, int i, int j) {
        if (i >= 0 && j >= 0 && i < grid.length && j < grid[0].length && grid[i][j] == '1') {
            grid[i][j] = '0';
            dfs(grid, i - 1, j);
            dfs(grid, i + 1, j);
            dfs(grid, i, j + 1);
            dfs(grid, i, j - 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String para = sc.nextLine();
        String[] s = para.split(",");
        int m = s.length;
        int n = s[0].length();
        char[][] grid = new char[m][n];
        for (int i = 0; i < m; i++) {
            grid[i] = s[i].toCharArray();
        }
        int ret = numIslands(grid);
        System.out.println(ret);
    }


}
