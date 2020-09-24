package set;

import java.util.HashSet;
import java.util.Set;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: set
 * @Author: elvis
 * @CreateTime: 2020-09-22 23:16
 * @Description: 349. 两个数组的交集
 *
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2]
 *
 * 示例 2：
 *
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[9,4]
 *
 *
 *
 * 说明：
 *
 *     输出结果中的每个元素一定是唯一的。
 *     我们可以不考虑输出结果的顺序。
 */
public class Leetcode349 {

    /**
     * 分别将两个数组的数据放入set中
     * 然后对set进行求交集
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int x : nums1) set1.add(x);
        for (int y : nums2) set2.add(y);
        set1.retainAll(set2);
        int[] out = new int[set1.size()];
        int idx = 0;
        for (int x : set1) out[idx++] = x;
        return out;
    }
}
