package tree;

import tree.treenode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: com.elvis.leetcode.tree
 * @Author: Elvis
 * @CreateTime: 2019-03-05 09:42
 * Description: 95. 不同的二叉搜索树 II
 * 给定一个整数 n，生成所有由 1 ... n 为节点所组成的二叉搜索树。
 *
 * 示例:
 *
 * 输入: 3
 * 输出:
 * [
 *   [1,null,3,2],
 *   [3,2,null,1],
 *   [3,1,null,null,2],
 *   [2,1,3],
 *   [1,null,2,null,3]
 * ]
 * 解释:
 * 以上的输出对应以下 5 种不同结构的二叉搜索树：
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 */
public class Leetcode95 {

    /**
     * 2ms 典范
     * @param n
     * @return
     */
    public List<TreeNode> generateTrees(int n) {
        if (n < 1) return new ArrayList<>();
        //利用一个辅助数组保存中间的值，避免重复求取，但是也会导致有些子树的结点是公共的
        List[][] dp = new List[n + 2][n + 2];
        return generateTrees(1, n,dp);
    }

    private List<TreeNode> generateTrees(int start, int end, List[][] dp) {
        List<TreeNode> res = new ArrayList<>();
        if (end < start) {
            res.add(null);
            return res;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> list1 = dp[start][i - 1];
            if (list1 == null) {
                //递归，并将结果保存下来
                list1 = generateTrees(start, i - 1, dp);
                dp[start][i - 1] = list1;
            }
            List<TreeNode> list2 = dp[i + 1][end];//当 i = n 时，就需要求 dp[n+1][end] 的值
            if (list2 == null) {
                //递归，并将结果保存下来
                list2 = generateTrees(i + 1, end, dp);
                dp[i + 1][end] = list2;
            }
            //（start,i-1）为左子树，遍历不同的左子树组合
            for (TreeNode left : list1) {

                //（i+1,end）为右子树，遍历不同的右子树组合
                for (TreeNode right : list2) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    res.add(root);
                }
            }
        }
        return res;
    }
}
