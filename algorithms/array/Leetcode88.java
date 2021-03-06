package array;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: com.elvis.leetcode.array
 * @Author: Elvis
 * @CreateTime: 2019-05-16 12:38
 * Description:
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 *
 * 说明:
 *
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 * 示例:
 *
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 *
 * 输出: [1,2,2,3,5,6]
 */
public class Leetcode88 {

    /**
     * 采用倒序赋值　首先nums1数组容量>=n+m 所以nums1倒数前n个位置为空
     * 从len=m+n-1最后一个位置赋值
     * 首先m>0&&n>0时　对nums1 nums2元素依次判断大小　并赋值
     * @param nums1
     * @param m 数组nums1中实际元素个数
     * @param nums2
     * @param n　数组nums2中实际元素个数
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums2 == null || nums2.length == 0)
            return;
        int len = m + n - 1;
        while (m > 0 && n > 0) {
            if (nums1[m - 1] > nums2[n - 1]) {
                nums1[len--] = nums1[m - 1];
                m--;
            } else {
                nums1[len--] = nums2[n - 1];
                n--;
            }
        }
        if (m == 0) {
            for (int i = 0; i < n; i++)
                nums1[i] = nums2[i];
        }

    }
}
