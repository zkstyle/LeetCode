package tree;

import tree.treenode.TreeNode;

import java.util.*;

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
     * 递归调用 定义list 首先root若为null 直接返回list
     *          若不为空　然后分别遍历左子树　添加root.val 再遍历右子树
     * @param root
     * @return
     */
    private List<Integer> list = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) return list;
        if (root.left != null) {
            inorderTraversal(root.left);
        }
        list.add(root.val);
        if (root.right != null) {
            inorderTraversal(root.right);
        }
        return list;

    }

    /**
     * 迭代循环　利用stack进行迭代　先放root根节点　再让左子树进栈　
     *          左子树先出栈　再将右子树入栈
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            res.add(curr.val);
            curr = curr.right;
        }

        return res;
    }
}
