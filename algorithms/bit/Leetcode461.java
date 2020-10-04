package bit;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: bit
 * @Author: elvis
 * @CreateTime: 2020-10-04 22:47
 * @Description: 汉明距离
 * 两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。
 *
 * 给出两个整数 x 和 y，计算它们之间的汉明距离。
 *
 * 注意：
 * 0 ≤ x, y < 231.
 *
 * 示例:
 *
 * 输入: x = 1, y = 4
 *
 * 输出: 2
 *
 * 解释:
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 *        ↑   ↑
 *
 * 上面的箭头指出了对应二进制位不同的位置。
 */
public class Leetcode461 {

    /**
     * 为了计算等于 1 的位数，可以每次获取x,y最低位　
     */
    public int hammingDistance(int x, int y) {
        int res = 0;
        while (x > 0 || y > 0) {
            res += (x & 1) ^ (y & 1);
            x = x >> 1;
            y = y >> 1;
        }
        return res;
    }
}
