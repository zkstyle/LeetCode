package com.elvis.leetcode.stack;

import com.sun.deploy.util.StringUtils;

import java.util.Stack;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: com.elvis.leetcode.stack
 * @Author: Elvis
 * @CreateTime: 2019-03-25 09:10
 * Description: 逆波兰表达式求值
 * 根据逆波兰表示法，求表达式的值。
 *
 * 有效的运算符包括 +, -, *, / 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
 *
 * 说明：
 *
 * 整数除法只保留整数部分。
 * 给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。
 * 示例 1：
 *
 * 输入: ["2", "1", "+", "3", "*"]
 * 输出: 9
 * 解释: ((2 + 1) * 3) = 9
 * 示例 2：
 *
 * 输入: ["4", "13", "5", "/", "+"]
 * 输出: 6
 * 解释: (4 + (13 / 5)) = 6
 * 示例 3：
 *
 * 输入: ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]
 * 输出: 22
 * 解释:
 *   ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
 * = ((10 * (6 / (12 * -11))) + 17) + 5
 * = ((10 * (6 / -132)) + 17) + 5
 * = ((10 * 0) + 17) + 5
 * = (0 + 17) + 5
 * = 17 + 5
 * = 22
 */
public class Leetcode150 {


    String[] tokens = null;
    int pos = -1;

    /**
     * best
     * @param tokens
     * @return
     */
    public int evalRPN1(String[] tokens) {
        this.tokens = tokens;
        pos = tokens.length - 1;
        return eval();
    }

    private int eval() {
        String token = tokens[pos--];
        if ("+".equals(token)) return eval() + eval();
        if ("-".equals(token)) return -1 * eval() + eval();
        if ("*".equals(token)) return eval() * eval();
        if ("/".equals(token)) {int d = eval(); return eval() / d;}
        return Integer.parseInt(token);
    }

    /**
     * personal
     * @param tokens
     * @return
     */
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        int num1, num2;
        for (int i = 0; i < tokens.length; i++) {
            if (Character.isDigit(tokens[i].charAt(0)) || ((tokens[i].length() > 1) && Character.isDigit(tokens[i].charAt(1)))){
                stack.push(tokens[i]);
            } else {
                num2 = Integer.valueOf(stack.pop());
                num1 = Integer.valueOf(stack.pop());
                switch (tokens[i]) {
                    case "+":
                        stack.push(String.valueOf(num1 + num2));
                        break;
                    case "-":
                        stack.push(String.valueOf(num1 - num2));
                        break;
                    case "*":
                        stack.push(String.valueOf(num1 * num2));
                        break;
                    case "/":
                        stack.push(String.valueOf(num1 / num2));
                        break;

                }
            }
        }
            return Integer.parseInt(stack.peek());
        }

    public static void main(String[] args) {
        String[] tokens = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        new Leetcode150().evalRPN(tokens);;
    }
}
