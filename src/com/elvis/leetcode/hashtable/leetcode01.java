package com.elvis.leetcode.hashtable;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: com.elvis.leetcode.hashtable
 * @Author: Elvis
 * @CreateTime: 2018-12-13 19:15
 * Description:
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。##HashMap的键不重复
 *
 * 示例:
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */
public class leetcode01 {

    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target-nums[i])){
                result[1] = i;
                result[0] = map.get(target-nums[i]);
                return result;
            }
            map.put(nums[i],i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int[] index = new int[2];
        int target = 18;
        try {
            Class clazz = Class.forName("com.elvis.leetcode.hashtable.leetcode01");
            Object obj = clazz.newInstance();
            Method method = clazz.getMethod("twoSum", int[].class, int.class);
            index = (int[]) method.invoke(obj,nums,target);
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < index.length; i++) {
            System.out.println(index[i]);
        }

    }
}
