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

    public void rotate(int[][] matrix) {
        int n = matrix.length;
        float translate = (n - 1) / 2.0f;
        int last;
        int col, row;
        for (int i = 0; i < n / 2; i++) { // 圈
            for (int j = i; j < n - i - 1; j++) { // 边
                last = matrix[i][j];
                row = i;
                col = j;
                for (int k = 0; k < 3; k++) { // 点
                    //  pre_point
                    int pre_col = row;
                    int pre_row = (int) (2 * translate - col);

                    matrix[row][col] = matrix[pre_row][pre_col];
                    row = pre_row;
                    col = pre_col;
                }
                matrix[row][col] = last;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        new Leetcode48().rotate(matrix);
    }
}
