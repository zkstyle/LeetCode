package array;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: array
 * @Author: elvis
 * @CreateTime: 2021-02-05 22:27
 * @Description: 74. 搜索二维矩阵
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 *
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 *
 *
 * 示例 1：
 *
 *
 * 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
 * 输出：true
 * 示例 2：
 *
 *
 * 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
 * 输出：false
 *
 *
 * 提示：
 *
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 100
 * -104 <= matrix[i][j], target <= 104
 */
public class Leetcode74 {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) {
            return false;
        }
        //行数
        int row = matrix.length;
        //列数
        int col = matrix[0].length;
        int left = 0;
        //行数乘列数 - 1，右指针
        int right = row * col - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            //将一维坐标变为二维坐标
            int rownum = mid / col;
            int colnum = mid % col;
            if (matrix[rownum][colnum] == target) {
                return true;
            } else if (matrix[rownum][colnum] > target) {
                right = mid - 1;
            } else if (matrix[rownum][colnum] < target) {
                left = mid + 1;
            }
        }
        return false;
    }

}
