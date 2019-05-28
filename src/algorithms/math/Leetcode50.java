package algorithms.math;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: com.elvis.leetcode.math
 * @Author: Elvis
 * @CreateTime: 2019-03-16 09:36
 * Description: pow
 */
public class Leetcode50 {

    /**
     * simple
     * @param x
     * @param n
     * @return
     */
    public double myPow1(double x, int n) {
        if (n < 0) return 1.0 / power(x, -n);
        else return power(x, n);
    }
    private static double power(double x, int n) {
        if (n == 0) return 1;
        double v = power(x, n / 2);
        if (n % 2 == 0) return v * v;
        else return v * v * x;
    }

    /**
     * self
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {
        double ans;
        if (n == 0){
            return 1;
        }
        int flag = n > 0 ? 1 : -1;
        n = Math.abs(n);
        ans = pow(x, n);
        if (flag < 0) ans = 1 / ans;
        return ans;
    }

    private double pow(double x, int n) {
        if (n == 0) return 1;
        if (n == 1) return x;
        double sum = x;
        int count = 1;
        while (count <= Integer.MAX_VALUE / 2 && (count + count) <= n){
            sum *= sum;
            count += count;
        }
        return sum * pow(x, n - count);
    }
}
