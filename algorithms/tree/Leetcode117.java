package tree;

import tree.treenode.Node;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: tree
 * @Author: elvis
 * @CreateTime: 2020-06-16 13:05
 * @Description: 填充每个节点的下一个右侧节点指针 II
 * 给定一个二叉树
 *
 * struct Node {
 *   int val;
 *   Node *left;
 *   Node *right;
 *   Node *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 *
 * 初始状态下，所有 next 指针都被设置为 NULL。
 *
 *  
 *
 * 进阶：
 *
 * 你只能使用常量级额外空间。
 * 使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。
 */
public class Leetcode117 {

    /**
     * 解题思路　队列思想　每次将每一层的节点装载到队列中
     * 然后顺序访问　并添加next指针连接　和116题不一样的是　root左右孩子节点的添加需要分别判断
     * @param root
     * @return
     */
    public Node connect(Node root) {
        Queue<Node> queue = new LinkedList<>();
        if (root == null) return root;
        queue.add(root);
        while (!queue.isEmpty()) {
            //取出每一层的第一个节点　作首节点连接设置　q.next=p
            Node q = queue.poll();
            int size = queue.size();
            if (q.left != null) queue.add(q.left);

            if (q.right != null) queue.add(q.right);

            //循环遍历该层的其他节点　并用size控制访问节点数
            while (size-- != 0) {
                Node p = queue.poll();
                if (p.left != null) queue.add(p.left);

                if (p.right != null) queue.add(p.right);
                q.next = p;
                q = p;
            }
        }
        return root;
    }


    //每一层都是单向链表
    public Node connect2(Node root) {
        //节点parent代表上一层
        Node parent = root;
        while (parent != null) {
            //哨兵节点，方便在遍历串联起当前层后，把parent移动为当前层链表头结点
            Node dummy = new Node();
            Node cur = dummy;
            //将上一层所有节点遍历完，才能串联起当前节点
            while (parent != null) {
                //如此便将parent的子节点都串起来了
                if (parent.left != null) {
                    cur.next = parent.left;
                    cur = cur.next;
                }
                if (parent.right != null) {
                    cur.next = parent.right;
                    cur = cur.next;
                }
                //可以进入下一个parent了
                parent = parent.next;
            }
            //这一层都串联完了，当前层头结点就是下一层的parent
            parent = dummy.next;
        }
        return root;
    }
}
