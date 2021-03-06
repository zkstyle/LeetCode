package array;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: com.elvis.leetcode.array
 * @Author: Elvis
 * @CreateTime: 2019-03-28 10:06
 * Description: 旋转图像
 */
public class Leetcode48 {
    /**
     * 官方解答
     * @param matrix
     */
    public void rotate2(int[][] matrix) {
        int length = matrix.length;
        //i代表正方形的起始位置,　i = 0即(0,0) i = 1即(1,1)
        for (int i = 0; i < length / 2; i++){
            //j代表当前正方形上的一条边上的一个点
            for (int j = i; j < length - i - 1; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[length - j - 1][i];
                matrix[length - j - 1][i] = matrix[length -i - 1][length - j - 1];
                matrix[length -i - 1][length - j - 1] = matrix[j][length - i - 1];
                matrix[j][length - i - 1] = temp;
            }
        }
    }

    /**
     * 首先将矩阵以中垂线对称折叠　再以斜对角线折叠　完成旋转目标
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        int len = matrix.length;
        int mid = (len - 1) / 2;
        for (int i = 0; i < len; i++)
            for (int j = 0; j <= mid; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][len - 1 - j];
                matrix[i][len - 1 - j] = temp;
            }

        for (int i = 0; i < len; i++)
            for (int j = 0; j < len - 1 - i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[len - 1 - j][len - 1 - i];
                matrix[len - 1 - j][len - 1 - i] = temp;
            }
    }

    //最直接的想法是先转置矩阵，然后翻转每一行。这个简单的方法已经能达到最优的时间复杂度O(N^2)
    public void rotate3(int[][] matrix) {
        int n = matrix.length;

        // transpose matrix
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int tmp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = tmp;
            }
        }
        // reverse each row
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][n - j - 1];
                matrix[i][n - j - 1] = tmp;
            }
        }
    }
}
