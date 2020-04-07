package linkedlist;

import linkedlist.listnode.ListNode;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: com.elvis.leetcode.linkedlist
 * @Author: Elvis
 * @CreateTime: 2019-02-22 10:11
 * Description: 分隔链表
 * 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
 *
 * 你应当保留两个分区中每个节点的初始相对位置。
 *
 * 示例:
 *
 * 输入: head = 1->4->3->2->5->2, x = 3
 * 输出: 1->2->2->4->3->5
 */
public class Leetcode86 {

    /**
     * 基本思路　首先定义两个带哑结点链表指针　分别保存小于x与大于等于x的节点　
     * 遍历链表进行分割 最后为避免形成环形链表　断链after链表尾指针
     */
    public ListNode partition(ListNode head, int x) {
        ListNode before_head = new ListNode(0);
        ListNode before = before_head;
        ListNode after_head = new ListNode(0);
        ListNode after = after_head;

        while (head != null) {

            // If the original list node is lesser than the given x,
            // assign it to the before list.
            if (head.val < x) {
                before.next = head;
                before = before.next;
            } else {
                // If the original list node is greater or equal to the given x,
                // assign it to the after list.
                after.next = head;
                after = after.next;
            }

            // 遍历
            head = head.next;
        }

        // head = 1->4->3->2->5->2, x = 3　after指针指向before最后一个节点2 需要断链
        after.next = null;

        // Once all the nodes are correctly assigned to the two lists,
        // combine them to form a single list which would be returned.
        before.next = after_head.next;

        return before_head.next;
    }
}
