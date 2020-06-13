package bit;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: bit
 * @Author: elvis
 * @CreateTime: 2020-06-11 08:42
 * @Description: 4的幂
 * 给定一个整数 (32 位有符号整数)，请编写一个函数来判断它是否是 4 的幂次方。
 *
 * 示例 1:
 *
 * 输入: 16
 * 输出: true
 * 示例 2:
 *
 * 输入: 5
 * 输出: false
 * 进阶：
 * 你能不使用循环或者递归来完成本题吗？
 */
public class Leetcode342 {

    /**
     * 数学运算　4^n=num ==> n=log(num}/log4
     */
    public boolean isPowerOfFour(int num) {
        double n = Math.log(num) / Math.log(4);
        return Math.round(n) == n;

    }

    /**
     * 递归运算　num==0 false num==1 true
     */
    public boolean isPowerOfFour2(int num) {
        if (num <= 0) return false;
        if (num == 1) return true;
        return num % 4 == 0 && isPowerOfFour(num / 4);
    }

    /**
     * n>0 然后确保是2^n ==> num^(num-1)==0 ==> 4的幂总是奇数位为1 ==> 100,10000,1000000...==>　与偶数位为1按位与必为0
     * oxaaaaaaaa ==> a->10
     */
    public boolean isPowerOfFour3(int num) {
        return (num > 0) && ((num & (num - 1)) == 0) && ((num & 0xaaaaaaaa) == 0);
    }
}
