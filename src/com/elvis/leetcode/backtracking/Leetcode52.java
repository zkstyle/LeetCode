package com.elvis.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

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

    public static void main(String[] args) {
        new Leetcode52().totalNQueens(5);
    }
}
