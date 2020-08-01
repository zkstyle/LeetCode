package array;


import array.point.Interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: com.elvis.leetcode.array
 * @Author: Elvis
 * @CreateTime: 2019-05-13 08:49
 * Description:
 * 给出一个区间的集合，请合并所有重叠的区间。
 *
 * 示例 1:
 *
 * 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2:
 *
 * 输入: [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 */
public class Leetcode56 {

    public List<Interval> merge(List<Interval> list) {
        List<Interval> res = new ArrayList<>();
        if (list.size() < 2)
            return list;
        Collections.sort(list, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });
        Interval tmp = list.get(0);
        for (int i = 1; i < list.size() - 1; i++) {
            if (tmp.end >= list.get(i).start){
                tmp.end = Math.max(tmp.end, list.get(i).end);
            } else {
                res.add(tmp);
                tmp = list.get(i);
            }
        }

        res.add(tmp);

        return res;
    }

    /**
     * 算法思路　首先对于i from 0 to intervals.length-2
     *          对于每一个i 都有 j from i+1 to intervals.length-1
     *          然后进行比较　i 与　j 行 min为两个数组较小的起始下标 max为两个数组较大的结束下标
     *          iLen 为 i　区间长度　jLen为　j　区间长度
     *          若　max-min <= iLen + jLen 则更新 j 行坐标　两个区间可以合并
     *          然后将　i 位置的值置为null
     */
    public int[][] merge(int[][] intervals) {
        int rows = intervals.length;
        if (rows == 0) {
            return intervals;
        }
        int count = rows;
        for (int i = 0; i < rows - 1; i++) {
            for (int j = i + 1; j < rows; j++) {
                if (canMerge(intervals, i, j)) {
                    count--;
                    break;
                }
            }
        }
        int[][] res = new int[count][2];
        int index = 0;
        for (int[] row : intervals) {
            if (row != null) {
                res[index] = row;
                index++;
            }
        }
        return res;
    }

    public boolean canMerge(int[][] intervals, int first, int second) {
        if (!((intervals[first][0] < intervals[second][0] && intervals[first][1] < intervals[second][0])
                || (intervals[second][0] < intervals[first][0] && intervals[second][1] < intervals[first][0]))) {
            intervals[second] = new int[]{Math.min(intervals[first][0], intervals[second][0]),
                    Math.max(intervals[first][1], intervals[second][1])};
            intervals[first] = null;
            return true;
        }
        return false;
    }
}
