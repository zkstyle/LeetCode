package contest;


import tree.treenode.TreeNode;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: com.elvis.leetcode.contest
 * @Author: Elvis
 * @CreateTime: 2019-03-10 13:30
 * Description:
 * 返回与给定先序遍历 preorder 相匹配的二叉搜索树（binary search tree）的根结点。
 *
 * (回想一下，二叉搜索树是二叉树的一种，其每个节点都满足以下规则，
 * 对于 node.left 的任何后代，值总 < node.val，而 node.right 的任何后代，值总 > node.val。
 * 此外，先序遍历首先显示节点的值，然后遍历 node.left，接着遍历 node.right。）
 * 输入：[8,5,1,7,10,12]
 * 输出：[8,5,10,1,7,null,12]
 * 提示：
 *
 * 1 <= preorder.length <= 100
 * 先序 preorder 中的值是不同的。
 */
public class Leetcode1008 {

    /**
     * binary search tree
     * @param preorder
     * @return
     */
    public TreeNode bstFromPreorder(int[] preorder) {

        return new TreeNode(0);
    }

}
