package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: com.elvis.leetcode.backtracking
 * @Author: Elvis
 * @CreateTime: 2019-05-06 12:34
 * Description:　N皇后问题
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 *
 * 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。
 *
 * 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 *
 * 示例:
 *
 * 输入: 4
 * 输出: [
 *  [".Q..",  // 解法 1
 *   "...Q",
 *   "Q...",
 *   "..Q."],
 *
 *  ["..Q.",  // 解法 2
 *   "Q...",
 *   "...Q",
 *   ".Q.."]
 * ]
 * 解释: 4 皇后问题存在两个不同的解法。
 */
public class Leetcode51 {

    /**
     * 经典回溯问题　N*N的棋盘放置皇后　要求每一行每一列每一斜对角线不能同时存在两个皇后
     * 解题思路：　首先介绍变量含义　row:遍历行号　当前放置皇后的行号　n: 棋盘大小 N*N
     *          cols:记录当前列是否放置过皇后 d1:记录对角线1(反斜对角线)是否放置了皇后 d2:记录对角线2(斜对角线)是否放置了皇后
     *          list 存放每一次的放置皇后值
     *          helper函数回溯放置皇后　递归出口是当前遍历行等于n(0~n-1放置了n个皇后)
     *          判断当前位置可以放置皇后　放置后将位置标志为true表示已经放置过
     *          回溯完　再标志为false 并移除上一次放置的值
     */
    private List<List<String>> res=new ArrayList<>();
        public List<List<String>> solveNQueens(int n) {
            //new boolean[2*n-1] 因为有2*n-1条斜对角线
            helper(0,n,new boolean[n],new boolean[2*n-1],new boolean[2*n-1],new ArrayList<>());
            return res;
        }
        private void helper(int row,int n,boolean[] cols,boolean[] d1,boolean[] d2,List<String> list){
            if(row==n){
                res.add(new ArrayList<>(list));
                return;
            }
            for(int col=0;col<n;col++){
                int d1Num=col+row;
                //斜对角线坐标差值相等 i1-i2=j1-j2 ==> i1-j1=i2-j2
                int d2Num=col-row+n-1;
                //判断是否冲突
                if(!cols[col]&&!d1[d1Num]&&!d2[d2Num]){
                    char[] temp=new char[n];
                    Arrays.fill(temp,'.');
                    temp[col]='Q';
                    cols[col]=true;
                    d1[d1Num]=true;
                    d2[d2Num]=true;
                    list.add(new String(temp));
                    helper(row+1,n,cols,d1,d2,list);
                    //回溯
                    cols[col]=false;
                    d1[d1Num]=false;
                    d2[d2Num]=false;
                    list.remove(list.size()-1);
                }
            }
        }


}
