package com.elvis.leetcode.linkedlist;

import com.elvis.leetcode.linkedlist.listnode.ListNode;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: com.elvis.leetcode.linkedlist.listnode
 * @Author: Elvis
 * @CreateTime: 2019-01-24 10:53
 * Description:  合并k个排序链表
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 *
 * 示例:
 * 输入:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 */
public class Leetcode23 {
    /**
     *
     * @param lists
     * @return
     */
    public static ListNode mergeKLists(ListNode[] lists) {
        ListNode flag = new ListNode(0);
        ListNode firstflag = flag;
        while (lists != null){
            ListNode tmpNode = lists[0];
            for (ListNode listNode : lists){
                if (tmpNode.val > listNode.val){
                    tmpNode = listNode;
                }
            }
            flag.next = tmpNode;
            tmpNode = tmpNode.next;
            flag = flag.next;
        }
        return firstflag.next;
    }

    public static void main(String[] args) {
        ListNode[] lists = new ListNode[3];
        lists[0] = new ListNode(1);
        lists[0].next = new ListNode(4);
        lists[0].next.next = new ListNode(5);
        lists[1] = new ListNode(1);
        lists[1].next = new ListNode(3);
        lists[1].next.next = new ListNode(4);
        lists[2] = new ListNode(2);
        lists[2].next = new ListNode(6);
        mergeKLists(lists);
    }
}
