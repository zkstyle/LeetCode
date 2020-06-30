package hashmap;

import java.util.HashMap;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: hashmap
 * @Author: elvis
 * @CreateTime: 2020-06-30 17:30
 * @Description: 和为K的子数组
 * 给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
 *
 * 示例 1 :
 *
 * 输入:nums = [1,1,1], k = 2
 * 输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
 * 说明 :
 *
 * 数组的长度为 [1, 20,000]。
 * 数组中元素的范围是 [-1000, 1000] ，且整数 k 的范围是 [-1e7, 1e7]
 */
public class Leetcode560 {

    /**
     * 先计算前缀和　再暴力枚举所有可能
     */
    public int subarraySum(int[] nums, int k) {
        int ans = 0;
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == k) ans++;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] - nums[j] == k) ans++;
            }
        }
        return ans;

    }

    /**
     * 采用数组实现hashmap
     */
    public int subarraySum2(int[] nums, int k) {
        if (nums.length == 0) return 0;
        int max = nums[0];
        int min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
            max = max > nums[i] ? max : nums[i];
            min = min < nums[i] ? min : nums[i];
        }
        int count = 0;
        int map[] = new int[max - min + 1];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == k) {
                count++;
            }
            if (nums[i] - k >= min && nums[i] - k <= max) {
                count += map[nums[i] - k - min];
            }
            map[nums[i] - min]++;
        }
        return count;
    }

    /**
     * 哈希表　保存每一次的中间值
     * 我们可以基于方法一利用数据结构进行进一步的优化，我们知道方法一的瓶颈在于对每个 ii，我们需要枚举所有的 jj 来判断是否符合条件，这一步是否可以优化呢？答案是可以的。
     *
     * 我们定义 pre[i] 为 [0..i]里所有数的和，则 pre[i] 可以由 pre[i−1] 递推而来，即：
     *
     * pre[i]=pre[i−1]+nums[i]
     *
     * 那么[j..i] 这个子数组和为 k这个条件我们可以转化为
     *
     * pre[i]−pre[j−1]==k
     *
     * 简单移项可得符合条件的下标 j 需要满足
     *
     * pre[j−1]==pre[i]−k
     *
     * 所以我们考虑以 i 结尾的和为 k 的连续子数组个数时只要统计有多少个前缀和为 pre[i]-k 的  pre[j] 即可。
     *
     * 我们建立哈希表  mp，以和为键，出现次数为对应的值，记录  pre[i] 出现的次数，从左往右边更新  mp 边计算答案，那么以 i结尾的答案mp[pre[i]−k] 即可在 O(1) 时间内得到。
     * 最后的答案即为所有下标结尾的和为 k 的子数组个数之和。
     *
     * 需要注意的是，从左往右边更新边计算的时候已经保证了mp[pre[i]−k] 里记录的 [j]pre[j] 的下标范围是 0≤j≤i 。同时，由于pre[i] 的计算只与前一项的答案有关，
     *
     * 因此我们可以不用建立pre 数组，直接用 pre 变量来记录 pre[i-1] 的答案即可。
     */
    public int subarraySum3(int[] nums, int k) {
        int count = 0, pre = 0;
        HashMap<Integer, Integer> mp = new HashMap<>();
        mp.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            if (mp.containsKey(pre - k))
                count += mp.get(pre - k);
            mp.put(pre, mp.getOrDefault(pre, 0) + 1);
        }
        return count;
    }
}
