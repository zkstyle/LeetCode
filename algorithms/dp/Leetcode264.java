package algorithms.dp;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: com.elvis.leetcode.dp
 * @Author: Elvis
 * @CreateTime: 2019-05-17 11:30
 * Description:
 * 编写一个程序，找出第n个丑数。
 *
 * 丑数就是只包含质因数  2, 3, 5的正整数。
 *
 * 示例:
 *
 * 输入: n = 10
 *  输出: 12
 *  解释:1, 2, 3, 4, 5, 6, 8, 9, 10, 12是前10个丑数。
 * 说明:
 *
 * 1 是丑数。
 * n 不超过 1690。
 */
public class Leetcode264 {


    public int nthUglyNumber(int n) {
        int[] ugly = new int[n];
        ugly[0] = 1;
        int i2 = 0, i3 = 0, i5 = 0;
        int factor2 = 2, factor3 = 3, factor5 = 5;
        for (int i = 1; i < n; i++) {
            int min = Math.min(Math.min(factor2, factor3), factor5);
            ugly[i] = min;
            if (min == factor2) factor2 = 2 * ugly[++i2];
            if (min == factor3) factor3 = 3 * ugly[++i3];
            if (min == factor5) factor5 = 5 * ugly[++i5];
        }
        return ugly[n - 1];
    }

    public static void main(String[] args) {
        new Leetcode264().nthUglyNumber(10);
    }

}
