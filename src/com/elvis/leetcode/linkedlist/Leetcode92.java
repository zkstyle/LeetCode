package com.elvis.leetcode.linkedlist;

import com.elvis.leetcode.linkedlist.listnode.ListNode;

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
     *
     * @param head
     * @param m
     * @param n
     * @return
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null || m == n){
            return head;
        }
        ListNode curr = head;
        ListNode prev = null;
        ListNode next = null;
        int k = n - m + 1;
        if (m == 1) {
            while (k-- != 0 && curr != null){
                if (curr.next == null){
                    next = null;
                }else {
                    next = curr.next;
                }
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            head.next = curr;
            head = prev;
        } else {
            head.next = reverseBetween(head.next, m - 1, n - 1);
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        ListNode l2 = new Leetcode92().reverseBetween(l1, 1, 2);
    }
}
