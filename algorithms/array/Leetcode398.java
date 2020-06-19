package array;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: array
 * @Author: elvis
 * @CreateTime: 2020-06-17 17:00
 * @Description: 随机数索引
 * 给定一个可能含有重复元素的整数数组，要求随机输出给定的数字的索引。 您可以假设给定的数字一定存在于数组中。
 *
 * 注意：
 * 数组大小可能非常大。 使用太多额外空间的解决方案将不会通过测试。
 *
 * 示例:
 *
 * int[] nums = new int[] {1,2,3,3,3};
 * Solution solution = new Solution(nums);
 *
 * // pick(3) 应该返回索引 2,3 或者 4。每个索引的返回概率应该相等。
 * solution.pick(3);
 *
 * // pick(1) 应该返回 0。因为只有nums[0]等于1。
 * solution.pick(1);
 */
public class Leetcode398 {

    int[] nums;

    public Leetcode398(int[] nums) {
        this.nums = nums;
    }
    //获取随机下标
    Random random = new Random();

    /**
     * 首先将满足目标的结果存放到"池子"里
     * 再从池子里随机选择一个
     *
     * @tag 蓄水池抽样
     */
    public int pick(int target) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            //将每一个满足条件的元素下标存到list中
            if (nums[i] == target) list.add(i);
        }
        //从list中随机获取一个下标
        return list.get(random.nextInt(list.size()));
    }
}
