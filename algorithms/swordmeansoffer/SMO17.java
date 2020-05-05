package swordmeansoffer;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: swordmeansoffer
 * @Author: elvis
 * @CreateTime: 2020-05-04 08:32
 * @Description: 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
 *
 * 示例 1:
 *
 * 输入: n = 1
 * 输出: [1,2,3,4,5,6,7,8,9]
 *  
 *
 * 说明：
 *
 * 用返回一个整数列表来代替打印
 * n 为正整数
 */
public class SMO17 {

    /**
     *简单打印　首先对于给定n 打印 0 ~ (10 ^ n) - 1
     * 计算len
     * @param n
     * @return
     */
    public int[] printNumbers(int n) {
        int len = 1;
        while (n != 0) {
            len *= 10;
            n--;
        }
        int[] ans = new int[len - 1];
        for (int i = 0; i < len - 1; i++) {
            ans[i] = i + 1;
        }
        return ans;
    }
}
