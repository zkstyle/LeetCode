package tree;

import tree.treenode.TreeNode;

import java.util.HashMap;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: com.elvis.leetcode.tree
 * @Author: Elvis
 * @CreateTime: 2019-04-16 08:51
 * Description:105. 从前序与中序遍历序列构造二叉树
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 *
 * 前序遍历 preorder = [3,9,10,20,15,7]
 * 中序遍历 inorder = [10,9,3,15,20,7]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *  /   / \
 * 10 15   7
 */
public class Leetcode105 {

    int index = 0;

    /**
     * 递归构建二叉树　首先对与先序序列preorder[0]肯定是根节点
     * 然后拿根节点值取中序序列找到该节点　该节点左边的值是左子树的值　该节点右边的值为右子树的值
     * 然后分别继续递归构造二叉树
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (inorder.length == 0) {
            return null;
        }
        return build(preorder,inorder,0,inorder.length - 1);
    }

    /**
     *以根节点的值以及搜索下标搜索根节点坐标
     */
    public int serach(int[] inorder, int str, int end, int data) {
        for (int i = end; i >= str; i--) {
            if (inorder[i] == data) {
                return i;
            }
        }
        return -1;
    }

    private TreeNode build(int[] preorder, int[] inorder, int left, int right) {
        if (left > right || index >= preorder.length) {
            return null;
        }
        int j = serach(inorder, left, right, preorder[index]);
        TreeNode node = new TreeNode(preorder[index]);
        //buildleft
        index++;
        node.left = build(preorder, inorder, left, j - 1);
        //buildright
        node.right = build(preorder, inorder, j + 1, right);
        return node;
    }

    /**
     * 和上面揭发类似　不同的是将中序序列存入到hashmap字典中　
     * 然后每一次在字典中搜索中序序列对应的根节点下标
     */
    HashMap<Integer, Integer> dic = new HashMap<>();
    int[] po;
    public TreeNode buildTree2(int[] preorder, int[] inorder) {
        po = preorder;
        for(int i = 0; i < inorder.length; i++)
            dic.put(inorder[i], i);
        return recur(0, 0, inorder.length - 1);
    }
    TreeNode recur(int pre_root, int in_left, int in_right) {
        if(in_left > in_right) return null;
        TreeNode root = new TreeNode(po[pre_root]);
        int i = dic.get(po[pre_root]);
        root.left = recur(pre_root + 1, in_left, i - 1);
        root.right = recur(pre_root + i - in_left + 1, i + 1, in_right);
        return root;
    }

}
