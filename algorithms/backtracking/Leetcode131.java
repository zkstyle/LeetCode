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
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        if (s == null || s.length() == 0) return res;
        char[] chars = s.toCharArray();
        backtrack(chars, res, new ArrayList<String>(), 0, 0);
        return res;
    }

    private void backtrack(char[] chars, List<List<String>> res, ArrayList<String> list, int start, int index) {
        if (start == chars.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = index; i < chars.length; i++) {
            //若不是回文串　继续遍历
            if (!isPalindrome(chars, start, i)) continue;
            list.add(new String(chars, start, i - start + 1));
            //回溯接着i后面继续找寻回文串
            backtrack(chars, res, list, i + 1, i + 1);
            list.remove(list.size() - 1);
        }
    }

    private boolean isPalindrome(char[] chars, int low, int high) {

        while (low < high) {
            if (chars[low] != chars[high]) return false;
            --high;
            ++low;
        }
        return true;
    }

}
