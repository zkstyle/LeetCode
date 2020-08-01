package array;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: array
 * @Author: elvis
 * @CreateTime: 2020-07-15 19:36
 * @Description: 插入区间
 * 给出一个无重叠的 ，按照区间起始端点排序的区间列表。
 *
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 *
 * 示例 1:
 *
 * 输入: intervals = [[1,3],[6,9]], newInterval = [2,5]
 * 输出: [[1,5],[6,9]]
 * 示例 2:
 *
 * 输入: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * 输出: [[1,2],[3,10],[12,16]]
 * 解释: 这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
 */
public class Leetcode57 {

    /**
     * 先将结果存放在list集合中　依次判断每一个数组是否可以和newInterval合并
     * 主要分为三部分　1. 不可以合并区间　存放在list中
     *              2. 可以合并　while循环判断并合并
     *              3. 最后不可以合并　存放在list中
     *              4. 将list转化为数组
     */
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        int i = 0;
        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            res.add(new int[]{intervals[i][0], intervals[i][1]});
            i++;
        }
        //i is first [][1] >= [0]  overlap
        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        res.add(newInterval);

        for (; i < intervals.length; i++) {
            res.add(new int[]{intervals[i][0], intervals[i][1]});
        }
        int[][] result = new int[res.size()][2];
        for (int j = 0; j < res.size(); j++) {
            result[j][0] = res.get(j)[0];
            result[j][1] = res.get(j)[1];
        }
        return result;
    }
}
