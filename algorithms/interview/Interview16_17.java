package interview;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: interview
 * @Author: elvis
 * @CreateTime: 2020-10-04 23:10
 * @Description: 面试题 16.17. 连续数列
 * 给定一个整数数组，找出总和最大的连续数列，并返回总和。
 *
 * 示例：
 *
 * 输入： [-2,1,-3,4,-1,2,1,-5,4]
 * 输出： 6
 * 解释： 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 进阶：
 *
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 */
public class Interview16_17 {

    /**
     * 如果当前前缀数组和<0 则从下一个重新计算cur
     */
    public int maxSubArray(int[] nums) {
        int max=nums[0];
        int cur=nums[0];
        for(int i=1;i<nums.length;i++){
            if(cur<0){
                cur=nums[i];
            }else{
                cur+=nums[i];
            }
            max=Math.max(cur,max);
        }
        return max;
    }
}
