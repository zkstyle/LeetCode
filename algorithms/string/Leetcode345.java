package string;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: string
 * @Author: elvis
 * @CreateTime: 2020-06-10 22:41
 * @Description: 反转字符串中的元音字母
 * 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
 *
 * 示例 1:
 *
 * 输入: "hello"
 * 输出: "holle"
 * 示例 2:
 *
 * 输入: "leetcode"
 * 输出: "leotcede"
 * 说明:
 * 元音字母不包含字母"y"。
 */
public class Leetcode345 {

    /**
     *将元音字母存放到int数组中
     * 双指针从两端向中心移动
     */
    public String reverseVowels(String s) {
        int[] dict = new int[128];
        dict['a'] = 1;
        dict['e'] = 1;
        dict['o'] = 1;
        dict['i'] = 1;
        dict['u'] = 1;
        dict['A'] = 1;
        dict['E'] = 1;
        dict['O'] = 1;
        dict['I'] = 1;
        dict['U'] = 1;
        char[] ch = s.toCharArray();
        int l = 0, r = ch.length - 1;
        while (l < r) {
            while (l < r && dict[ch[l]] == 0) l++;
            while (l < r && dict[ch[r]] == 0) r--;
            char c = ch[l];
            ch[l++] = ch[r];
            ch[r--] = c;
        }
        return new String(ch);
    }
}
