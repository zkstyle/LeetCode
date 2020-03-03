package stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: stack
 * @Author: elvis
 * @CreateTime: 2020-03-01 08:59
 * @Description: 用队列实现栈
 */
public class Leetcode225 {
    class MyStack {
        private Queue<Integer> q1 = new LinkedList<>();
        /**
         * Initialize your data structure here.
         */
        public MyStack() {

        }

        /**
         * Push element x onto stack.
         * 每次将队尾元素移除并添加至队首　完成元素逆置
         * 达到模仿栈结构目的
         */
        public void push(int x) {
            q1.offer(x);
            int sz = q1.size();
            while (sz >1){
                q1.add(q1.poll());
                sz--;
            }
        }

        /**
         * Removes the element on top of the stack and returns that element.
         */
        public int pop() {
            return q1.poll();
        }

        /**
         * Get the top element.
         */
        public int top() {
            return q1.peek();
        }

        /**
         * Returns whether the stack is empty.
         */
        public boolean empty() {
            return q1.isEmpty();
        }
    }


    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();

    }

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */

}
