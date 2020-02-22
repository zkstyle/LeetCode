package SwordMeansOffer;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: SwordMeansOffer
 * @Author: elvis
 * @CreateTime: 2020-02-22 10:59
 * @Description:
 * 剑指Offer面试题50
 * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。
 *
 * 示例:
 *
 * s = "abaccdeff"
 * 返回 "b"
 *
 * s = ""
 * 返回 " "
 * 限制：
 *
 * 0 <= s 的长度 <= 50000
 */
public class SMO50 {

    public char firstUniqChar(String s) {
        char[] chars = s.toCharArray();
        int[] nums = new int[26];
        //两次遍历　第一次统计字符个数　第二次查找个数为1的字符
        for (int i = 0; i < chars.length; i++) {
            nums[chars[i] - 'a'] += 1;
        }
        for (int i = 0; i < chars.length; i++) {
            if (nums[chars[i]-'a'] == 1) {
                return chars[i];
            }
        }
        return ' ';
    }
}
