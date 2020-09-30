package dp;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: dp
 * @Author: elvis
 * @CreateTime: 2020-09-28 23:15
 * @Description: 删除与获得点数
 * 给定一个整数数组 nums ，你可以对它进行一些操作。
 *
 * 每次操作中，选择任意一个 nums[i] ，删除它并获得 nums[i] 的点数。之后，你必须删除每个等于 nums[i] - 1 或 nums[i] + 1 的元素。
 *
 * 开始你拥有 0 个点数。返回你能通过这些操作获得的最大点数。
 *
 * 示例 1:
 *
 * 输入: nums = [3, 4, 2]
 * 输出: 6
 * 解释:
 * 删除 4 来获得 4 个点数，因此 3 也被删除。
 * 之后，删除 2 来获得 2 个点数。总共获得 6 个点数。
 * 示例 2:
 *
 * 输入: nums = [2, 2, 3, 3, 3, 4]
 * 输出: 9
 * 解释:
 * 删除 3 来获得 3 个点数，接着要删除两个 2 和 4 。
 * 之后，再次删除 3 获得 3 个点数，再次删除 3 获得 3 个点数。
 * 总共获得 9 个点数。
 * 注意:
 *
 * nums的长度最大为20000。
 * 每个整数nums[i]的大小都在[1, 10000]范围内。
 */
public class Leetcode740 {

    /**
     * 首先，我们先明确一个概念，就是每个位置上的数字是可以在两种前结果之上进行选择的：
     *
     * 如果你不删除当前位置的数字，那么你得到就是前一个数字的位置的最优结果。
     * 如果你觉得当前的位置数字i需要被删，那么你就会得到i - 2位置的那个最优结果加上当前位置的数字乘以个数。
     * 以上两个结果，你每次取最大的，记录下来，然后答案就是最后那个数字了。
     *
     *
     * 我们在原来的 nums 的基础上构造一个临时的数组 all，这个数组，以元素的值来做下标，下标对应的元素是原来的元素的个数。
     *
     * 举个例子：
     *
     * nums = [2, 2, 3, 3, 3, 4]
     *
     * 构造后：
     *
     * all=[0, 0, 2, 3, 1];
     *
     * 就是代表着 2 的个数有两个，3 的个数有 3 个，4 的个数有 1 个。
     *
     * 其实这样就可以变成打家劫舍的问题了
     *
     * dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
     *
     * 再来看看现在对这个问题的最优子结构公式：
     *
     * dp[i] = Math.max(dp[i - 1], dp[i - 2] + i * all[i]);
     */
    public int deleteAndEarn(int[] nums) {
        if (nums == null | nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int max = nums[0];
        for (int x : nums) max = Math.max(max, x);
        int[] all = new int[max + 1];
        for (int y : nums) all[y]++;
        int[] dp = new int[max + 1];
        dp[1] = all[1];
        dp[2] = Math.max(all[1], all[2] * 2);
        for (int i = 3; i <= max; i++)
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + all[i] * i);
        return dp[max];
    }
}
