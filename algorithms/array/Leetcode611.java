package array;

import java.util.Arrays;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: array
 * @Author: elvis
 * @CreateTime: 2020-06-20 14:42
 * @Description: 有效的三角形个数
 * 给定一个包含非负整数的数组，你的任务是统计其中可以组成三角形三条边的三元组个数。
 *
 * 示例 1:
 *
 * 输入: [2,2,3,4]
 * 输出: 3
 * 解释:
 * 有效的组合是:
 * 2,3,4 (使用第一个 2)
 * 2,3,4 (使用第二个 2)
 * 2,2,3
 * 注意:
 *
 * 数组长度不超过1000。
 * 数组里整数的范围为 [0, 1000]。
 */
public class Leetcode611 {

    /**
     * 三层循环遍历　对于a,b,c判断是否能组成三角形 ==>　res++
     */
    public int triangleNumber(int[] nums) {
        int res = 0, len = nums.length - 1;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                int right = len;
                while (j < right) {
                    int a = nums[i], b = nums[j], c = nums[right];
                    if (judge(a, b, c)) res++;
                    right--;
                }
            }

        }
        return res;
    }

    private boolean judge(int a, int b, int c) {
        return a + b > c && a + c > b && b + c > a;
    }

    /**
     * 对数组进行排序　外层循环控制数组访问　从最后以为也就是最大的数开始
     * 双指针 left 指向0 right指向i-1
     * while循环　若 nums[right] + nums[left] > nums[i] 意味着left~right-1这么多的数都满足nums[right] + nums[left] > nums[i]
     * 所以res+=right-left
     */
    public int triangleNumber2(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        int res = 0;
        for (int i = len - 1; i >= 2; i--) {
            int left = 0;
            int right = i - 1;
            while (left < right) {
                if (nums[right] + nums[left] > nums[i]) {
                    res += right - left;
                    right--;
                } else {
                    left++;
                }
            }
        }
        return res;
    }
}
