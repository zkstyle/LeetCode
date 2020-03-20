package backtracking;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: com.elvis.leetcode.backtracking
 * @Author: Elvis
 * @CreateTime: 2019-05-07 08:46
 * Description:
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * 上图为 8 皇后问题的一种解法。
 *
 * 给定一个整数 n，返回 n 皇后不同的解决方案的数量。
 */
public class Leetcode52 {
    /**
     * 思路　回溯法　用rows数组检测每一列的放置冲突
     * 定义一个checkPerRow方法检测斜对角线的放置是否冲突　
     */
    private int total = 0;
    public int totalNQueens(int n) {
        int[] rows = new int[n];
        perRowQueen(0, rows, n);
        return total;
    }

    private void perRowQueen(int row, int[] rows, int n) {
        if (row >= n) {
            total++;
            return;
        }
        for (int i = 0; i < n; i++) {
            rows[row] = i;
            if (checkPerRow(row, rows)) {
                perRowQueen(row + 1, rows, n);
            }
        }
    }

    private boolean checkPerRow(int row, int[] rows) {
        for (int i = 0; i < row; i++) {
            if (rows[row] == rows[i] || Math.abs(row - i) == Math.abs(rows[row] - rows[i])) {
                return false;
            }
        }

        return true;
    }

    /**
     * #######################################################################
     * 法二：　深度遍历　回溯算法
     * 利用三个数组进行检测皇后放置冲突　cols检测列冲突　d1检测反斜对角冲突　d2检测检测斜对角冲突
     */

    private int ans = 0;

    public int totalNQueens2(int n) {
        dfs(0, n, new boolean[n], new boolean[2 * n - 1], new boolean[2 * n - 1]);
        return ans;
    }

    private void dfs(int row, int n, boolean[] cols, boolean[] d1, boolean[] d2) {
        if (row == n) {
            ans++;
            return;
        }
        for (int col = 0; col < n; col++) {
            int d1pos = row + col;
            int d2pos = col - row + n - 1;
            if (!cols[col] && !d1[d1pos] && !d2[d2pos]) {
                cols[col] = true;
                d1[d1pos] = true;
                d2[d2pos] = true;
                dfs(row + 1, n, cols, d1, d2);
                cols[col] = false;
                d1[d1pos] = false;
                d2[d2pos] = false;
            }
        }
    }
}
