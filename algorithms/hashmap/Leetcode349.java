package hashmap;

import java.util.HashSet;
import java.util.Set;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: hashmap
 * @Author: elvis
 * @CreateTime: 2020-06-10 21:42
 * @Description: 两个数组的交集
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 * 示例 1:
 *
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2]
 * 示例 2:
 *
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [9,4]
 * 说明:
 *
 * 输出结果中的每个元素一定是唯一的。
 * 我们可以不考虑输出结果的顺序。
 */
public class Leetcode349 {

    /**
     * 首先判断nums1或者nums2是否为空　为空就返回空集
     * 将nums1的值存放入set中
     * 然后遍历nums2 如果nums2中的值y存在于set中　就添加到ans中
     * 最后将 ans的值传入　数组中
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1.length == 0 || nums2.length == 0) return new int[]{};
        Set<Integer> set = new HashSet<>();
        Set<Integer> ans = new HashSet<>();
        for (int x : nums1) set.add(x);
        for (int y : nums2) if (set.contains(y)) ans.add(y);
        int[] res = new int[ans.size()];
        int idx = 0;
        for (int x : ans) res[idx++] = x;
        return res;
    }
}
