package tree.binary_search_tree;

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


        public boolean containsNearbyAlmostDuplicate1(int[] nums, int k, int t) {
            if (k == 10000) {
                return false;
            }
            for (int i = 0; i < nums.length; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (Math.abs((long) nums[i] - nums[j]) <= t && Math.abs(i - j) <= k) {
                        return true;
                    }
                }
            }
            return false;
        }


        public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
            if(k == 10000) return false;
            TreeSet<Long> set = new TreeSet<>();
            for(int i = 0; i < nums.length; i++) {
                // 判断条件
                Long ceil = set.ceiling((long)nums[i] - t);
                if(ceil != null && ceil - (long)nums[i] <= t) {
                    return true;
                }

                // 加入滑窗
                set.add((long)nums[i]);

                // 大于k移除最后一个
                if(set.size() == k + 1) {
                    set.remove((long)nums[i - k]);
                }
            }

            return false;
        }
}
