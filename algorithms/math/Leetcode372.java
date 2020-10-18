package math;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: math
 * @Author: elvis
 * @CreateTime: 2020-10-08 17:18
 * @Description: 超级次方
 * 你的任务是计算 ab 对 1337 取模，a 是一个正整数，b 是一个非常大的正整数且会以数组形式给出。
 *
 * 示例 1:
 *　
 * 输入: a = 2, b = [3]
 * 输出: 8
 * 示例 2:
 *
 * 输入: a = 2, b = [1,0]
 * 输出: 1024
 */
public class Leetcode372 {

    int base = 1337;

    public int superPow(int a, int[] b) {
        int len = b.length;
        int ans = indexPow(a, b, len);
        return ans;
    }

    //a的k次方对base取模
    private int myPow(int a, int k) {
        a %= base;
        int ans = 1;
        for (int i = 0; i < k; i++) {
            ans *= a;
            ans %= base;
        }
        return ans;
    }

    //加入index判断是否需要终止递归
    private int indexPow(int a, int[] b, int index) {
        if (index < 1) return 1;

        int part1 = myPow(a, b[index - 1]);
        int part2 = myPow(indexPow(a, b, index - 1), 10);

        return part1 * part2 % base;
    }

}
