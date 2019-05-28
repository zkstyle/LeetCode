package array;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: com.elvis.leetcode.array
 * @Author: Elvis
 * @CreateTime: 2019-05-22 11:30
 * Description:
 * 给定一个大小为 n 的数组，找出其中所有出现超过 ⌊ n/3 ⌋ 次的元素。
 *
 * 说明: 要求算法的时间复杂度为 O(n)，空间复杂度为 O(1)。
 *
 * 示例 1:
 *
 * 输入: [3,2,3]
 * 输出: [3]
 * 示例 2:
 *
 * 输入: [1,1,1,3,3,2,2,2]
 * 输出: [1,2]
 */
public class Leetcode229 {

    public List<Integer> majorityElement(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int major1 = 0;
        int major2 = 0;
        int count1 = 0;
        int count2 = 0;
        for (int n : nums) {
            if (n == major1) {
                count1++;
            } else if (n == major2) {
                count2++;
            } else if (count1 == 0) {
                major1 = n;
                count1++;
            } else if (count2 == 0) {
                major2 = n;
                count2++;
            } else {
                count1--;
                count2--;
            }
        }

        count1 = 0;
        count2 = 0;
        for (int n : nums) {
            if (n == major1) {
                count1++;
            } else if (n == major2) {
                count2++;
            }
        }

        if (count1 > nums.length / 3) {
            list.add(major1);
        }
        if (count2 > nums.length / 3) {
            list.add(major2);
        }
        return list;
    }
}
