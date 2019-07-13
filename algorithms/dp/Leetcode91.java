package dp;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: dp
 * @Author: Elvis
 * @CreateTime: 2019-07-13 09:19
 * Description:
 * 一条包含字母 A-Z 的消息通过以下方式进行了编码：
 *
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 给定一个只包含数字的非空字符串，请计算解码方法的总数。
 *
 * 示例 1:
 *
 * 输入: "12"
 * 输出: 2
 * 解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
 * 示例 2:
 *
 * 输入: "226"
 * 输出: 3
 * 解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
 *
 */
public class Leetcode91 {

    /**
     *需要注意的测试
     * "0******" "**00***" "10"
     * @param s
     * @return
     */

    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        if (s.startsWith("0")) {
            return 0;
        }

        int len = s.length();
        int[] dp = new int[len];
        dp[0] = 1;
        for (int i = 1; i < len; i++) {
            int v1 = value(s, i - 1);
            int v2 = value(s, i);
            if (v2 == 0) {
                if (v1 == 1 || v1 == 2) {
                    dp[i] = i > 1 ? dp[i - 2] : 1;
                } else {
                    // 无解
                    return 0;
                }
            } else {
                if ((v1 == 2 && v2 <= 6) || (v1 == 1 && v2 != 0)) {
                    // 能组合
                    dp[i] = dp[i - 1] + (i > 1 ? dp[i - 2] : 1);
                } else {
                    // 不能组合
                    dp[i] = dp[i - 1];
                }
            }
        }
        return dp[len - 1];
    }

    private int value(String s, int index) {
        return s.charAt(index) - '0';
    }
}
