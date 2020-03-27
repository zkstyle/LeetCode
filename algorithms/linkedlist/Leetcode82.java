package linkedlist;

import linkedlist.listnode.ListNode;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: com.elvis.leetcode.linkedlist
 * @Author: Elvis
 * @CreateTime: 2019-02-19 15:58
 * Description: 删除排序链表中的重读元素2
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 *
 * 示例 1:
 *
 * 输入: 1->2->3->3->4->4->5
 * 输出: 1->2->5
 * 示例 2:
 *
 * 输入: 1->1->1->2->3
 * 输出: 2->3
 */
public class Leetcode82 {

    /**
     * 递归法　若当前节点值不等于下一个节点值　直接递归head.next = deleteDuplicates(head.next)
     * 否则　while循环删除节点　返回deleteDuplicates(head.next)　这里区别于83题　返回的是head.next因为head还是保留了一个重复值
     * 因为82题要求删除所有重复元素　故参数为head.next
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }

        if (head.next != null && head.val == head.next.val) {
            while (head.next != null && head.val == head.next.val) {
                head = head.next;
            }
            return deleteDuplicates(head.next);
        } else {
            head.next = deleteDuplicates(head.next);
        }

        return head;
    }

    /**
     * 迭代法　　申明一个dummy节点　dummy.next指向head
     * cur指向dummy　while循环判断cur.next,cur.next.next不为空
     * 如果下一个节点值与下下个节点值相等　申明temp节点指向cur.next
     * while循环删除重复节点　最后temp节点指向唯一的重复节点　cur.next = temp.next删除最后一个重复节点
     * @param head
     * @return
     */
    public ListNode deleteDuplicates2(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null) {
            if (cur.next.val == cur.next.next.val) {
                ListNode temp = cur.next;
                while (temp != null && temp.next != null && temp.val == temp.next.val ) {
                    temp = temp.next;
                }
                cur.next = temp.next;
            }
            else
                cur = cur.next;
        }
        return dummy.next;
    }
}
