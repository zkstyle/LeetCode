package tree;

import tree.treenode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: tree
 * @Author: elvis
 * @CreateTime: 2020-08-02 08:16
 * @Description: 锯齿状遍历
 * 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 *
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回锯齿形层次遍历如下：
 *
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 */
public class Leetcode103 {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) return list;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;
        boolean flag = true;
        while (!queue.isEmpty()) {
            list.add(new ArrayList());
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                TreeNode node = queue.poll();
                if (flag) list.get(level).add(node.val);
                else list.get(level).add(0, node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            flag = !flag;
            level++;
        }
        return list;
    }

    public List<List<Integer>> zigzagLevelOrder2(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(root, 0, ans);
        return ans;
    }

    public void helper(TreeNode root, int height, List<List<Integer>> ans) {
        if (root == null)
            return;
        if (ans.size() == height) {
            List<Integer> list = new ArrayList<>();
            list.add(root.val);
            ans.add(list);
        } else {
            if (height % 2 == 0) {
                ans.get(height).add(root.val);
            } else {
                ans.get(height).add(0, root.val);
            }
        }
        helper(root.left, height + 1, ans);
        helper(root.right, height + 1, ans);
    }
}
