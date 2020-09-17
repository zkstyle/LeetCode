package hashmap;

import java.util.HashMap;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: hashmap
 * @Author: elvis
 * @CreateTime: 2020-08-31 12:51
 * @Description: 直线上最多的点
 * 给定一个二维平面，平面上有 n 个点，求最多有多少个点在同一条直线上。
 *
 * 示例 1:
 *
 * 输入: [[1,1],[2,2],[3,3]]
 * 输出: 3
 * 解释:
 * ^
 * |
 * |        o
 * |     o
 * |  o
 * +------------->
 * 0  1  2  3  4
 *
 * 示例 2:
 *
 * 输入: [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
 * 输出: 4
 * 解释:
 * ^
 * |
 * |  o
 * |     o        o
 * |        o
 * |  o        o
 * +------------------->
 * 0  1  2  3  4  5  6
 *
 */
public class Leetcode149 {

    public int maxPoints(int[][] points) {
        int len = points.length;
        if (len <= 2) return len;
        int ans = 0;
        for (int i = 0; i < len - 1; i++) {
            if (len - i <= ans) break;
            int repeat = 1;
            int temp = 1;
            for (int j = i + 1; j < len; j++) {
                if (len - j + temp <= ans) break;
                temp++;
                int x1 = points[i][0];
                int y1 = points[i][1];
                int x2 = points[j][0];
                int y2 = points[j][1];
                if (x1 == x2 && y1 == y2) {
                    repeat++;
                    ans = Math.max(ans, temp);
                    continue;
                }
                for (int p = j + 1; p < len; p++) {
                    if (len - p + temp <= ans) break;
                    int x3 = points[p][0];
                    int y3 = points[p][1];
                    if ((long) (y2 - y1) * (x3 - x2) == (long) (y3 - y2) * (x2 - x1)) {
                        temp++;
                    }
                }
                ans = Math.max(ans, temp);
                temp = repeat;
            }
        }
        return ans;
    }

    /**
     * 直线方程的另一种表示方式，「点斜式」，换句话，一个点加一个斜率即可唯一的确定一条直线。
     *
     * 所以我们可以对「点」进行分类然后去求，问题转换成，经过某个点的直线，哪条直线上的点最多。
     *
     * 当确定一个点后，平面上的其他点都和这个点可以求出一个斜率，斜率相同的点就意味着在同一条直线上。
     *
     * 所以我们可以用 HashMap 去计数，斜率作为 key，然后遍历平面上的其他点，相同的 key 意味着在同一条直线上。
     *
     * 上边的思想解决了「经过某个点的直线，哪条直线上的点最多」的问题。接下来只需要换一个点，然后用同样的方法考虑完所有的点即可。
     *
     * 当然还有一个问题就是斜率是小数，怎么办。
     *
     * 之前提到过了，我们用分数去表示，求分子分母的最大公约数，然后约分，最后将 　「分子 + "@" + "分母"」　作为 key 即可。
     *
     * 最后还有一个细节就是，当确定某个点的时候，平面内如果有和这个重叠的点，如果按照正常的算法约分的话，会出现除 0 的情况，所以我们需要单独用一个变量记录重复点的个数，而重复点一定是过当前点的直线的
     */
    public int maxPoints2(int[][] points) {
        if (points.length < 3) {
            return points.length;
        }
        int res = 0;
        //遍历每个点
        for (int i = 0; i < points.length; i++) {
            int duplicate = 0;
            int max = 0;//保存经过当前点的直线中，最多的点
            HashMap<String, Integer> map = new HashMap<>();
            for (int j = i + 1; j < points.length; j++) {
                //求出分子分母
                int x = points[j][0] - points[i][0];
                int y = points[j][1] - points[i][1];
                if (x == 0 && y == 0) {
                    duplicate++;
                    continue;

                }
                //进行约分
                int gcd = gcd(x, y);
                x = x / gcd;
                y = y / gcd;
                String key = x + "@" + y;
                map.put(key, map.getOrDefault(key, 0) + 1);
                max = Math.max(max, map.get(key));
            }
            //1 代表当前考虑的点，duplicate 代表和当前的点重复的点
            res = Math.max(res, max + duplicate + 1);
        }
        return res;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

}
