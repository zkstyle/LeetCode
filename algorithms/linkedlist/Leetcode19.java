package linkedlist;

import linkedlist.listnode.ListNode;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: com.elvis.leetcode.linkedlist
 * @Author: Elvis
 * @CreateTime: 2019-01-23 09:08
 * Description: 删除链表的倒数第N个节点
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *
 * 示例：
 *
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 *
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 *
 * 给定的 n 保证是有效的。
 *
 * 进阶：
 *
 * 你能尝试使用一趟扫描实现吗？
 */
public class Leetcode19 {
    /**
     * 8ms
     * @param head
     * @param n
     * @return
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        //声明一个起始节点，dummy.next = head 用以表示head的前一个节点
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        //初始位置从头结点前一个节点开始，可以轻松解决倒数第n个节点是头结点的情况
        ListNode second = dummy;
        // 利用双指针　第一个指针先行n+1步　这样两个指针之间相差n+1步(因为初始位置指向dummy节点)
        for (int i = 0; i <= n; i++) {
            first = first.next;
        }
        /**
         * 功能描述: 同时将两个指针向最后一个节点移动，当第一个指针节点移动到最后一个节点,
         * 第二个指针节点刚好移动到倒数第n个节点的前一个节点（因为删除第n个节点需要找到它的前驱节点）
         * 这样两个节点之间保持着n个节点差距
         */
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        //删除第n个节点
        second.next = second.next.next;
        return dummy.next;
    }
}
