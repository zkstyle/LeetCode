package set;

import java.util.HashSet;
import java.util.Set;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: set
 * @Author: elvis
 * @CreateTime: 2020-07-02 22:10
 * @Description: 错误的集合
 * 集合 S 包含从1到 n 的整数。不幸的是，因为数据错误，导致集合里面某一个元素复制了成了集合里面的另外一个元素的值，导致集合丢失了一个整数并且有一个元素重复。
 *
 * 给定一个数组 nums 代表了集合 S 发生错误后的结果。你的任务是首先寻找到重复出现的整数，再找到丢失的整数，将它们以数组的形式返回。
 *
 * 示例 1:
 *
 * 输入: nums = [1,2,2,4]
 * 输出: [2,3]
 * 注意:
 *
 * 给定数组的长度范围是 [2, 10000]。
 * 给定的数组是无序的。
 */
public class Leetcode645 {


    /**
     * 时间复杂度 O(n) 空间复杂度O(n)
     * 首先查找到重复的数字　用set检查
     * 其次　计算数组元素之和　1+2..+n求和
     * 那么另一个缺失的数字就是　res[0]+n-sum 缺失的差值
     */
    public int[] findErrorNums(int[] nums) {
        int n = nums.length, sum = 0;
        int[] res = new int[2];
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            sum += num;
            if (!set.add(num)) res[0] = num;
        }
        n = (n + 1) * n / 2;
        res[1] = res[0] + n - sum;
        return res;
    }
}
