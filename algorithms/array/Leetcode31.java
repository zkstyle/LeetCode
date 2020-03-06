package array;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: com.elvis.leetcode.array
 * @Author: Elvis
 * @CreateTime: 2019-03-14 08:37
 * Description: 下一个排列
 * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 *
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 *
 * 必须原地修改，只允许使用额外常数空间。
 *
 * 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
 * 1,2,3→交通1,3,2
 * 3,2,1→交通1,2,3
 * 1,1,5→交通1,5,1
 */
public class Leetcode31 {

    /**
     * 首先，我们观察到对于任何给定序列的降序，没有可能的下一个更大的排列
     * 例如，以下数组不可能有下一个排列： [9, 5, 4, 3, 1]
     * 我们需要从右边找到第一对两个连续的数字 a[i]和 a[i-1]，它们满足 a[i]>a[i-1]。现在，没有对 a[i-1]右侧的重新排列可以创建更大的排列，
     * 因为该子数组由数字按降序组成。因此，我们需要重新排列 a[i-1]右边的数字，包括它自己。
     *
     * 现在，什么样子的重新排列将产生下一个更大的数字呢？我们想要创建比当前更大的排列。
     * 因此，我们需要将数字 a[i-1]替换为位于其右侧区域的数字中比它更大的数字，例如 a[j]。以下举例为证
     *  1   5   8   4        7      6    5   3   1
     *             a[i]    a[i-1]       a[j]
     *  a[i] a[i-1] 是出现的第一对升序数字　a[i]要与a[j]对换　因为这是从右边数　第一个出现的比a[i]大的数
     *  调换产生的大小相对最小　如果和6进行调换得到的数更大　不是下一个排列　然后调换后再将右边的数逆置　获取最小的右边(i的右边)
     *  因为i右边的数是降序排列　只需要逆置数字　就能获得最小的数　
     *
     * @param nums
     */
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        //找到第一对升序数对
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            //从右向左找到第一个大于a[i]的数字
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            //逆置数字
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    private void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        /*int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;*/
        nums[i] = nums[i] ^ nums[j];
        nums[j] = nums[j] ^ nums[i];
        nums[i] = nums[i] ^ nums[j];
    }


}
