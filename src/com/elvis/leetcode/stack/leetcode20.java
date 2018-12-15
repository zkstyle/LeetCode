package com.elvis.leetcode.stack;

import org.junit.Test;

import java.util.Map;
import java.util.Stack;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: com.elvis.leetcode.stack
 * @Author: Elvis
 * @CreateTime: 2018-12-13 18:59
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
public class leetcode20 {
    //定义键值对map 存放括号　键值分别是左括号与右括号
    private Map<Character,Character> map = null;

    public static void pushStack(String s){

    }

    @Test
    public boolean isValid(String s) {
        boolean flag = true;//判断是否符合条件的标志


        return flag;
    }


    public static void main(String[] args) {

    }

}
