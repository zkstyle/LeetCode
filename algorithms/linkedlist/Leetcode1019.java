package linkedlist;

import linkedlist.listnode.ListNode;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: linkedlist
 * @Author: elvis
 * @CreateTime: 2020-10-18 22:35
 * @Description: 链表中的下一个更大节点
 * 给出一个以头节点 head 作为第一个节点的链表。链表中的节点分别编号为：node_1, node_2, node_3, ... 。
 *
 * 每个节点都可能有下一个更大值（next larger value）：对于 node_i，如果其 next_larger(node_i) 是 node_j.val，那么就有 j > i 且  node_j.val > node_i.val，而 j 是可能的选项中最小的那个。如果不存在这样的 j，那么下一个更大值为 0 。
 *
 * 返回整数答案数组 answer，其中 answer[i] = next_larger(node_{i+1}) 。
 *
 * 注意：在下面的示例中，诸如 [2,1,5] 这样的输入（不是输出）是链表的序列化表示，其头节点的值为 2，第二个节点值为 1，第三个节点值为 5 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：[2,1,5]
 * 输出：[5,5,0]
 * 示例 2：
 *
 * 输入：[2,7,4,3,5]
 * 输出：[7,0,5,5,0]
 * 示例 3：
 *
 * 输入：[1,7,5,1,9,2,5,1]
 * 输出：[7,9,9,9,0,5,0,0]
 *
 *
 * 提示：
 *
 * 对于链表中的每个节点，1 <= node.val <= 10^9
 * 给定列表的长度在 [0, 10000] 范围内
 */
public class Leetcode1019 {

    /**
     * 首先获取链表长度　生命对应长度数组　将链表元素放入数组
     * 定义递减栈数组　逆序遍历　每次若当前元素小于栈顶元素　则当前结果集保存栈顶元素　并且将当前数组元素存入到栈顶
     */
    public static int[] nextLargerNodes(ListNode head) {
        int len = 0;
        ListNode pos = head;
        while (pos != null) {// 求出需要的数组的长度
            len++;
            pos = pos.next;
        }
        int ret[] = new int[len];
        pos = head;
        len = 0;
        while (pos != null) {// 把所有的元素添加到数组中
            ret[len++] = pos.val;
            pos = pos.next;
        }
        int stack[] = new int[ret.length];// 递减栈
        int pi = -1;
        for (int i = ret.length - 1; i >= 0; i--) {
            while (pi >= 0 && stack[pi] <= ret[i]) {
                pi--;
            }
            if (pi == -1) {// pi减到-1，表示当前节点为从后往前的当前的最大值，将该值添加到stack中，然后将当前结果设置为0
                stack[++pi] = ret[i];
                ret[i] = 0;
            } else {// 表示stack中有一个大于当前ret元素的值，但pi不是-1，将ret当前元素存入stack中，然后将stack中的值作为结果
                stack[++pi] = ret[i];
                ret[i] = stack[pi - 1];
            }
        }
        return ret;
    }
}
