package dfs;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: dfs
 * @Author: elvis
 * @CreateTime: 2020-06-01 16:22
 * @Description: 单词搜索
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 *  
 *
 * 示例:
 *
 * board =
 * [
 *   ['A','B','C','E'],
 *   ['S','F','C','S'],
 *   ['A','D','E','E']
 * ]
 *
 * 给定 word = "ABCCED", 返回 true
 * 给定 word = "SEE", 返回 true
 * 给定 word = "ABCB", 返回 false
 *  
 *
 * 提示：
 *
 * board 和 word 中只包含大写和小写英文字母。
 * 1 <= board.length <= 200
 * 1 <= board[i].length <= 200
 * 1 <= word.length <= 10^3　
 * */
public class Leetcode79 {

    /**
     * 采用dfs搜索　对于每一个字符　双重for循环遍历　
     * 对于每一个字符　首先进行首字符判断是否相等　若第一个字母不等　直接进行下一次循环
     * 然后dfs进行深搜判断　
     * dfs中逻辑主要分为三步
     * 1. 首先是出口　idx==word.length()　说明找到了这个单词　返回true
     * 2. 其次是越界判断和访问判断　若越界或者已经访问过　则走不通　返回false
     * 3. 最后是dfs并回溯　从上下左右四个方向去访问　若有一个成功　则返回true 否则返回false
     */
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[i].length; j++) {
                if (word.charAt(0) == board[i][j]) {
                    if (dfs(board, word, visited, i, j, 0))
                        return true;
                }
            }
        return false;
    }

    private boolean dfs(char[][] board, String word, boolean[][] visited, int i, int j, int idx) {
        if (idx == word.length()) return true;
        if (i < 0 || j < 0 || i == board.length || j == board[0].length || visited[i][j]) return false;
        if (word.charAt(idx) == board[i][j]) {
            visited[i][j] = true;
            boolean res = dfs(board, word, visited, i + 1, j, idx + 1) || dfs(board, word, visited, i - 1, j, idx + 1) || dfs(board, word, visited, i, j - 1, idx + 1) || dfs(board, word, visited, i, j + 1, idx + 1);
            visited[i][j] = false;
            return res;
        }
        return false;
    }
}
