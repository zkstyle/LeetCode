package math;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: math
 * @Author: Elvis
 * @CreateTime: 2019-07-09 10:06
 * Description:
 * 给定一个正整数，返回它在 Excel 表中相对应的列名称。
 *
 * 例如，
 *
 *     1 -> A
 *     2 -> B
 *     3 -> C
 *     ...
 *     26 -> Z
 *     27 -> AA
 *     28 -> AB
 *     ...
 * 示例 1:
 *
 * 输入: 1
 * 输出: "A"
 * 示例 2:
 *
 * 输入: 28
 * 输出: "AB"
 * 示例 3:
 *
 * 输入: 701
 * 输出: "ZY"
 */
public class Leetcode168 {

    /**
     * 有26个字母　因为取模结果为0~25 故为一一对应　每次先n-- 再取最低位数值
     * n%26+'A'就是每一次最低位的字符　
     * sb每次拼接完　n = n / 26
     * @param n
     * @return
     */
    public String convertToTitle(int n) {
        String sb = "";
        while (n != 0) {
            n -= 1;
            sb = ((char) (n % 26 + 'A')) + sb;
            n /= 26;
        }
        return sb;
    }
}
