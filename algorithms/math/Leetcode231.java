package math;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: math
 * @Author: Elvis
 * @CreateTime: 2019-06-03 22:00
 * Description:
 * 给定一个整数，编写一个函数来判断它是否是 2 的幂次方。
 *
 * 示例 1:
 *
 * 输入: 1
 * 输出: true
 * 解释: 20 = 1
 * 示例 2:
 *
 * 输入: 16
 * 输出: true
 * 解释: 24 = 16
 * 示例 3:
 *
 * 输入: 218
 * 输出: false
 */
public class Leetcode231 {

    /**
     * 累加思想＋递归 每次从2开始递归　n/=fo & fo *= fo
     *              第一次　n/2 fo=2^2
     *              第二次  n/2^2 fo=2^4
     *              第三次  n/2^4 fo=2^8 ...
     *              最后剩余n < fo
     *              然后递归调用isPowerOfTwo(n)
     * @param n
     * @return
     */
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) return false;
        if (n == 1) return true;
        int fo = 2;
        while (n >= fo) {
            if (n % fo == 0) {
                n /= fo;
                fo = fo * fo;
            } else {
                return false;
            }
        }
        return isPowerOfTwo(n);
    }

    /**
     * 按位思想　首先若n=2^x 则n=1000..00
     *                     n-1=0111..11  n&n-1 == 0
     * @param n
     * @return
     */
    public boolean isPowerOfTwo2(int n) {
        return n > 0 && ((n & (n - 1)) == 0);
    }
}
