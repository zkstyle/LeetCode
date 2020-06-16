package tree;

import tree.treenode.Node;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: tree
 * @Author: elvis
 * @CreateTime: 2020-06-16 13:19
 * @Description: 填充每个节点的下一个右侧节点指针
 * 给定一个完美二叉树，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
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
 * 提示：
 *
 * 你只能使用常量级额外空间。
 * 使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。
 */
public class Leetcode116 {

    /**
     * 解题思路　队列思想　每次将每一层的节点装载到队列中
     * 然后顺序访问　并添加next指针连接
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
            if (q.left != null) {
                queue.add(q.left);
                queue.add(q.right);
            }
            //循环遍历该层的其他节点　并用size控制访问节点数
            while (size-- != 0) {
                Node p = queue.poll();
                if (p.left != null) {
                    queue.add(p.left);
                    queue.add(p.right);
                }
                q.next = p;
                q = p;
            }
        }
        return root;
    }



    public Node connect2(Node root) {
        work(root);
        return root;
    }

    /**
     * 递归解法　work表示连接root left与right 以及right与root.next节点之间的联系
     */
    private void work(Node root) {
        if (root == null || root.left == null) return;
        root.left.next = root.right;
        if (root.next != null) {
            root.right.next = root.next.left;
        }
        work(root.left);
        work(root.right);
        return;
    }
}
