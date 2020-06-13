package hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: hashmap
 * @Author: elvis
 * @CreateTime: 2020-06-13 12:47
 * @Description: 同构字符串
 * 给定两个字符串 s 和 t，判断它们是否是同构的。
 *
 * 如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。
 *
 * 所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身。
 *
 * 示例 1:
 *
 * 输入: s = "egg", t = "add"
 * 输出: true
 * 示例 2:
 *
 * 输入: s = "foo", t = "bar"
 * 输出: false
 * 示例 3:
 *
 * 输入: s = "paper", t = "title"
 * 输出: true
 * 说明:
 * 你可以假设 s 和 t 具有相同的长度。
 */
public class Leetcode205 {

    /**
     * 利用hashmap作关系映射　每次判断当前字符是否存在map中　存在若map.get(i)不等于t.charAt(i)则返回false
     * 若不存在于map中　则判断t.charAt(i)是否存在与map的values中
     *
     * 思路二　这题也可以用数组表示map　通过下标索引到对应的值　下标为s.charAt(i) 值为 t.charAt(i)
     */
    public boolean isIsomorphic(String s, String t) {
        int sLen = s.length(), tLen = t.length();
        if (sLen != tLen) return false;
        char[] cs = s.toCharArray();
        char[] ts = t.toCharArray();
        Map<Character, Character> map = new HashMap<>();
        int idx = 0;
        while (idx < sLen) {
            if (map.containsKey(cs[idx])) {
                if (map.get(cs[idx]) != ts[idx])
                    return false;
            } else {
                if (map.containsValue(ts[idx])) return false;
                map.put(cs[idx], ts[idx]);
            }
            idx++;
        }
        return true;
    }

}
