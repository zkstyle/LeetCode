package swordmeansoffer;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: swordmeansoffer
 * @Author: elvis
 * @CreateTime: 2020-10-07 21:49
 * @Description: 剑指 Offer 40. 最小的k个数
 * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 *
 *
 *
 * 示例 1：
 *
 * 输入：arr = [3,2,1], k = 2
 * 输出：[1,2] 或者 [2,1]
 * 示例 2：
 *
 * 输入：arr = [0,1,2,1], k = 1
 * 输出：[0]
 *
 *
 * 限制：
 *
 * 0 <= k <= arr.length <= 10000
 * 0 <= arr[i] <= 10000
 */
public class SMO40 {

    /**
     * 桶排序　先将元素放入桶中　然后逐个遍历
     * 对于元素大于1需要循环减少cnt至0
     */
    public int[] getLeastNumbers(int[] arr, int k) {
        int[] ans = new int[k];
        int[] bucket = new int[10001];
        for (int i = 0; i < arr.length; i++) {
            bucket[arr[i]]++;
        }
        int idx = 0;
        for (int i = 0; i < 10001; i++) {
            if (bucket[i] >= 1) {
                while (idx < k && bucket[i]-- > 0) ans[idx++] = i;
            }
        }
        return ans;
    }
}
