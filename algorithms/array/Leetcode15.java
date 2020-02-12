package array;

import java.util.*;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: com.elvis.leetcode.array
 * @Author: Elvis
 * @CreateTime: 2019-03-09 09:37
 * Description: 三数之和
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 *
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 */
public class Leetcode15 {
    /**
     * 常规
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        // 考虑特殊情况　
        if (nums == null || nums.length < 3) return ans;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) break;     //最左边的数大于0　则不可能三数之和为０
            if (i > 0 && nums[i] == nums[i - 1])  continue;  //中心元素去重 以i为下标元素为中心元素　去L～R中寻找两个合适元素
            int L = i + 1, R = nums.length - 1;
            while (L < R){
                int sum = nums[i] + nums[L] + nums[R];
                if (sum == 0){
                    ans.add(Arrays.asList(nums[i], nums[L], nums[R]));
                    /**
                     * 功能描述: 去除重复元素
                     * 以i下标元素为中心　在L～ R中搜索合适元素 若L==L+1或R==R-1，则直接pass
                     */
                    while (L < R && nums[L] == nums[L + 1]) L++;
                    while (L < R && nums[R] == nums[R - 1]) R--;
                    L++;
                    R--;
                }else if (sum < 0){
                    L++;
                }else {
                    R--;
                }
            }
        }
        return ans;
    }
}
