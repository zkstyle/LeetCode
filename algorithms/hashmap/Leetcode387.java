package hashmap;

import java.util.HashMap;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: hashmap
 * @Author: elvis
 * @CreateTime: 2020-06-08 20:28
 * @Description: 字符串中的第一个唯一字符
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 *
 *  
 *
 * 示例：
 *
 * s = "leetcode"
 * 返回 0
 *
 * s = "loveleetcode"
 * 返回 2
 *  
 *
 * 提示：你可以假定该字符串只包含小写字母。
 */
public class Leetcode387 {

    /**
     * 利用hashmap存放字符以及对应数量
     * 第二遍for循环检测数量为1的字符
     */
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> count = new HashMap<Character, Integer>();
        int n = s.length();
        // build hash map : character and how often it appears
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            count.put(c, count.getOrDefault(c, 0) + 1);
        }

        // find the index
        for (int i = 0; i < n; i++) {
            if (count.get(s.charAt(i)) == 1)
                return i;
        }
        return -1;
    }

    /**
     * 因为字符仅仅有26个小写字母　优化为int数组
     * 每个位置存放'a'~'z'的数量
     * 当大于26时　可以重26个字母的角度出发　遍历并判断每一个字母的起始位置与结束位置是否一样
     */
    public int firstUniqChar2(String s) {
        if (s.length() <= 26) {
            int[] charNum = new int[26];
            char[] chars = s.toCharArray();
            for (int i = 0; i < s.length(); i++) {
                charNum[chars[i] - 'a']++;
            }
            for (int j = 0; j < s.length(); j++) {
                if (charNum[chars[j] - 'a'] == 1) {
                    return j;
                }
            }
            return -1;
        }
        int index = -1;
        for (char c = 'a'; c <= 'z'; c++) {
            int beginIndex = s.indexOf(c);
            if (beginIndex != -1 && beginIndex == s.lastIndexOf(c)) {
                index = (index == -1 || index > beginIndex) ? beginIndex : index;
            }
        }
        return index;
    }
}
