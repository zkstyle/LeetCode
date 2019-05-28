package algorithms.linkedlist;

import algorithms.linkedlist.listnode.ListNode;

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
     * 4ms典范
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroupPlus(ListNode head, int k) {
        ListNode prev = null;
        ListNode cur = head;
        ListNode next = null;
        ListNode check = head;
        int canProceed = 0;
        int count = 0;

        while(canProceed < k && check != null){
            check = check.next;
            canProceed++;
        }

        if(canProceed == k){
            while(count < k && cur != null){
                next = cur.next;
                cur.next = prev;
                prev = cur;
                cur = next;
                count++;
            }
            if(next != null){
                head.next = reverseKGroupPlus(next, k);
            }
            return prev;
        } else {
            return head;
        }
    }

    /**
     *
     * @param head
     * @param k
     * @return
     */
    public  ListNode reverseKGroup(ListNode head, int k) {
        if (head == null){
            return head;
        }
        if (k == 1){
            return head;
        }
        ListNode curr = head;
        ListNode hand = head;
        ListNode temp = null;
        ListNode pre = null;

        while (true){
            ListNode tempHand = curr;
            ListNode tempLast = curr;
            for (int i = 1; i < k; i++) {
                if (tempLast != null && tempLast.next != null){
                    tempLast = tempLast.next;
                    if (i == k - 1){
                        temp = tempLast.next;
                        tempLast.next = null;
                    }
                }else {
                    if (temp != null){
                        getLastNode(hand).next = tempHand;
                    }
                    return hand;
                }
            }
            ListNode newNode = reverseList(tempHand);
            if (pre != null){
                pre.next = newNode;
            }else {
                hand = newNode;
            }

            while (newNode.next != null){
                newNode = newNode.next;
                if (newNode == null){
                    newNode.next = temp;
                }else {
                    pre = newNode;
                }
            }
            curr = temp;
        }

    }

    public ListNode getLastNode(ListNode hand){
        if (hand == null){
            return hand;
        }
        ListNode temp = new ListNode(0);
        temp.next = hand;
        ListNode last = hand;
        while (temp.next != null){
            last = temp.next;
            temp = temp.next;
        }
        return last;
    }
    public ListNode reverseList(ListNode head){
        if (head == null){
            return null;
        }
        ListNode next = null;
        ListNode pre = null;
        ListNode curr = head;

        while (curr != null){
            next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }

        head = pre;
        return head;
    }


    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);
        l1.next.next.next.next = new ListNode(5);
        new Leetcode25().reverseKGroupPlus(l1, 4);
    }
}
