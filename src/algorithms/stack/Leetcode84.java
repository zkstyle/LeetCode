package algorithms.stack;

import java.util.Stack;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: com.elvis.leetcode.stack
 * @Author: Elvis
 * @CreateTime: 2019-01-20 11:23
 * Description: 柱状图中最大的矩形
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 *
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 *
 * 以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为 [2,1,5,6,2,3]。
 *
 * 图中阴影部分为所能勾勒出的最大矩形面积，其面积为 10 个单位。
 */
public class Leetcode84 {

    /**
     * 20ms 典范
     * @param heights
     * @return
     */
    public static int largestRectangleArea(int[] heights) {
        if(heights.length == 0 || heights == null) return 0;
        Stack<Integer> s = new Stack<>();
        int res = 0;
        for(int i = 0; i < heights.length; i++){
            while(!s.isEmpty() && heights[i] <= heights[s.peek()]){
                int j = s.pop();
                int k = s.isEmpty() ? -1 : s.peek();
                int curArea = (i - k - 1) * heights[j];
                res = Math.max(res, curArea);
            }
            s.push(i);
        }
        while(!s.isEmpty()){
            int i = s.pop();
            int k = s.isEmpty() ? - 1 : s.peek();
            int curArea = (heights.length - k - 1) * heights[i];
            res = Math.max(res, curArea);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] heights = {2,1,5,6,2,3};
        System.out.println(largestRectangleArea(heights));
    }
}
