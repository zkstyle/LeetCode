package com.elvis.leetcode.hashtable;

import java.util.*;

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
    public static List<List<Integer>> fourSum1(int[] nums, int target) {
        List<List<Integer>> lists = null;
        List<Integer> list = null;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {

        }



        return lists;
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Set<List<Integer>> listSet = new HashSet<>();
        int n = nums.length;
        Arrays.sort(nums);//数据排序
        HashMap<Integer, List<Integer[]>> hashMap = new HashMap<>();
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                int num = nums[i] + nums[j];
                Integer[] pair = {i, j};
                if(hashMap.containsKey(num)) {
                    hashMap.get(num).add(pair);
                }else {
                    List<Integer[]> list = new ArrayList<>();
                    list.add(pair);
                    hashMap.put(num, list);
                }
            }
        }
        for(Integer integer : hashMap.keySet()) {
            if(hashMap.containsKey(target - integer)) {
                List<Integer[]> list1 = hashMap.get(integer);
                List<Integer[]> list2 = hashMap.get(target - integer);
                for(Integer[] pair1 : list1) {
                    int index1 = pair1[0];
                    int index2 = pair1[1];
                    for(Integer[] pair2 : list2) {
                        int index3 = pair2[0];
                        int index4 = pair2[1];
                        if(index2 < index3) {
                            List<Integer> list = new ArrayList<>();
                            list.add(nums[index1]);
                            list.add(nums[index2]);
                            list.add(nums[index3]);
                            list.add(nums[index4]);
                            listSet.add(list);
                        }
                    }
                }
            }
        }
        return new ArrayList<>(listSet);
    }


    public static void main(String[] args) {
        int[] nums = {1,0,-1,0,-2,2};
        int target = 0;
        List<List<Integer>> lists = fourSum(nums, target);
        for (List<Integer> list : lists) {
            for (Object i : list.toArray()){
                System.out.print(i+" ");
            }
            System.out.println();
        }

    }
}
