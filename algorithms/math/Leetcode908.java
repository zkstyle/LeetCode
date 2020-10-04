package math;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: math
 * @Author: elvis
 * @CreateTime: 2020-10-04 22:01
 * @Description: 最小差值 I
 * 给你一个整数数组 A，请你给数组中的每个元素 A[i] 都加上一个任意数字 x （-K <= x <= K），从而得到一个新数组 B 。
 *
 * 返回数组 B 的最大值和最小值之间可能存在的最小差值。
 *
 *
 *
 * 示例 1：
 *
 * 输入：A = [1], K = 0
 * 输出：0
 * 解释：B = [1]
 * 示例 2：
 *
 * 输入：A = [0,10], K = 2
 * 输出：6
 * 解释：B = [2,8]
 * 示例 3：
 *
 * 输入：A = [1,3,6], K = 3
 * 输出：0
 * 解释：B = [3,3,3] 或 B = [4,4,4]
 *
 *
 * 提示：
 *
 * 1 <= A.length <= 10000
 * 0 <= A[i] <= 10000
 * 0 <= K <= 10000
 */
public class Leetcode908 {

    /**
     * 需要最小化max(B)-min(B)，则应使原数组A中最大值和最小值尽量接近。仔细分析后，容易知道若max(A)与min(A)的差值大于2K，
     * 则在变换中应使max(A)+(-K),min(A)+K，此时结果为max(A)-min(A)-2K。若差值小于等于2*K,则可使最终结果为0。
     */
    public int smallestRangeI(int[] A, int K) {
        int min = A[0], max = A[0];
        for (int x: A) {
            min = Math.min(min, x);
            max = Math.max(max, x);
        }
        return Math.max(0, max - min - 2*K);
    }
}
