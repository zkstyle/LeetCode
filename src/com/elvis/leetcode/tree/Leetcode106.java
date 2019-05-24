package com.elvis.leetcode.tree;

import com.elvis.leetcode.tree.treenode.TreeNode;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: com.elvis.leetcode.tree
 * @Author: Elvis
 * @CreateTime: 2019-04-23 10:34
 * Description:
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 *
 * 中序遍历 inorder = [9,3,15,20,7]
 * 后序遍历 postorder = [9,15,7,20,3]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 */
public class Leetcode106 {
    int index = 0;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0){
            return null;
        }
        index = inorder.length - 1;
        return build(inorder, postorder, 0, inorder.length - 1);
    }

    private int search(int[] inorder, int start, int end, int data){
        for (int i = start; i <= end; i++){
            if (inorder[i] == data)
                return i;
        }
        return -1;
    }

    private TreeNode build(int[] inorder, int[] postorder, int left, int right){
        if (left > right || index < 0){
            return null;
        }
        int j = search(inorder, left, right, postorder[index]);
        TreeNode node = new TreeNode(postorder[index]);
        index--;
        node.right = build(inorder, postorder, j + 1, right);
        node.left = build(inorder, postorder, left, j - 1);
        return node;
    }


    class Leetcode106_best{
        public TreeNode buildTree(int[] inorder, int[] postorder) {
            if(postorder.length==0) return null;
            return builfTree(postorder,postorder.length-1,inorder,inorder.length-1,inorder.length);
        }

        private TreeNode builfTree(int[] postorder,int pe, int[] inorder,int ie,int len){

            if(len==1){
                return new TreeNode(postorder[pe]);
            }
            if(len<1){
                return null;
            }
            TreeNode node=new TreeNode(postorder[pe]);
            int midLen=0;
            for(int i=0;i<len;i++){
                if(inorder[ie-i]==postorder[pe]){
                    midLen=i;
                    break;
                }
            }
            node.right=builfTree(postorder,pe-1,inorder,ie,midLen);
            node.left=builfTree(postorder,pe-midLen-1,inorder,ie-1-midLen,len-midLen-1);
            return node;
        }


    }

    public static void main(String[] args) {
        int[] postorder = {9,15,7,20,3};
        int[] inorder = {9,3,15,20,7};
        new Leetcode106().buildTree(inorder, postorder);
    }
}
