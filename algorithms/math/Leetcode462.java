package math;

import java.util.Arrays;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: math
 * @Author: elvis
 * @CreateTime: 2020-08-20 10:02
 * @Description: 最小移动次数II
 * 给定一个非空整数数组，找到使所有数组元素相等所需的最小移动数，其中每次移动可将选定的一个元素加1或减1。 您可以假设数组的长度最多为10000。
 *
 * 例如:
 *
 * 输入:
 * [1,2,3]
 *
 * 输出:
 * 2
 *
 * 说明：
 * 只有两个动作是必要的（记得每一步仅可使其中一个元素加1或减1）：
 *
 * [1,2,3]  =>  [2,2,3]  =>  [2,2,2]
 */
public class Leetcode462 {

    /**
     * 假设最终数组 a 中的每个数均为 x，那么需要移动的次数即为 |a[0] - x| + |a[1] - x| + ... + |a[n-1] - x|。
     *
     * 如果我们把数组 a 中的每个数看成水平轴上的一个点，那么根据上面的移动次数公式，我们需要找到在水平轴上找到一个点 x，使得这 N 个点到 x 的距离之和最小。
     *
     * 这是一个经典的数学问题，当 x 为这个 N 个数的中位数时，可以使得距离最小。具体地，若 N 为奇数，则 x 必须为这 N 个数中的唯一中位数；
     *
     * 若 N 为偶数，中间的两个数为 p 和 q，中位数为 (p + q) / 2，此时 x 只要是区间 [p, q] 中的任意一个数即可。
     *
     */
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int num : nums) {
            sum += Math.abs(nums[nums.length / 2] - num);
        }
        return sum;
    }

    public void quickSort(int[] nums, int left, int right) {
        if (left > right) return;
        int i = left, j = right;
        int pivot = nums[left];
        while (i < j) {
            while (i < j && nums[i] <= pivot) i++;
            while (i < j && nums[j] >= pivot) j--;
            if (i < j) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
            }
        }
        nums[left] = nums[i];
        nums[i] = pivot;
        quickSort(nums, left, i - 1);
        quickSort(nums, i + 1, right);

    }



}
