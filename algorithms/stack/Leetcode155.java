package stack;

import java.util.ArrayList;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: com.elvis.leetcode.stack
 * @Author: Elvis
 * @CreateTime: 2019-03-25 10:59
 * Description: MInStack
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 * push(x) —— 将元素 x 推入栈中。
 * pop() —— 删除栈顶的元素。
 * top() —— 获取栈顶元素。
 * getMin() —— 检索栈中的最小元素。
 *  
 *
 * 示例:
 *
 * 输入：
 * ["MinStack","push","push","push","getMin","pop","top","getMin"]
 * [[],[-2],[0],[-3],[],[],[],[]]
 *
 * 输出：
 * [null,null,null,null,-3,null,0,-2]
 *
 * 解释：
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 */
public class Leetcode155 {

    /**
     * 设计思路　首先使用两个数组list stack min
     * stack用来存放栈数据　min用来保存每一次当前的最小值
     * 若当前入栈的值x小于上一次的最小值　则将x压入min栈　否则取上一次的最小值压入min栈
     * push则直接压入stack栈　对于min栈　若为空则直接入栈　否则判断x与min栈顶元素大小
     */
    class MinStack {
        ArrayList<Integer> stack;
        ArrayList<Integer> min;

        /**
         * initialize your data structure here.
         */
        public MinStack() {
            stack = new ArrayList<>();
            min = new ArrayList<>();
        }

        public void push(int x) {
            stack.add(x);
            int idx = min.size();
            if (idx == 0 || min.get(idx - 1) > x) {
                min.add(x);
            } else {
                min.add(min.get(idx - 1));
            }
        }

        public void pop() {
            if (stack.size() == 0) throw new RuntimeException("栈为空");
            stack.remove(stack.size() - 1);
            min.remove(min.size() - 1);
        }

        public int top() {
            if (stack.size() == 0) throw new RuntimeException("栈为空");
            return stack.get(stack.size() - 1);
        }

        public int getMin() {
            if (min.size() == 0) throw new RuntimeException("栈为空");
            return min.get(min.size() - 1);
        }
    }
}
