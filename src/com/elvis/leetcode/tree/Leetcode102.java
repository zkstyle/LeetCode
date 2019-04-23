package com.elvis.leetcode.tree;

import com.elvis.leetcode.tree.treenode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: com.elvis.leetcode.tree
 * @Author: Elvis
 * @CreateTime: 2019-04-01 10:53
 * Description:
 */
public class Leetcode102 {

    /**
     * 巧妙的通过level参数控制数据的添加，本质上是二叉树的先序遍历
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>>list= new ArrayList<List<Integer>>();
        addlevel(list,0,root);
        return list;
    }
    public void addlevel(List<List<Integer>> list,int level,TreeNode node){
        if(node==null) return;
        if(list.size()-1<level) list.add(new ArrayList<Integer>());
        list.get(level).add(node.val);

        addlevel(list,level+1,node.left);
        addlevel(list,level+1,node.right);
    }
}
