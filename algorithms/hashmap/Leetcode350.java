package hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: hashmap
 * @Author: elvis
 * @CreateTime: 2020-06-10 21:53
 * @Description: 两个数组的交集II
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 * 示例 1:
 *
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2,2]
 * 示例 2:
 *
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [4,9]
 * 说明：
 *
 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
 * 我们可以不考虑输出结果的顺序。
 * 进阶:
 *
 * 如果给定的数组已经排好序呢？你将如何优化你的算法？
 * 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
 * 如果 nums2 的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
 */
public class Leetcode350 {

    /**
     * 首先判断nums1或者nums2是否为空　为空就返回空集
     * 将nums1的值与数量存放入map中
     * 然后遍历nums2 如果nums2中的值y存在于map中且不为0　就添加到ans中
     * 最后将 ans的值传入　数组中
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length == 0 || nums2.length == 0) return new int[]{};
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> ans = new ArrayList<>();
        for (int x : nums1) map.put(x, map.getOrDefault(x, 0) + 1);
        for (int y : nums2)
            if (map.getOrDefault(y, 0) != 0) {
                ans.add(y);
                map.put(y, map.get(y) - 1);
            }
        int[] res = new int[ans.size()];
        int idx = 0;
        for (int x : ans) res[idx++] = x;
        return res;
    }

}
