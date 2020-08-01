package hashmap;

import java.util.*;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: com.elvis.leetcode.hashmap
 * @Author: Elvis
 * @CreateTime: 2018-12-26 17:48
 * Description:
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 *
 * 示例:
 *
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * 输出:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 * 说明：
 *
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 */
public class Leetcode49 {

    /**
     * 思路
     *
     * 当且仅当它们的排序字符串相等时，两个字符串是字母异位词。
     *
     * 维护一个映射 ans : {String -> List}，其中每个键 K 是一个排序字符串，每个值是初始输入的字符串列表，排序后等于K。
     *
     * 在 Java 中，我们将键存储为字符串，例如，code。 在 Python 中，我们将键存储为散列化元组，例如，('c', 'o', 'd', 'e')。
     *
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) return new ArrayList();
        //key为遍历的任一字符串的排序后的结果　value为list 添加遍历的符合要求的字符串
        Map<String, List> ans = new HashMap<String, List>();
        for (String s : strs) {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String key = String.valueOf(ca);
            if (!ans.containsKey(key)) ans.put(key, new ArrayList());
            ans.get(key).add(s);
        }
        return new ArrayList(ans.values());
    }

    //fast
    public List<List<String>> groupAnagrams2(String[] strs) {
        List<List<String>> rs = new ArrayList<List<String>>();
        Map<String, List<String>> mapping = new HashMap<String, List<String>>();

        for (String str : strs) {

            char[] letters = str.toCharArray();
            Arrays.sort(letters);
            String sortStr = new String(letters);

            List<String> out = mapping.get(sortStr);
            if (null == out) {
                out = new ArrayList<String>();
                rs.add(out);
                mapping.put(sortStr, out);
            }

            out.add(str);
        }
        return rs;
    }
}
