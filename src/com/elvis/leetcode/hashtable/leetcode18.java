package com.elvis.leetcode.hashtable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: com.elvis.leetcode.hashtable
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
public class leetcode18 {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> lists = null;
        List<Integer> list = null;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {

        }



        return lists;
    }

    public static void main(String[] args) {
        int[] nums = {1,0,-1,0,-2,2};
        int target = 0;
        List<List<Integer>> lists = fourSum(nums, target);
        for (List<Integer> list : lists) {
            System.out.println(list.toArray().toString());

        }

    }
}
