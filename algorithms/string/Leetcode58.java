package string;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: string
 * @Author: elvis
 * @CreateTime: 2020-03-12 10:31
 * @Description: 最后一个单词的长度
 * 给定一个仅包含大小写字母和空格 ' ' 的字符串 s，返回其最后一个单词的长度。如果字符串从左向右滚动显示，那么最后一个单词就是最后出现的单词。
 *
 * 如果不存在最后一个单词，请返回 0 。
 *
 * 说明：一个单词是指仅由字母组成、不包含任何空格字符的 最大子字符串。
 * 示例:
 *
 * 输入: "Hello World"
 * 输出: 5
 */
public class Leetcode58 {


    /*
    *       利用分割函数　以空格为分隔符进行分割
    *       返回最后一个分割单词的长度
     */
    public int lengthOfLastWord(String s) {
        String[] arr = s.split(" ");
        if(arr.length == 0) return 0;
        return arr[arr.length-1].length();
    }

    /**
     *  也是利用String封装函数　先去掉尾部可能存在的空格
     *  再以s.length减去最后一个空格出现的下标
     */
    public int lengthOfLastWord1(String s) {
        s = s.trim();
        return s.length() -1 - s.lastIndexOf(" ");
    }

    /*
    *   手写实现　先将下标遍历至非空格位置
    *   再接着遍历到下一个空格位置
     */
    public int lengthOfLastWord2(String s) {
        int end = s.length() - 1;
        while(end >= 0 && s.charAt(end) == ' ') end--;
        if(end < 0) return 0;
        int start = end;
        while(start >= 0 && s.charAt(start) != ' ') start--;
        return end - start;
    }
}
