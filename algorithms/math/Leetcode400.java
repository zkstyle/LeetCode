package math;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: math
 * @Author: elvis
 * @CreateTime: 2020-09-30 15:56
 * @Description: 第N个数字
 * 在无限的整数序列 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...中找到第 n 个数字。
 *
 * 注意:
 * n 是正数且在32位整数范围内 ( n < 231)。
 *
 * 示例 1:
 *
 * 输入:
 * 3
 *
 * 输出:
 * 3
 * 示例 2:
 *
 * 输入:
 * 11
 *
 * 输出:
 * 0
 *
 * 说明:
 * 第11个数字在序列 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... 里是0，它是10的一部分。
 */
public class Leetcode400 {

    /**
     * 我们通过观察，可以发现以下规律：
     *
     *   123456789        11 12 13 .. 99          100 101 ..  999
     *    ９个数               90个数                900个数
     *    9*1                 90*2                 900*3
     *
     * 对于第 n 位对应的数字，我们令这个数字对应的数为 target，然后分三步进行。
     *
     * 首先找到这个数字对应的数是几位数，用 digits 表示；
     * 然后确定这个对应的数的数值 target；
     * 最后确定返回值是 target 中的哪个数字。
     * 举个栗子：
     *
     * 比如输入的 n 是 365：
     *
     * 经过第一步计算我们可以得到第 365 个数字表示的数是三位数，n=365−9−90×2=176，digits = 3。这时 n=176 表示目标数字是三位数中的第 176个数字。
     *
     * 我们设目标数字所在的数为 number，计算得到  number=100+176/3=158，idx 是目标数字在 number 中的索引，如果 idx = 0，表示目标数字是 number - 1 中的最后一个数字。
     *
     * 根据步骤2，我们可以计算得到 idx = n % digits = 176 % 3 = 2，说明目标数字应该是 number = 158 中的第二个数字，即输出为 5。
     */
    public int findNthDigit(int n) {
        long num = n;
        long size = 1;
        long max = 9;
        while (n > 0) {
            //判断不在当前位数内
            if (num - max * size > 0) {
                num = num - max * size;
                size++;
                max = max * 10;
            } else {
                long count = num / size;
                long left = num % size;
                if (left == 0) {
                    return (int) (((long) Math.pow(10, size - 1) + count - 1) % 10);
                } else {
                    return (int) (((long) Math.pow(10, size - 1) + count) / ((long) Math.pow(10, (size - left))) % 10);
                }
            }
        }
        return 0;
    }
}
