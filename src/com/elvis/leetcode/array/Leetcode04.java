package com.elvis.leetcode.array;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: com.elvis.leetcode.array
 * @Author: Elvis
 * @CreateTime: 2019-03-07 10:57
 * Description: 寻找两个有序数组的中位数
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 *
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 *
 * 你可以假设 nums1 和 nums2 不会同时为空。
 *
 * 示例 1:
 *
 * nums1 = [1, 3]
 * nums2 = [2]
 *
 * 则中位数是 2.0
 * 示例 2:
 *
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 *
 * 则中位数是 (2 + 3)/2 = 2.5
 */
public class Leetcode04 {
    /**
     * 分治法节选部分思想
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length + nums2.length];
        double result;
        int i = 0, j = 0, k = 0;
        while (i <= nums1.length - 1 && j <= nums2.length - 1){
            if (nums1[i] < nums2[j]){
                res[k++] = nums1[i++];
            }else {
                res[k++] = nums2[j++];
            }
        }
        while (i <= nums1.length - 1){
            res[k++] = nums1[i++];
        }
        while (j <= nums2.length - 1){
            res[k++] = nums2[j++];
        }
        if (res.length % 2 == 0){
            result = (res[res.length / 2] + res[res.length / 2 - 1]) / 2.0;
        }else {
            result = res[res.length / 2];
        }
        return result;
    }
}
