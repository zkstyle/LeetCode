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

    List<List<Integer>> lists = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);  //排序　因为重复元素
        back(nums, new ArrayList(), 0);
        return lists;
    }

    /**
     * 首先每次都添加list结果到lists中
     * 循环添加数组元素　首先判断剪枝　若i>idx(起始位置)且等于前一个元素　则跳过
     * 添加元素　回溯　移除元素
     * @param nums 数组
     * @param list　存储满足条件结果
     * @param idx　每次dfs起始下标
     */
    private void back(int[] nums, List<Integer> list, int idx) {

        lists.add(new ArrayList(list));

        for (int i = idx; i < nums.length; i++) {
            if (i > idx && nums[i] == nums[i - 1]) continue;
            list.add(nums[i]);
            back(nums, list, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
