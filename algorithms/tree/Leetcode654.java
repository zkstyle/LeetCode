package tree;

import tree.treenode.TreeNode;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: tree
 * @Author: elvis
 * @CreateTime: 2020-10-03 16:06
 * @Description: z
 */
public class Leetcode654 {

    /**
     * 首先调用 construct(nums, 0, n)，其中 nn 是数组 nums 的长度。
     *
     * 在索引范围 (l:r-1)内找到最大值的索引，将 nums[max_i] 作为根节点。
     *
     * 调用 construct(nums, l, max_i) 创建根节点的左孩子。递归执行此操作，创建根节点的整个左子树。
     *
     * 类似的，调用 construct(nums, max_i + 1, r) 创建根节点的右子树。
     *
     * 方法 construct(nums, 0, n) 返回最大二叉树的根节点。
     */
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return construct(nums, 0, nums.length);
    }
    public TreeNode construct(int[] nums, int l, int r) {
        if (l == r)
            return null;
        int max_i = max(nums, l, r);
        TreeNode root = new TreeNode(nums[max_i]);
        root.left = construct(nums, l, max_i);
        root.right = construct(nums, max_i + 1, r);
        return root;
    }
    public int max(int[] nums, int l, int r) {
        int max_i = l;
        for (int i = l; i < r; i++) {
            if (nums[max_i] < nums[i])
                max_i = i;
        }
        return max_i;
    }
}
