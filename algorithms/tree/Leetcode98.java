package tree;

import tree.treenode.TreeNode;

import java.util.Stack;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: com.elvis.leetcode.tree
 * @Author: Elvis
 * @CreateTime: 2019-03-05 09:42
 * Description:给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 *
 * 假设一个二叉搜索树具有如下特征：
 *
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * 示例 1:
 *
 * 输入:
 *     2
 *    / \
 *   1   3
 * 输出: true
 * 示例 2:
 *
 * 输入:
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 *      根节点的值为 5 ，但是其右子节点值为 4 。
 */

public class Leetcode98{

    /**
     * 本质上是中序遍历　每一次保存上一次遍历的节点值
     * 中序遍历递归调用　每一次都检验当前值是否大于上一次的last值　即root.val > root.left.val or root.val < root.right.val
     */
    double last = Double.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (isValidBST(root.left)) {
            if (last < root.val) {
                last = root.val;
                return isValidBST(root.right);
            }
        }
        return false;
    }

    /**
     * 思路　dfs深度遍历　min max分别保存左子树的最小值　以及右子树的最大值
     * 因为二叉搜索树需要保证左子树所有节点小于根节点（递归定义）　右子树同理
     * @param root
     * @return
     */
    public boolean isValidBST2(TreeNode root) {
        if (root == null) return true;
        return helper(root, null, null);
    }
    public  boolean helper(TreeNode root, Integer min, Integer max) {

        if (root == null) return true;
        if (min != null && root.val <= min) return false;
        if (max != null && root.val >= max) return false;

        return helper(root.left, min, root.val) && helper(root.right, root.val, max);
    }

    /**
     * 利用栈实现中序遍历　因为中序遍历得到的结果应当是顺序排列的
     * 若不满足顺序排列　说明不是二叉搜索树
     * @param root
     * @return
     */
    public boolean isValidBST3(TreeNode root) {
        Stack<TreeNode> stack = new Stack();
        double inorder = - Double.MAX_VALUE;

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            // If next element in inorder traversal
            // is smaller than the previous one
            // that's not BST.
            if (root.val <= inorder) return false;
            inorder = root.val;
            root = root.right;
        }
        return true;
    }
}
