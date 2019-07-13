package linkedlist;

import linkedlist.listnode.ListNode;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: linkedlist
 * @Author: Elvis
 * @CreateTime: 2019-07-06 11:06
 * Description:
 */
public class Leetcode234 {

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null)  return true;
        ListNode fast = head, slow = head;
        while (fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        fast = slow.next;
        slow.next = null;
        slow = head;
        // reverse
        ListNode head2 = fast;
        ListNode next2;
        while (fast.next != null){
            next2 = fast.next;
            fast.next = next2.next;
            next2.next = head2;
            head2 = next2;
        }
        fast = head2;
        while (slow != null && fast != null){
            if (slow.val != fast.val){
                return false;
            }
            slow = slow.next;
            fast = fast.next;
        }
        return true;
    }
}
