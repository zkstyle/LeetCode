package swordmeansoffer;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: swordmeansoffer
 * @Author: elvis
 * @CreateTime: 2020-05-04 08:35
 * @Description: 面试题64. 求1+2+…+n
 * 求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 *
 * 示例 1：
 *
 * 输入: n = 3
 * 输出: 6
 * 示例 2：
 *
 * 输入: n = 9
 * 输出: 45
 *
 * 限制：
 *
 * 1 <= n <= 10000
 */
public class SMO64 {

    /**
     *直接等差数列计算　但是不符合题意　pass
     */
    public int sumNums2(int n) {
        return (n + 1) * n / 2;
    }

    /**
     * 用递归+递归出口进行控制
     */
    int res = 0;

    public int sumNums(int n) {
        boolean x = n > 1 && sumNums(n - 1) > 0;
        res += n;
        return res;
    }


}
