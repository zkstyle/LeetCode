package tree;

import tree.treenode.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: com.elvis.leetcode.tree
 * @Author: Elvis
 * @CreateTime: 2019-04-10 10:06
 * Description:
 */
public class Leetcode173 {

    class BSTIterator {
        Stack<TreeNode> stack = new Stack<>();

        public BSTIterator(TreeNode root) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
        }

        /**
         * @return the next smallest number
         */
        public int next() {
            TreeNode node = stack.pop();
            if (node.right != null) {
                TreeNode temp = node.right;
                while (temp != null) {
                    stack.push(temp);
                    temp = temp.left;
                }
            }
            return node.val;
        }

        /**
         * @return whether we have a next smallest number
         */
        public boolean hasNext() {
            if (stack.isEmpty())
                return false;
            return true;
        }
    }


    /**
     * 第二种方法采用中序遍历将数据存入list 然后以数组形式访问list中元素
     * 设置全局index索引　依次从小到大访问元素　元素在list中也是升序排列的
     */
    class BSTIterator2 {

        List<Integer> list;
        int index;

        public BSTIterator2(TreeNode root) {
            list = new ArrayList<>();
            index = 0;
            inOrder(root);
        }

        /**
         * @return the next smallest number
         */
        public int next() {
            return list.get(index++);
        }

        /**
         * @return whether we have a next smallest number
         */
        public boolean hasNext() {
            return (index < list.size());
        }

        private void inOrder(TreeNode root) {
            if (root == null) {
                return;
            } else {
                inOrder(root.left);
                list.add(root.val);
                inOrder(root.right);
            }
        }

    }
}
