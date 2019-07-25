package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: backtracking
 * @Author: Elvis
 * @CreateTime: 2019-07-23 10:40
 * Description:
 * 给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *
 * 说明：解集不能包含重复的子集。
 *
 * 示例:
 *
 * 输入: [1,2,2]
 * 输出:
 * [
 *   [2],
 *   [1],
 *   [1,2,2],
 *   [2,2],
 *   [1,2],
 *   []
 * ]
 */
public class Leetcode90 {

    List<List<Integer>> res = new ArrayList();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        dfs(nums, 0, new ArrayList());
        return res;
    }

    private void dfs(int[] nums, int i, List<Integer> tmp) {
        res.add(new ArrayList(tmp));
        int j = i;
        for (; i < nums.length; i++) {
            while (i < nums.length && i != j && nums[i] == nums[i - 1]) i++;
            if (i == nums.length) break;
            tmp.add(nums[i]);
            dfs(nums, i + 1, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] num = {1,2,2};
        new Leetcode90().subsetsWithDup(num);
    }
}
