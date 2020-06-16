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
     * 定义dp[i]是nums前i个字符可以得到的解码种数，假设之前的字符串是abcx，现在新加入了y，则有以下5种情况：
     *
     * 如果x=='0'，且y=='0'，无法解码，返回0；
     * 如果只有x=='0'，则y只能单独放在最后，不能与x合并(不能以0开头)，此时有：
     * dp[i] = dp[i-1]
     * 如果只有y=='0'，则y不能单独放置，必须与x合并，并且如果合并结果大于26，返回0，否则有：
     * dp[i] = dp[i-2]
     * 如果 xy<=26: 则y可以“单独”放在abcx的每个解码结果之后后，并且如果abcx以x单独结尾，此时可以合并xy作为结尾，而这种解码种数就是abc的解码结果，此时有：
     * dp[i+1] = dp[i] + dp[i-1]
     * 如果 xy>26: 此时x又不能与y合并，y只能单独放在dp[i]的每一种情况的最后，此时有：
     * dp[i+1] = dp[i]
     * @param s
     * @return　编码总数
     */
    public int numDecodings(String s) {
        char[] chars = s.toCharArray();
        int length = chars.length;
        if (chars[0] == '0') return 0;
        int[] dp = new int[length + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 1; i < length; i++) {
            char now = chars[i];
            char last = chars[i - 1];
            if (now == '0') {
                if (last == '1' || last == '2')
                    dp[i + 1] = dp[i - 1];
                else return 0;
            } else {
                int num = (last - '0') * 10 + (now - '0');
                if (num <= 26 && num > 10) {
                    dp[i + 1] = dp[i] + dp[i - 1];
                } else {
                    dp[i + 1] = dp[i];
                }
            }

        }
        return dp[length];
    }
}
