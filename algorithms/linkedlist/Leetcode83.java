package linkedlist;

import linkedlist.listnode.ListNode;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: com.elvis.leetcode.linkedlist
 * @Author: Elvis
 * @CreateTime: 2019-02-19 21:05
 * Description:删除排序链表中的重读元素
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 *
 * 示例 1:
 *
 * 输入: 1->1->2
 * 输出: 1->2
 * 示例 2:
 *
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
 */
public class Leetcode83 {

    /**
     * 递归法　若当前节点值不等于下一个节点值　直接递归head.next = deleteDuplicates(head.next)
     * 否则　while循环删除节点　返回deleteDuplicates(head)　这里head已经删除了重复节点值
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null){
            return null;
        }
        if (head.next != null && head.val == head.next.val) {
            while (head.next != null && head.val == head.next.val) {
                head = head.next;
            }
            return deleteDuplicates(head);
        } else {
            head.next = deleteDuplicates(head.next);
        }
        return head;
    }

    /**
     * 迭代法　cur指向头结点　while循环判断cur.next不为空
     * 如果当前节点值等于下一个节点值　cur.next=cur.next.next
     * @param head
     * @return
     */
    public ListNode deleteDuplicates2(ListNode head) {
        if (head==null) return head;
        ListNode cur = head;
        while(cur.next!=null){
            if(cur.val==cur.next.val){
                cur.next=cur.next.next;
            }else{
                cur = cur.next;
            }
        }
        return head;
    }
}
