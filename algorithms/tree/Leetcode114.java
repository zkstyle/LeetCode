package tree;

import tree.treenode.TreeNode;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: tree
 * @Author: elvis
 * @CreateTime: 2020-06-08 17:15
 * @Description: 二叉树展开为链表
 * 给定一个二叉树，原地将它展开为一个单链表。
 *
 * 例如，给定二叉树
 *
 *     1
 *    / \
 *   2   5
 *  / \   \
 * 3   4   6
 * 将其展开为：
 *
 * 1
 *  \
 *   2
 *    \
 *     3
 *      \
 *       4
 *        \
 *         5
 *          \
 *           6
 */
public class Leetcode114 {

    /**
     * 分为三步：
     *
     * 首先将根节点的左子树变成链表
     * 其次将根节点的右子树变成链表
     * 最后将变成链表的右子树放在变成链表的左子树的最右边
     * 这就是一个递归的过程，递归的一个非常重要的点就是：不去管函数的内部细节是如何处理的，
     * 我们只看其函数作用以及输入与输出。对于函数flatten来说：
     *
     * 函数作用：将一个二叉树，原地将它展开为链表
     * 输入：树的根节点
     * 输出：无
     */
    public void flatten(TreeNode root) {
        if (root == null) return;
        flatten(root.left);
        flatten(root.right);
        TreeNode right = root.right;
        root.right = root.left;
        root.left = null;
        while (root.right != null) root = root.right;
        root.right = right;
    }
}
