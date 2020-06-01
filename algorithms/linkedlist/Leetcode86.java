package linkedlist;

import linkedlist.listnode.ListNode;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: com.elvis.leetcode.linkedlist
 * @Author: Elvis
 * @CreateTime: 2019-02-22 10:11
 * Description: 分隔链表
 * 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
 *
 * 你应当保留两个分区中每个节点的初始相对位置。
 *
 * 示例:
 *
 * 输入: head = 1->4->3->2->5->2, x = 3
 * 输出: 1->2->2->4->3->5
 */
public class Leetcode86 {

    /**
     * 基本思路　首先定义两个带哑结点链表指针　分别保存小于x与大于等于x的节点　
     * 遍历链表进行分割 最后为避免形成环形链表　断链after链表尾指针
     */
    public ListNode partition(ListNode head, int x) {
        ListNode before_head = new ListNode(0);
        ListNode before = before_head;
        ListNode after_head = new ListNode(0);
        ListNode after = after_head;

        while (head != null) {

            // If the original list node is lesser than the given x,
            // assign it to the before list.
            if (head.val < x) {
                before.next = head;
                before = before.next;
            } else {
                // If the original list node is greater or equal to the given x,
                // assign it to the after list.
                after.next = head;
                after = after.next;
            }

            // 遍历
            head = head.next;
        }

        // head = 1->4->3->2->5->2, x = 3　after指针指向before最后一个节点2 需要断链
        after.next = null;

        // Once all the nodes are correctly assigned to the two lists,
        // combine them to form a single list which would be returned.
        before.next = after_head.next;

        return before_head.next;
    }


    /**
     * 法二　直接原地修改重组链表
     * 1. 先声明一个哑结点　然后声明一个one节点　one节点用来指向小于目标值的最后一个节点 并循环找到one所在位置
     * 2.　再声明two节点　指向one 并循环判断找到下一个one节点后一段大于x节点的最后一个节点
     * 3. 节点分为3段　[A(小于x的节点链表，最后一个节点引用是one)][B(大于x的一段节点链表，最后一个节点引用是two)][C(未遍历节点)]
     * 4. 目标是将C中第一个节点(小于x)插入到[A,B]之间　步骤如下
     * @param head　头结点
     * @param x　目标值
     * @return
     */
    public ListNode partition2(ListNode head, int x) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode one = dummy;
        while (one.next != null && one.next.val < x)
            one = one.next;

        ListNode two = one;
        while (two.next != null) {
            if (two.next.val < x) {
                ListNode temp = two.next;
                two.next = temp.next;
                temp.next = one.next;
                one.next = temp;
                one = temp;
            } else
                two = two.next;
        }
        return dummy.next;
    }
}
