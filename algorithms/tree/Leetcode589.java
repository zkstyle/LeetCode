package tree;

import tree.binary_search_tree.Node;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: tree
 * @Author: elvis
 * @CreateTime: 2020-06-20 15:38
 * @Description: 多叉树的先序遍历
 * 给定一个 N 叉树，返回其节点值的前序遍历。
 *
 * 说明: 递归法很简单，你可以使用迭代法完成此题吗?
 *
 * class Node {
 *     public int val;
 *     public List<Node> children;
 *
 *     public Node() {}
 *
 *     public Node(int _val) {
 *         val = _val;
 *     }
 *
 *     public Node(int _val, List<Node> _children) {
 *         val = _val;
 *         children = _children;
 *     }
 * }
 */
public class Leetcode589 {

    /**
     * 递归算法　先添加根节点　再依次遍历孩子节点
     */
    List<Integer> ans = new LinkedList<>();

    public List<Integer> preorder(Node root) {
        if (root == null) return ans;
        ans.add(root.val);
        List<Node> children = root.children;
        for (int i = 0; i < children.size(); i++) {
            preorder(children.get(i));
        }
        return ans;
    }

    /**
     * 每次添加根节点值　通过stack倒序访问孩子节点实现先序遍历
     */
    public List<Integer> preorder2(Node root) {
        List<Integer> res = new LinkedList<>();
        if (root == null) return res;
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            res.add(cur.val);
            for (int i = cur.children.size() - 1; i >= 0; i--) {
                stack.push(cur.children.get(i));
            }
        }
        return res;
    }
}
