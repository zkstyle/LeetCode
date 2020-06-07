package math;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: com.elvis.leetcode.math
 * @Author: Elvis
 * @CreateTime: 2019-04-23 16:11
 * Description:
 * Count the number of prime numbers less than a non-negative number, n.
 *
 * Example:
 *
 * Input: 10
 * Output: 4
 * Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
 */
public class Leetcode204 {

    /**
     * 常规解法　对于每一个数进行判断　
     * 对于任意的i 从2~i^1/2 判断
     * @param n
     * @return
     */
    int countPrimes(int n) {
        int count = 0;
        for (int i = 2; i < n; i++)
            if (isPrime(i)) count++;
        return count;
    }

    // 判断整数 n 是否是素数
    boolean isPrime(int n) {
        for (int i = 2; i * i <= n; i++)
            if (n % i == 0)
                // 有其他整除因子
                return false;
        return true;
    }

    /**
     *任何一个合数(非质数)，都可以以唯一的形式被写成有限个质数的乘积，即分解质因数。
     *
     * 这个定理使用反证法很好证明，在理解了算数基本定理后，我们就知道所有超过根号n的合数都可以进行因式分解，
     * 其中最小的因子必然为根号n以内的一个质数，这样我们只要剔除掉根号n以内的质数倍数，就可以排除掉n以内的所有合数了，之后剩下来的数就都是质数
     * 这就是厄拉多塞筛法：
     *
     * 要得到自然数n以内的全部质数，必须把不大于根号n的所有质数的倍数剔除，剩下的就是质数
     */
    public int countPrimes2(int n) {
        int res = 0;
        if (n > 2) res++;
        boolean[] b = new boolean[n];
        for (int i = 3; i < n; i += 2) {
            if (!b[i]) {
                res++;
                for (int j = 3; i * j < n; j += 2) {
                    b[i * j] = true;
                }
            }
        }
        return res;
    }

}
