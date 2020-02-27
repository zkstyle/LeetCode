package linkedlist;

import linkedlist.listnode.ListNode;

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
     * 递归版 因为每两个相邻节点逆置都是相同的操作　故可以使用递归求解
     * @param head
     * @return
     */
    public ListNode swapPairsPlus(ListNode head) {
        //相邻节点的逆置
        if (head == null || head.next == null) return head;
        //temp保存头结点　逆置
        ListNode temp = head;
        head = head.next;
        temp.next = head.next;
        head.next = temp;
        head.next.next = swapPairs(head.next.next);
        return head;
    }

    /**
     * /* 1-2-3-4
     *
     * flag 为 0（0-1-2-3-4） ;
     * tmp 为 1（1-2-3-4）
     *       节点     链        对应操作
     * 1, flag 0   0-2-3-4      flag.next=tmp.next;
     *    tmp 1   1-2-3-4
     * 2, flag 0   0-2-3-4      tmp.next=tmp.next.next;
     *    tmp 1   1-3-4
     * 3, flag 0   0-2-1-3-4    flag.next.next= tmp;
     *    tmp 1   1-3-4
     * 4, flag = tmp =节点1     完成
     * @param head
     * @return
     */
    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;
        // save the reverse tmp node (1,3)
        ListNode tmp;
        // save the head node's location
        ListNode flag_pre = new ListNode(0);
        flag_pre.next = head;
        ListNode flag = flag_pre;
        while (flag.next != null && flag.next.next != null) {
            //tmp指向相邻节点的第一个节点
            tmp = flag.next;
            //flag.next指向第二个节点
            flag.next = tmp.next;
            //tmp.next断链指向下一对节点的第一个节点
            tmp.next = tmp.next.next;
            //逆置节点 即flag.next指向tmp的前驱节点　0->2(flag) 1->3(tmp)->4 连接为0->2->1->3->4
            flag.next.next = tmp;
            flag = tmp;
        }
        return flag_pre.next;
    }
}
