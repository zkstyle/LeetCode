package swordmeansoffer;

import linkedlist.listnode.ListNode;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: swordmeansoffer
 * @Author: elvis
 * @CreateTime: 2020-05-04 08:34
 * @Description: 面试题24. 反转链表
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。　
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 *
 *
 * 限制：
 *
 * 0 <= 节点个数 <= 5000
 */
public class SMO24 {

    /**
     * 声明一个dummy节点　方便处理
     * 采用头插法依次将节点插入　定义cur节点遍历插入
     * 定义next节点保存下一次遍历节点
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        ListNode cur = head;
        ListNode next = cur;
        while (cur != null) {
            next = cur.next;
            cur.next = dummy.next;
            dummy.next = cur;
            cur = next;

        }
        return dummy.next;
    }
}
