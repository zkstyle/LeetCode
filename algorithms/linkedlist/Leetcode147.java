package linkedlist;

import linkedlist.listnode.ListNode;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: linkedlist
 * @Author: elvis
 * @CreateTime: 2020-06-24 22:00
 * @Description: 链表插入排序
 */
public class Leetcode147 {


    public ListNode insertionSortList(ListNode head) {
        if(head==null||head.next==null) return head;
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode newHead=head.next.next;
        dummy.next.next=null;
        while(newHead!=null){
            ListNode cur=newHead;
            newHead=newHead.next;
            ListNode cmp=dummy;
            while(cmp.next!=null&&cur.val>cmp.next.val) cmp=cmp.next;
            cur.next=cmp.next;
            cmp.next=cur;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode node=new ListNode(4);
        node.next=new ListNode(2);
        node.next.next=new ListNode(1);
        node.next.next.next=new ListNode(3);
        new Leetcode147().insertionSortList(node);
    }
}
