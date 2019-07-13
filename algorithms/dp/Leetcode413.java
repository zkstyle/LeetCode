package dp;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: dp
 * @Author: Elvis
 * @CreateTime: 2019-06-27 10:02
 * Description:
 * 如果一个数列至少有三个元素，并且任意两个相邻元素之差相同，则称该数列为等差数列。
 *
 * 例如，以下数列为等差数列:
 *
 * 1, 3, 5, 7, 9
 * 7, 7, 7, 7
 * 3, -1, -5, -9
 * 以下数列不是等差数列。
 *
 * 1, 1, 2, 5, 7
 *  
 *
 * 数组 A 包含 N 个数，且索引从0开始。数组 A 的一个子数组划分为数组 (P, Q)，P 与 Q 是整数且满足 0<=P<Q<N 。
 *
 * 如果满足以下条件，则称子数组(P, Q)为等差数组：
 *
 * 元素 A[P], A[p + 1], ..., A[Q - 1], A[Q] 是等差的。并且 P + 1 < Q 。
 *
 * 函数要返回数组 A 中所有为等差数组的子数组个数。
 *
 *  
 *
 * 示例:
 *
 * A = [1, 2, 3, 4]
 *
 * 返回: 3, A 中有三个子等差数组: [1, 2, 3], [2, 3, 4] 以及自身 [1, 2, 3, 4]。
 */
public class Leetcode413 {

    /**
     * dp问题　思路如下：
     * dp[i]表示前i个数的等差数列数　differ记录等差值
     * 如果遇到等差不相等　则更新该值
     * len记录当前可利用等差值　如 1 2 3 可利用为 1 2 长度为2 若再来一个4 可组成2 3 4 和　1 2 3 4
     * dp[i]等于dp[i-1]加上新的可利用len个数
     * @param A
     * @return
     */
    public int numberOfArithmeticSlices(int[] A) {
        int n = A.length;
        if (n < 3) return 0;
        int[] dp = new int[n];
        int differ = A[1]-A[0];
        int len = 1;
        for (int i = 2; i < n; i++){
            if (A[i]-A[i-1]==differ){
                dp[i] = dp[i-1] + len;
                len++;
            }else{
                dp[i] = dp[i-1];
                differ = A[i] - A[i-1];
                len = 1;
            }
        }
        return dp[n-1];
    }
}
