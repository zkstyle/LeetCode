package tree;

import tree.treenode.TreeNode;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: com.elvis.leetcode.tree
 * @Author: Elvis
 * @CreateTime: 2019-04-16 08:27
 * Description:
 */
public class Leetcode104 {
    public int maxDepth(TreeNode root) {
        if (root == null){
            return 0;
        }else {
            return Math.max(maxDepth(root.left) + 1,maxDepth(root.right) + 1);
        }
    }
}
