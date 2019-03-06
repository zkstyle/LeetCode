package com.elvis.leetcode.linkedlist;

import com.elvis.leetcode.linkedlist.listnode.ListNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
     * 效率低 260ms 55MB
     * 解题思想：
     * 从题目合并两个排序链表中得到灵感 两两合并最终得到结果
     * @param lists
     * @return
     */
    public static ListNode mergeKLists_01(ListNode[] lists) {
        ListNode head = new ListNode(0);
        ListNode point = head;
        for (ListNode node : lists){
            point.next = mergeKList(point.next, node);
        }
        return head.next;
    }

    public static ListNode mergeKList(ListNode l1, ListNode l2){
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val < l2.val){
            l1.next = mergeKList(l1.next , l2);
            return l1;
        }else {
            l2.next = mergeKList(l1, l2.next);
            return l2;
        }
    }

    /**
     * 解题思路： 将所有点的值放入一个数组中，然后对数组进行排序，再构建一个新的链表，将其返回
     * @param lists
     * @return
     */
    public static ListNode mergeKLists_02(ListNode[] lists) {
        ListNode result = new ListNode(0);
        ListNode point = result;
        List<Integer> list = new ArrayList<>();
        for (ListNode node : lists){
            while (node != null){
                list.add(node.val);
                node = node.next;
            }
        }
        Collections.sort(list);
        for (int x : list){
            point.next = new ListNode(x);
            point = point.next;
        }
        return result.next;
    }

    /**
     *
     * @param lists
     * @return
     */
    public static ListNode mergeKLists_03(ListNode[] lists) {
        if (lists == null || lists.length == 0){
            return null;
        }
        return MSort(lists, 0, lists.length - 1);
    }

    private static ListNode MSort(ListNode[] lists, int low, int high) {
        if (low < high){
            int mid = (low + high) / 2;
            ListNode leftlist = MSort(lists, low, mid);
            ListNode rightlist = MSort(lists, mid + 1, high);
            return mergeTwoLists(leftlist, rightlist);
        }
        return lists[low];
    }

    private static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode res = null;
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val < l2.val){
            res = l1;
            l1.next = mergeTwoLists(l1.next , l2);
        }else {
            res = l2;
            l2.next = mergeTwoLists(l1, l2.next);
        }
        return res;
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
        mergeKLists_01(lists);
    }
}
