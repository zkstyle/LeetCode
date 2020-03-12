package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: com.elvis.leetcode.backtracking
 * @Author: Elvis
 * @CreateTime: 2019-04-17 11:05
 * Description:
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的每个数字在每个组合中只能使用一次。
 *
 * 说明：
 *
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。
 * 示例 1:
 *
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 所求解集为:
 * [
 *   [1, 7],
 *   [1, 2, 5],
 *   [2, 6],
 *   [1, 1, 6]
 * ]
 * 示例 2:
 *
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 所求解集为:
 * [
 *   [1,2,2],
 *   [5]
 * ]
 */
public class Leetcode40 {

    /**
     *　回溯法　注意剪枝
     * 如果一个数位搜索起点都不能搜索到结果，那么比它还大的数肯定搜索不到结果，基于这个想法，我们可以对输入数组进行排序，以减少搜索的分支；
     * 排序是为了提高搜索速度，非必要；
     *
     * 搜索问题一般复杂度较高，能剪枝就尽量需要剪枝。把候选数组排个序，遇到一个较大的数，
     * 如果以这个数为起点都搜索不到结果，后面的数就更搜索不到结果了。
     * 这一题与39题很相似　唯一区别就是需要去重　不能形成同一组合
     * 所以因为去重　所以先对数组进行排序
     *
     */
    List<List<Integer>> lists = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<Integer> list = new ArrayList<>();
        Arrays.sort(candidates);
        back(candidates,list,target,0);
        return lists;
    }
    private void back(int[] candidates, List<Integer> list ,int target,int row) {
        if (target == 0) {
            lists.add(new ArrayList<>(list));
            return;
        }
        //1 1 2 5 6 7 10
        for (int i = row; i < candidates.length; i++) {
            //在一层里面只用一次这个数字　核心去重代码
            if (i >row && candidates[i]==candidates[i-1]) continue;
            //若target减小到0一下　则需要回溯
            if (target < 0) break;
            //剪枝　若从i开始　nums[i]>target 则会面不需要再遍历
            if (target >= candidates[i]){
                list.add(candidates[i]);
                //递归运算，将i传递至下一次运算是为了避免结果重复。
                back(candidates, list, target - candidates[i], i+1);
                list.remove(list.size() - 1);
            }

        }
    }
}
