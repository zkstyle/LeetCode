package algorithms.math;

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
     * return sqrt(x)
     * @param x
     * @return
     */
    public int mySqrt(int x) {
        if (x == 0 || x == 1){
            return x;
        }
        return serach_sqrt(x, 0, x);
    }

    private int serach_sqrt(int x, long low, long high) {
        int res;
        long mid = (low + high) / 2;
        if (mid * mid > x){
            res = serach_sqrt(x, low, mid);
        }else if ((mid + 1)*(mid + 1) > x){
            res = (int) mid;
        }else {
            res = serach_sqrt(x, mid + 1, high);
        }
        return res;
    }

    public static void main(String[] args) {
        int s = new Leetcode69().mySqrt(9);
    }
}
