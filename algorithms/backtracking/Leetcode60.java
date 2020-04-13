package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: com.elvis.leetcode.backtracking
 * @Author: Elvis
 * @CreateTime: 2019-05-09 13:19
 * Description:给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。
 *
 * 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
 *
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * 给定 n 和 k，返回第 k 个排列。
 *
 * 说明：
 *
 * 给定 n 的范围是 [1, 9]。
 * 给定 k 的范围是[1,  n!]。
 * 示例 1:
 *
 * 输入: n = 3, k = 3
 * 输出: "213"
 * 示例 2:
 *
 * 输入: n = 4, k = 9
 * 输出: "2314"　
 */
public class Leetcode60 {

    /**
     *这道题有个回溯标签,用回溯算法超时,回溯算法真的可以过吗?
     * 直接举例子:
     *
     * 比如n = 3, k = 3
     *
     * 我们要由num = [1, 2, 3]这三个数组成!
     *
     * 首先我们要确定首位置是什么?我们整体看一下所有数;
     *
     * "123"
     * "132"
     * "213"
     * "231"
     * "312"
     * "321"
     * 我们发现当首数字确定了,后面和首数字组成数字的个数相等的!
     *
     * 比如: 首数字为1,后面有组成两个数123,132,可以组成2个数.当首数字为2,3同样都是.
     *
     * 所有我们要找k = 3的数字 ,我们只需要 3/2 便可找到首数字什么,
     *
     * 下面依次类推!
     */
    public String getPermutation(int n, int k) {
        int[] fb = new int[n + 1];
        fb[0] = 1;
        for (int i = 1; i <= n; i++) {
            fb[i] = fb[i - 1] * i;
        }
        // factorial[] = {1, 1, 2, 6, 24, ... n!}

        List<Integer> num = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            num.add(i);
        }

        k--;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            int index = k / fb[n - i];
            sb.append(num.get(index));
            num.remove(index);
            k = k - index * fb[n - i];
        }
        return sb.toString();
    }

    /**
     * 回溯法时间 1058ms
     * 使用used数组标记当前数字i是否使用过
     */
    int k = 0;

    public String getPermutation2(int n, int k) {
        this.k = k;
        StringBuilder sb = new StringBuilder();
        getPermutation(n, sb, new boolean[n]);
        return sb.toString();
    }

    private void getPermutation(int n, StringBuilder sb, boolean[] used) {
        if (sb.length() == n) {
            k--;
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (used[i - 1]) continue;
            sb.append(i);
            used[i - 1] = true;
            getPermutation(n, sb, used);
            if (k == 0) return;
            sb.deleteCharAt(sb.length() - 1);
            used[i - 1] = false;
        }
    }

}
