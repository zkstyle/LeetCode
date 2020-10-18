package array;

import java.util.Arrays;
import java.util.Random;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: array
 * @Author: elvis
 * @CreateTime: 2020-10-18 23:09
 * @Description: 打乱数组
 * 打乱一个没有重复元素的数组。
 *
 *
 *
 * 示例:
 *
 * // 以数字集合 1, 2 和 3 初始化数组。
 * int[] nums = {1,2,3};
 * Solution solution = new Solution(nums);
 *
 * // 打乱数组 [1,2,3] 并返回结果。任何 [1,2,3]的排列返回的概率应该相同。
 * solution.shuffle();
 *
 * // 重设数组到它的初始状态[1,2,3]。
 * solution.reset();
 *
 * // 随机返回数组[1,2,3]打乱后的结果。
 * solution.shuffle();
 */
public class Leetcode384 {

    int[] origin;
    int[] nums;
    public Leetcode384(int[] nums) {
        this.nums = nums;
        this.origin = Arrays.copyOf(nums, nums.length);
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return origin;
    }

    /** Returns a random shuffling of the array.
     * 每次交换两个元素　交换n次　
     *
     * */
    public int[] shuffle() {
        Random r = new Random();
        int n = nums.length;
        for(int i = 0; i < n; i++){
            int index = i + r.nextInt(n - i);
            swap(i, index);
        }
        return nums;
    }

    private void swap(int x, int y){
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
}
