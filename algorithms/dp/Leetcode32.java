package dp;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: com.elvis.leetcode.dp
 * @Author: Elvis
 * @CreateTime: 2019-03-30 11:16
 * Description:
 */
public class Leetcode32 {

    /**
     * 动态规划
     *
     * 我们定义 dp[i] 表示以下标 i 字符结尾的最长有效括号的长度。我们将 dp 数组全部初始化为 0。显然有效的子串一定以‘)’ 结尾，因此我们可以知道
     *
     * 以 ‘(’ 结尾的子串对应的 dp 值必定为 0 ，我们只需要求解 ‘)’ 在 dp 数组中对应位置的值。
     *
     * 我们从前往后遍历字符串求解dp 值，我们每两个字符检查一次：
     *
     * s[i]=‘)’ 且 s[i - 1] = ‘(’，也就是字符串形如 “……()”“……()”，我们可以推出：
     *
     * dp[i]=dp[i−2]+2
     *
     * 我们可以进行这样的转移，是因为结束部分的 "()" 是一个有效子字符串，并且将之前有效子字符串的长度增加了 2。
     *
     * s[i]=‘)’ 且 s[i−1]=‘)’，也就是字符串形如 “……))”“……))”，我们可以推出：
     *
     * 如果 s[i−dp[i−1]−1]=‘(’，那么
     *
     * dp[i]=dp[i−1]+dp[i−dp[i−1]−2]+2
     *
     * 我们考虑如果倒数第二个 ‘)’ 是一个有效子字符串的一部分（记作 sub_s)，对于最后一个‘)’ ，
     *
     * 如果它是一个更长子字符串的一部分，那么它一定有一个对应的 ‘(’ ，且它的位置在倒数第二个 ‘)’ 所在的有效子字符串的前面（也就是 sub_s）。
     *
     * 因此，如果子字符串 sub_s的前面恰好是 ‘(’ ，那么我们就用 2加上 sub_s的长度（dp[i−1]）去更新 dp[i]。同时，我们也会把有效子串
     *
     * “(sub_s)”之前的有效子串的长度也加上，也就是再加上dp[i−dp[i−1]−2]。
     *
     * 最后的答案即为 dp 数组中的最大值。
     */
    public int longestValidParentheses(String s) {
        int maxans = 0;
        int dp[] = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                maxans = Math.max(maxans, dp[i]);
            }
        }
        return maxans;
    }
}
