package linkedlist;

import linkedlist.listnode.ListNode;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: com.elvis.leetcode.linkedlist
 * @Author: Elvis
 * @CreateTime: 2019-03-13 09:08
 * Description: Reorder List
 *
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
 * reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
 *
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 *
 * Example 1:
 *
 * Given 1->2->3->4, reorder it to 1->4->2->3.
 * Example 2:
 *
 * Given 1->2->3->4->5, reorder it to 1->5->2->4->3.
 */
public class Leetcode143 {
    /**
     * 思路： 这道题可谓是集合了各种的链表操作，把这道题的每个步骤都理解清楚了之后，链表相关的大部分题应该都可以搞定了。建议在脑中多过两遍这个题 可以把本题分为3个步骤：
     *
     * 使用双指针将链表分成两段
     * 将链表后半段进行翻转
     * 将两段链表进行合并
     * 另外有一些命名的规则，可以使代码更为清晰：
     *
     * p为遍历节点，如果有两个p1在前，p2在后
     * next为遍历节点p的下一个节点，next1则为p1的下一个节点
     * 如果有必要存head值，head2为第二段链表的规则
     * @param head
     */
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;

        ListNode p1 = head;
        ListNode p2 = head;

        // 找到链表的一半
        while (p2.next != null && p2.next.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
        }

        // 将链表分为两段
        p2 = p1.next;
        p1.next = null;
        p1 = head;

        // 将后半段进行链表的翻转
        ListNode head2 = p2;
        ListNode next2;
        while (p2.next != null) {
            next2 = p2.next;
            p2.next = next2.next;
            next2.next = head2;
            head2 = next2;
        }
        p2 = head2;

        // 两条链表进行合并
        ListNode next1;
        while (p2 != null) {
            next1 = p1.next;
            next2 = p2.next;

            p1.next = p2;
            p2.next = next1;

            p1 = next1;
            p2 = next2;
        }

    }

    public void reorderList2(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) return;
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode phead = slow.next;
        fast = phead;
        slow.next = null;
        ListNode cur;
        //reverse
        while (fast.next != null) {
            cur = fast.next;
            fast.next = cur.next;
            cur.next = phead;
            phead = cur;
        }
        slow = head;
        fast = phead;
        //合并
        while (phead != null) {
            phead = fast.next;
            fast.next = slow.next;
            slow.next = fast;
            slow = fast.next;
            fast = phead;
        }
    }

}
