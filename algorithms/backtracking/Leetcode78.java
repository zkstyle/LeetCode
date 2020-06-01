package backtracking;

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

    /**
     * 算法思路　深度搜索+回溯思想　
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 0) return res;
        res.add(new ArrayList<>());
        dfs(0, nums, res, new ArrayList<>());
        return res;
    }

    public void dfs(int curIdx, int[] nums, List<List<Integer>> res, List<Integer> l) {
        for (int i = curIdx; i < nums.length; i++) {
            l.add(nums[i]);
            //每次添加组合值
            res.add(new ArrayList<>(l));
            dfs(i + 1, nums, res, l);
            l.remove(l.size() - 1);
        }
    }


    /**
     * 思路分析：
     *
     * 获得一个集合的所有子集，可以将子集按元素个数0，1，2……n来划分，不同长度的子集间肯定不会出现重复。
     * 对于集合，组合的题目都会想到使用回溯，为了简化递归时的传参，将结果集List<List<Integer>> result;设置为成员变量。
     * 在主函数中，首先创建List，然后将空集放入结果集result.add(new ArrayList<>());，如果所给的原集合元素为0就直接返回。否则按子集长度1到nums.length将所有子集放入结果集。
     * 现在定义void backTrack(int[] nums, int k, int start, int[] temp, int curIndex)，用于寻找指定长度的子集的当前元素。
     * 第二个参数int k表示子集的长度，第四个参数int[] temp是长度为k的数组，用于存放子集的元素
     * 第三个参数表示寻找元素应该从原数组索引start处开始寻找子集的当前元素。这是为了避免出现诸如：（1，2，3）与（1，3，2）这样的重复（对于集合是重复），也避免选出（1，1，1）这样不对的集合。
     * 第五个参数表示现在在找子集的第curIndex个元素。
     * 递归开始时，如果curIndex == k说明已经找够k个元素，此时就生成子集放入结果集后结束递归。
     * 然后遍历所有可能的元素，temp[curIndex] = nums[i];，且调用backTrack(nums, k, i + 1, temp, curIndex + 1);表示下一次要找的元素从原集合索引i + 1开始，该元素是第curIndex + 1个。这里回溯通过temp[curIndex]的赋值覆盖完成即可。
     * 在找当前元素时要注意剪枝，这里可以类似题解77. 组合中反思部分的剪枝：
     * 思路就是，如果当前选的元素的索引很靠后，后续剩余可选的元素就不足以凑够k个。
     * 假设当前所选的元素的索引为i，还剩的可选的元素为区间[i + 1, nums.length - 1]，还剩余的元素个数为nums.length - i - 1。
     * 包括i，已选的元素个数为curIndex + 1，要选k个元素，还需要k - curIndex - 1。
     * 要能保证剩余元素能选够k个，就要求nums.length - i - 1 >= k - curIndex - 1，即i <= nums.length - k + curIndex，也就是i < nums.length - k + curIndex + 1
     */
    private List<List<Integer>> result;

    public List<List<Integer>> subsets2(int[] nums) {
        result = new ArrayList<>();

        for (int i = 0; i <= nums.length; i++) {
            backTrack(nums, i, 0, new int[i], 0);
        }
        return result;
    }

    private void backTrack(int[] nums, int k, int start, int[] temp, int curIndex) {
        if (curIndex == k) {
            List<Integer> tempRes = new ArrayList<>();
            for (int i : temp)
                tempRes.add(i);
            result.add(tempRes);
            return;
        }
        // 这里的剪树枝条件，可以参考77题 子集其实也就是一中组合，所以在选数的时候，如果选得太大，会导致后续不够选。
        for (int i = start; i < nums.length - k + curIndex + 1; i++) {
            temp[curIndex] = nums[i];
            backTrack(nums, k, i + 1, temp, curIndex + 1);
        }
    }
}
