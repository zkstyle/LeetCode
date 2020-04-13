package binarysearch;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: com.elvis.leetcode.array
 * @Author: Elvis
 * @CreateTime: 2019-05-20 10:33
 * Description:
 * 峰值元素是指其值大于左右相邻值的元素。
 *
 * 给定一个输入数组 nums，其中 nums[i] ≠ nums[i+1]，找到峰值元素并返回其索引。
 *
 * 数组可能包含多个峰值，在这种情况下，返回任何一个峰值所在位置即可。
 *
 * 你可以假设 nums[-1] = nums[n] = -∞。
 *
 * 示例 1:
 *
 * 输入: nums = [1,2,3,1]
 * 输出: 2
 * 解释: 3 是峰值元素，你的函数应该返回其索引 2。
 * 示例 2:
 *
 * 输入: nums = [1,2,1,3,5,6,4]
 * 输出: 1 或 5
 * 解释: 你的函数可以返回索引 1，其峰值元素为 2；
 *      或者返回索引 5， 其峰值元素为 6。
 */
public class Leetcode162 {
    /**
     * 方法一: 线性扫描
     * 本方法利用了连续的两个元素 nums[j]  和 nums[j + 1] 不会相等这一事实。
     * 于是，我们可以从头开始遍历 nums  数组。每当我们遇到数字 nums[i] ，只需要检查它是否大于下一个元素 nums[i+1]
     * 即可判断 nums[i] 是否是峰值。可以通过分别讨论问题的全部三种可能情况来理解本方法的思路。
     * 1. 单调递减 第一个点就是峰值
     * 2.　单调递增　最后一个点是峰值
     * 3. 先增后减　在单调性发生变化处是峰值
     *
     */
    public int findPeakElement(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1])
                return i;
        }
        return nums.length - 1;
    }

    /**
     * 标签：二分查找
     * 过程：
     * 首先要注意题目条件，在题目描述中出现了 nums[-1] = nums[n] = -∞，这就代表着 只要数组中存在一个元素比相邻元素大，那么沿着它一定可以找到一个峰值
     * 根据上述结论，我们就可以使用二分查找找到峰值
     * 查找时，左指针 l，右指针 r，以其保持左右顺序为循环条件
     * 根据左右指针计算中间位置 mid，并比较 mid 与 mid+1 的值，如果 mid 较大，则左侧存在峰值，r = mid，
     * 如果 mid + 1 较大，则右侧存在峰值，l = mid + 1
     * 时间复杂度：O(logN)
     */
    public int findPeakElement2(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] > nums[mid + 1])
                r = mid;
            else
                l = mid + 1;
        }
        return l;
    }
}
