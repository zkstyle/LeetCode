package swordmeansoffer;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: swordmeansoffer
 * @Author: elvis
 * @CreateTime: 2020-05-04 08:32
 * @Description:面试题11. 旋转数组的最小数字
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。  
 *
 * 示例 1：
 *
 * 输入：[3,4,5,1,2]
 * 输出：1
 * 示例 2：
 *
 * 输入：[2,2,2,0,1]
 * 输出：0
 */
public class SMO11 {

    /**
     * 算法流程：
     * 循环二分： 设置 ii, jj 指针分别指向 numbers 数组左右两端，m = (i + j) /2 为每次二分的中点（ 代表向下取整除法，因此恒有 i≤m≤j ），可分为以下三种情况：
     * 当 numbers[m] > numbers[j]时： m 一定在 左排序数组 中，即旋转点 x 一定在 [m + 1, j] 闭区间内，因此执行 i = m + 1
     * 当 numbers[m] < numbers[j] 时： mm 一定在 右排序数组 中，即旋转点 x 一定在[i, m] 闭区间内，因此执行 j = m
     * 当 numbers[m] == numbers[j] 时： 无法判断 m 在哪个排序数组中，即无法判断旋转点 x 在 [i, m] 还是 [m + 1, j] 区间中。解决方案： 执行 j = j - 1 缩小判断范围
     * 返回值： 当 i = j 时跳出二分循环，并返回 numbers[i] 即可。
     * @param nums
     * @return
     */
    public int minArray(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] > nums[r]) {
                l = mid + 1;
            } else if (nums[mid] < nums[r]) {
                r = mid;
            } else {
                r--;
            }
        }
        return nums[l];
    }
}
