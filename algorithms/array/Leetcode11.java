package array;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: com.elvis.leetcode.array
 * @Author: Elvis
 * @CreateTime: 2019-03-08 15:06
 * Description: 盛最多水的容器
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai)
 * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 *
 * 图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。
 * 在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 */
public class Leetcode11 {

    /**
     * 利用双指针 分别进行左右遍历　首先若height[left] < height[right]
     *          根据木桶效应　以短板高度　计算容纳水的体积　height[left] * (right - left)　然后更新最大值
     *          反之一样　以右边高度为准
     *          至于指针更新肯定是更新低的一侧　因为长度一定　限定体积的是高度　否则即使找到更高的高度也没有用处
     *          因为以短板高度作为容水高度
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int l = 0, r = height.length - 1, max = 0;
        while (l < r) {
            int area = (r - l) * (height[l] > height[r] ? height[r--] : height[l++]);
            max = area > max ? area : max;

        }
        return max;
    }
}
