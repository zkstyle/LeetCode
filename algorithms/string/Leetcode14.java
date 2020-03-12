package string;

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
    /*
    *   就是以其中一个字符串为模板　对其他字符串进行判断
    *   是不是strs[i].startsWith(match.toString()
    *   如果不是　删除最后一个字符　一直循环下去　直到符合条件
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs.length < 1) return "";
        if (strs.length == 1) return strs[0];
        //StringBuilder的内置函数deleteCharAt() 或者用String截取函数substring()函数
        StringBuilder match = new StringBuilder(strs[0]);
        for (int i = 1; i < strs.length; i++) {
            //重点：如果match不是当前的子串，则删除最后一位再次比较，直到取出子串为止
            while (!strs[i].startsWith(match.toString())) {
                match.deleteCharAt(match.length() - 1);
                if (match.length() < 1) return "";
            }
        }
        return match.toString();
    }
}
