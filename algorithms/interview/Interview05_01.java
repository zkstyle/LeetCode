package interview;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: interview
 * @Author: elvis
 * @CreateTime: 2020-10-04 23:07
 * @Description: 面试题 05.01. 插入
 * 插入。给定两个32位的整数N与M，以及表示比特位置的i与j。编写一种方法，将M插入N，使得M从N的第j位开始，到第i位结束。假定从j位到i位足以容纳M，也即若M = 10 011，那么j和i之间至少可容纳5个位。例如，不可能出现j = 3和i = 2的情况，因为第3位和第2位之间放不下M。
 *
 * 示例1:
 *
 *  输入：N = 1024(10000000000), M = 19(10011), i = 2, j = 6
 *  输出：N = 1100(10001001100)
 * 示例2:
 *
 *  输入： N = 0, M = 31(11111), i = 0, j = 4
 *  输出：N = 31(11111)
 */
public class Interview05_01 {

    /**
     * 先把数N的j到i之间的位置0
     * M左移i位
     * 再用N或运算M
     *
     * 例 N = 1011 1111, M = 101, i = 2, j = 4
     *      (1<<(j-i+1))-1)<<i = 0001 1100
     * 取反后
     *      1110 0011
     * 对N于运算
     *      1011 1111 & 1110 0011 = 1010 0011
     * M左移动i位
     *     101 << i = 0001 0100
     * 最后M|N
     *     0001 0100 | 1010 0011 = 1011 0111 = 183
     */
    public int insertBits(int N, int M, int i, int j) {
        int mask = ((1 << (j - i + 1)) - 1) << i;
        mask = ~mask;
        N &= mask;
        M = M << i;
        return M | N;
    }

}
