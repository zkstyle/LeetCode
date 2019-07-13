package array;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: array
 * @Author: Elvis
 * @CreateTime: 2019-07-06 09:32
 * Description:
 * 给定一个无重复元素的有序整数数组，返回数组区间范围的汇总。
 *
 * 示例 1:
 *
 * 输入: [0,1,2,4,5,7]
 * 输出: ["0->2","4->5","7"]
 * 解释: 0,1,2 可组成一个连续的区间; 4,5 可组成一个连续的区间。
 * 示例 2:
 *
 * 输入: [0,2,3,4,6,8,9]
 * 输出: ["0","2->4","6","8->9"]
 * 解释: 2,3,4 可组成一个连续的区间; 8,9 可组成一个连续的区间。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/summary-ranges
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Leetcode228 {

    public List<String> summaryRanges(int[] nums) {
        List<String> summary = new ArrayList<>();
        for (int i, j = 0; j < nums.length; ++j){
            i = j;
            // try to extend the range [nums[i], nums[j]]
            while (j + 1 < nums.length && nums[j + 1] == nums[j] + 1)
                ++j;
            // put the range into the list
            if (i == j)
                summary.add(nums[i] + "");
            else
                summary.add(nums[i] + "->" + nums[j]);
        }
        return summary;
    }
    /**
     * best version
     * @param nums
     * @return
     */
    public List<String> summaryRanges_best(int[] nums) {
        List<String> res = new ArrayList<>();
        String aux="";
        int left = 0, right=0;
        while(right<nums.length){
            while(right<nums.length-1 && nums[right+1]==nums[right]+1) right++;
            if (right==left) aux = nums[left]+"";
            else aux = nums[left]+"->"+nums[right];
            left = right+1;
            right = left;
            res.add(aux);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {0,1,2,4,5,7};
        new Leetcode228().summaryRanges(nums);
    }
}
