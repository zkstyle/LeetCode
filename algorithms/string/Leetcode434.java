package string;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: string
 * @Author: elvis
 * @CreateTime: 2020-10-04 22:54
 * @Description: 字符串中的单词数
 * 统计字符串中的单词个数，这里的单词指的是连续的不是空格的字符。
 *
 * 请注意，你可以假定字符串里不包括任何不可打印的字符。
 *
 * 示例:
 *
 * 输入: "Hello, my name is John"
 * 输出: 5
 * 解释: 这里的单词是指连续的不是空格的字符，所以 "Hello," 算作 1 个单词。
 */
public class Leetcode434 {

    /**
     * 首先过滤起始空格　然后每次循环统计字符串　并过滤空格
     * 统计个数
     */
    public int countSegments(String s) {
        int cnt=0;
        int idx=0;
        while(idx<s.length()&&s.charAt(idx)==' ') idx++;
        while(idx<s.length()){
            while(idx<s.length()&&s.charAt(idx)!=' ') idx++;
            while(idx<s.length()&&s.charAt(idx)==' ') idx++;
            cnt++;
        }
        return cnt;
    }
}
