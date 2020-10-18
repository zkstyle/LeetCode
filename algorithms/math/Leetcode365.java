package math;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: math
 * @Author: elvis
 * @CreateTime: 2020-10-08 17:06
 * @Description: 水壶问题
 * 有两个容量分别为 x升 和 y升 的水壶以及无限多的水。请判断能否通过使用这两个水壶，从而可以得到恰好 z升 的水？
 *
 * 如果可以，最后请用以上水壶中的一或两个来盛放取得的 z升 水。
 *
 * 你允许：
 *
 * 装满任意一个水壶
 * 清空任意一个水壶
 * 从一个水壶向另外一个水壶倒水，直到装满或者倒空
 * 示例 1: (From the famous "Die Hard" example)
 *
 * 输入: x = 3, y = 5, z = 4
 * 输出: True
 * 示例 2:
 *
 * 输入: x = 2, y = 6, z = 5
 * 输出: False
 */
public class Leetcode365 {

    int x, y, z;
    HashSet<Integer> visited;

    public boolean canMeasureWater(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
        visited = new HashSet<>();
        return canMeasureWater(0);
    }

    /**
     * i是中间状态值　若i==z或者i+x==z或者i+y==z　则返回true
     * visited记录状态值
     */
    private boolean canMeasureWater(int i) {
        if (visited.contains(i))
            return false;
        visited.add(i);
        if (i == z || i + y == z || x + i == z)
            return true;
        return canMeasureWater(Math.abs(x - i)) || canMeasureWater(Math.abs(y - i));
    }



    public boolean canMeasureWater2(int x, int y, int z) {
        if (z < 0 || z > x + y) {
            return false;
        }
        Set<Integer> set = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        while (!queue.isEmpty()) {
            int n = queue.poll();
            if (n + x <= x + y && set.add(n + x)) {
                if (n + x == z) return true;
                queue.offer(n + x);
            }
            if (n + y <= x + y && set.add(n + y)) {
                if (n + y == z) return true;
                queue.offer(n + y);
            }
            if (n - x >= 0 && set.add(n - x)) {
                if (n - x == z) return true;
                queue.offer(n - x);
            }
            if (n - y >= 0 && set.add(n - y)) {
                if (n - y == z) return true;
                queue.offer(n - y);
            }
        }
        return false;
    }
}
