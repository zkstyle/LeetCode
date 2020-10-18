package contest;

import java.util.Arrays;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: contest
 * @Author: elvis
 * @CreateTime: 2020-10-18 22:25
 * @Description: 无矛盾的最佳球队
 *
 * 假设你是球队的经理。对于即将到来的锦标赛，你想组合一支总体得分最高的球队。球队的得分是球队中所有球员的分数 总和 。
 *
 * 然而，球队中的矛盾会限制球员的发挥，所以必须选出一支 没有矛盾 的球队。如果一名年龄较小球员的分数 严格大于 一名年龄较大的球员，则存在矛盾。同龄球员之间不会发生矛盾。
 *
 * 给你两个列表 scores 和 ages，其中每组 scores[i] 和 ages[i] 表示第 i 名球员的分数和年龄。请你返回 所有可能的无矛盾球队中得分最高那支的分数 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：scores = [1,3,5,10,15], ages = [1,2,3,4,5]
 * 输出：34
 * 解释：你可以选中所有球员。
 * 示例 2：
 *
 * 输入：scores = [4,5,6,5], ages = [2,1,2,1]
 * 输出：16
 * 解释：最佳的选择是后 3 名球员。注意，你可以选中多个同龄球员。
 * 示例 3：
 *
 * 输入：scores = [1,2,3,5], ages = [8,9,10,1]
 * 输出：6
 * 解释：最佳的选择是前 3 名球员。
 *
 *
 * 提示：
 *
 * 1 <= scores.length, ages.length <= 1000
 * scores.length == ages.length
 * 1 <= scores[i] <= 106
 * 1 <= ages[i] <= 1000
 */
public class Leetcode5545 {

    /**
     * 类似于最长公共子序列　将年龄　积分存放在二维数组中　
     * 对数组排序　按照优先年龄升序　次则积分升序进行排序
     * dp[i]表示以第i个元素为结尾元素的最大积分
     */
    public int bestTeamScore(int[] scores, int[] ages) {
        int n = ages.length;
        int[][] combine = new int[n + 1][2];
        combine[n][0] = combine[n][1] = -1;
        for(int i = 0; i < n; i++)
        {
            combine[i][0] = scores[i];
            combine[i][1] = ages[i];
        }
        Arrays.sort(combine, (a1, a2) -> (a1[1] != a2[1] ? a1[1] - a2[1] : a1[0] - a2[0]));
        int[] dp = new int[n + 1];
        int res = 0;
        for(int i = 1; i <= n; i++){
            for(int j = 0; j < i; j++){
                if(combine[j][1] == combine[i][1] || combine[j][0] <= combine[i][0])
                    dp[i] = Math.max(dp[i], dp[j] + combine[i][0]);
            }
            res = Math.max(res, dp[i]);
        }
        System.out.println(Arrays.toString(dp));
        return res;
    }
}
