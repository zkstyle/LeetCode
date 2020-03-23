package dfs;


import tree.treenode.TreeNode;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: com.elvis.leetcode.dfs
 * @Author: Elvis
 * @CreateTime: 2019-05-28 10:10
 * Description:
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 *
 * 本题中，一棵高度平衡二叉树定义为：
 *
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
 *
 * 示例 1:
 *
 * 给定二叉树 [3,9,20,null,null,15,7]
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回 true 。
 *
 * 示例 2:
 *
 * 给定二叉树 [1,2,2,3,3,null,null,4,4]
 *
 *        1
 *       / \
 *      2   2
 *     / \
 *    3   3
 *   / \
 *  4   4
 * 返回 false 。
 */
public class Leetcode110 {

    //计算左子树右子树高度差　不能大于1
    int maxHeightDiff = 0;

    /**
     * 定义traversTree　返回值为左右子树的高度差　大于1返回false
     */
    public boolean isBalanced(TreeNode root) {

        int height = traversTree(root);

        if (maxHeightDiff > 1) {
            return false;
        } else {
            return true;
        }
    }

    public int traversTree(TreeNode node) {
        //如果根节点为空　显然是符合平衡二叉树
        if (node == null) {
            return 1;
        }
        //分别获取左右子树高度
        int left = traversTree(node.left);
        int right = traversTree(node.right);
        //每次更新左右子树高度差　
        if (Math.abs(left - right) > maxHeightDiff) {
            maxHeightDiff = Math.abs(left - right);
        }
        //更新左右子树高度
        if (left > right) {
            return left + 1;
        } else {
            return right + 1;
        }
    }
}
