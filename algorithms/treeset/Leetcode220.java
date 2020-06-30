package treeset;

import java.util.TreeSet;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: com.elvis.leetcode.tree.binary_search_tree
 * @Author: Elvis
 * @CreateTime: 2019-04-18 12:51
 * Description:
 * 给定一个整数数组，判断数组中是否有两个不同的索引 i 和 j，使得 nums [i] 和 nums [j] 的差的绝对值最大为 t，并且 i 和 j 之间的差的绝对值最大为 ķ。
 *
 * 示例 1:
 *
 * 输入: nums = [1,2,3,1], k = 3, t = 0
 * 输出: true
 * 示例 2:
 *
 * 输入: nums = [1,0,1,1], k = 1, t = 2
 * 输出: true
 * 示例 3:
 *
 * 输入: nums = [1,5,9,1,5,9], k = 2, t = 3
 * 输出: false
 */
public class Leetcode220 {


    /**
     * 初始化一颗空的二叉搜索树 set
     * 对于每个元素xx，遍历整个数组
     * 在 set 上查找大于等于x的最小的数，如果s - x≤t则返回 true
     * 在 set 上查找小于等于x的最大的数，如果x - g≤t则返回 true
     * 在 set 中插入x
     * 如果树的大小超过了k , 则移除最早加入树的那个数。
     * 返回 false
     * 我们把大于等于 x 的最小的数 s 当做 x 在 BST 中的后继节点。同样的，我们能把小于等于 x  最大的数 g  当做 xx 在 BST 中的前继节点。
     * s和 g 这两个数是距离 x 最近的数。因此只需要检查它们和 x 的距离就能知道条件二是否满足了。
     * @param nums 数组
     * @param k 下标索引最大差距
     * @param t　数组元素最大差值
     * @return　boolean
     */
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < nums.length; ++i) {
            // Find the successor of current element
            Integer s = set.ceiling(nums[i]);
            if (s != null && s <= nums[i] + t) return true;

            // Find the predecessor of current element
            Integer g = set.floor(nums[i]);
            if (g != null && nums[i] <= g + t) return true;

            set.add(nums[i]);
            if (set.size() > k) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }
}
