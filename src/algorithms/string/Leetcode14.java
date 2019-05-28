package algorithms.string;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: com.elvis.leetcode.string
 * @Author: Elvis
 * @CreateTime: 2019-04-15 13:02
 * Description:
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1:
 *
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 *
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 *
 * 所有输入只包含小写字母 a-z 。
 */
public class Leetcode14 {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length < 1) return "";
        if (strs.length == 1) return strs[0];
        StringBuilder match = new StringBuilder(strs[0]);
        for (int i = 1; i < strs.length; i++) {
            while (!strs[i].startsWith(match.toString())) {
                match.deleteCharAt(match.length() - 1);
                if (match.length() < 1) return "";
            }
        }
        return match.toString();
    }
}
