package dfs;

import tree.treenode.TreeNode;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: dfs
 * @Author: Elvis
 * @CreateTime: 2019-07-19 13:30
 * Description:
 */
public class Leetcode513 {


    /**
     * dfs 深度遍历　通过level访问当前节点层数　ans数组ans[0]存储节点层数　ans[1]存储节点值
     * 通过if (level > ans[0])判断保证只访问每一层的第一个节点(从左至右)因为是深度优先遍历
     * @param root
     * @return
     */
    public int findBottomLeftValue(TreeNode root) {
        int[] ans = new int[2];
        ans[0] = -1;
        dfs(root, ans, 0);
        return ans[1];
    }

    private void dfs(TreeNode root, int[] ans, int level){
        if (root == null) return;
        if (level > ans[0]){
            ans[0] = level;
            ans[1] = root.val;
        }

        dfs(root.left, ans, level +1);
        dfs(root.right, ans, level +1);

    }
}
