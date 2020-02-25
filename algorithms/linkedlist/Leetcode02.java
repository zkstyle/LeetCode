package linkedlist;

import linkedlist.listnode.ListNode;

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

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode list = new ListNode(0);
        ListNode cur = list;
        int val = 0; //进位标志位
        while (l1 != null || l2 != null) {
            /**
             * 对l1 l2每一位相加　进行分析　
             * 因为可能发生进位 对获取的值val取摩10
             * 除以10则是产生的进位　两位个数相加　进位最多为1
             */
            if (l1 != null) {
                val += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                val += l2.val;
                l2 = l2.next;
            }
            cur.next = new ListNode(val % 10);
            val /= 10;
            cur = cur.next;
        }
        // 最后一次可能产生进位　若val大于0补上
        if (val > 0) cur.next = new ListNode(val);
        return list.next;
    }
}
