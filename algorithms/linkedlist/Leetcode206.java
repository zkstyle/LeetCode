package linkedlist;

import linkedlist.listnode.ListNode;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: linkedlist
 * @Author: Elvis
 * @CreateTime: 2019-07-01 10:23
 * Description:
 * 反转一个单链表。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 */
public class Leetcode206 {

    /**
     * 经典链表翻转问题　链表逆置
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        ListNode p = head;
        ListNode next;
        while (p.next != null) {
            //next为逆置节点后继节点 p为每一次需要逆置节点　head保存每一次逆置后的头结点
            next = p.next;
            p.next = next.next;
            next.next = head;
            head = next;
        }
        return head;
    }
}
