package tree;

import tree.treenode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: com.elvis.leetcode.tree
 * @Author: Elvis
 * @CreateTime: 2019-04-23 11:54
 * Description:
 * 从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 *
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其自底向上的层次遍历为：
 *
 * [
 *   [15,7],
 *   [9,20],
 *   [3]
 * ]
 */
public class Leetcode107 {

    /**
     * 还是和之前的层序遍历一样　只是每次存放的层数为 levels.size()-1 - level 倒序插入
     */
    List<List<Integer>> levels = new ArrayList<>();
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        helper(root,0);
        return levels;
    }
    private void helper(TreeNode root,int level){
        if(root == null ) return;
        if(level == levels.size())
            levels.add(0,new ArrayList <>());
        if(root.left != null)
            helper(root.left,level+1);
        if(root.right != null) helper(root.right,level+1);
        levels.get(levels.size()-1-level).add(root.val);
    }

    /**
     * 首先获取最大层数　也就是树的最大深度
     * 然后将当前root.val存放在最大level中
     * 第二层放在level-1层中　依次存放
     */
    List<List<Integer>> lists = new ArrayList<>();

    public List<List<Integer>> levelOrderBottom2(TreeNode root) {
        int h = getH(root);
        for (int i = 0; i < h; i++) lists.add(new ArrayList<>());
        level(root, h - 1);
        return lists;
    }

    private void level(TreeNode root, int level) {
        if (root == null) return;
        lists.get(level).add(root.val);
        level(root.left, level - 1);
        level(root.right, level - 1);
    }

    int getH(TreeNode root) {
        if (root == null) return 0;
        return Math.max(getH(root.left) + 1, getH(root.right) + 1);
    }
}
