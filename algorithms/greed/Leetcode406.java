package greed;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: greed
 * @Author: elvis
 * @CreateTime: 2020-08-19 14:31
 * @Description: 根据身高重建队列
 * 假设有打乱顺序的一群人站成一个队列。 每个人由一个整数对(h, k)表示，其中h是这个人的身高，k是排在这个人前面且身高大于或等于h的人数。
 * 编写一个算法来重建这个队列。
 *
 * 注意：
 * 总人数少于1100人。
 *
 * 示例
 *
 * 输入:
 * [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
 *
 * 输出:
 * [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 */
public class Leetcode406 {

    /**
     * 排序：
     * 按高度降序排列。(最高的在前面,必然有最高的前面没有人(看不到人或真没人)）)
     * 在同一高度的人中，按 k 值的升序排列。
     * 逐个地把它们放在输出队列中，索引等于它们的 k 值。
     * 返回输出队列
     */
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0];
            }
        });
        List<int[]> list = new ArrayList<>();
        for (int[] p : people) {
            list.add(p[1], p);
        }
        int n = people.length;
        return list.toArray(new int[n][2]);
    }
}
