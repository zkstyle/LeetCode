package tree;

import tree.treenode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: tree
 * @Author: elvis
 * @CreateTime: 2020-09-29 23:28
 * @Description: 二叉树的层平均值
 * 给定一个非空二叉树, 返回一个由每层节点平均值组成的数组。
 *
 *
 *
 * 示例 1：
 *
 * 输入：
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 输出：[3, 14.5, 11]
 * 解释：
 * 第 0 层的平均值是 3 ,  第1层是 14.5 , 第2层是 11 。因此返回 [3, 14.5, 11] 。
 *
 *
 * 提示：
 *
 * 节点值的范围在32位有符号整数范围内。
 */
public class Leetcode637 {

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ans = new ArrayList<>();
        if (root == null) return ans;
        List<long[]> list = new ArrayList<>();
        dfs(root, 0, list);
        for (int i = 0; i < list.size(); i++) {
            long[] n = list.get(i);
            ans.add((double) n[0] / n[1]);
        }
        return ans;
    }

    /**
     * dfs 使用深度优先搜索计算二叉树的层平均值，list 用于存储二叉树的每一层的节点数，与存储二叉树的每一层的节点值之和。
     *
     * 搜索过程中需要记录当前节点所在层，如果访问到的节点在第 i 层，则将 p[1] 的值加 1，并将该节点的值加到 p[0]
     *
     * 遍历结束之后，第 i 层的平均值即为 p[1]/p[0]
     */
    private void dfs(TreeNode root, int level, List<long[]> list) {
        if (root == null) return;
        if (level == list.size()) {
            list.add(new long[2]);
        }
        long[] p = list.get(level);
        p[0] += root.val;
        p[1]++;
        dfs(root.left, level + 1, list);
        dfs(root.right, level + 1, list);
    }
}
