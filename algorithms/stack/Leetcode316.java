package stack;

import java.util.*;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: stack
 * @Author: elvis
 * @CreateTime: 2020-06-16 14:20
 * @Description: 去除重复字母
 *
 * 给你一个仅包含小写字母的字符串，请你去除字符串中重复的字母，使得每个字母只出现一次。需保证返回结果的字典序最小（要求不能打乱其他字符的相对位置）。
 *
 *
 *
 * 示例 1:
 *
 * 输入: "bcabc"
 * 输出: "abc"
 *
 * 示例 2:
 *
 * 输入: "cbacdcbc"
 * 输出: "acdb"
 */
public class Leetcode316 {

    /**
     * 用栈来存储最终返回的字符串，并维持字符串的最小字典序。每遇到一个字符，如果这个字符不存在于栈中，就需要将该字符压入栈中。
     * 但在压入之前，需要先将之后还会出现，并且字典序比当前字符小的栈顶字符移除，然后再将当前字符压入。
     */
    public String removeDuplicateLetters(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        Set<Character> seen = new HashSet<>();
        Map<Character, Integer> last_occurence = new HashMap<>();
        for (int i = 0; i < s.length(); i++) last_occurence.put(s.charAt(i), i);

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!seen.contains(c)) {
                while (!stack.isEmpty() && c < stack.peek() && last_occurence.get(stack.peek()) > i) {
                    seen.remove(stack.pop());
                }
                seen.add(c);
                stack.push(c);
            }
        }
        char[] c = new char[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) c[i] = stack.pop();
        return new String(c);
    }
}
