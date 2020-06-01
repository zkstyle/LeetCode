package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: com.elvis.leetcode.backtracking
 * @Author: Elvis
 * @CreateTime: 2019-05-16 11:54
 * Description:
 * 排列组合
 */
public class Leetcode77 {

    /**
     * 回溯法遍历　对于组合计算　首选回溯法　遍历所有情况　但是需要注意的是剪枝
     * 减少不必要的回溯　提高回溯的效率
     */
    List<List<Integer>> lists = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        combine(n, k, new ArrayList<>(), 0);
        return lists;
    }

    void combine(int n, int k, List<Integer> list, int idx) {
        if (0 == k) {
            lists.add(new ArrayList<>(list));
            return;
        }
        //剩余的数已经不足以再添加k个数　所以剪枝　i<=n-k 当i=n-k+1时　n-1-(n-k+1) +1 =k-1<k不足k个数
        for (int i = idx; i <= n - k; i++) {
            list.add(i + 1);
            combine(n, k - 1, list, i + 1);
            list.remove(list.size() - 1);
        }
    }

}
