package swordmeansoffer;

import java.util.Stack;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: swordmeansoffer
 * @Author: elvis
 * @CreateTime: 2020-04-29 14:28
 * @Description:
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，
 * 分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 * 示例 1：
 *
 * 输入：
 * ["CQueue","appendTail","deleteHead","deleteHead"]
 * [[],[3],[],[]]
 * 输出：[null,null,3,-1]
 * 示例 2：
 *
 * 输入：
 * ["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
 * [[],[],[5],[2],[],[]]
 * 输出：[null,-1,null,null,5,2]
 * 提示：
 *
 * 1 <= values <= 10000
 * 最多会对 appendTail、deleteHead 进行 10000 次调用
 * */
public class SMO09 {

    class CQueue {
        Stack<Integer> stack1;
        Stack<Integer> stack2;
        int size;

        public CQueue() {
            stack1 = new Stack<Integer>();
            stack2 = new Stack<Integer>();
            size = 0;
        }

        /**
         * 在队列添加元素时　先将栈1的元素放入栈2 再将元素push进栈1 再将栈2元素pop()出来 同时push进栈1
         */
        public void appendTail(int value) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            stack1.push(value);
            while (!stack2.isEmpty()) {
                stack1.push(stack2.pop());
            }
            size++;
        }

        public int deleteHead() {
            if (size == 0) {
                return -1;
            }
            size--;
            return stack1.pop();
        }
    }
}
