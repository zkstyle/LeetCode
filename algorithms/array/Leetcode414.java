package array;

import java.util.PriorityQueue;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: array
 * @Author: elvis
 * @CreateTime: 2020-06-19 22:34
 * @Description: 给定一个非空数组，返回此数组中第三大的数。如果不存在，则返回数组中最大的数。要求算法时间复杂度必须是O(n)。
 *
 * 示例 1:
 *
 * 输入: [3, 2, 1]
 *
 * 输出: 1
 *
 * 解释: 第三大的数是 1.
 * 示例 2:
 *
 * 输入: [1, 2]
 *
 * 输出: 2
 *
 * 解释: 第三大的数不存在, 所以返回最大的数 2 .
 * 示例 3:
 *
 * 输入: [2, 2, 3, 1]
 *
 * 输出: 1
 *
 * 解释: 注意，要求返回第三大的数，是指第三大且唯一出现的数。
 * 存在两个值为2的数，它们都排第二。
 */
public class Leetcode414 {

    /**
     * 优先队列　每次更新3个最大的值　最后返回第三大的值
     */
    public int thirdMax(int[] nums) {
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (queue.contains(nums[i])) {
                continue;
            }
            if (queue.size() < 3) {
                queue.add(nums[i]);
            } else {
                if (nums[i] > queue.peek()) {
                    queue.poll();
                    queue.add(nums[i]);
                }
            }
        }
        if (queue.size() == 3) return queue.peek();
        else if (queue.size() == 2) {
            queue.poll();
            return queue.poll();
        } else {
            return queue.poll();
        }
    }
}
