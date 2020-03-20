package swordmeansoffer;

import linkedlist.listnode.ListNode;

import java.util.LinkedList;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: swordmeansoffer
 * @Author: elvis
 * @CreateTime: 2020-03-20 18:10
 * @Description: 反向输出链表‘
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 * 示例 1：
 *
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 *
 *
 * 限制：
 *
 * 0 <= 链表长度 <= 10000
 */
public class SMO06 {

    //首先先得到链表长度，然后再反向存入数组中 思路很简单
    public int[] reversePrint(ListNode head) {
        int len = 0;
        ListNode tmp = head;
        while(tmp!=null){
            tmp = tmp.next;
            len++;
        }
        int[] ans = new int[len];
        len--;
        while(head!=null){
            ans[len--]=head.val;
            head =head.next;
        }
        return ans;
    }

    /**
     * 法二　利用辅助结构栈进行逆置　将链表节点添加到栈中
     * 再将节点一一取出　这样就是逆置的链表顺序　再将节点值赋值给结果数组
     * @param head
     * @return
     */
    public int[] reversePrint2(ListNode head) {
        LinkedList<Integer> stack = new LinkedList<Integer>();
        while(head != null) {
            stack.addLast(head.val);
            head = head.next;
        }
        int[] res = new int[stack.size()];
        for(int i = 0; i < res.length; i++)
            res[i] = stack.removeLast();
        return res;
    }
}
