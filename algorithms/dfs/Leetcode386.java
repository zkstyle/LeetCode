package dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: dfs
 * @Author: elvis
 * @CreateTime: 2020-06-13 16:33
 * @Description: 字典序排数数
 * 给定一个整数 n, 返回从 1 到 n 的字典顺序。
 *
 * 例如，
 *
 * 给定 n =1 3，返回 [1,10,11,12,13,2,3,4,5,6,7,8,9] 。
 *
 * 请尽可能的优化算法的时间复杂度和空间复杂度。 输入的数据 n 小于等于 5,000,000。
 */
public class Leetcode386 {

    public List<Integer> lexicalOrder(int n) {
        List<Integer> result = new ArrayList(n);
        buildList(1, 10, n, result);
        return result;
    }

    /**
     * 我们将n个数按照一定的顺序构建成树，然后从左到右对每棵树进行dfs就行了
     */
    private void buildList(int start, int end, int limit, List<Integer> result) {
        for (int i = start; i < end && i <= limit; i++) {
            result.add(i);
            buildList(i * 10, i * 10 + 10, limit, result);
        }
    }
}
