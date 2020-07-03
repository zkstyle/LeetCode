package array;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: array
 * @Author: elvis
 * @CreateTime: 2020-07-02 22:35
 * @Description: 单调数列
 * 如果数组是单调递增或单调递减的，那么它是单调的。
 *
 * 如果对于所有 i <= j，A[i] <= A[j]，那么数组 A 是单调递增的。 如果对于所有 i <= j，A[i]> = A[j]，那么数组 A 是单调递减的。
 *
 * 当给定的数组 A 是单调数组时返回 true，否则返回 false。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：[1,2,2,3]
 * 输出：true
 * 示例 2：
 *
 * 输入：[6,5,4,4]
 * 输出：true
 * 示例 3：
 *
 * 输入：[1,3,2]
 * 输出：false
 * 示例 4：
 *
 * 输入：[1,2,4,5]
 * 输出：true
 * 示例 5：
 *
 * 输入：[1,1,1]
 * 输出：true
 *  
 *
 * 提示：
 *
 * 1 <= A.length <= 50000
 * -100000 <= A[i] <= 100000
 */
public class Leetcode896 {

    /**
     * 用布尔变量　grow记录单调性
     * 在分别判断　单调递增　若A[i]>A[i+1]则返回false
     */
    public boolean isMonotonic(int[] A) {
        boolean grow = (A[0] <= A[A.length - 1]);
        for (int i = 0; i < A.length - 1; i++) {
            if (grow) {
                if (A[i] > A[i + 1]) {
                    return false;
                }
            } else {
                if (A[i] < A[i + 1]) {
                    return false;
                }
            }
        }
        return true;
    }
}
