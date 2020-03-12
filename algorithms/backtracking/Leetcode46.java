package backtracking;

import java.util.*;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: com.elvis.leetcode.array
 * @Author: Elvis
 * @CreateTime: 2019-03-18 12:59
 * Description: 全排列
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。
 *
 * 示例:
 *
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 */
public class Leetcode46 {

    /*
    *   回溯算法　遍历所有可能　因为是全排列
    *   递归出口自然是元素个数为数组nums长度
    *   是否可以添加list条件为判断该元素是否已存在ist集合中
     */
    private List<List<Integer>> lists = new ArrayList<>();
    public List<List<Integer>> permute1(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int n = nums.length;
        back(list, nums, n);
        return lists;
    }

    private void back(List<Integer> list, int[] nums, int n) {
        //递归出口
        if (n == list.size()) {
            lists.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < n; i++) {
            //如果不存在　再添加到集合中
            if (!list.contains(nums[i])) {
                list.add(nums[i]);
                back(list, nums, n);
                //若是不满足条件　则移除该元素　进入下一次的回溯
                list.remove(list.size() - 1);
            }

        }
    }

}
