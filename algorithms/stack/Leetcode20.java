package stack;

import java.util.Stack;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: com.elvis.leetcode.stack
 * @Author: Elvis
 * @CreateTime: 2020-2-13 18:59
 * Description:
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * 示例 1:
 *
 * 输入: "()"
 * 输出: true
 * 示例 2:
 *
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 *
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 *
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 *
 * 输入: "{[]}"
 * 输出: true
 */
public class Leetcode20 {

    /**
     *stack.peek()与stack.pop()区别
     * 相同点：大家都返回栈顶的值。
     * 不同点：peek 不改变栈的值(不删除栈顶的值)，pop会把栈顶的值删除。
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++){
            switch(s.charAt(i)){
                //首先将判断是不是左括号　是左括号就把对应的右括号入栈
                case '(':  stack.push(')'); break;
                case '[':  stack.push(']'); break;
                case '{':  stack.push('}'); break;
                //如果是右括号　判断能否出栈　若stack为空　则不能出栈　若不为空则判断出栈元素是否与当前字符相等
                default:   if (stack.isEmpty() || stack.pop() != s.charAt(i)) return false;
            }

        }
        //若为空　则说明一一匹配
        return stack.isEmpty();
    }

}
