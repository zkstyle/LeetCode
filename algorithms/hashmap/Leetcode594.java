package hashmap;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: hashmap
 * @Author: elvis
 * @CreateTime: 2020-06-20 15:21
 * @Description: 最长和谐子序列
 * 和谐数组是指一个数组里元素的最大值和最小值之间的差别正好是1。
 *
 * 现在，给定一个整数数组，你需要在所有可能的子序列中找到最长的和谐子序列的长度。
 *
 * 示例 1:
 *
 * 输入: [1,3,2,2,5,2,3,7]
 * 输出: 5
 * 原因: 最长的和谐数组是：[3,2,2,2,3].
 * 说明: 输入的数组长度最大不超过20,000.
 */
public class Leetcode594 {

    /**
     * 哈希映射 + 单次扫描
     *
     * 我们扫描一次数组，当扫描到元素 x 时，我们首先将 x 加入哈希映射，随后获取哈希映射中 x - 1, x, x + 1 三者出现的次数 u, v, w，
     * 那么 u + v 即为 x - 1, x 组成的和谐子序列的长度，v + w 即为 x, x + 1 组成的和谐子序列的长度。
     * 假设数组中最长的和谐子序列的最后一个元素在数组中的位置为 i，那么在扫描到 nums[i] 时，u + v 和 v + w 中一定有一个就是答案。
     * 因此这种方法可以找到最长的和谐子序列的长度
     */
    public int findLHS1(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>((int) (nums.length / 0.75) + 1);
        int res = 0;
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
            if (map.containsKey(n + 1)) {
                res = Math.max(res, map.get(n) + map.get(n + 1));
            }
            if (map.containsKey(n - 1)) {
                res = Math.max(res, map.get(n) + map.get(n - 1));
            }
        }
        return res;
    }

    /**
     * 排序算法　双指针　end控制数组遍历　start控制起始位置
     * 当start end指向元素差距过大　start++
     * 若等于1 更新res
     *
     * @param nums
     * @return
     */
    public int findLHS(int[] nums) {
        Arrays.sort(nums);
        int begin = 0, res = 0;
        for (int end = 0; end < nums.length; end++) {
            while (nums[end] - nums[begin] > 1)
                begin++;
            if (nums[end] - nums[begin] == 1)
                res = Math.max(res, end - begin + 1);
        }
        return res;
    }
}
