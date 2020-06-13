package bit;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: bit
 * @Author: elvis
 * @CreateTime: 2020-06-13 16:16
 * @Description: 只出现一次的数字III
 * 给定一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。
 *
 * 示例 :
 *
 * 输入: [1,2,1,3,2,5]
 * 输出: [3,5]
 * 注意：
 *
 * 结果输出的顺序并不重要，对于上面的例子， [5, 3] 也是正确答案。
 * 你的算法应该具有线性时间复杂度。你能否仅使用常数空间复杂度来实现？
 */
public class Leetcode260 {

    public int[] singleNumber(int[] nums) {
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum ^= nums[i]; // 最后sum得到的是两个只出现一次的数的异或值
        }
        int first = 1; // 一开始假设二进制的第一位是相同的，最后目的是「从右往左」找到不同的那一位
        while((sum & first) == 0){
            first = first << 1;  // 说明前一位是相同的，更新下一位，继续比较
        }
        int result[] = new int[2];
        for(int i = 0; i < nums.length; i++){
            if((nums[i] & first) == 0){ // 依据测试用例[1,2,1,3,2,5]，此时的first为2，这一步是找到数组换算二进制后，第二位为0的数字，遍历进行异或操作，结果保存在result数组的第0位。
                result[0] ^= nums[i];
            }else{
                result[1] ^= nums[i]; // 同上，找到数组换算二进制后，第二位为1的数字，遍历进行异或操作，结果保存在result数组的第1位。
            }
        }
        return result;
    }
}
