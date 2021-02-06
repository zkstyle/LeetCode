package math;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: com.elvis.leetcode.math
 * @Author: Elvis
 * @CreateTime: 2019-03-10 08:32
 * Description: Sqrt(x)  Easy
 * Implement int sqrt(int x).
 *
 * Compute and return the square root of x, where x is guaranteed to be a non-negative integer.
 *
 * Since the return type is an integer, the decimal digits are truncated and only the integer part of the result is returned.
 *
 * Example 1:
 *
 * Input: 4
 * Output: 2
 * Example 2:
 *
 * Input: 8
 * Output: 2
 * Explanation: The square root of 8 is 2.82842..., and since
 *              the decimal part is truncated, 2 is returned.
 */
public class Leetcode69 {

    /**
     * 二分法求解　时间复杂度log N
     * 每次判断mid*mid与x的大小　依据大小二分查找　因为这一次不能用等于判断
     * 因为   mid*mid <= x < (mid+1)*(mid+1)时　找到sqrt(x) 故该条件用于判断是否找到根号x
     * @param x
     * @return
     */
    public int mySqrt(int x) {
        if (x < 2) return x;
        int l = 1, r = x;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (mid > x / mid) {
                r = mid - 1;
            } else if (mid + 1 > x / (mid + 1)) {
                return mid;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 应用牛顿法解决平方根问题　令f(x)=x^2-a
     * f(x)约等于f(x0)+(x-x0)*f'(x0)
     * 令f(x)=0 ==> f(x0)+(x-x0)*f'(x0) = 0
     *  ==> x=x0-f(x0)/f'(x0) ==>化简得　x = (x0 + a/x0)/2
     *  故迭代公式为　x0 = (x0 + a/x0) / 2
     * @param a
     * @return
     */
    public int mySqrt_newton(int a) {
        long x = a;
        while (x * x > a) {
            x = (x + a / x) / 2;
        }
        return (int) x;
    }

}
