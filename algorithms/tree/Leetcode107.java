package algorithms.tree;

import algorithms.tree.treenode.TreeNode;

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

    List<List<Integer>> levels = new ArrayList<>();
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        helper(root,0);
        return levels;
    }
    private void helper(TreeNode root,int level){
        if(root == null ) return;
        if(level == levels.size())
            levels.add(0,new ArrayList <Integer>());
        if(root.left != null)
            helper(root.left,level+1);
        if(root.right != null) helper(root.right,level+1);
        levels.get(levels.size()-1-level).add(root.val);
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(9);
        treeNode.right = new TreeNode(20);
        treeNode.right.left = new TreeNode(15);
        treeNode.right.right = new TreeNode(7);
        new Leetcode107().levelOrderBottom(treeNode);
    }
}
