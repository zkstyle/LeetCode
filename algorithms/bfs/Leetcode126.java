package bfs;

import java.util.*;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: bfs
 * @Author: elvis
 * @CreateTime: 2020-08-28 19:57
 * @Description: 单词接龙
 */
public class Leetcode126 {

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
