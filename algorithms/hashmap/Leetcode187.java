package hashmap;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: hashmap
 * @Author: elvis
 * @CreateTime: 2020-06-05 11:01
 * @Description: 重复的DNA序列
 */
public class Leetcode187 {

    /**
     * 首先list保存返回结果　set用于切割窗口　大小题目给出为10
     * 然后每次切割大小为10的窗口　再判断是否存在于set中　存在则添加到list中
     * 同时也要判断在list中是否存在
     */
    public List<String> findRepeatedDnaSequences(String s) {
        int len = 10;
        List<String> list = new ArrayList<>();
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i <= s.length() - len; i++) {
            String t = s.substring(i, i + len);
            if (set.add(t)) {
                continue;
            } else {
                if (!list.contains(t))
                    list.add(t);
            }

        }
        return list;
    }
}
