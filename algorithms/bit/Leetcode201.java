package bit;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: bit
 * @Author: elvis
 * @CreateTime: 2020-04-09 20:48
 * @Description: 给定范围 [m, n]，其中 0 <= m <= n <= 2147483647，
 * 返回此范围内所有数字的按位与（包含 m, n 两端点）。
 *
 * 示例 1: 
 *
 * 输入: [5,7]
 * 输出: 4
 *
 * 示例 2:
 *
 * 输入: [0,1]
 * 输出: 0　
 */
public class Leetcode201 {

    /**
     * n的二进制位比m二进制最左边的1高时，&的结果必然为0；
     * 由这个思想启发，二进制最高位相同时，这个1会保存，然后比较右一位，相同也保留...
     * 所以只需要m n 同时右移到相等时 m n的值就是&后能保留的位数，然后左移回来就是最后的值。
     */
    public int rangeBitwiseAnd(int m, int n) {
        int zeros = 0;
        while (n > m) {
            zeros++;
            m >>>= 1;
            n >>>= 1;
        }
        //将 0 的个数空出来
        return m << zeros;
    }
}
