package greed;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: com.elvis.leetcode.greed
 * @Author: Elvis
 * @CreateTime: 2019-05-25 08:30
 * Description:
 */
public class Leetcode17 {

    private String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits != null && digits.length() > 0) dfs(ans, "", digits);
        return ans;
    }

    public void dfs(List<String> ans, String cur, String digits) {
        if (cur.length() == digits.length()) {
            ans.add(cur);
            return;
        }
        int index = digits.charAt(cur.length()) - '0';
        for (int i = 0; i < map[index].length(); i++) {
            dfs(ans, cur + map[index].charAt(i), digits);
        }
    }
}
