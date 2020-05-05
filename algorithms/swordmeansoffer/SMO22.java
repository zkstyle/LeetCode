package swordmeansoffer;

import linkedlist.listnode.ListNode;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: swordmeansoffer
 * @Author: elvis
 * @CreateTime: 2020-05-04 08:34
 * @Description: 面试题22. 链表中倒数第k个节点
 * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
 *
 * 例如，一个链表有6个节点，从头节点开始，它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个节点是值为4的节点。　
 * 示例：
 *
 * 给定一个链表: 1->2->3->4->5, 和 k = 2.
 *
 * 返回链表 4->5.
 */
public class SMO22 {

    /**
     * 首先定义一个指针　用于找寻倒数第k个节点 node
     * node先向后移动k个节点
     * 然后head node同时向尾节点移动　当node到达尾节点
     * head也到达了倒数第k个节点
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode node = head;
        while (k != 0) {
            node = node.next;
            k--;
        }
        while (node != null) {
            node = node.next;
            head = head.next;
        }
        return head;
    }
}
