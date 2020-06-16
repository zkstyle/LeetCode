package sort;

import java.util.Arrays;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: sort
 * @Author: elvis
 * @CreateTime: 2020-06-13 15:46
 * @Description: 数组第k大的数
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 * 示例 1:
 *
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * 示例 2:
 *
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 * 说明:
 *
 * 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
 */
public class Leetcode215 {

    /**
     * 直接利用工具类直接排序　返回倒数第k个数
     */
    public int findKthLargest(int[] nums, int k) {
        int n=nums.length;
        Arrays.sort(nums);
        return nums[n-k];
    }

    /**
     * 快速排序　
     */
    public int findKthLargest2(int[] nums, int k) {
        return quickSelectK(nums, k, 0, nums.length - 1);
    }

    /**
     * 递归排序第K大的数据，基本思想为快排+partition算法
     *
     * @param nums 输入数组
     * @param k    k值
     * @param low  起始下标
     * @param high 终止下标
     * @return 第 k 大的数据
     */
    private int quickSelectK(int[] nums, int k, int low, int high) {
        int pivot;
        // 保存当前查找的起始和终止下标
        int start = low, end = high;
        if (low < high) {
            pivot = nums[(high + low) / 2];
            nums[(high + low) / 2] = nums[high];
            nums[high] = pivot;

            while (low < high) {
                while (low < high && nums[low] >= pivot) {
                    low++;
                }
                if (low < high) {
                    nums[high] = nums[low];
                    high--;
                }
                while (low < high && nums[high] < pivot) {
                    high--;
                }
                if (low < high) {
                    nums[low] = nums[high];
                    low++;
                }
            }
            nums[low] = pivot;
            if (low < k - 1) {
                return quickSelectK(nums, k, low + 1, end);
            } else {
                return quickSelectK(nums, k, start, low - 1);
            }
        }
        return nums[k - 1];
    }
}
