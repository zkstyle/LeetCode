package tree;


import tree.treenode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: com.elvis.leetcode.tree
 * @Author: Elvis
 * @CreateTime: 2020-03-22 10:53
 * Description:给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
 *
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层次遍历结果：
 *
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 */
public class Leetcode102 {

    /**
     * 巧妙的通过level参数控制数据的添加，本质上是二叉树的先序遍历
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        addlevel(list, 0, root);
        return list;
    }

    public void addlevel(List<List<Integer>> list, int level, TreeNode node) {
        if (node == null) return;
        //level控制二叉树层数　list.size() - 1 < level自动扩展lists大小
        if (list.size() - 1 < level) list.add(new ArrayList<Integer>());
        list.get(level).add(node.val);

        addlevel(list, level + 1, node.left);
        addlevel(list, level + 1, node.right);
    }

    /**
     * 迭代遍历　利用队列Deque进行迭代遍历
     * 一次将每一层的节点放入队列
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        if (root == null) return lists;

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int level = 0;
        while ( !queue.isEmpty() ) {
            // start the current level
            lists.add(new ArrayList<Integer>());

            // number of elements in the current level
            int level_length = queue.size();
            for(int i = 0; i < level_length; ++i) {
                TreeNode node = queue.remove();

                // fulfill the current level
                lists.get(level).add(node.val);

                // add child nodes of the current level
                // in the queue for the next level
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            // go to next level
            level++;
        }
        return lists;
    }
}
