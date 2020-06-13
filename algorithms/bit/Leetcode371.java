package bit;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: bit
 * @Author: elvis
 * @CreateTime: 2020-06-08 21:34
 * @Description: 两整数之和
 * 不使用运算符 + 和 - ​​​​​​​，计算两整数 ​​​​​​​a 、b ​​​​​​​之和。
 *
 * 示例 1:
 *
 * 输入: a = 1, b = 2
 * 输出: 3
 * 示例 2:
 *
 * 输入: a = -2, b = 3
 * 输出: 1
 */
public class Leetcode371 {

    /**
     * a^b 计算无进位加法
     * a&b计算进位　左移一位为进位
     * 直到进位为0
     */
    public int getSum(int a, int b) {
        while (b != 0) {
            int res = (a & b) << 1;
            a = a ^ b;
            b = res;
        }
        return a;
    }

}
