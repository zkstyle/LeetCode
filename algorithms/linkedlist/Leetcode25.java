package linkedlist;

import linkedlist.listnode.ListNode;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: com.elvis.leetcode.linkedlist
 * @Author: Elvis
 * @CreateTime: 2019-02-16 14:57
 * Description: k个一组翻转链表
 * 给出一个链表，每 k 个节点一组进行翻转，并返回翻转后的链表。
 *
 * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么将最后剩余节点保持原有顺序。
 *
 * 示例 :
 *
 * 给定这个链表：1->2->3->4->5
 *
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 *
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 *
 * 说明 :
 *
 * 你的算法只能使用常数的额外空间。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 */
public class Leetcode25 {

    /**
     * 采用递归解法　比较方法处理每k个节点的链接问题
     * 首先每次先找到第k个节点　nh为下一个head 保存第k+1个节点
     * 将1~k个节点翻转　cur next nnext
     * 每次将next节点next指针指向cur 依次后移　最后返回ans首节点(翻转后)
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k <= 1) return head;
        ListNode ans = head;
        for (int i = 1; i < k && ans != null; i++) ans = ans.next;
        if (ans == null) return head;
        ListNode nh = ans.next, cur = head, next = cur.next;
        while (next != nh) {
            ListNode nnext = next.next;
            next.next = cur;
            cur = next;
            next = nnext;
        }
        head.next = reverseKGroup(nh, k);
        return ans;
    }

}
