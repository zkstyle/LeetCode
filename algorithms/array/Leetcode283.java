package array;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: array
 * @Author: Elvis
 * @CreateTime: 2019-07-23 11:11
 * Description:
 *
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 示例:
 *
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 *
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 */
public class Leetcode283 {

    /**
     * 我们创建两个指针i和j，第一次遍历的时候指针j用来记录当前有多少非0元素。
     * 即遍历的时候每遇到一个非0元素就将其往数组左边挪，第一次遍历完后，j指针的下标就指向了最后一个非0元素下标。
     * 第二次遍历的时候，起始位置就从j开始到结束，将剩下的这段区域内的元素全部置为0。
     */
    public void moveZeroes(int[] nums) {
        if (nums == null) return;
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j++] = nums[i];
            }
        }
        for (int i = j; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
