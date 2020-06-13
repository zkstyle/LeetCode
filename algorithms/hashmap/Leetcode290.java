package hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: hashmap
 * @Author: elvis
 * @CreateTime: 2020-06-11 21:41
 * @Description: 单词规律
 * 给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。
 *
 * 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。
 *
 * 示例1:
 *
 * 输入: pattern = "abba", str = "dog cat cat dog"
 * 输出: true
 * 示例 2:
 *
 * 输入:pattern = "abba", str = "dog cat cat fish"
 * 输出: false
 * 示例 3:
 *
 * 输入: pattern = "aaaa", str = "dog cat cat dog"
 * 输出: false
 * 示例 4:
 *
 * 输入: pattern = "abba", str = "dog dog dog dog"
 * 输出: false
 * 说明:
 * 你可以假设 pattern 只包含小写字母， str 包含了由单个空格分隔的小写字母。
 */
public class Leetcode290 {

    /**
     * 用map进行关系映射　首先将str分割成字符串数组
     * for循环遍历数组　若字符串存在于map中　判断字符串对应value值与pattern.charAt(i)是否相等
     * 若不存在　判断当前pattern.charAt(i)是否存在于map的value中
     */
    public boolean wordPattern(String pattern, String str) {
        String[] split = str.split(" ");
        if (split.length != pattern.length()) return false;
        Map<String, Character> map = new HashMap<>();
        for (int i = 0; i < split.length; i++) {
            if (map.containsKey(split[i])) {
                if (map.get(split[i]) != pattern.charAt(i)) return false;
            } else {
                if (map.containsValue(pattern.charAt(i))) return false;
                map.put(split[i], pattern.charAt(i));
            }
        }
        return true;
    }
}
