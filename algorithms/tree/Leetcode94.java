package tree;

import tree.treenode.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: com.elvis.leetcode.tree
 * @Author: Elvis
 * @CreateTime: 2019-02-26 19:33
 * Description: 二叉树的中序遍历
 * 给定一个二叉树，返回它的中序 遍历。
 *
 * 示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,3,2]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 */
public class Leetcode94 {

    /**
     * 递归调用
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        if (root == null) {
            return list;
        }
        if (root.left != null) {
            list.addAll(inorderTraversal(root.left));
        }
        list.add(root.val);
        if (root.right != null) {
            list.addAll(inorderTraversal(root.right));
        }
        return list;
    }

    /**
     * 迭代循环
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> list = new  ArrayList<>();
        if(root == null) {
            return list;
        }

        Stack<TreeNode> stack = new Stack<>();

        stack.add(root);

        TreeNode cur = null;

        HashSet<TreeNode> set = new HashSet<>();

        while(!stack.isEmpty()) {
            if(stack.peek().left != null && !set.contains(stack.peek().left)) {
                cur = stack.peek().left;
                stack.push(cur);
                set.add(cur);
            }else if(stack.peek().right != null) {
                cur = stack.pop();
                list.add(cur.val);
                stack.push(cur.right);
            }else {
                cur = stack.pop();
                list.add(cur.val);
            }
        }

        return list;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = null;
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        new Leetcode94().inorderTraversal2(root);
    }
}
