package string;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: com.elvis.leetcode.string
 * @Author: Elvis
 * @CreateTime: 2019-03-16 09:06
 * Description: Implement strStr()
 * Implement strStr().
 *
 * Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 *
 * Example 1:
 *
 * Input: haystack = "hello", needle = "ll"
 * Output: 2
 * Example 2:
 *
 * Input: haystack = "aaaaa", needle = "bba"
 * Output: -1
 * Clarification:
 *
 * What should we return when needle is an empty string? This is a great question to ask during an interview.
 *
 * For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().
 */
public class Leetcode28 {

    /**
     * 取巧利用封装好的字符串截取函数substring　逐一进行字符串比对
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0){
            return 0;
        }
        int m = haystack.length();
        int n = needle.length();
        for (int i = 0; i <= m - n; i++){
            //从0一直遍历到m-n(因为needle字符串有长度)
            if (haystack.substring(i, i + n).equals(needle)){
                return i;
            }
        }
        return -1;
    }

    /**
     * 方法二　利用自定义substring逐一进行字符匹配
     * @param haystack
     * @param needle
     * @return
     */
    public static int strStr02(String haystack, String needle) {
        int result = -1;
        int m = haystack.length();
        int n = needle.length();
        // 如果目标字符串为空 返回0
        if (n == 0) {
            return 0;
        }
        // 遍历源字符串 如果源字符当前索引后面的长度没有目标字符串长 则不匹配,跳过当前循环
        for (int i = 0; i + n <= m; i++) {
            // 判断当前字符是否和目标第一个字符相同
            if (haystack.charAt(i) == needle.charAt(0)) {
                // 遍历目标字符串, 和源字符串当前索引位置的字符串开始对比 都想同则return
                for (int j = 0; j < n; j++) {
                    result = i;
                    if (haystack.charAt(i+j) != needle.charAt(j)) {
                        result = -1;
                        break;
                    }
                }
                if (result > -1) {
                    return result;
                }
            }
        }
        return result;
    }

}
