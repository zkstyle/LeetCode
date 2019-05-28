package array;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: com.elvis.leetcode.array
 * @Author: Elvis
 * @CreateTime: 2019-03-14 09:19
 * Description:
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 *
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 *
 * 注意:
 * 不能使用代码库中的排序函数来解决这道题。
 *
 * 示例:
 *
 * 输入: [2,0,2,1,1,0]
 * 输出: [0,0,1,1,2,2]
 * 进阶：
 *
 * 一个直观的解决方案是使用计数排序的两趟扫描算法。
 * 首先，迭代计算出0、1 和 2 元素的个数，然后按照0、1、2的排序，重写当前数组。
 * 你能想出一个仅使用常数空间的一趟扫描算法吗？
 */
public class Leetcode75{
        public void sortColors(int[] nums) {
            int index = 0;
            index = swap(nums, 0 , nums.length - 1);
            swap(nums, index, nums.length - 1);
        }

        private int swap(int[] nums, int start, int end){
            int temp;
            for (; start < end;){
                if (nums[start] == 0){
                    start++;
                }else{
                    if (nums[end] == 0){
                        temp = nums[end];
                        nums[end] = nums[start];
                        nums[start] = temp;
                        start++;
                    }else{
                        end--;
                    }
                }
            }
            return start;
        }
    }