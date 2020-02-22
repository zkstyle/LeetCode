package linkedlist;

import linkedlist.listnode.ListNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: com.elvis.leetcode.linkedlist.listnode
 * @Author: Elvis
 * @CreateTime: 2019-01-24 10:53
 * Description:  合并k个排序链表
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 *
 * 示例:
 * 输入:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 */

public class Leetcode23 {
    /**
     * 效率低 260ms 55MB
     * 解题思想：
     * 方法一 : 从题目合并两个排序链表中得到灵感 两两合并最终得到结果
     * @param lists
     * @return
     */
    public static ListNode mergeKLists(ListNode[] lists) {
        ListNode head = new ListNode(0);
        ListNode point = head;
        //对于每一条链表进行遍历　然后两两进行合并　合并完再和另一条进行合并　合并复杂度o(k)
        for (ListNode node : lists){
            point.next = mergeTwoList(point.next, node);
        }
        return head.next;
    }

    public static ListNode mergeTwoList(ListNode l1, ListNode l2){
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val < l2.val){
            l1.next = mergeTwoList(l1.next , l2);
            return l1;
        }else {
            l2.next = mergeTwoList(l1, l2.next);
            return l2;
        }
    }

    /**
     * 解题思路： 将所有点的值放入一个数组中，然后对数组进行排序，再构建一个新的链表，将其返回
     * @param lists
     * @return
     */
    public static ListNode mergeKLists_02(ListNode[] lists) {
        ListNode result = new ListNode(0);
        ListNode point = result;
        List<Integer> list = new ArrayList<>();
        //将每一条链表的每一个节点值存储在list里面　再利用Collections进行排序
        for (ListNode node : lists){
            while (node != null){
                list.add(node.val);
                node = node.next;
            }
        }
        Collections.sort(list);
        //再以空间换时间 新建节点　赋值
        for (int x : list){
            point.next = new ListNode(x);
            point = point.next;
        }
        return result.next;
    }

    /**
     *执行用时 :3 ms在所有 Java 提交中击败了83.82%的用户
     * 三种方法最优方法　时间复杂度nlogk
     * 首先对于两个链表的排序需要O(N)复杂度　然后分治算法(二分法)将两两链表进行归并　需要logk次 k为链表的条数
     * @param lists
     * @return
     */
    public static ListNode mergeKLists_03(ListNode[] lists) {
        if (lists == null || lists.length == 0){
            return null;
        }
        //归并算法　将链表进行两两归并　
        return MSort(lists, 0, lists.length - 1);
    }

    private static ListNode MSort(ListNode[] lists, int low, int high) {
        /**
         * 利用二分法　将链表数组进行二分分割
         * 选取两条链表进行合并　合并用mergeTwoLists
         */
        if (low == high) return lists[low];
        int mid = (low + high) / 2;
        ListNode leftlist = MSort(lists, low, mid);
        ListNode rightlist = MSort(lists, mid + 1, high);
        return mergeTwoLists(leftlist, rightlist);
    }

    private static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode res = null;
        if (l1 == null || l2 == null) return l2 == null ? l1 : l2;
        if (l1.val < l2.val){
            res = l1;
            l1.next = mergeTwoLists(l1.next , l2);
        }else {
            res = l2;
            l2.next = mergeTwoLists(l1, l2.next);
        }
        return res;
    }
}
