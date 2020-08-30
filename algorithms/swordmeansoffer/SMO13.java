package swordmeansoffer;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: swordmeansoffer
 * @Author: elvis
 * @CreateTime: 2020-08-30 18:19
 * @Description: 机器人的运动范围
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 *
 *
 *
 * 示例 1：
 *
 * 输入：m = 2, n = 3, k = 1
 * 输出：3
 *
 * 示例 2：
 *
 * 输入：m = 3, n = 1, k = 0
 * 输出：1
 *
 * 提示：
 *
 *     1 <= n,m <= 100
 *     0 <= k <= 20
 */
public class SMO13 {

    int ans = 0;

    /**
     * 深度优先遍历 DFS
     *
     *     深度优先搜索： 可以理解为暴力法模拟机器人在矩阵中的所有路径。DFS 通过递归，先朝一个方向搜到底，再回溯至上个节点，沿另一个方向搜索，以此类推。
     *     剪枝： 在搜索中，遇到数位和超出目标值、此元素已访问，则应立即返回，称之为 可行性剪枝 。
     *
     * 算法解析：
     *
     *     递归参数： 当前元素在矩阵中的行列索引 i 和 j ，两者的数位和 si, sj 。
     *     终止条件： 当 ① 行列索引越界 或 ② 数位和超出目标值 k 或 ③ 当前元素已访问过 时，返回 000 ，代表不计入可达解。
     *     递推工作：
     *         标记当前单元格 ：将索引 (i, j) 存入 use 中，代表此单元格已被访问过。
     *         搜索下一单元格： 计算当前元素的 下、右 两个方向元素的数位和，并开启下层递归 。
     *     回溯返回值： 返回 1 + 右方搜索的可达解总数 + 下方搜索的可达解总数，代表从本单元格递归搜索的可达解总数。
     */
    public int movingCount(int m, int n, int k) {
        dfs(m, n, k, 0, 0, new boolean[m][n]);
        return ans;
    }

    private void dfs(int m, int n, int k, int i, int j, boolean[][] use) {
        if (i < 0 || j < 0 || i >= m || j >= n || !check(i, j, k) || use[i][j]) return;
        ans++;
        use[i][j] = true;
        dfs(m, n, k, i + 1, j, use);
        dfs(m, n, k, i, j + 1, use);
    }

    //检查当前节点是否可以访问
    private boolean check(int i, int j, int k) {
        int ret = 0;
        while (i > 0 || j > 0) {
            ret = ret + i % 10 + j % 10;
            i /= 10;
            j /= 10;
        }
        return ret <= k;
    }
}
