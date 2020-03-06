package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: com.elvis.leetcode.backtracking
 * @Author: Elvis
 * @CreateTime: 2019-04-17 10:39
 * Description:
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的数字可以无限制重复被选取。
 *
 * 说明：
 *
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。
 * 示例 1:
 *
 * 输入: candidates = [2,3,6,7], target = 7,
 * 所求解集为:
 * [
 *   [7],
 *   [2,2,3]
 * ]
 * 示例 2:
 *
 * 输入: candidates = [2,3,5], target = 8,
 * 所求解集为:
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 */
public class Leetcode39 {

    /**
     *　回溯法　注意剪枝
     * 如果一个数位搜索起点都不能搜索到结果，那么比它还大的数肯定搜索不到结果，基于这个想法，我们可以对输入数组进行排序，以减少搜索的分支；
     *
     * 排序是为了提高搜索速度，非必要；
     *
     * 搜索问题一般复杂度较高，能剪枝就尽量需要剪枝。把候选数组排个序，遇到一个较大的数，
     * 如果以这个数为起点都搜索不到结果，后面的数就更搜索不到结果了。
     *
     */
    List<List<Integer>> lists = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> list = new ArrayList<>();
        back(candidates,list,target,0);
        return lists;
    }
    private void back(int[] candidates, List<Integer> list ,int target,int row) {
        if (target == 0) {
            lists.add(new ArrayList<>(list));
            return;
        }
        for (int i = row; i < candidates.length; i++) {
            //若target减小到0一下　则需要回溯
            if (target < 0) break;
            //剪枝　若从i开始　nums[i]>target 则会面不需要再遍历
            if (target >= candidates[i]){
                list.add(candidates[i]);
                //递归运算，将i传递至下一次运算是为了避免结果重复。
                back(candidates, list, target - candidates[i], i);
                list.remove(list.size() - 1);
            }

        }
    }

}
