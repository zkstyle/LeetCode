package algorithms.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
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
     * dfs best
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(candidates==null || candidates.length<1 ||target<=0){
            return new ArrayList<List<Integer>>();
        }

        ArrayList<List<Integer>> ret = new ArrayList<List<Integer>>();
        dfs(ret, candidates, target, new ArrayList<Integer>(),0);
        return ret;
    }

    public void dfs(ArrayList<List<Integer>> ret, int[] nums, int target, ArrayList<Integer> one, int cur){
        if(0==target){
            ret.add(new ArrayList<Integer>(one));
            return;
        }
        else{
            for(int i=cur; i<nums.length; i++){
                if(nums[i]<=target){
                    one.add(nums[i]);
                    dfs(ret,nums,target-nums[i],one,i);
                    one.remove(one.size()-1);
                }
            }
        }
    }

    /*************************************************/
    /**
     * 回溯法
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(candidates);
        generateSums(lists, list, candidates, target,0);
        return lists;
    }

    private void generateSums(List<List<Integer>> lists, List<Integer> tmp, int[] candidates, int target, int num){
        //递归的终点
        if(target==0){
            lists.add(tmp);
            return;
        }
        if(target<candidates[0]) return;
        for(int i = num; i < candidates.length && candidates[i] <= target; i++){
            //深拷贝
            List<Integer> list = new ArrayList<>(tmp);
            list.add(candidates[i]);
            //递归运算，将i传递至下一次运算是为了避免结果重复。
            generateSums(lists, list, candidates, target-candidates[i], i);
        }
    }

}
