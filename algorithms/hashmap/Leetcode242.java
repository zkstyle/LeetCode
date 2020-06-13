package hashmap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: hashmap
 * @Author: elvis
 * @CreateTime: 2020-06-07 21:24
 * @Description: 有效的字母异位词
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * 示例 1:
 *
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 *
 * 输入: s = "rat", t = "car"
 * 输出: false
 * 说明:
 * 你可以假设字符串只包含小写字母。
 *
 * 进阶:
 * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 */
public class Leetcode242 {

    /**
     * 简单粗暴的工具类进行排序
     * 然后再对两个字符数组进行判断是否相等
     */
    public boolean isAnagram0(String s, String t) {
        if (s.length() != t.length())
            return false;
        char[] cs = s.toCharArray();
        char[] ct = t.toCharArray();
        Arrays.sort(cs);
        Arrays.sort(ct);
        return Arrays.equals(cs, ct);
    }

    /**
     * 将字符串转化为字符数组　然后将字符数组存储到hashmap中　并存储对应的字符数量
     * 然后再次遍历　若当前字符的数量为0　则不符合返回false
     */
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        char[] cs = s.toCharArray();
        char[] ct = t.toCharArray();
        if (cs.length != ct.length) return false;
        for (int i = 0; i < cs.length; i++) {
            map.put(cs[i], map.getOrDefault(cs[i], 0) + 1);
        }
        for (int j = 0; j < ct.length; j++) {
            int v = map.getOrDefault(ct[j], 0);
            if (v == 0) return false;
            map.put(ct[j], v - 1);
        }
        return true;
    }

    /**
     * 进一步优化　因为都是小写字母　将字符与数量存储到int数组中
     * 并同时遍历字符加减当前字符数量
     * 最后遍历一次　查看alpha[i] 若存在不等于0的字符　则返回false
     */
    public boolean isAnagram2(String s, String t) {
        if (s.length() != t.length())
            return false;
        int[] alpha = new int[26];
        for (int i = 0; i < s.length(); i++) {
            alpha[s.charAt(i) - 'a']++;
            alpha[t.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++)
            if (alpha[i] != 0)
                return false;
        return true;
    }
}
