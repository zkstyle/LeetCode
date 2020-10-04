package tree;

import tree.binary_search_tree.Node;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: tree
 * @Author: elvis
 * @CreateTime: 2020-10-04 22:25
 * @Description: N叉树的后序遍历
 * 给定一个 N 叉树，返回其节点值的后序遍历。
 *
 * 例如，给定一个 3叉树 :
 *
 * 返回其后序遍历: [5,6,3,2,4,1].
 *
 *
 *
 * 说明: 递归法很简单，你可以使用迭代法完成此题吗?
 */
public class Leetcode590 {

    /**
     * 递归解法　很简单
     */
     List<Integer> ans=new ArrayList<>();
     public List<Integer> postorder(Node root) {
           if(root==null) return ans;

             List<Node> children=root.children;
             for(int i=0;i<children.size();i++){
                 postorder(children.get(i));
             }
             ans.add(root.val);
             return ans;
     }

    /**
     * 非递归解法　采用先访问根　再访问右子树　再访问左子树的方式　
     * 插入逆序达到后序遍历的效果
     */
    public List<Integer> postorder2(Node root) {
        LinkedList<Integer> ans = new LinkedList<>();
        Deque<Node> deque = new LinkedList<>();
        if (root == null)
            return ans;
        deque.add(root);
        while (!deque.isEmpty()) {
            Node node = deque.pollLast();
            ans.addFirst(node.val);
            deque.addAll(node.children);
        }
        return ans;
    }
}
