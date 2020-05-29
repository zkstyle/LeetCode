package hashmap;

import java.util.*;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: com.elvis.leetcode.hashmap
 * @Author: Elvis
 * @CreateTime: 2018-12-21 19:51
 * Description:
 * 判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
 *
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 *
 *
 * 上图是一个部分填充的有效的数独。
 *
 * 数独部分空格内已填入了数字，空白格用 '.' 表示。
 *
 * 示例 1:
 *
 * 输入:
 * [
 *   ["5","3",".",".","7",".",".",".","."],
 *   ["6",".",".","1","9","5",".",".","."],
 *   [".","9","8",".",".",".",".","6","."],
 *   ["8",".",".",".","6",".",".",".","3"],
 *   ["4",".",".","8",".","3",".",".","1"],
 *   ["7",".",".",".","2",".",".",".","6"],
 *   [".","6",".",".",".",".","2","8","."],
 *   [".",".",".","4","1","9",".",".","5"],
 *   [".",".",".",".","8",".",".","7","9"]
 * ]
 * 输出: true
 * 示例 2:
 *
 * 输入:
 * [
 *   ["8","3",".",".","7",".",".",".","."],
 *   ["6",".",".","1","9","5",".",".","."],
 *   [".","9","8",".",".",".",".","6","."],
 *   ["8",".",".",".","6",".",".",".","3"],
 *   ["4",".",".","8",".","3",".",".","1"],
 *   ["7",".",".",".","2",".",".",".","6"],
 *   [".","6",".",".",".",".","2","8","."],
 *   [".",".",".","4","1","9",".",".","5"],
 *   [".",".",".",".","8",".",".","7","9"]
 * ]
 * 输出: false
 * 解释: 除了第一行的第一个数字从 5 改为 8 以外，空格内其他数字均与 示例1 相同。
 *      但由于位于左上角的 3x3 宫内有两个 8 存在, 因此这个数独是无效的。
 * 说明:
 *
 * 一个有效的数独（部分已被填充）不一定是可解的。
 * 只需要根据以上规则，验证已经填入的数字是否有效即可。
 * 给定数独序列只包含数字 1-9 和字符 '.' 。
 * 给定数独永远是 9x9 形式的。
 */
public class Leetcode36 {
    /**
     * 最优14ms
     */
    public boolean isValidSudoku(char[][] board) {
        int[] rows = new int[9];
        int[] cols = new int[9];
        int[] blocks = new int[9];
        for (int r = 0; r < 9; ++r) {
            for (int c = 0; c < 9; ++c) {
                if (board[r][c] != '.') {
                    int x = 1 << (board[r][c] - '1');
                    if ((rows[r] & x) > 0) return false;
                    rows[r] |= x;

                    if ((cols[c] & x) != 0) return false;
                    cols[c] |= x;

                    int i = (r / 3 * 3) + (c / 3);
                    if ((blocks[i] & x) != 0) return false;
                    blocks[i] |= x;
                }
            }
        }
        return true;
    }

    /**
     * 将行列以及该位置的数以特定格式保存到hashmap中
     * 然后每次判断是否存在
     * @param board
     * @return
     */
    public static boolean isValidSudokuPlusTwo(char[][] board) {
        /**
         * 判断方式：　所在九宫格是否有重复元素以及同行同列是否重复
         */
        HashSet<String> map = new HashSet(81 * 4);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                String x = "row" + String.valueOf(board[i][j]) + i;
                if (map.contains(x)) {
                    return false;
                }
                map.add(x);
                x =  "columns" + String.valueOf(board[i][j]) + j;
                if (map.contains(x)) {
                    return false;
                }
                map.add(x);

                x = "cell" + String.valueOf(board[i][j]) + ((i / 3) * 3 + j / 3);
                if (map.contains(x)) {
                    return false;
                }
                map.add(x);
            }
        }
        return true;
    }

}
