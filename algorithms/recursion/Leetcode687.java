package recursion;

import tree.treenode.TreeNode;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: com.elvis.leetcode.recursion
 * @Author: Elvis
 * @CreateTime: 2019-04-24 10:50
 * Description:
 * 给定一个二叉树，找到最长的路径，这个路径中的每个节点具有相同值。 这条路径可以经过也可以不经过根节点。
 *
 * 注意：两个节点之间的路径长度由它们之间的边数表示。
 *
 * 示例 1:
 *
 * 输入:
 *
 *               5
 *              / \
 *             4   5
 *            / \   \
 *           1   1   5
 * 输出:
 *
 * 2
 * 示例 2:
 *
 * 输入:
 *
 *               1
 *              / \
 *             4   5
 *            / \   \
 *           4   4   5
 * 输出:
 *
 * 2
 * 注意: 给定的二叉树不超过10000个结点。 树的高度不超过1000。
 */
public class Leetcode687 {
    private  int maxVal=0;
    public int longestUnivaluePath(TreeNode root) {
        if(root == null)
            return 0;
        this.dfs(root,root.val);
        return  this.maxVal;
    }
    private int dfs(TreeNode node, int prevVal){
        if (node ==null){
            return  0;
        }
        int left = dfs(node.left, node.val);
        int right = dfs(node.right, node.val);
        maxVal = Math.max(maxVal, left + right);
        if (node.val == prevVal){
            return Math.max(left, right) + 1;
        }
        return  0;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(5);
        node.left = new TreeNode(5);
        node.left.left = new TreeNode(5);
        node.left.right = new TreeNode(5);
        node.right = new TreeNode(5);
        node.right.right = new TreeNode(5);
        new Leetcode687().longestUnivaluePath(node);
    }
}
