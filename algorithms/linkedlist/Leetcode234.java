package linkedlist;

import linkedlist.listnode.ListNode;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: linkedlist
 * @Author: Elvis
 * @CreateTime: 2019-07-06 11:06
 * Description:
 * 请判断一个链表是否为回文链表。
 *
 * 示例 1:
 *
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 *
 * 输入: 1->2->2->1
 * 输出: true
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 */
public class Leetcode234 {

    /**
     *基本思路　首先利用快慢指针找到链表中点　再对链表后半部分逆置
     * 然后再对前半部分和后半部分进行比较　判断回文
     */
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        ListNode fast = head, slow = head;
        //找到中点
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        fast = slow.next;
        slow.next = null;
        slow = head;
        // 翻转
        ListNode head2 = fast; //保存后半部分头结点
        ListNode next2; //next指针
        while (fast.next != null) {
            next2 = fast.next;
            fast.next = next2.next;
            next2.next = head2;
            head2 = next2;
        }
        fast = head2;
        //比对
        while (slow != null && fast != null) {
            if (slow.val != fast.val) {
                return false;
            }
            slow = slow.next;
            fast = fast.next;
        }
        return true;
    }
}
