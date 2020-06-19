package hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: hashmap
 * @Author: elvis
 * @CreateTime: 2020-06-19 22:21
 * @Description: 信息
 * 给定平面上 n 对不同的点，“回旋镖” 是由点表示的元组 (i, j, k) ，其中 i 和 j 之间的距离和 i 和 k 之间的距离相等（需要考虑元组的顺序）。
 *
 * 找到所有回旋镖的数量。你可以假设 n 最大为 500，所有点的坐标在闭区间 [-10000, 10000] 中。
 *
 * 示例:
 *
 * 输入:
 * [[0,0],[1,0],[2,0]]
 *
 * 输出:
 * 2
 *
 * 解释:
 * 两个回旋镖为 [[1,0],[0,0],[2,0]] 和 [[1,0],[2,0],[0,0]]
 */
public class Leetcode447 {

    /**
     * 两层for循环遍历　point节点数组　
     * 对于每一个节点　计算距离　然后将距离值存入map以及对应的次数
     */
    public int numberOfBoomerangs(int[][] points) {
        Map<Integer, Integer> map = new HashMap();
        int sum = 0;
        for (int[] p : points) {
            map.clear(); // this is faster than new Map!
            for (int[] q : points) {
                int t, x = p[0] - q[0], y = p[1] - q[1], d2 = x * x + y * y;
                sum += t = map.getOrDefault(d2, 0);
                map.put(d2, ++t);
            }
        }
        return sum << 1;
    }
}
