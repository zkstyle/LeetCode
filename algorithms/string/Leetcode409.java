package string;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: string
 * @Author: elvis
 * @CreateTime: 2020-06-17 16:59
 * @Description: 最长回文串
 * 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
 *
 * 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
 *
 * 注意:
 * 假设字符串的长度不会超过 1010。
 *
 * 示例 1:
 *
 * 输入:
 * "abccccdd"
 *
 * 输出:
 * 7
 *
 * 解释:
 * 我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
 */
public class Leetcode409 {

    /**
     * 解题思路　hash表思想　首先将各个字符及数量存储到char数组中
     *      odd 存储奇数个数字符　even存储偶数字符个数
     *      结果应当为　偶数字符个数 + 是否存在奇数字符个数(是为1 否为0)
     */
    public int longestPalindrome(String s) {
        int[] dict = new int[63];
        for (int i = 0; i < s.length(); i++) dict[s.charAt(i) - 'A']++;
        int odd = 0, even = 0;
        for (int j = 0; j < dict.length; j++) {
            if (dict[j] > 1) {
                if (dict[j] % 2 == 0) {
                    even += dict[j];
                } else {
                    odd = 1;
                    even += dict[j] - 1;
                }
            } else if (dict[j] == 1) {
                odd = 1;
            }
        }
        return even + odd;
    }
}
