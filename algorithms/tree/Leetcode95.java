package tree;

import tree.treenode.TreeNode;

import java.util.LinkedList;
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

    public List<TreeNode> generateTrees(int n) {
        if(n==0) return new LinkedList<TreeNode>();
        return generateTrees(1,n);
    }

    /**
     * 我们定义 generateTrees(start, end) 函数表示当前值的集合为 [start,end]，返回序列 [start,end] 生成的所有可行的二叉搜索树。
     *
     * 按照上文的思路，我们考虑枚举 [start,end] 中的值 i为当前二叉搜索树的根，那么序列划分为了[start,i−1] 和 [i+1,end] 两部分。
     *
     * 我们递归调用这两部分，即 generateTrees(start, i - 1) 和 generateTrees(i + 1, end)，获得所有可行的左子树和可行的右子树，
     *
     * 那么最后一步我们只要从可行左子树集合中选一棵，再从可行右子树集合中选一棵拼接到根节点上，并将生成的二叉搜索树放入答案数组即可。
     *
     * 递归的入口即为 generateTrees(1, n)，出口为当 start>end 的时候，当前二叉搜索树为空，返回空节点即可。
     */
    public List<TreeNode> generateTrees(int start, int end) {
        LinkedList<TreeNode> allTree = new LinkedList<>();
        if (start > end) {
            allTree.add(null);
            return allTree;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> leftTrees = generateTrees(start, i - 1);
            List<TreeNode> rightTrees = generateTrees(i + 1, end);
            for (TreeNode left : leftTrees)
                for (TreeNode right : rightTrees) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    allTree.add(root);
                }
        }
        return allTree;
    }

}
