package swordmeansoffer;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: swordmeansoffer
 * @Author: elvis
 * @CreateTime: 2020-05-05 14:07
 * @Description: 面试题14- II. 剪绳子 II
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m] 。请问 k[0]*k[1]*...*k[m] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 *
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 *
 *
 *
 * 示例 1：
 *
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1
 * 示例 2:
 *
 * 输入: 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36
 *
 *
 * 提示：
 *
 * 2 <= n <= 1000
 */
public class SMO14_2 {

    /**
     * 切分规则：
     *      * 最优： 3 。把绳子尽可能切为多个长度为 3  的片段，留下的最后一段绳子的长度可能为 0,1,2 三种情况。
     *      * 次优： 2 。若最后一段绳子长度为 2 ；则保留，不再拆为 1+1  。
     *      * 最差： 1 。若最后一段绳子长度为 1 ；则应把一份 3+1 替换为 2+2，因为 2×2>3×1。
     */
    public int cuttingRope(int n) {
        if (n <= 3) {
            return n - 1;
        }
        int mod = (int) 1e9 + 7;
        long res = 1;
        while (n > 4) {
            res *= 3;
            res %= mod;
            n -= 3;
        }
        return (int) (res * n % mod);
    }
}
