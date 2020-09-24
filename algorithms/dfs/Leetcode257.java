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

    /**
     * 最直观的方法是使用递归。在递归遍历二叉树时，需要考虑当前的节点和它的孩子节点。如果当前的节点不是叶子节点，则在当前的路径末尾添加该节点，
     * 并递归遍历该节点的每一个孩子节点。如果当前的节点是叶子节点，则在当前的路径末尾添加该节点后，就得到了一条从根节点到叶子节点的路径，
     * 可以把该路径加入到答案中。
     */
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        if (root == null) return list;
        dfs(root, list, "");
        return list;
    }

    private void dfs(TreeNode root, List<String> list, String s) {
        if (root.left == null && root.right == null) {
            list.add(s + root.val);
            return;
        }

        s += root.val + "->";
        if (root.left != null)
            dfs(root.left, list, s);
        if (root.right != null)
            dfs(root.right, list, s);
    }

    /**
     *最直观的方法是使用深度优先搜索。在深度优先搜索遍历二叉树时，我们需要考虑当前的节点以及它的孩子节点。
     *
     *     如果当前节点不是叶子节点，则在当前的路径末尾添加该节点，并继续递归遍历该节点的每一个孩子节点。
     *     如果当前节点是叶子节点，则在当前路径末尾添加该节点后我们就得到了一条从根节点到叶子节点的路径，将该路径加入到答案即可。
     */
    public void dfs(TreeNode root, String path, List<String> paths) {
        if (root != null) {
            StringBuffer pathSB = new StringBuffer(path);
            pathSB.append(Integer.toString(root.val));
            if (root.left == null && root.right == null) {  // 当前节点是叶子节点
                paths.add(pathSB.toString());  // 把路径加入到答案中
            } else {
                pathSB.append("->");  // 当前节点不是叶子节点，继续递归遍历
                dfs(root.left, pathSB.toString(), paths);
                dfs(root.right, pathSB.toString(), paths);
            }
        }
    }
}
