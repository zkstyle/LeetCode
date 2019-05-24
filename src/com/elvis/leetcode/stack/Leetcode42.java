package com.elvis.leetcode.stack;

import java.util.Stack;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: com.elvis.leetcode.stack
 * @Author: Elvis
 * @CreateTime: 2019-01-14 16:12
 * Description: 接雨水问题
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。

 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Marcos 贡献此图。
 *
 * 示例:
 *
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 */
public class Leetcode42 {

    /**
     * O(n) time  O(1) space
     * @param height
     * @return
     */
    public static int trap(int [] height){
        if (height.length < 3)
            return 0;
        int ans = 0;
        int l = 0, r = height.length - 1;
        //find the left and right edge which can hold water
        while (l < r && height[l] <= height[l + 1]) l++;
        while (l < r && height[r] <= height[r - 1]) r--;
        while (l < r){
            int left = height[l];
            int right = height[r];
            if (left <= right){
                // add volum until an edge larger than the left edge
                while (l < r && left >= height[++l]){
                    ans += left - height[l];
                }
            }else {
                // add volum until an edge larger than the right edge
                while (l < r && height[--r] <= right){
                    ans += right - height[r];
                }
            }
        }
        return ans;
    }



    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        int s = trap(height);
        System.out.println(s);
    }
}
