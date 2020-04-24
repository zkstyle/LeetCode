package linkedlist;

import linkedlist.listnode.ListNode;

import java.util.HashSet;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: linkedlist
 * @Author: Elvis
 * @CreateTime: 2019-07-02 11:31
 * Description:
 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 *
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 *
 * 说明：不允许修改给定的链表。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：tail connects to node index 1
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 */
public class Leetcode142 {

    /**我们遍历所有结点并在哈希表中存储每个结点的引用（或内存地址）。如果当前结点为空结点 null（即已检测到链表尾部的下一个结点），
     *  那么我们已经遍历完整个链表，并且该链表不是环形链表。如果当前结点的引用已经存在于哈希表中，那么返回 true（即该链表为环形链表）。
     */
    public ListNode detectCycle2(ListNode head) {
        HashSet<ListNode> set = new HashSet<>();
        while (head != null) {
            if (!set.contains(head)) {
                set.add(head);
            } else {
                return head;
            }
            head = head.next;
        }
        return null;
    }
    /**
     * 快慢指针
     * 首先　环形链表分为非环部分　假定长度为h  环形部分长度为c
     * 环中的节点从 0 到 C-1编号，其中 C是环的长度。非环节点从 -F到 -1编号，其中 F 是环以外节点的数目。 F次迭代以后，慢指针指向了 0
     * 且快指针指向某个节点 h，其中 F ≡h(modC) 。这是因为快指针在 F次迭代中遍历了 2F个节点，且恰好有 F个在环中。继续迭代 C-h 次，
     * 慢指针显然指向第 C-h号节点，而快指针也会指向相同的节点。原因在于，快指针从 hh号节点出发遍历了 2(C-h)个节点。
     * h+2(C−h)=2C−h
     *          =C−h(modC)
     * 因此，如果列表是有环的，快指针和慢指针最后会同时指向同一个节点，因此被称为 相遇 。
     *
     * 假设相遇节点到环形节点入口长度为a  其中a+b=h
     * 则 2(F+a) = F+a + F+b ==> F=b
     * 故将相遇节点与头结点同时移动　必然会相遇
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head, fast = head;
        //找到相遇节点
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }
        //判断有无环
        if (fast.next == null || fast.next.next == null) {
            return null;
        }

        ListNode first = head, meet = slow;
        //找到环形入口
        while (first != meet) {
            first = first.next;
            meet = meet.next;
        }

        return meet;
    }

}
