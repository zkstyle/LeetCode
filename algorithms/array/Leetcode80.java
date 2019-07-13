package array;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: array
 * @Author: Elvis
 * @CreateTime: 2019-07-01 09:33
 * Description:
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素最多出现两次，返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 *
 * 示例 1:
 *
 * 给定 nums = [1,1,1,2,2,3],
 *
 * 函数应返回新长度 length = 5, 并且原数组的前五个元素被修改为 1, 1, 2, 2, 3 。
 *
 * 你不需要考虑数组中超出新长度后面的元素。
 * 示例 2:
 *
 * 给定 nums = [0,0,1,1,1,1,2,3,3],
 *
 * 函数应返回新长度 length = 7, 并且原数组的前五个元素被修改为 0, 0, 1, 1, 2, 3, 3 。
 *
 * 你不需要考虑数组中超出新长度后面的元素。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Leetcode80 {

    /**
     * 遍历数组　n表示当前元素　i记录符合条件的下一个下标
     * 通用模板　最多允许k个元素重复则如下
     *          for (int n : nums){
     *             if (i < k || n != nums[i-k]){
     *                 nums[i] = n;
     *                 i++;
     *             }
     *           }
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int n : nums){
            if (i < 2 || n != nums[i-2]){
                nums[i] = n;
                i++;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        int[] num = {0,0,1,1,1,1,2,3,3};
        new Leetcode80().removeDuplicates(num);
    }

}
