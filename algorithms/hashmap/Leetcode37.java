package hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: com.elvis.leetcode.hashmap
 * @Author: Elvis
 * @CreateTime: 2018-12-25 20:37
 * Description:
 * 编写一个程序，通过已填充的空格来解决数独问题。
 *
 * 一个数独的解法需遵循如下规则：
 *
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 * 空白格用 '.' 表示。
 *
 * Note:
 *
 * 给定的数独序列只包含数字 1-9 和字符 '.' 。
 * 你可以假设给定的数独只有唯一解。
 * 给定数独永远是 9x9 形式的。
 */
public class Leetcode37 {

    public void solveSudokuPlus(char[][] board) {
        /**
         * 记录某行，某位数字是否已经被摆放
         */
        boolean[][] row = new boolean[9][10];
        /**
         * 记录某列，某位数字是否已经被摆放
         */
        boolean[][] col = new boolean[9][10];
        /**
         * 记录某 3x3 宫格内，某位数字是否已经被摆放
         */
        boolean[][] block = new boolean[9][10];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '0';
                    row[i][num] = true;
                    col[j][num] = true;
                    // blockIndex = i / 3 * 3 + j / 3，取整
                    block[i / 3 * 3 + j / 3][num] = true;
                }
            }
        }
        dfs(board, row, col, block, 0, 0);
    }

    private boolean dfs(char[][] board, boolean[][] row, boolean[][] col, boolean[][] block, int i, int j) {
        // 找寻空位置
        while (board[i][j] != '.') {
            if (++j >= 9) {
                i++;
                j = 0;
            }
            if (i >= 9) {
                return true;
            }
        }
        for (int num = 1; num <= 9; num++) {
            int blockIndex = i / 3 * 3 + j / 3;
            if (!row[i][num] && !col[j][num] && !block[blockIndex][num]) {
                // 递归
                board[i][j] = (char) ('0' + num);
                row[i][num] = true;
                col[j][num] = true;
                block[blockIndex][num] = true;
                if (dfs(board, row, col, block, i, j)) {
                    return true;
                } else {
                    // 回溯
                    row[i][num] = false;
                    col[j][num] = false;
                    block[blockIndex][num] = false;
                    board[i][j] = '.';
                }
            }
        }
        return false;
    }

    private void printBoard(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
    //=======================================================================================================

    /**
     * 等待回溯法学习
     * @param board
     */
    public void solveSudoku(char[][] board) {
        Map<Character, List<Integer[]>> map = new HashMap<>();

        int boardRow = board.length;
        int boardCol = board[0].length;
        for (int i = 0; i < boardRow; i++) {
            for (int j = 0; j < boardCol; j++) {
                if (Character.isDigit(board[i][j])){
                    Integer[] value = {i, j};
                    List<Integer[]> list = new ArrayList<>();
                    list.add(value);
                    map.put(board[i][j], list);

                }
            }
        }
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        Leetcode37 solution = new Leetcode37();
        solution.printBoard(board);
        solution.solveSudokuPlus(board);
        solution.printBoard(board);

    }
}
