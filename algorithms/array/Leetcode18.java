package array;

import java.util.*;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: com.elvis.leetcode.hashmap
 * @Author: Elvis
 * @CreateTime: 2018-12-15 10:47
 * Description:
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 *
 * 注意：
 *
 * 答案中不可以包含重复的四元组。
 * 判断不重复　则至少三个不重复
 *
 * 示例：
 *
 * 给定数组 nums = [1, 0, -1, 0, -2, 2]和 target = 0。
 *
 * 满足要求的四元组集合为：
 * [
 *   [-1,  0, 0, 1],
 *   [-2, -1, 1, 2],
 *   [-2,  0, 0, 2]
 * ]
 */
public class Leetcode18 {
    /**
     * int[] nums = {1,0,-1,0,-2,2};
     *
     * @param nums
     * @param target
     * @return
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length < 4) return ans;
        int len = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < len - 3; i++) {
            // 作为最小的元素　防止四个数过大　先做一个判断
            if (nums[i] * 4 > target) break;
            //跳过相同元素，避免重复解
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for (int j = len - 1; j - i > 2; j--) {
                // 作为最大的元素　防止四个数过小　先做一个判断
                if (nums[j] * 4 < target) break;
                //跳过相同元素，避免重复解
                if (j < len - 1 && nums[j] == nums[j + 1]) continue;
                int L = i + 1, R = j - 1;
                while (L < R) {
                    int sum = nums[i] + nums[j] + nums[L] + nums[R];
                    if (sum == target) {
                        ans.add(Arrays.asList(nums[i], nums[j], nums[L], nums[R]));
                        //跳过相同元素，避免重复解
                        while (L < R && nums[L] == nums[L + 1]) L++;
                        while (L < R && nums[R] == nums[R - 1]) R--;
                        L++;
                        R--;
                    } else if (sum < target) {
                        while (L < R && nums[L] == nums[L + 1]) L++;
                        L++;
                    } else {
                        while (L < R && nums[R] == nums[R - 1]) R--;
                        R--;
                    }

                }
            }
        }
        return ans;
    }
}
