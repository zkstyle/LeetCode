package array;

import java.util.HashSet;
import java.util.Set;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: com.elvis.leetcode.array
 * @Author: Elvis
 * @CreateTime: 2019-03-19 13:15
 * Description:
 * 给定一个 m x n 的矩阵，如果一个元素为 0，则将其所在行和列的所有元素都设为 0。请使用原地算法。
 *
 * 示例 1:
 *
 * 输入:
 * [
 *   [1,1,1],
 *   [1,0,1],
 *   [1,1,1]
 * ]
 * 输出:
 * [
 *   [1,0,1],
 *   [0,0,0],
 *   [1,0,1]
 * ]
 * 示例 2:
 *
 * 输入:
 * [
 *   [0,1,2,0],
 *   [3,4,5,2],
 *   [1,3,1,5]
 * ]
 * 输出:
 * [
 *   [0,0,0,0],
 *   [0,4,5,0],
 *   [0,3,1,0]
 * ]
 * 进阶:
 *
 * 一个直接的解决方案是使用  O(mn) 的额外空间，但这并不是一个好的解决方案。
 * 一个简单的改进方案是使用 O(m + n) 的额外空间，但这仍然不是最好的解决方案。
 * 你能想出一个常数空间的解决方案吗？
 */
public class Leetcode73 {

    /**
     * 方法 1：额外存储空间方法
     * 如果矩阵中任意一个格子有零我们就记录下它的行号和列号，这些行和列的所有格子在下一轮中全部赋为零。
     *
     * 算法
     *
     * 我们扫描一遍原始矩阵，找到所有为零的元素。
     * 如果我们找到 [i, j] 的元素值为零，我们需要记录下行号 i 和列号 j。
     * 用两个 sets ，一个记录行信息一个记录列信息。
     * 最后，我们迭代原始矩阵，对于每个格子检查行 r 和列 c 是否被标记过，如果是就将矩阵格子的值设为 0。
     *
     */
    public void setZeroes(int[][] matrix) {
        int R = matrix.length;
        int C = matrix[0].length;
        Set<Integer> rows = new HashSet<Integer>();
        Set<Integer> cols = new HashSet<Integer>();

        // Essentially, we mark the rows and columns that are to be made zero
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (matrix[i][j] == 0) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }

        // Iterate over the array once again and using the rows and cols sets, update the elements.
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (rows.contains(i) || cols.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }
    }


    /**
     * 时间复杂度O(M*N) 空间复杂度O(1)
     * 算法：　遍历整个矩阵，如果 matrix[i][j] == 0 就将第 i 行和第 j 列的第一个元素标记。
     * 然后，从第二行第二列的元素开始遍历，如果第 r 行或者第 c 列被标记了，那么就将 matrix[r][c] 设为 0。这里第一行和第一列的作用就相当于方法一中的 row_set 和 column_set 。
     * 然后我们检查是否 matrix[0][0] == 0 ，如果是则赋值第一行的元素为零。
     * 然后检查第一列是否被标记，如果是则赋值第一列的元素为零。
     * @param matrix
     */
    public void setZeroes2(int[][] matrix) {
        if (matrix.length == 0) {
            return;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;
        //分别检查第一行与第一列是否存在0 存在则最后将第一行或第一列需要置为）
        boolean firstRowAllZero = false;
        boolean firstColumnAllZero = false;
        //检查第一行是否存在0
        for (int i = 0; i < cols; i++) {
            if (matrix[0][i] == 0) {
                firstRowAllZero = true;
                break;
            }
        }

        //检查第一列是否存在0
        for (int i = 0; i < rows; i++) {
            if (matrix[i][0] == 0) {
                firstColumnAllZero = true;
                break;
            }
        }
        //从第二行第二列的元素开始遍历 将行列起始位置置为0
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        /**
         *以下两个for循环分别根据行列头位置　将对应位置元素置为0
         */
        for (int i = 1; i < rows; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 1; j < cols; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        for (int i = 1; i < cols; i++) {
            if (matrix[0][i] == 0) {
                for (int j = 1; j < rows; j++) {
                    matrix[j][i] = 0;
                }
            }
        }
        //检查第一行第一列是否需要置为0
        if (firstRowAllZero) {
            for (int i = 0; i < cols; i++) {
                matrix[0][i] = 0;
            }
        }

        if (firstColumnAllZero) {
            for (int i = 0; i < rows; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
