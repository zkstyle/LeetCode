package linkedlist;

import linkedlist.listnode.ListNode;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: com.elvis.leetcode.linkedlist
 * @Author: Elvis
 * @CreateTime: 2019-01-23 10:14
 * Description: 合并两个有序链表
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * 示例：
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 */
public class Leetcode21 {

    /**
     *法一　迭代法
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //声明一个新的节点　然后依次判断l1,l2节点大小　flag用于保存链表尾节点　firstflag用于保存头结点
        ListNode flag = new ListNode(0);
        ListNode firstflag = flag;
        while (l1 != null && l2 != null){
            if (l1.val < l2.val){
                flag.next = l1;
                l1 = l1.next;
            }else {
                flag.next = l2;
                l2 = l2.next;
            }
            //更新flag指向链表尾节点
            flag = flag.next;
        }
        //将较长链表的剩余部分节点链接到新的链表尾部
        flag.next = l1 != null ? l1 : l2;
        return firstflag.next;
    }
    /**
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoListsPlus(ListNode l1, ListNode l2) {
        // 递归出口　分治递归法
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        ListNode l0 = l1.val > l2.val ? l2 : l1;
        //分治思想，每次拿一个小的出来，每次的动作相同
        l0.next = l1.val > l2.val ? mergeTwoLists(l1, l2.next) : mergeTwoLists(l1.next, l2);
        return l0;
    }
}
