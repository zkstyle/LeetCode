package tree;

import algorithms.tree.treenode.TreeNode;

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
            while(root!=null){
                stack.push(root);
                root = root.left;
            }
        }

        /** @return the next smallest number */
        public int next() {
            TreeNode node = stack.pop();
            if(node.right!=null){
                TreeNode temp = node.right;
                while(temp!=null){
                    stack.push(temp);
                    temp = temp.left;
                }
            }
            return node.val;
        }

        /** @return whether we have a next smallest number */
        public boolean hasNext() {
            if(stack.isEmpty())
                return false;
            return true;
        }
    }
}
