package array;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: array
 * @Author: elvis
 * @CreateTime: 2020-09-30 11:38
 * @Description: 最大连续1的个数
 * 给定一个二进制数组， 计算其中最大连续1的个数。
 *
 * 示例 1:
 *
 * 输入: [1,1,0,1,1,1]
 * 输出: 3
 * 解释: 开头的两位和最后的三位都是连续1，所以最大连续1的个数是 3.
 * 注意：
 *
 * 输入的数组只包含 0 和1。
 * 输入数组的长度是正整数，且不超过 10,000。
 */
public class Leetcode485 {

    /**
     * 统计每一段1的个数　最后比较最大1的个数与最后一段1的个数值
     */
    public int findMaxConsecutiveOnes(int[] nums) {
        int max=0,cur=0;
        for(int x:nums){
            if(x==1){
                cur++;
            }else{
                max=Math.max(cur,max);
                cur=0;
            }
        }
        return Math.max(max,cur);
    }
}
