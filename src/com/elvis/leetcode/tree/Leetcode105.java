package com.elvis.leetcode.tree;

import com.elvis.leetcode.tree.treenode.TreeNode;

import java.util.Arrays;

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
 *     /  \
 *    15   7
 */
public class Leetcode105 {

    int index = 0;

    /**
     * 1ms典范
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree2(int[] preorder, int[] inorder) {
        if (inorder.length == 0) {
            return null;
        }
        return build(preorder,inorder,0,inorder.length - 1);
    }

    public int serach(int [] inorder ,int str ,int end , int data){
        for ( int i = end ; i >= str ; i --){
            if ( inorder[i] == data){
                return i;
            }
        }
        return -1;
    }

    private TreeNode build(int[] preorder,int[] inorder,int left,int right) {
        if (left > right || index >= preorder.length){
            return null;
        }
        int j = serach(inorder,left,right,preorder[index]);
        TreeNode node = new TreeNode(preorder[index]);
        //buildleft
        index ++;
        node.left =build(preorder,inorder,left,j-1);
        //buildright
        node.right =build(preorder,inorder,j + 1,right);
        return node;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        if(preorder.length == 0){
            return null;
        }
        TreeNode root = null, left, right;
        if(preorder.length == 1){
            return new TreeNode(inorder[0]);
        }
        int rootVal = preorder[0];
        for(int i = 0; i < inorder.length; i++){

            if(inorder[i] == rootVal){
                root =  new TreeNode(inorder[i]);

                root.left = buildTree(Arrays.copyOfRange(preorder, 1,i+1), Arrays.copyOfRange(inorder, 0,i));
                root.right = buildTree(Arrays.copyOfRange(preorder, i+1, preorder.length),
                        Arrays.copyOfRange(inorder, i + 1,inorder.length));

            }

        }

        return root;
    }

    public static void main(String[] args) {
        int[] preorder = {3,9,10,20,15,7};
        int[] inorder = {10,9,3,15,20,7};
        new Leetcode105().buildTree2(preorder,inorder);
    }
}
