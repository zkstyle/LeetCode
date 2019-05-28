package algorithms.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: com.elvis.leetcode.dp
 * @Author: Elvis
 * @CreateTime: 2019-05-16 14:38
 * Description:
 * 输入: s = "leetcode", wordDict = ["leet", "code"]
 * 输出: true
 * 解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
 * 示例 2：
 *
 * 输入: s = "applepenapple", wordDict = ["apple", "pen"]
 * 输出: true
 * 解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
 *      注意你可以重复使用字典中的单词。
 * 示例 3：
 *
 * 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 输出: false
 */
public class Leetcode139 {

    public boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length() + 1;
        boolean[] flags = new boolean[len];
        flags[0] = true;
        for (int i = 1; i < len; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (flags[j] && wordDict.contains(s.substring(j, i))) {
                    flags[i] = true;
                    break;
                }
            }
        }
        return flags[len - 1];
    }

    class word{
        public boolean wordBreak(String s, List<String> wordDict) {
            Boolean[] a = new Boolean[s.length()];
            return recent(0, s, wordDict, a);
        }

        private boolean recent(int p, String s, List<String> wordDict, Boolean[] a) {
            if (p == s.length()) {
                return true;
            }
            if (a[p] != null) {
                return a[p];
            }
            boolean b = false;
            for (String s1 : wordDict){
                if (s.startsWith(s1, p)) {
                    b = b || recent(p+s1.length(), s, wordDict, a);
                }
            }
            a[p] = b;
            return b;
        }
    }

    public static void main(String[] args) {
        String s = "leetcode";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("leet");
        wordDict.add("code");
        new Leetcode139().wordBreak(s, wordDict);
    }
}
