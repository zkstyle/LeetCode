package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: com.elvis.leetcode.backtracking
 * @Author: Elvis
 * @CreateTime: 2019-03-30 11:04
 * Description:
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 *
 * 例如，给出 n = 3，生成结果为：
 *
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 */
public class Leetcode22 {
    /**
     * 回溯法　遍历所有可能　
     */
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        generate(n, list, "", 0, 0);
        return list;
    }

    private void generate(int n, List<String> list, String ans, int left, int right) {
        if (ans.length() == 2 * n) {
            list.add(ans);
            return;
        }
        if (left < right) return;
        if (left < n) {
            generate(n, list, ans + "(", left + 1, right);
        }
        if (right < n) {
            generate(n, list, ans + ")", left, right + 1);
        }
    }

}
