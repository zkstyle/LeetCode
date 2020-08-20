package tree;

import tree.treenode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: tree
 * @Author: Elvis
 * @CreateTime: 2019-08-15 11:56
 * Description:
 * 二叉搜索树中的两个节点被错误地交换。
 *
 * 请在不改变其结构的情况下，恢复这棵树。
 *
 * 示例 1:
 *
 * 输入: [1,3,null,null,2]
 *
 *    1
 *   /
 *  3
 *   \
 *    2
 *
 * 输出: [3,1,null,null,2]
 *
 *    3
 *   /
 *  1
 *   \
 *    2
 */
public class Leetcode99 {

    public TreeNode t1, t2, pre;
    //用两个变量t1,t2来记录需要交换的节点 pre记录上一次访问节点　保证中序遍历是递增的
    public void recoverTree(TreeNode root) {
        inorder(root);
        int tmp = t1.val;
        t1.val = t2.val;
        t2.val = tmp;
    }

    public void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        if (pre != null && pre.val > root.val) {
            if (t1 == null) t1 = pre;
            t2 = root;
        }
        pre = root;
        inorder(root.right);
    }

    /**
     * 找到二叉搜索树中序遍历得到值序列的不满足条件的位置。
     *
     * 如果有两个，我们记为 i 和 j（i<j 且 ai>ai+1 aj>aj+1)，那么对应被错误交换的节点即为 ai,aj+1
     *
     * 对应的节点，我们分别记为 x  和 y
     *
     * 交换 xx 和 yy 两个节点即可。
     *
     */
    public void recoverTree2(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        inorder(root,list);
        int[] swap=findTwoSwapNode(list);
        recover(root,2,swap[0],swap[1]);
    }

    public void inorder(TreeNode root,List<Integer> list){
        if(root==null) return;
        inorder(root.left,list);
        list.add(root.val);
        inorder(root.right,list);
    }
    //1 2 3 7 5 6 4 8
    public int[] findTwoSwapNode(List<Integer> list){
        int x=-1,y=-1;
        for(int i=1;i<list.size();i++){
            if(list.get(i)<list.get(i-1)){
                y=list.get(i);
                if(x==-1) x=list.get(i-1);
                else break;
            }
        }
        return new int[]{x,y};
    }

    public void recover(TreeNode root,int count,int x,int y){
        if(root!=null){
            if(root.val==x||root.val==y){
                root.val=root.val==x?y:x;
                if(--count==0) return;
            }
            recover(root.left,count,x,y);
            recover(root.right,count,x,y);
        }
    }

}
