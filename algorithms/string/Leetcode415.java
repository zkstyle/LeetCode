package string;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: string
 * @Author: elvis
 * @CreateTime: 2020-06-11 21:45
 * @Description: 字符串相加
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
 *
 * 注意：
 *
 * num1 和num2 的长度都小于 5100.
 * num1 和num2 都只包含数字 0-9.
 * num1 和num2 都不包含任何前导零。
 * 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式。
 */
public class Leetcode415 {

    /**
     * 利用StringBuilder拼接结果　i,j指针从字符串最后一位开始遍历
     * carry记录进位　while循环遍历
     * 最后若carry==1 再进位1
     * 最后逆序返回
     */
    public String addStrings(String num1, String num2) {
        StringBuilder res = new StringBuilder("");
        int i = num1.length() - 1, j = num2.length() - 1, carry = 0;
        while (i >= 0 || j >= 0) {
            int n1 = i >= 0 ? num1.charAt(i--) - '0' : 0;
            int n2 = j >= 0 ? num2.charAt(j--) - '0' : 0;
            int tmp = n1 + n2 + carry;
            carry = tmp / 10;
            res.append(tmp % 10);
        }
        if (carry == 1) res.append(1);
        return res.reverse().toString();
    }
}
