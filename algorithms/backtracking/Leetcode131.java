package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: backtracking
 * @Author: Elvis
 * @CreateTime: 2019-07-18 11:06
 * Description:
 * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
 *
 * 返回 s 所有可能的分割方案。
 *
 * 示例:
 *
 * 输入: "aab"
 * 输出:
 * [
 *   ["aa","b"],
 *   ["a","a","b"]
 * ]
 */
public class Leetcode131 {

    /**
     * 算法思路　回溯算法　首先定义一个判断回文串函数isPalindrome
     *          回溯遍历字符串　若start~i为回文串则保存　否则i++继续遍历
     * @param s
     * @return
     */
    List<List<String>> lists = new ArrayList<>();

    public List<List<String>> partition(String s) {
        back(s, 0, new ArrayList<>());
        return lists;
    }

    void back(String s, int idx, List<String> list) {
        if (idx == s.length()) {
            lists.add(new ArrayList(list));
            return;
        }

        for (int i = idx + 1; i <= s.length(); i++) {
            String t = s.substring(idx, i);
            if (isPalindrome(s, idx, i - 1)) {
                list.add(s.substring(idx, i));
                back(s, i, list);
                list.remove(list.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l++) != s.charAt(r--)) return false;
        }
        return true;
    }
}
