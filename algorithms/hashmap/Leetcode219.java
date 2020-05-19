package hashmap;

import java.util.HashSet;
import java.util.Set;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: hashmap
 * @Author: elvis
 * @CreateTime: 2020-05-08 13:49
 * @Description: 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，
 *
 * 并且 i 和 j 的差的 绝对值 至多为 k。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: nums = [1,2,3,1], k = 3
 * 输出: true
 * 示例 2:
 *
 * 输入: nums = [1,0,1,1], k = 1
 * 输出: true
 * 示例 3:
 *
 * 输入: nums = [1,2,3,1,2,3], k = 2　
 */
public class Leetcode219 {

    /**
     * 二次遍历　对于任意一个元素nums[i]
     * 查找0~i-1中有没有重复元素
     */
    public boolean containsNearbyDuplicate2(int[] nums, int k) {
        for (int i = 1; i < nums.length; i++)
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j]) {
                    break;
                } else if (nums[j] == nums[i] && (i - j <= k)) return true;
            }
        return false;
    }

    /**
     * 将元素存入HashSet 判断是否有重复元素
     *  根据set.add方法插入成功失败判断重复
     *  然后保证set最多k个元素　大于k时　移除第i-k个元素　也就是当前set中第一个元素
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; ++i) {
            if (set.contains(nums[i])) return true;
            set.add(nums[i]);
            if (set.size() > k) {
                set.remove(nums[i - k]);
            }
        }
        System.out.println();
        return false;
    }
}
