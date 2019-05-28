package algorithms.hashtable;

import java.util.*;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: com.elvis.leetcode.hashtable
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
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> lists = new ArrayList<>();

        Map<String , List<Integer>> map = Sort(strs);
        for (Map.Entry<String , List<Integer>> entry : map.entrySet()){
            List<Integer> listReturn = entry.getValue();
            List<String> list = new ArrayList<>();
            for (Integer i : listReturn) {
                list.add(strs[i]);
            }
            lists.add(list);
        }
        return lists;
    }

    public static Map<String , List<Integer>> Sort(String[] strs){
        Map<String , List<Integer>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] ch = strs[i].toCharArray();
            Arrays.sort(ch);
            String s = new String(ch);
            if (!map.containsKey(s)){
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(s, list);
            }else {
                List<Integer> list = map.get(s);
                list.add(i);
                map.put(s, list);
            }
        }
        return map;
    }

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> lists = groupAnagrams(strs);
        for (List<String> list : lists){
            for (String s : list){
                System.out.print(s+" ");
            }
            System.out.println();
        }
    }
}
