package tree;

import tree.treenode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: tree
 * @Author: elvis
 * @CreateTime: 2020-06-28 21:53
 * @Description: 二叉树的右视图
 * 给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 *
 * 示例:
 *
 * 输入: [1,2,3,null,5,null,4]
 * 输出: [1, 3, 4]
 * 解释:
 *
 *    1            <---
 *  /   \
 * 2     3         <---
 *  \     \
 *   5     4       <---
 *
 */
public class Leetcode199 {

    /**
     * dfs深度搜索　先访问右孩子节点　通过list元素个数与深度对等关系添加每一层第一个元素
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        rightSideView(list, root, 0);
        return list;
    }

    private void rightSideView(List<Integer> list, TreeNode root, int depth) {
        if (root == null) return;
        if (depth == list.size()) {
            list.add(root.val);
        }
        rightSideView(list, root.right, depth + 1);
        rightSideView(list, root.left, depth + 1);
    }
}
