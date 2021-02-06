package array;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: array
 * @Author: elvis
 * @CreateTime: 2021-02-02 20:01
 * @Description: 54. 螺旋矩阵
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * 示例 2：
 *
 *
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 *
 *
 * 提示：
 *
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 10
 * -100 <= matrix[i][j] <= 100
 */
public class Leetcode54 {

    /**
     * 用四个变量分别控制行列缩圈
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int a = 0, b = n - 1, c = 0, d = m - 1;
        List<Integer> ans = new ArrayList<>();
        while (ans.size() < n * m) {
            for (int i = a; i <= b && ans.size() < n * m; i++) ans.add(matrix[c][i]);
            c++;
            for (int i = c; i <= d && ans.size() < n * m; i++) ans.add(matrix[i][b]);
            b--;
            for (int i = b; i >= a && ans.size() < n * m; i--) ans.add(matrix[d][i]);
            d--;
            for (int i = d; i >= c && ans.size() < n * m; i--) ans.add(matrix[i][a]);
            a++;
        }
        return ans;
    }
}
