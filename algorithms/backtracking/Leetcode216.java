package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: backtracking
 * @Author: elvis
 * @CreateTime: 2020-06-13 16:01
 * @Description: 组合总数III
 * 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
 *
 * 说明：
 *
 * 所有数字都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 *
 * 输入: k = 3, n = 7
 * 输出: [[1,2,4]]
 * 示例 2:
 *
 * 输入: k = 3, n = 9
 * 输出: [[1,2,6], [1,3,5], [2,3,4]]
 */
public class Leetcode216 {

    List<List<Integer>> lists = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        dfs(1, k, n, new ArrayList<>());
        return lists;
    }

    /**
     * 深度搜索+回溯
     * 剪枝　若当前和n 小于当前遍历数字i 则直接break(因为i是递增的)
     * @param idx　起始下标
     * @param k　选取数字数量
     * @param n  目标和
     * @param list 存放结果
     */
    private void dfs(int idx, int k, int n, List<Integer> list) {
        if (list.size() == k && n == 0) {
            lists.add(new ArrayList(list));
            return;
        }

        for (int i = idx; i <= 9; i++) {
            if (n < i || k == 0) break;
            list.add(i);
            dfs(i + 1, k, n - i, list);
            list.remove(list.size() - 1);
        }
    }
}
