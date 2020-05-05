package swordmeansoffer;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: swordmeansoffer
 * @Author: elvis
 * @CreateTime: 2020-05-05 14:08
 * @Description: 面试题39. 数组中出现次数超过一半的数字
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。　
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。　
 *
 * 示例 1:
 *
 * 输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
 * 输出: 2
 *
 *
 * 限制：
 *
 * 1 <= 数组长度 <= 50000
 */
public class SMO39 {

    /**
     * 摩尔投票法　首先任意选择一个数　作为假想众数
     * 依次遍历后面的数　vote作为投票计数　若vote减少到0
     * 则从新选择一个数　继续投票
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        int x = 0, votes = 0;
        for (int num : nums) {
            if (votes == 0) x = num;
            votes += num == x ? 1 : -1;
        }
        return x;
    }
}
