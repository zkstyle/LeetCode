package dfs;

import tree.treenode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: dfs
 * @Author: Elvis
 * @CreateTime: 2019-07-19 11:39
 * Description:
 * 您需要在二叉树的每一行中找到最大的值。
 *
 * 示例：
 *
 * 输入:
 *
 *           1
 *          / \
 *         3   2
 *        / \   \
 *       5   3   9
 *
 * 输出: [1, 3, 9]
 *
 */
public class Leetcode515 {


    /**
     * dfs深度遍历　先序遍历　用level控制层次　找出每一层次的最大值
     * @param root
     * @return
     */
    public List<Integer> largestValues(TreeNode root) {
        if (root == null)  return new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        dfs(root, list,  0);
        return list;
    }

    private void dfs(TreeNode root, List<Integer> list,  int level){
        if (root == null) return;
        if (list.size() == level ){
            list.add(root.val);
        }else{
            if (list.get(level) < root.val){
                list.set(level, root.val);
            }
        }
        dfs(root.left, list, level + 1);
        dfs(root.right, list, level + 1);

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(9);
        new Leetcode515().largestValues(root);
    }

}
