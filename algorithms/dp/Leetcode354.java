package dp;

import java.util.Arrays;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: dp
 * @Author: elvis
 * @CreateTime: 2020-09-28 23:24
 * @Description: 俄罗斯套娃信封问题
 * 给定一些标记了宽度和高度的信封，宽度和高度以整数对形式 (w, h) 出现。当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如同俄罗斯套娃一样。
 *
 * 请计算最多能有多少个信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。
 *
 * 说明:
 * 不允许旋转信封。
 *
 * 示例:
 *
 * 输入: ev = [[5,4],[6,4],[6,7],[2,3]]
 * 输出: 3
 * 解释: 最多信封的个数为 3, 组合为: [2,3] => [5,4] => [6,7]。
 */
public class Leetcode354 {

    /**
     * 信封套娃问题　dp问题　
     * 首先对信封数组排序　按　w　排序　
     * 双重for遍历　dp[i]代表 以第i个信封作为最外层的套娃　所获取最大信封数
     */
    public int maxEnvelopes(int[][] ev) {
        Arrays.sort(ev, (e1, e2) -> e1[0] - e2[0]);
        int n = ev.length;
        if (n == 0) return 0;
        int[] dp = new int[n + 1];
        int max = 1;
        for (int i = 1; i <= n; i++) {
            dp[i] = 1;
            for (int j = 1; j < i; j++) {
                if (ev[i - 1][0] > ev[j - 1][0] && ev[i - 1][1] > ev[j - 1][1]) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            max = Math.max(dp[i], max);
        }
        return max;
    }


    /**
     * 动态规划加二分查找加贪心思想。按照width 升序，height 降序排序之后。
     *
     * 利用贪心思想，本质上如果两个信封不能嵌套，我们选择height 尽量小的，以便极可能的让后面的大信封嵌套起来容易。
     */
    public int maxEnvelopes2(int[][] ev) {
        if (ev.length == 0) {
            return 0;
        }
        Arrays.sort(ev, (e1, e2) -> e1[0] == e2[0] ? e1[1] - e2[1] : e1[0] - e2[0]);
        int[] d = new int[ev.length];
        d[0] = ev[0][1];
        int len = 1;
        for (int i = 1; i < ev.length; i++) {
            if (ev[i][1] > d[len - 1]) {
                d[len++] = ev[i][1];
            } else {
                int k = bs(d, len, ev[i][1]);
                d[k] = ev[i][1];
            }
        }
        return len;
    }

    int bs(int[] d, int len, int target) {
        int l = 0;
        int r = len - 1;
        while (l < r) {
            int mid = l + r >> 1;
            if (d[mid] >= target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
