package string;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: string
 * @Author: elvis
 * @CreateTime: 2020-06-19 20:17
 * @Description: 下一个更大元素III
 * 给定一个32位正整数 n，你需要找到最小的32位整数，其与 n 中存在的位数完全相同，并且其值大于n。如果不存在这样的32位整数，则返回-1。
 *
 * 示例 1:
 *
 * 输入: 12
 * 输出: 21
 * 示例 2:
 *
 * 输入: 21
 * 输出: -1
 */
public class Leetcode556 {

    /**
     * 思路与下一个排列类似　首先先将整数转为字符数组　方便对每一位的数据操作
     * 从右向左寻找第一个left<right的下标index 然后从index往右寻找最后一个index2 ==> nums[index2]> nums[index2-1]
     * 然后交换index-1 index2-1 最后将index~char.length-1 翻转
     */
    public int nextGreaterElement(int n) {
        if (n <= 10) {
            return -1;
        }
        char[] chars = String.valueOf(n).toCharArray();
        int len = chars.length;
        int index = len - 1;
        while (index >= 1 && chars[index] <= chars[index - 1]) {
            index--;
        }
        if (index == 0) {
            // 从尾到头都是递增的，说明无法找到更大的元素
            return -1;
        }
        int index2 = index;
        // 找出右边大于需要换位的数值的最小元素所在位置
        while (index2 < len && chars[index2] > chars[index - 1]) {
            index2++;
        }
        swap(chars, index2 - 1, index - 1);
        reverse(chars, index);
        long ans = Long.parseLong(new String(chars));
        return ans > Integer.MAX_VALUE ? -1 : (int) ans;
    }

    //翻转字符数组
    private void reverse(char[] chars, int index) {
        int left = index, right = chars.length - 1;
        while (left < right) {
            swap(chars, left, right);
            left++;
            right--;
        }
    }

    private void swap(char[] chars, int index1, int index2) {
        char tmp = chars[index1];
        chars[index1] = chars[index2];
        chars[index2] = tmp;
    }
}
