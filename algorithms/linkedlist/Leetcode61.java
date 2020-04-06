package linkedlist;

import linkedlist.listnode.ListNode;

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

    /**
     * 思路：　首先若head为空或长度为1 直接返回head
     *        然后找寻head长度　因为k可能大于链表长度　所以必须求出长度 l
     *        若k%l==0 则链表旋转为原来的样子直接返回head
     *        若不为0 定义两个节点cur knode 先将cur右移k个位置
     *        再同时将cur knode同时移到尾节点　最后cur指向尾节点　knode指向倒数第k个节点前驱节点
     *        cur保存以待最后旋转逆置　最后将两段节点拼接一下
     * @param head
     * @param k 旋转次数
     * @return
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        ListNode len = head;
        int l = 0;
        while (len != null) {
            len = len.next;
            l++;
        }
        //先判断链表是否需要改变
        k = k % l;
        if (k == 0) return head;
        ListNode cur = head;
        ListNode knode = head;
        //寻到倒数第k节点前驱节点
        while (k > 0) {
            cur = cur.next;
            k--;
        }
        while (cur.next != null) {
            cur = cur.next;
            knode = knode.next;
        }

        ListNode next = knode.next;
        knode.next = null;
        cur.next = head;
        return next;
    }
}
