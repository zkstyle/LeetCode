package com.elvis.leetcode.linkedlist;

import com.elvis.leetcode.linkedlist.listnode.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: com.elvis.leetcode.linkedlist
 * @Author: Elvis
 * @CreateTime: 2019-01-22 09:16
 * Description: 两数相加
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
public class Leetcode02 {


    public static ListNode addTwoNumbersPlus(ListNode l1, ListNode l2){
        ListNode rs = null;
        ListNode last = null;
        ListNode cur = null;
        int val = 0;
        while (null != l1 || null != l2){
            if (null != l1){
                val += l1.val;
                l1 = l1.next;
            }
            if (null != l2){
                val += l2.val;
                l2 = l2.next;
            }
            cur = new ListNode(val % 10);
            val = val / 10;
            if (null == last){
                rs = cur;
            }else {
                last.next = cur;
            }
            last = cur;
        }
        if (val > 0){
            cur = new ListNode(val);
            last.next = cur;
        }
        return rs;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        ListNode l3 = new ListNode(4);
        l1.next = l3;

        ListNode l4 = new ListNode(3);
        l1.next.next = l4;

        ListNode l2 = new ListNode(5);
        ListNode l5 = new ListNode(6);
        l2.next = l5;

        ListNode l6 = new ListNode(4);
        l2.next.next = l6;

        addTwoNumbersPlus(l1,l2);

    }

}
