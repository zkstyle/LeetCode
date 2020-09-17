package string;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: string
 * @Author: elvis
 * @CreateTime: 2020-09-17 21:54
 * @Description: 计数二进制子串
 * 给定一个字符串 s，计算具有相同数量0和1的非空(连续)子字符串的数量，并且这些子字符串中的所有0和所有1都是组合在一起的。
 *
 * 重复出现的子串要计算它们出现的次数。
 *
 * 示例 1 :
 *
 * 输入: "00110011"
 * 输出: 6
 * 解释: 有6个子串具有相同数量的连续1和0：“0011”，“01”，“1100”，“10”，“0011” 和 “01”。
 *
 * 请注意，一些重复出现的子串要计算它们出现的次数。
 *
 * 另外，“00110011”不是有效的子串，因为所有的0（和1）没有组合在一起。
 *
 * 示例 2 :
 *
 * 输入: "10101"
 * 输出: 4
 * 解释: 有4个子串：“10”，“01”，“10”，“01”，它们具有相同数量的连续1和0。
 *
 * 注意：
 *
 *     s.length 在1到50,000之间。
 *     s 只包含“0”或“1”字符。
 *
 */
public class Leetcode696 {

    /**
     * 将连续的0 1数量统计出来　连续0 1字符串取较小的
     */
    public int countBinarySubstrings(String s) {
        char[] ch = s.toCharArray();
        char c = ch[0];
        int ret=0;
        int precount = 0, count = 0;
        for (int i = 0; i < ch.length; i++) {
            if (c == ch[i]) count++;
            else {
                c = ch[i];
                ret += Math.min(precount, count);
                precount = count;
                count = 1;
            }
        }
        return ret += Math.min(precount, count);
    }
}
