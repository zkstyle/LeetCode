package stack;

import java.util.ArrayDeque;
import java.util.Deque;

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

    public int largestRectangleArea(int[] heights) {
        if (heights.length == 0) return 0;
        return getLargestRectangleArea(heights, 0, heights.length);
    }

    public int getLargestRectangleArea(int[] heights, int left, int right) {
        if (left == right) return 0;
        if (left == right - 1)
            return heights[left];
        int shortestIndex = left;
        boolean sorted = true;
        for (int i = left + 1; i < right; ++i) {
            if (heights[i] < heights[i - 1]) sorted = false;
            if (heights[shortestIndex] > heights[i]) shortestIndex = i;
        }
        if (sorted) {
            int max = 0;
            for (int i = left; i < right; i++) {
                int now = heights[i] * (right - i);
                max = Math.max(now, max);
            }
            return max;
        }
        int leftArea = getLargestRectangleArea(heights, left, shortestIndex);
        int rightArea = getLargestRectangleArea(heights, shortestIndex + 1, right);
        return Math.max(Math.max(leftArea, rightArea), (right - left) * heights[shortestIndex]);
    }

    /**
     * 递增栈解法　首先考虑边界　声明一个长度为n+2的数组　两端设置为0 这是为0,heights.length-1边界考虑
     *           每一次如果当前数组值 heights[i]比栈顶元素大　则直接将下标入栈　保持栈内下标所在元素递增
     *           否则　计算循环计算最大值并更新
     * @param heights
     * @return
     */
    public int largestRectangleArea2(int[] heights) {
        int n = heights.length;
        int res = 0;
        int[] height = new int[n + 2];
        for (int i = 1; i < n + 1; i++) height[i] = heights[i - 1];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n + 2; i++) {
            while (!stack.isEmpty() && height[i] < height[stack.peek()]) {
                int h = height[stack.pop()];
                res = Math.max(res, (i - stack.peek() - 1) * h);
            }
            stack.push(i);
        }
        return res;
    }


}
