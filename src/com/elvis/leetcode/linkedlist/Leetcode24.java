package com.elvis.leetcode.linkedlist;

import com.elvis.leetcode.linkedlist.listnode.ListNode;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: com.elvis.leetcode.linkedlist
 * @Author: Elvis
 * @CreateTime: 2019-02-16 09:31
 * Description:
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * 示例:
 *
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 */
public class Leetcode24 {

    /**
     * 递归版
     * @param head
     * @return
     */
    public ListNode swapPairsPlus(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode temp = head;
        head = head.next;
        temp.next = head.next;
        head.next = temp;

        head.next.next = swapPairs(head.next.next);
        return head;
    }


    public static ListNode swapPairs(ListNode head) {
        if(head == null||head.next == null)
            return head;
        // save the reverse tmp node (1,3)
        ListNode tmp;
        // save the head node's location
        ListNode flag_pre = new ListNode(0);
        flag_pre.next = head;
        ListNode flag = flag_pre;
        while(flag.next != null && flag.next.next != null) {
            tmp = flag.next;
            flag.next = tmp.next;
            tmp.next = tmp.next.next;
            flag.next.next = tmp;
            flag = tmp;
        }
        return flag_pre.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);
        swapPairs(l1);
    }
}
