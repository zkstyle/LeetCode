package dfs;

import tree.treenode.TreeNode;

import java.util.Stack;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: dfs
 * @Author: Elvis
 * @CreateTime: 2019-05-30 12:51
 * Description:
 * 给定一个二叉树，原地将它展开为链表。
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
     * 递归版　后序遍历
     * @param root
     */
    public void flatten(TreeNode root) {
        if(root == null) return;
        flatten(root.left);
        flatten(root.right);
        TreeNode tmp = root.right;
        root.right = root.left;
        root.left = null;
        while(root.right != null) root = root.right;
        root.right = tmp;
    }

    /**
     * 非递归版本
     * @param root
     */
    public void flatten01(TreeNode root) {
        Stack<TreeNode> stack = new Stack();
        while (root != null || !stack.isEmpty()){
            while (root != null){
                stack.push(root);
                root = root.left;
            }

            if (!stack.isEmpty()){
                TreeNode node = stack.pop();
                TreeNode tmp = node.right;
                node.right = node.left;
                node.left = null;

                while(node.right != null) node = node.right;
                node.right = tmp;
                root = tmp;
            }
        }
    }
}
