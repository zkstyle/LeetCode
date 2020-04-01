package linkedlist;

import linkedlist.listnode.ListNode;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: com.elvis.leetcode.linkedlist
 * @Author: Elvis
 * @CreateTime: 2019-02-23 19:09
 * Description: 反转链表2
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 *
 * 说明:
 * 1 ≤ m ≤ n ≤ 链表长度。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 */
public class Leetcode92 {

    /**
     * 算法思路　首先dummy节点是定义的预节点　防止不确定n是1还是大于1 大于1当逆置节点后需要连接
     *          cur是指向需要逆置的第一个节点　curpre指向cur前一个节点　首先先将cur指向需要逆置的第一个节点
     *          再逆置n~m节点　最后连接
     * @param head
     * @param m
     * @param n
     * @return
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == n) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = head;
        ListNode curpre = dummy;//保存逆置起始节点前驱节点 因为逆置n~m的节点后　需要连接n-1,n两个节点
        while (m > 1) {
            curpre = curpre.next;
            cur = cur.next;
            m--;
            n--;
        }
        ListNode curHead = cur;//保存每一次的逆置后的头结点
        ListNode next;
        while (n > 1) {
            //逆置
            next = cur.next;
            cur.next = next.next;
            next.next = curHead;
            curHead = next;
            n--;
        }
        curpre.next = curHead;
        return dummy.next;
    }
}
