package tree;

import tree.treenode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: tree
 * @Author: elvis
 * @CreateTime: 2020-03-24 17:33
 * @Description: 路径总和II
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \    / \
 *         7    2  5   1
 * 返回:
 *
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 */
public class Leetcode113 {

    /**
     * 思路：若当前节点不是叶子节点　且右子树或左子树为空直接返回false 如上面二叉树左子树中节点4的右子树
     * 回溯遍历　首先将当前节点值添加到path集合　剩余值为rem -= root.val
     * 还是判断　若剩余值为0且当前节点为叶子节点　则将path添加到ans中
     * 回溯遍历左右子树　若左右子树都不存在　path移除节点值
     */
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrace(root, ans, new ArrayList<>(), sum);
        return ans;
    }

    void backtrace(TreeNode root, List<List<Integer>> ans, List<Integer> path, int rem) {
        if (root == null) return;
        path.add(root.val);
        rem -= root.val;
        if (rem == 0 && root.left == null && root.right == null)
            ans.add(new ArrayList<>(path));
        backtrace(root.left, ans, path, rem);
        backtrace(root.right, ans, path, rem);
        //回溯　移除当前节点值
        path.remove(path.size() - 1);
    }
}
