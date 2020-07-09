package dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: com.elvis.leetcode.greed
 * @Author: Elvis
 * @CreateTime: 2019-05-25 08:30
 * Description:
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * 示例:
 *
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 说明:
 * 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 */
public class Leetcode17 {
    //列出所有数字可能字符组合 0,1单独符号标识
    private String[] map = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits != null && digits.length() > 0) dfs(digits, new StringBuilder(), ans);
        return ans;
    }

    private void dfs(String digits, StringBuilder cur, List<String> ans) {
        //cur表示深搜算法获取当前组合字符串
        if (cur.length() == digits.length()) {
            ans.add(cur.toString());
            return;
        }
        //获取digits的第1,2,3个数字对应map数组中的索引,因为已经优化，是一一对应即(1->1,2->2)
        int index = digits.charAt(cur.length()) - '2';
        //对每一个的当前数字的包含字母进行遍历 那么长度自然也是map对应数字的字符串长度
        for (int i = 0; i < map[index].length(); i++) {
            cur.append(map[index].charAt(i));
            dfs(digits, cur, ans);
            cur.deleteCharAt(cur.length() - 1);
        }
    }
}


