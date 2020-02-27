package array;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: com.elvis.leetcode.array
 * @Author: Elvis
 * @CreateTime: 2019-03-09 10:55
 * Description: 删除排序数组中的重复项
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 *
 * 示例 1:
 *
 * 给定数组 nums = [1,1,2],
 *
 * 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
 *
 * 你不需要考虑数组中超出新长度后面的元素。
 * 示例 2:
 *
 * 给定 nums = [0,0,1,1,1,2,2,3,3,4],
 *
 * 函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
 *
 * 你不需要考虑数组中超出新长度后面的元素。
 * 说明:
 *
 * 为什么返回数值是整数，但输出的答案是数组呢?
 *
 * 请注意，输入数组是以“引用”方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。
 *
 * 你可以想象内部操作如下:
 *
 * // nums 是以“引用”方式传递的。也就是说，不对实参做任何拷贝
 * int len = removeDuplicates(nums);
 *
 * // 在函数里修改输入数组对于调用者是可见的。
 * // 根据你的函数返回的长度, 它会打印出数组中该长度范围内的所有元素。
 * for (int i = 0; i < len; i++) {
 *     print(nums[i]);
 * }
 */
public class Leetcode26 {

    /**
     * 双指针法　两个指针　i指向需要落放元素的位置(排除重复位置)
     * j指向遍历元素的下标
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length < 2) {
            return nums.length;
        }
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            //如果相同就跳过重复项,如果不同说明跳过了重复项,把nums[j]放在nums[i+1]的后面
            if (nums[i] != nums[j]) {
                nums[++i] = nums[j];
            }
        }
        return i + 1;
    }

    /**
     *  覆盖 count统计重复元素数
     * @param nums
     * @return
     */
    public int removeDuplicates2(int[] nums) {
        if(nums==null || nums.length<2){
            return nums.length;
        }
        int count = 0;
        for (int i = 1; i < nums.length; i++){
            if (nums[i] == nums[i-1]) count++;
            //count是重复元素个数　i-count是需要存放元素的下标
            nums[i-count] = nums[i];
        }
        return nums.length-count;
    }
}
