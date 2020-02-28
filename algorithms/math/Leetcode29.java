package math;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: com.elvis.leetcode.binarysearch
 * @Author: Elvis
 * @CreateTime: 2019-03-10 09:42
 * Description: Divide Two Integers
 * Given two integers dividend and divisor, divide two integers without using multiplication, division and mod operator.
 *
 * Return the quotient after dividing dividend by divisor.
 *
 * The integer division should truncate toward zero.
 *
 * Example 1:
 *
 * Input: dividend = 10, divisor = 3
 * Output: 3
 * Example 2:
 *
 * Input: dividend = 7, divisor = -3
 * Output: -2
 * Note:
 *
 * Both dividend and divisor will be 32-bit signed integers.
 * The divisor will never be 0.
 * Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1].
 * For the purpose of this problem, assume that your function returns 231 − 1 when the division result overflows.
 */
public class Leetcode29 {

    /**
     * 累加法＋递归调用　取自leetcode英文讨论区　奇思妙想
     * １. 首先对边界条件进行讨论 如取值正负　除数与被除数是否为0
     * @param dividend
     * @param divisor
     * @return
     */
    public int divide_1(int dividend, int divisor) {
        //Reduce the problem to positive long integer to make it easier.
        //Use long to avoid integer overflow cases.
        int sign = 1;
        if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0))
            sign = -1;
        //转换为long型　因为商可能会溢出　
        long ldividend = Math.abs((long) dividend);
        long ldivisor = Math.abs((long) divisor);

        //Take care the edge cases.
        if (ldivisor == 0) return Integer.MAX_VALUE;
        if ((ldividend == 0) || (ldividend < ldivisor)) return 0;

        long lans = ldivide(ldividend, ldivisor);

        int ans;
        //判断是否溢出
        if (lans > Integer.MAX_VALUE) { //Handle overflow.
            ans = (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        } else {
            ans = (int) (sign * lans);
        }
        return ans;
    }

    private long ldivide(long ldividend, long ldivisor) {
        // Recursion exit condition
        if (ldividend < ldivisor) return 0;

        //  Find the largest multiple so that (divisor * multiple <= dividend),
        //  whereas we are moving with stride 1, 2, 4, 8, 16...2^n for performance reason.
        //  Think this as a binary search.
        long sum = ldivisor;
        long multiple = 1;
        while ((sum + sum) <= ldividend) {
            sum += sum;
            multiple += multiple;
        }
        //Look for additional value for the multiple from the reminder (dividend - sum) recursively.
        return multiple + ldivide(ldividend - sum, ldivisor);
    }

    /**
     * 方法思想与上面的思路相同　不同的是上面采用递归的方法+累加
     * 下面这种思路采用while循环+按位运算
     * @param dividend
     * @param divisor
     * @return
     */
    public int divide(int dividend, int divisor) {
        //只有这一种溢出的情况。
        if (dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;
        //进行类型扩充　防止溢出
        long x = Math.abs((long) dividend);
        long y = Math.abs((long) divisor);
        if (dividend == 0) return 0;
        //巧妙的获取两数相除的正负情况
        int sign = (dividend < 0) ^ (divisor < 0) ? -1 : 1;
        int result = 0;
        for (; x >= y; ) {
            int k = 1; //按位左移位数　最后累加至结果时　需要进行左移获取真正结果
            /*
            * y << k 表示除数divisor乘以2^k
            * 直到某一刻　y * 2^k > x 说明　y * 2 ^ (k-1) <= x < y * 2 ^ (k)
            * 所以k应该取上一次值　故k--
            * 然后x减去y<<k 剩余的部分继续下一次解析　进入下一次的循环
            * 并且 result累加上2^k
             */
            while (y << k <= x) {
                k++;
            }
            k--;
            x -= y << k;
            result += 1 << k;
        }
        return sign == 1 ? result : -result;
    }
}
