package backtracking;

import algorithms.tree.treenode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: com.elvis.leetcode.backtracking
 * @Author: Elvis
 * @CreateTime: 2019-05-23 11:24
 * Description:
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
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

    List<List<Integer>> lists = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) return lists;
        findPathSum(root, sum, new ArrayList<>());
        return lists;
    }

    private void findPathSum(TreeNode root, int sum, List<Integer> tmp){
        if (root == null)
            return;
        if (root.left == null && root.right == null && sum == root.val){
            tmp.add(root.val);
            lists.add(new ArrayList<>(tmp));
            tmp.remove(tmp.size() - 1);
            return;
        }
        tmp.add(root.val);
        findPathSum(root.left, sum - root.val, tmp);
        findPathSum(root.right, sum - root.val, tmp);
        tmp.remove(tmp.size() - 1);
    }
}
