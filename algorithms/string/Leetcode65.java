package string;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: string
 * @Author: elvis
 * @CreateTime: 2020-07-17 22:53
 * @Description: 有效字符串
 * 验证给定的字符串是否可以解释为十进制数字。
 *
 * 例如:
 *
 * "0" => true
 * " 0.1 " => true
 * "abc" => false
 * "1 a" => false
 * "2e10" => true
 * " -90e3   " => true
 * " 1e" => false
 * "e3" => false
 * " 6e-1" => true
 * " 99e2.5 " => false
 * "53.5e93" => true
 * " --6 " => false
 * "-+3" => false
 * "95a54e53" => false
 *
 * 说明: 我们有意将问题陈述地比较模糊。在实现代码之前，你应当事先思考所有可能的情况。这里给出一份可能存在于有效十进制数字中的字符列表：
 *
 * 数字 0-9
 * 指数 - "e"
 * 正/负号 - "+"/"-"
 * 小数点 - "."
 * 当然，在输入中，这些字符的上下文也很重要。
 */
public class Leetcode65 {

    /**
     * 用 numSeen dotSeen eSeen 分别标记数字　小数点　对数e 是否出现过
     * 若当前是数字　numSeen 标记为true
     * 当前字符是小数点　如果已经出现过小数点或者对数e 返回false
     * 当前字符是对数e　如果之前出现过e 或者没出现数字　返回false
     * 如果当前是+ -符号　若不是第一个字符或者对数e的下一个字符　返回false
     * 其他字符返回false
     */
    public boolean isNumber(String s) {
        if (s == null || s.length() == 0) return false;
        boolean numSeen = false;
        boolean dotSeen = false;
        boolean eSeen = false;
        char arr[] = s.trim().toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= '0' && arr[i] <= '9') {
                numSeen = true;
            } else if (arr[i] == '.') {
                if (dotSeen || eSeen) {
                    return false;
                }
                dotSeen = true;
            } else if (arr[i] == 'e') {
                if (eSeen || !numSeen) {
                    return false;
                }
                eSeen = true;
                numSeen = false;
            } else if (arr[i] == '+' || arr[i] == '-') {
                if (i != 0 && arr[i - 1] != 'e') {
                    return false;
                }
            } else {
                return false;
            }
        }
        return numSeen;
    }
}
