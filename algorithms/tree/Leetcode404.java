package tree;

import tree.treenode.TreeNode;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: tree
 * @Author: elvis
 * @CreateTime: 2020-06-23 21:18
 * @Description: 左叶子之和
 * 计算给定二叉树的所有左叶子之和。
 *
 * 示例：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
 */
public class Leetcode404 {

    int sum = 0;

    public int sumOfLeftLeaves(TreeNode root) {
        dfs(root);
        return sum;
    }

    /**
     * 是否是当前节点的左孩子
     * 当前节点的左孩子是不是叶子节点（叶子结点：没有左右孩子）
     */
    private void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);
        if (root.left != null && root.left.left == null && root.left.right == null)
            sum += root.left.val;
        dfs(root.right);
    }
}
