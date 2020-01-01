package dfs;

import tree.treenode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: dfs
 * @Author: elvis
 * @CreateTime: 2019-09-04 09:41
 * @Description:
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 *
 * 输入:
 *
 * 1
 * / \
 * 2 3
 * \
 * 5
 *
 * 输出: [“1->2->5”, “1->3”]
 *
 * 解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
 */
public class Leetcode257 {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        if (root == null) return list;
        dfs(root, list, "");
        return list;
    }

    private void dfs(TreeNode root, List<String> list, String s){
        if (root.left == null && root.right == null){
            list.add(s + root.val);
            return;
        }

        s += root.val + "->";
        if (root.left != null)
            dfs(root.left, list, s);
        if (root.right != null)
            dfs(root.right, list, s);
    }
}
