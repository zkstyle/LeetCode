package stack;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: com.elvis.leetcode.stack
 * @Author: Elvis
 * @CreateTime: 2019-03-25 10:59
 * Description: MInStack
 */
public class Leetcode155 {

    private int top = -1;
    // 保存当前栈顶位置最小值的索引
    private int[] minIndex = new int[9999];
    private int[] stack = new int[9999];

    /*public MinStack() {
    }*/

    public void push(int x) {
        stack[++top] = x;
        if (top > 0)
            minIndex[top] = x < stack[minIndex[top - 1]] ? top : minIndex[top - 1];
    }

    public void pop() {
        if (top == -1) return;
        top--;
    }

    public int top() {
        return stack[top];
    }

    public int getMin() {
        return stack[minIndex[top]];
    }
}
