package bfs;

import java.util.*;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: bfs
 * @Author: elvis
 * @CreateTime: 2020-08-28 19:57
 * @Description: 单词接龙
 * 给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
 *
 * 每次转换只能改变一个字母。
 * 转换过程中的中间单词必须是字典中的单词。
 * 说明:
 *
 * 如果不存在这样的转换序列，返回 0。
 * 所有单词具有相同的长度。
 * 所有单词只由小写字母组成。
 * 字典中不存在重复的单词。
 * 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
 * 示例 1:
 *
 * 输入:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 *
 * 输出: 5
 *
 * 解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 *      返回它的长度 5。
 * 示例 2:
 *
 * 输入:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 *
 * 输出: 0
 *
 * 解释: endWord "cog" 不在字典中，所以无法进行转换。
 */
public class Leetcode127 {

    public static int minLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        beginSet.add(beginWord);
        endSet.add(endWord);
        Set<String> dict = new HashSet<>(wordList);
        if (!dict.contains(endWord)) return 0;
        return search(beginSet, endSet, dict, 1);
    }

    private static int search(Set<String> beginSet, Set<String> endSet, Set<String> dict, int cnt) {
        if (beginSet.isEmpty() || endSet.isEmpty()) return 0;
        cnt++;
        dict.removeAll(beginSet);
        Set<String> nextSet = new HashSet<>();
        for (String str : beginSet) {
            char[] chs = str.toCharArray();
            for (int i = 0; i < chs.length; i++) {
                char c = chs[i];
                for (char j = 'a'; j <= 'z'; j++) {
                    chs[i] = j;
                    String tmp = new String(chs);
                    if (!dict.contains(tmp)) continue;
                    if (endSet.contains(tmp)) return cnt;
                    nextSet.add(tmp);
                }
                chs[i] = c;
            }
        }
        return nextSet.size() > endSet.size() ? search(endSet, nextSet, dict, cnt) : search(nextSet, endSet, dict, cnt);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String begin = sc.nextLine();
        String end = sc.nextLine();
        String para = sc.nextLine();
        String[] dict = para.split(" ");
        List<String> wordList = new ArrayList<>();
        for (String s : dict) wordList.add(s);
        int ret = minLength(begin, end, wordList);
        System.out.println(ret);
    }
}
