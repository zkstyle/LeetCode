package backtracking;

import java.util.List;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: backtracking
 * @Author: elvis
 * @CreateTime: 2020-07-02 22:23
 * @Description: 钥匙和房间
 * 有 N 个房间，开始时你位于 0 号房间。每个房间有不同的号码：0，1，2，...，N-1，并且房间里可能有一些钥匙能使你进入下一个房间。
 *
 * 在形式上，对于每个房间 i 都有一个钥匙列表 rooms[i]，每个钥匙 rooms[i][j] 由 [0,1，...，N-1] 中的一个整数表示，其中 N = rooms.length。 钥匙 rooms[i][j] = v 可以打开编号为 v 的房间。
 *
 * 最初，除 0 号房间外的其余所有房间都被锁住。
 *
 * 你可以自由地在房间之间来回走动。
 *
 * 如果能进入每个房间返回 true，否则返回 false。
 *
 * 示例 1：
 *
 * 输入: [[1],[2],[3],[]]
 * 输出: true
 * 解释:
 * 我们从 0 号房间开始，拿到钥匙 1。
 * 之后我们去 1 号房间，拿到钥匙 2。
 * 然后我们去 2 号房间，拿到钥匙 3。
 * 最后我们去了 3 号房间。
 * 由于我们能够进入每个房间，我们返回 true。
 * 示例 2：
 *
 * 输入：[[1,3],[3,0,1],[2],[0]]
 * 输出：false
 * 解释：我们不能进入 2 号房间。
 * 提示：
 *
 * 1 <= rooms.length <= 1000
 * 0 <= rooms[i].length <= 1000
 * 所有房间中的钥匙数量总计不超过 3000。
 */
public class Leetcode841 {

    //回溯法　定义访问数组标记该房间是否访问过
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] visit = new boolean[n];
        visit[0] = true;
        dfs(rooms, visit, 0);
        for (boolean flag : visit) {
            if (!flag) return false;
        }
        return true;
    }

    /**
     * dfs深度搜索　将访问的房间visit[i]标记为true
     * @param rooms　房间数组
     * @param visit　数组访问标记
     * @param idx 访问房间号
     */
    private void dfs(List<List<Integer>> rooms, boolean[] visit, int idx) {
        for (int i = 0; i < rooms.get(idx).size(); i++) {
            int next = rooms.get(idx).get(i);
            //避免重复访问　若下一个访问房间为当前房间或者已经访问过的房间　continue进入下一次循环
            if (next == idx || visit[next] == true) continue;
            visit[next] = true;
            dfs(rooms, visit, next);
        }
    }
}
