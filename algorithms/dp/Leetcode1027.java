package dp;

import java.util.Arrays;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: dp
 * @Author: elvis
 * @CreateTime: 2020-10-21 12:45
 * @Description: 最长等差数列
 * 给定一个整数数组 A，返回 A 中最长等差子序列的长度。
 *
 * 回想一下，A 的子序列是列表 A[i_1], A[i_2], ..., A[i_k] 其中 0 <= i_1 < i_2 < ... < i_k <= A.length - 1。并且如果 B[i+1] - B[i]( 0 <= i < B.length - 1) 的值都相同，那么序列 B 是等差的。
 *
 *
 *
 * 示例 1：
 *
 * 输入：[3,6,9,12]
 * 输出：4
 * 解释：
 * 整个数组是公差为 3 的等差数列。
 * 示例 2：
 *
 * 输入：[9,4,7,2,10]
 * 输出：3
 * 解释：
 * 最长的等差子序列是 [4,7,10]。
 * 示例 3：
 *
 * 输入：[20,1,15,3,10,5,8]
 * 输出：4
 * 解释：
 * 最长的等差子序列是 [20,15,10,5]。
 *
 *
 * 提示：
 *
 * 2 <= A.length <= 2000
 * 0 <= A[i] <= 10000
 */
public class Leetcode1027 {

    /**
     * 由于至少两个元素才能定义等差数列，所以定义状态dp[i][j]为以A[i]和A[j]为最后两个元素的等差数列的长度。
     *
     * 那么最后两个数定了，前一个元素也就定了为target = 2 * dp[i] - dp[j]， 只需要找到i前面最靠近i的target的位置即可。
     *
     * dp[i][j] = dp[index[target]][i] + 1
     *
     * 通过一个哈希表记录每个在i之前的数出现的最后一个下标，就可以在O(1)的时间内找到target所在的下标。
     */
    public int longestArithSeqLength(int[] A) {
        int L = A.length;
        int[][] dp = new int[L][L];
        int[] index = new int[10001];
        int maxLength = 2;
        Arrays.fill(index, -1);
        for (int i = 0; i < L; i++) {
            Arrays.fill(dp[i], 2);
            for (int j = i + 1; j < L; j++) {
                int diff = A[i] * 2 - A[j];
                if (diff < 0 || index[diff] == -1) continue;
                dp[i][j] = dp[index[diff]][i] + 1;
                maxLength = Math.max(maxLength, dp[i][j]);
            }
            index[A[i]] = i;
        }
        return maxLength;
    }
}
