package algorithms.bit;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: com.elvis.leetcode.bit
 * @Author: Elvis
 * @CreateTime: 2019-04-08 10:50
 * Description:
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *
 * 说明：解集不能包含重复的子集。
 *
 * 示例:
 *
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 */
public class Leetcode78 {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums.length == 0) return res;
        res.add(new ArrayList<>());
        dfs(0,nums,res,new ArrayList<>());
        return res;
    }
    public void dfs(int curIdx,int[] nums,List<List<Integer>> res,List<Integer> l){
        for(int i = curIdx;i < nums.length;i++){
            l.add(nums[i]);
            res.add(new ArrayList<>(l));
            dfs(i + 1,nums,res,l);
            l.remove(l.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] num = {1,2,3};
        new Leetcode78().subsets(num);
    }
}
