package array;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: array
 * @Author: elvis
 * @CreateTime: 2020-07-02 22:15
 * @Description: 区间子数组个数
 * 给定一个元素都是正整数的数组A ，正整数 L 以及 R (L <= R)。
 *
 * 求连续、非空且其中最大元素满足大于等于L 小于等于R的子数组个数。
 *
 * 例如 :
 * 输入:
 * A = [2, 1, 4, 3]
 * L = 2
 * R = 3
 * 输出: 3
 * 解释: 满足条件的子数组: [2], [2, 1], [3].
 * 注意:
 *
 * L, R  和 A[i] 都是整数，范围在 [0, 10^9]。
 * 数组 A 的长度范围在[1, 50000]。
 */
public class Leetcode795 {

    /**
     * 其实我们只关心数组中的元素是否小于 L，大于 R，或者位于 [L, R] 之间。假设一个元素小于 L 标记为 0，位于 [L, R] 之间标记为 1，大于 R 标记为 2。
     *
     * 我们希望找出不包含 2 且至少包含一个 1 的子数组数量。因此可以看作是所有的 2 将数组拆分为仅包含 0 或 1 的子数组。例如在数组 [0, 0, 1, 2, 2, 1, 0, 2, 0]，
     *
     * 2 将数组拆分为 [0, 0, 1]、[1, 0] 和 [0] 三个子数组。
     *
     * 接下来，需要计算每个只包含 0 或 1 的数组中，至少包含一个 1 的子数组数量。那么问题可以转换为先找出所有的子数组，再从中减去只包含 0 的子数组。
     *
     * 例如，[0, 0, 1] 有 6 个子数组，其中 3 个子数组只包含 0，3 个子数组至少包含一个 1；[1, 0] 有 3 个子数组，其中 1 个子数组只包含 0，2 个子数组至少包含一个 1；[0] 只有 1 个子数组，且这个子数组只包含 0。因此数组 A = [0, 0, 1, 2, 2, 1, 0, 2, 0] 中不包含 2，且至少包含一个 1 的子数组的数量是 3 + 2 + 0 = 5。
     */
    public int numSubarrayBoundedMax(int[] A, int L, int R) {
        return count(A, R) - count(A, L - 1);
    }

    public int count(int[] A, int bound) {
        int ans = 0, cur = 0;
        for (int x : A) {
            //计算小于bound的子数组个数
            cur = x <= bound ? cur + 1 : 0;
            ans += cur;
        }
        return ans;
    }
}