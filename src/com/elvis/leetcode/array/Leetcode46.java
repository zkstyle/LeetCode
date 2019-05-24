package com.elvis.leetcode.array;

import java.util.*;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: com.elvis.leetcode.array
 * @Author: Elvis
 * @CreateTime: 2019-03-18 12:59
 * Description: 全排列
 */
public class Leetcode46 {

    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0){
            return null;
        }
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++){
            list.add(nums[i]);
        }
        int n = 1;
        for (int i = 1; i <= nums.length; i++) {
            n *= i;
        }
        lists.add(list);
        add(nums, lists, n);
        return lists;
    }

    private void add(int[] nums, List<List<Integer>> lists, int n){
        if (n == lists.size()){
            return;
        }
        List<Integer> list = new ArrayList<>();
        int i = nums.length - 2;
        while (i >= 0 && nums[i + 1] < nums[i]){
            i--;
        }
        if (i >= 0){
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i]){
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
        for (int k = 0; k < nums.length; k++){
            list.add(nums[k]);
        }
        lists.add(list);
        add(nums, lists, n);
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int start){
        int end = nums.length - 1;
        while (start < end){
            swap(nums, start, end);
            start++;
            end--;
        }
    }
}
