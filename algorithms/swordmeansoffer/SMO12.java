package swordmeansoffer;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: swordmeansoffer
 * @Author: elvis
 * @CreateTime: 2020-08-29 23:14
 * @Description: 矩阵中的路径
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一格开始，每一步可以在矩阵中向左、右、上、下移动一格。如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。例如，在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字母用加粗标出）。
 *
 * [["a","b","c","e"],
 * ["s","f","c","s"],
 * ["a","d","e","e"]]
 *
 * 但矩阵中不包含字符串“abfb”的路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入这个格子。
 *
 *
 *
 * 示例 1：
 *
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * 输出：true
 *
 * 示例 2：
 *
 * 输入：board = [["a","b"],["c","d"]], word = "abcd"
 * 输出：false
 *
 * 提示：
 *
 *     1 <= board.length <= 200
 *     1 <= board[i].length <= 200
 */
public class SMO12 {

    /**
     * 算法原理：
     *
     *     深度优先搜索： 可以理解为暴力法遍历矩阵中所有字符串可能性。DFS 通过递归，先朝一个方向搜到底，再回溯至上个节点，沿另一个方向搜索，以此类推。
     *     剪枝： 在搜索中，遇到 这条路不可能和目标字符串匹配成功 的情况（例如：此矩阵元素和目标字符不同、此元素已被访问），则应立即返回，称之为 可行性剪枝 。
     *
     * 算法剖析：
     *
     *     递归参数： 当前元素在矩阵 board 中的行列索引 i 和 j ，当前目标字符在 word 中的索引 k 。
     *     终止条件：
     *         返回 false ： ① 行或列索引越界 或 ② 当前矩阵元素与目标字符不同 或 ③ 当前矩阵元素已访问过 （③ 可合并至 ② ） 。
     *         返回 true ： 字符串 word 已全部匹配，即 k = len(word) - 1 。
     *     递推工作：
     *         标记当前矩阵元素： 将 board[i][j] 值是否访问用use[i][j]标记 ，代表此元素已访问过，防止之后搜索时重复访问。
     *         搜索下一单元格： 朝当前元素的 上、下、左、右 四个方向开启下层递归，使用 或 连接 （代表只需一条可行路径） ，并记录结果至 res 。
     *         还原当前矩阵元素： use[i][j]=false;
     *
     *     回溯返回值： 返回 res ，代表是否搜索到目标字符串。
     */
    public static boolean exist(char[][] board, String word) {
        char[] path = word.toCharArray();
        int row = board.length, col = board[0].length;
        for (int i = 0; i < row; i++)
            for (int j = 0; j < col; j++) {
                if (board[i][j] == path[0]) {
                    if (dfs(board, path, new boolean[row][col], 0, i, j)) return true;
                }
            }
        return false;
    }

    private static boolean dfs(char[][] board, char[] path, boolean[][] use, int idx, int i, int j) {
        if (idx == path.length) {
            return true;
        }
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || use[i][j] || board[i][j] != path[idx])
            return false;
        use[i][j] = true;
        boolean flag =  dfs(board, path, use, idx + 1, i - 1, j) ||
                dfs(board, path, use, idx + 1, i, j - 1) ||
                dfs(board, path, use, idx + 1, i + 1, j) ||
                dfs(board, path, use, idx + 1, i, j + 1);
        use[i][j] = false;
        return flag;
    }
}
