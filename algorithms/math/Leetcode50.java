package math;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: com.elvis.leetcode.math
 * @Author: Elvis
 * @CreateTime: 2019-03-16 09:36
 * Description: pow
 */
public class Leetcode50 {

    /**
     * 思路：递归调用　power(x,n) = power(x,n/2)^2 * x(n为奇数) 偶数就不需要乘以x
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {
        long N = n;
        return n < 0 ? pow(1 / x, -N) : pow(x, N);

    }

    private double pow(double x, long n) {
        if (n == 0) return 1.0d;
        return n % 2 == 0 ? pow(x * x, n / 2) : pow(x * x, n / 2) * x;
    }
}
