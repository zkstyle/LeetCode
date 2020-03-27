package string;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: string
 * @Author: elvis
 * @CreateTime: 2020-03-25 18:39
 * @Description: 验证回文串
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 *
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 *
 * 示例 1:
 *
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 示例 2:
 *
 * 输入: "race a car"
 * 输出: false
 */
public class Leetcode125 {
    /**
     * 首先双指针分别指向字符串首尾　while循环判断l<r
     * 然后分别去除两端的非数字和字母字符
     * 判断两个字符是否相等或为同一字母的大小写
     */
    public boolean isPalindrome(String s) {
        char[] ch = s.toCharArray();
        int l = 0, r = ch.length - 1;
        while (l < r) {
            while (l < r && !isValidChar(ch[l])) l++;
            while (r > l && !isValidChar(ch[r])) r--;
            if (toLowerCase(ch[l++]) != toLowerCase(ch[r--])) return false;
        }
        return true;
    }

    /**
     * 将大写字母转化为小写字母
     * @param c
     * @return
     */
    public char toLowerCase(char c) {
        int diff = 'a' - 'A';
        if (c >= 'A' && c <= 'Z') {
            return (char) (c + diff);
        }
        return c;
    }

    /**
     * 判断字符是否是数字或者字母
     * @param c
     * @return
     */
    public boolean isValidChar(char c) {
        char lc = toLowerCase(c);
        if ((lc >= 'a' && lc <= 'z') || (lc >= '0' && lc <= '9')) {
            return true;
        }
        return false;
    }
}
