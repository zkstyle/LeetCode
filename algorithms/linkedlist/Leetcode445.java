package linkedlist;

import linkedlist.listnode.ListNode;

import java.util.Stack;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: linkedlist
 * @Author: Elvis
 * @CreateTime: 2019-07-10 15:56
 * Description:
 * 给定两个非空链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储单个数字。将这两数相加会返回一个新的链表。
 *
 *  
 *
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 *
 * 进阶:
 *
 * 如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。
 *
 * 示例:
 *
 * 输入: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出: 7 -> 8 -> 0 -> 7
 */
public class Leetcode445 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        while(l1 != null){
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while(l2 != null){
            stack2.push(l2.val);
            l2 = l2.next;
        }

        ListNode head =null;
        int flag = 0;
        while (!stack1.isEmpty() || !stack2.isEmpty() || flag != 0){
            int value = 0;
            if (!stack1.isEmpty()) value += stack1.pop();
            if (!stack2.isEmpty()) value += stack2.pop();
            value += flag;
            ListNode node = new ListNode(value%10);
            flag = value / 10;
            node.next = head;
            head = node;
        }
        return head;
    }
}
