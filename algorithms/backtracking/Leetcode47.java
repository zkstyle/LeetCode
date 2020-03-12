package backtracking;

import java.util.*;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: backtracking
 * @Author: elvis
 * @CreateTime: 2020-03-12 09:17
 * @Description: 全排列II
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 *
 * 示例:
 *
 * 输入: [1,1,2]
 * 输出:
 * [
 *   [1,1,2],
 *   [1,2,1],
 *   [2,1,1]
 * ]
 */
public class Leetcode47 {

    List<List<Integer>> lists = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int[] v = new int[nums.length];
        Arrays.sort(nums);
        back(list, nums, v);
        return lists;
    }

    /**
     * 算法思想和46题全排列基本一致　需要考虑的是　出现重复数字需要去重
     * 因为存在重复数字　不能简单的通过判断数字元素是否重复　需要判断list组合是否重复
     * 通过剪枝去重不必要的组合　
     * 首先第一点　如何保证数字元素只能使用一次　通过数组v来保证
     * v[i] = 1表示使用过　v[i]==0 表示没有使用过
     * 第二点　如果保证重复元素的导致重复组合　i>0 && nums[i] == nums[i-1] && v[i-1] != 1
     * i>0保证不越界　如果nums[i] == nums[i-1]并且v[i-1]没有使用过　则跳过
     * @param list
     * @param nums
     * @param v
     */
    private void back(List<Integer> list, int[] nums, int[] v){
        if (list.size() == nums.length){
            lists.add(new ArrayList<>(list));
            return;
        }

        for (int  i = 0; i < nums.length; i++){
            if (v[i] != 1){
                //剪枝　去除重复组合
                if (i>0 && nums[i] == nums[i-1] && v[i-1] != 1) continue;
                list.add(nums[i]);
                v[i] = 1;
                back(list,nums,v);
                v[i] =0;
                list.remove(list.size()-1);
            }
        }
    }
}
