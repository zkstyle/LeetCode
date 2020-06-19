package hashmap;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: hashmap
 * @Author: elvis
 * @CreateTime: 2020-06-19 19:45
 * @Description: 字符串的排列
 * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
 *
 * 换句话说，第一个字符串的排列之一是第二个字符串的子串。
 *
 * 示例1:
 *
 * 输入: s1 = "ab" s2 = "eidbaooo"
 * 输出: True
 * 解释: s2 包含 s1 的排列之一 ("ba").
 *  
 *
 * 示例2:
 *
 * 输入: s1= "ab" s2 = "eidboaoo"
 * 输出: False
 *  
 *
 * 注意：
 *
 * 输入的字符串只包含小写字母
 * 两个字符串的长度都在 [1, 10,000] 之间
 */
public class Leetcode567 {

    /**
     * hashmap思想　首先将s1的字符及频率存入int数组中
     * for循环截取s1长度字符串　对每一个字符进行检查　用check数组检查该字符出现的频率是否小于dict数组中对应字符
     * 内循环结束　判断j==ch.length 等于说明符合　返回true
     */
    public boolean checkInclusion(String s1, String s2) {
        int len = s1.length();
        int[] dict = new int[26];
        for (char c : s1.toCharArray()) dict[c - 'a']++;
        for (int i = 0, j; i <= s2.length() - len; i++) {
            char[] ch = s2.substring(i, i + len).toCharArray();
            int[] check = new int[26];
            for (j = 0; j < ch.length; j++) {
                if (check[ch[j] - 'a'] < dict[ch[j] - 'a']) {
                    check[ch[j] - 'a']++;
                } else {
                    break;
                }
            }
            if (j == ch.length) return true;
        }
        return false;
    }

    /**
     * 滑动窗口
     */
    public boolean checkInclusion2(String s1, String s2) {
        int n = s2.length();
        int[] dict = new int[26];
        int[] freq = new int[26];
        int size = 0;
        for(char c : s1.toCharArray()) {
            if(dict[c - 'a'] == 0) size++;
            dict[c - 'a']++;
        }
        int match = 0;
        int left = 0, right = 0;
        while(right < n) {
            char rc = s2.charAt(right);
            freq[rc - 'a']++;
            if(freq[rc - 'a'] == dict[rc - 'a']) match++;
            while(size == match) {
                if(right - left + 1 == s1.length()) return true;
                char lc = s2.charAt(left);
                freq[lc - 'a']--;
                if(freq[lc - 'a'] < dict[lc - 'a']) match--;
                left++;
            }
            right++;
        }
        return false;
    }


}
