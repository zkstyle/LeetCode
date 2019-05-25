package com.elvis.leetcode.dp;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: com.elvis.leetcode.dp
 * @Author: Elvis
 * @CreateTime: 2019-05-25 09:02
 * Description:
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 *
 * 示例:
 *
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 * 说明:
 *
 * 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
 * 你算法的时间复杂度应该为 O(n2) 。
 * 进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?
 */
public class Leetcode300 {
    public static int lengthOfLIS(int[] nums) {
        int len = nums.length;
        if(len <= 1){
            return len;
        }
        int maxL = 0;
        //dp[i]: 所有长度为i+1的递增子序列中, 最小的那个序列尾数
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for(int i = 1; i < len; i++){
            if(nums[i] > dp[maxL]){
                dp[++maxL]= nums[i];
            }else{
                int left = 0, right = maxL;
                while(left < right){
                    int mid = left + (right-left)/2;
                    if(dp[mid] == nums[i]){
                        left = mid;
                        break;
                    }else if(dp[mid] < nums[i]){
                        left = left + 1;
                    }else{
                        right =  mid;
                    }
                }
                dp[left] = nums[i];
            }
        }
        return ++maxL;
    }

  static  class Solution{
        public static int lengthOfLIS(int[] nums) {
            if(nums.length <= 1){
                return nums.length;
            }
            //最大长度
            int max = 1;
            //dp[i]表示第i长的子序列，最后的元素
            int[] dp = new int[nums.length + 1];
            dp[1] = nums[0];
            for(int i = 1;i < nums.length;i++){
                //如果当前元素比最大的那个子串的最后一个元素还要大
                //那就直接长度加一，新子串的最后一个元素为当前元素
                if(nums[i] > dp[max]){
                    dp[++max] = nums[i];
                }else if(nums[i] < dp[max]){
                    //如果当前元素比最大的那个子串的最后一个元素要小
                    //那就要更新dp数组，保证每一个子串都是最优解
                    for(int j = 1 ;j <= max; j++){
                        //因为是递增，所以是<=,在将等于的时候直接终止循环
                        if(nums[i] <= dp[j]){
                            dp[j] = nums[i];
                            break;
                        }
                    }
                }
            }
            return max;
        }
    }

    public static void main(String[] args) {
        int[] nums = {10,9,2,5,3,7,101,18}; //
        Leetcode300.lengthOfLIS(nums);
    }

}
