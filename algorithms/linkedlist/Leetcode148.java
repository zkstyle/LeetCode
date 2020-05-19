package linkedlist;

import linkedlist.listnode.ListNode;

import java.util.Arrays;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: linkedlist
 * @Author: elvis
 * @CreateTime: 2020-05-08 09:48
 * @Description: 排序链表
 */
public class Leetcode148 {


    /**
     * 算法思路　首先遍历一遍链表得链表长度 count
     * 声明同样长度的数组new int[count]
     * 遍历链表将值保存到数组中　对数组进行快速排序
     * 最后将数组值一一重新赋值给head链表
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode cur = head;
        int count = 0;
        //获取长度
        while (cur != null) {
            count++;
            cur = cur.next;
        }
        int[] arr = new int[count];
        int index = 0;
        cur = head;
        //值导入数组
        while (cur != null) {
            arr[index++] = cur.val;
            cur = cur.next;
        }
        //排序
        Arrays.sort(arr);
        //quicksort(arr,0,arr.length - 1);

        cur = head;
        index = 0;
        //重新赋值
        while (cur != null) {
            cur.val = arr[index++];
            cur = cur.next;
        }
        return head;
    }

    private void quicksort(int[] a, int left, int right) {
        if (left > right) return;
        int pivot = a[left];
        int i = left, j = right;
        while (i < j) {
            while (i < j && pivot <= a[j]) j--;
            while (i < j && pivot >= a[i]) i++;

            if (i < j) {
                int tmp = a[i];
                a[i] = a[j];
                a[j] = tmp;
            }
        }
        a[left] = a[i];
        a[i] = pivot;
        quicksort(a, left, i - 1);
        quicksort(a, i + 1, right);
    }
}
