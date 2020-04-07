package math;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: com.elvis.leetcode.math
 * @Author: Elvis
 * @CreateTime: 2019-03-07 10:15
 * Description: 整数反转
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 *
 * 示例 1:
 *
 * 输入: 123
 * 输出: 321
 *  示例 2:
 *
 * 输入: -123
 * 输出: -321
 * 示例 3:
 *
 * 输入: 120
 * 输出: 21
 * 注意:
 *
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−2^31,  2^31 − 1]
 * 请根据这个假设，如果反转后整数溢出那么就返回 0。
 */
public class Leetcode07 {
    /**
     * 解题思路　首先很简单依次取模获取个位、十位、百位数字　然后求解
     *需要注意的是翻转之后　可能会超出int最大范围　所以需要越界判断
     * @param x
     * @return
     */
    public int reverse(int x) {
        int ans = 0;
        int flag = x < 0 ? -1 : 1;//保存正负号
        x = x < 0 ? -x : x;
        while (x > 0) {
            //越界判断
            if (ans > Integer.MAX_VALUE / 10 || (ans == Integer.MAX_VALUE / 10 && x % 10 > Integer.MAX_VALUE % 10))
                return 0;
            ans = ans * 10 + x % 10;
            x /= 10;
        }
        return flag * ans;
    }

}
