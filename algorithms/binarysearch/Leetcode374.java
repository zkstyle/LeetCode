package binarysearch;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: binarysearch
 * @Author: elvis
 * @CreateTime: 2020-06-10 16:42
 * @Description: 猜数字大小
 * 我们正在玩一个猜数字游戏。 游戏规则如下：
 * 我从 1 到 n 选择一个数字。 你需要猜我选择了哪个数字。
 * 每次你猜错了，我会告诉你这个数字是大了还是小了。
 * 你调用一个预先定义好的接口 guess(int num)，它会返回 3 个可能的结果（-1，1 或 0）：
 *
 * -1 : 我的数字比较小
 *  1 : 我的数字比较大
 *  0 : 恭喜！你猜对了！
 *  
 *
 * 示例 :
 *
 * 输入: n = 10, pick = 6
 * 输出: 6
 */
public class Leetcode374 {
    private static final int answer = 8;

    private int guess(int k){
        if(k == answer) return 0;
        return k > answer ? 1 : -1;
    }

    /**
     * 简单的二分查找　
     */
    public int guessNumber(int n) {
        int l = 1, r = n;
        while (l <= n) {
            int m = l + (r - l) / 2;
            if (guess(m) == 0) {
                return m;
            } else if (guess(m) > 0) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return -1;
    }
}
