package linkedlist;

import algorithms.linkedlist.listnode.ListNode;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: com.elvis.leetcode.linkedlist
 * @Author: Elvis
 * @CreateTime: 2019-02-18 15:54
 * Description: 旋转链表
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 *
 * 示例 1:
 *
 * 输入: 1->2->3->4->5->NULL, k = 2
 * 输出: 4->5->1->2->3->NULL
 * 解释:
 * 向右旋转 1 步: 5->1->2->3->4->NULL
 * 向右旋转 2 步: 4->5->1->2->3->NULL
 * 示例 2:
 *
 * 输入: 0->1->2->NULL, k = 4
 * 输出: 2->0->1->NULL
 * 解释:
 * 向右旋转 1 步: 2->0->1->NULL
 * 向右旋转 2 步: 1->2->0->NULL
 * 向右旋转 3 步: 0->1->2->NULL
 * 向右旋转 4 步: 2->0->1->NULL
 */
public class Leetcode61 {
    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null) return null;
        int len = 0;
        ListNode headPoint = head;
        while (headPoint != null && headPoint.next != null){
            headPoint = headPoint.next;
            len++;
        }
        len++;
        int n = k % len;
        if (n == 0) return head;
        ListNode flag = head;
        for (int i = 0; i < (len - n - 1); i++) {
            flag = flag.next;
        }
        ListNode tmp;
        tmp = flag.next;
        flag.next = null;
        headPoint.next = head;
        head = tmp;
        return head;
    }

    /**
     * 9ms典范
     * @param head
     * @param k
     * @return
     */
    public static ListNode rotateRightPlus(ListNode head, int k) {
        if (head == null) return null;
        int len = 0;
        ListNode headPoint = head;
        while (headPoint != null){
            headPoint = headPoint.next;
            len++;
        }
        int n = k % len;
        if (n == 0) return head;
        int count = 0;
        headPoint = head;
        ListNode next = null;
        while (headPoint != null){
            if (count == (len - n -1)){
                next = headPoint.next;
                headPoint.next = null;
                break;
            }
            count++;
            headPoint = headPoint.next;
        }
        ListNode res = next;
        while (next.next != null){
            next = next.next;
        }
        next.next = head;
        return res;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);
        l1.next.next.next.next = new ListNode(5);
        rotateRight(l1, 2);
    }
}
