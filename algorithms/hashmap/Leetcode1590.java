package hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: hashmap
 * @Author: elvis
 * @CreateTime: 2020-09-25 14:09
 * @Description: 使数组和能被P整除
 * 给你一个正整数数组 nums，请你移除 最短 子数组（可以为 空），使得剩余元素的 和 能被 p 整除。 不允许 将整个数组都移除。
 *
 * 请你返回你需要移除的最短子数组的长度，如果无法满足题目要求，返回 -1 。
 *
 * 子数组 定义为原数组中连续的一组元素。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [3,1,4,2], p = 6
 * 输出：1
 * 解释：nums 中元素和为 10，不能被 p 整除。我们可以移除子数组 [4] ，剩余元素的和为 6 。
 * 示例 2：
 *
 * 输入：nums = [6,3,5,2], p = 9
 * 输出：2
 * 解释：我们无法移除任何一个元素使得和被 9 整除，最优方案是移除子数组 [5,2] ，剩余元素为 [6,3]，和为 9 。
 * 示例 3：
 *
 * 输入：nums = [1,2,3], p = 3
 * 输出：0
 * 解释：和恰好为 6 ，已经能被 3 整除了。所以我们不需要移除任何元素。
 * 示例  4：
 *
 * 输入：nums = [1,2,3], p = 7
 * 输出：-1
 * 解释：没有任何方案使得移除子数组后剩余元素的和被 7 整除。
 * 示例 5：
 *
 * 输入：nums = [1000000000,1000000000,1000000000], p = 3
 * 输出：0
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 109
 * 1 <= p <= 109
 */
public class Leetcode1590 {

    public int minSubarray(int[] nums, int p) {
        int n = nums.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            sum %= p;
        }
        int mod = sum % p;
        if (mod == 0) return 0;
        sum = 0;
        int min = n;
        Map<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(0, -1);
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            sum %= p;
            int curMod = sum % p;
            hashMap.put(curMod, i);
            int targetMod = curMod >= mod ? curMod - mod : curMod - mod + p;
            if (hashMap.containsKey(targetMod)) {
                min = Math.min(min, i - hashMap.get(targetMod));
            }
        }
        return min == n ? -1 : min;
    }
}
