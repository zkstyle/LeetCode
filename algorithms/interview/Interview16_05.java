package interview;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: interview
 * @Author: elvis
 * @CreateTime: 2020-10-04 23:10
 * @Description: 面试题 16.05. 阶乘尾数
 * 设计一个算法，算出 n 阶乘有多少个尾随零。
 *
 * 示例 1:
 *
 * 输入: 3
 * 输出: 0
 * 解释: 3! = 6, 尾数中没有零。
 * 示例 2:
 *
 * 输入: 5
 * 输出: 1
 * 解释: 5! = 120, 尾数中有 1 个零.
 * 说明: 你算法的时间复杂度应为 O(log n) 。
 */
public class Interview16_05 {

    /**
     * 其实n!中的零全部是5和2的倍数贡献的，由于因子为2的个数大于5的，所以，只需计算其中有多少个5的倍数即可。
     */
    public int trailingZeroes(int n) {
        return n<5?0: n/5+trailingZeroes(n/5);
    }
}
