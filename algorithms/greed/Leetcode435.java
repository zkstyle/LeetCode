package greed;

import java.util.Arrays;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: greed
 * @Author: elvis
 * @CreateTime: 2020-09-29 19:45
 * @Description: 无重叠区间
 * 给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。
 *
 * 注意:
 *
 * 可以认为区间的终点总是大于它的起点。
 * 区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠。
 * 示例 1:
 *
 * 输入: [ [1,2], [2,3], [3,4], [1,3] ]
 *
 * 输出: 1
 *
 * 解释: 移除 [1,3] 后，剩下的区间没有重叠。
 * 示例 2:
 *
 * 输入: [ [1,2], [1,2], [1,2] ]
 *
 * 输出: 2
 *
 * 解释: 你需要移除两个 [1,2] 来使剩下的区间没有重叠。
 * 示例 3:
 *
 * 输入: [ [1,2], [2,3] ]
 *
 * 输出: 0
 *
 * 解释: 你不需要移除任何区间，因为它们已经是无重叠的了。
 */
public class Leetcode435 {


    /**
     * 对二维区间排序　若有交集时，优先选择较短的区间
     * 双指针对区间进行比较
     */
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]);
        int rs = 0;
        int len = intervals.length;
        for (int i = 0, j = 1; i < len && j < len; j++) {
            if(intervals[i][1] > intervals[j][0]) {
                //优先选择较短区间
                if(intervals[i][1] >= intervals[j][1]) {
                    i = j;
                }
                rs++;
            } else {
                i = j;
            }

        }
        return rs;
    }
}
