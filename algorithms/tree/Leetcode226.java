package tree;

import tree.treenode.TreeNode;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: tree
 * @Author: elvis
 * @CreateTime: 2020-10-04 23:01
 * @Description: 翻转二叉树
 * 翻转一棵二叉树。
 *
 * 示例：
 *
 * 输入：
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * 输出：
 *
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 */
public class Leetcode226 {

    /**
     * 先翻转右子树　再翻转左子树　分别保存返回值
     * 并修改root左右指针
     */
    public TreeNode invertTree(TreeNode root) {
        if(root==null) return null;
        TreeNode left=invertTree(root.right);
        TreeNode right=invertTree(root.left);
        root.left=left;
        root.right=right;
        return root;
    }
}
