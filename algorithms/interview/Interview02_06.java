package interview;

import linkedlist.listnode.ListNode;

import java.util.Stack;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: interview
 * @Author: elvis
 * @CreateTime: 2020-10-04 23:07
 * @Description: 面试题 05.01. 插入
 * 插入。给定两个32位的整数N与M，以及表示比特位置的i与j。编写一种方法，将M插入N，使得M从N的第j位开始，到第i位结束。假定从j位到i位足以容纳M，也即若M = 10 011，那么j和i之间至少可容纳5个位。例如，不可能出现j = 3和i = 2的情况，因为第3位和第2位之间放不下M。
 *
 * 示例1:
 *
 *  输入：N = 1024(10000000000), M = 19(10011), i = 2, j = 6
 *  输出：N = 1100(10001001100)
 * 示例2:
 *
 *  输入： N = 0, M = 31(11111), i = 0, j = 4
 *  输出：N = 31(11111)
 */
public class Interview02_06 {

    /**
     * 用栈存放节点　再比较栈中值是否与链表相等
     */
     public boolean isPalindrome(ListNode head) {
             Stack<ListNode> stack= new Stack<>();
             ListNode cur=head;
             while(cur!=null){
                 stack.push(cur);
                 cur=cur.next;
             }
             while(!stack.isEmpty()){
                 if(head.val!=stack.pop().val) return false;
                 head=head.next;
             }
             return true;
     }

    /**
     * 快慢指针找中点　后半段翻转　再比较
     */
    public boolean isPalindrome2(ListNode head) {
        ListNode fisrt = head;
        ListNode second = head;
        while(fisrt!=null &&fisrt.next!=null){
            second = second.next;
            fisrt =fisrt.next.next;
        }
        ListNode temp = reserve(second);
        while(temp!=null){
            if(head.val!= temp.val){
                return false;
            }
            temp= temp.next;
            head = head.next;
        }
        return true;
    }
    private ListNode reserve (ListNode head){
        if(head == null ||head.next == null){
            return head;
        }
        ListNode pre = reserve(head.next);
        head.next.next= head;
        head.next =null;
        return pre;
    }

}
