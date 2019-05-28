package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: com.elvis.leetcode.backtracking
 * @Author: Elvis
 * @CreateTime: 2019-05-06 12:34
 * Description:
 */
public class Leetcode51 {

        private List<List<String>> res=new ArrayList<>();
        public List<List<String>> solveNQueens(int n) {
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
                int d2Num=col-row+n-1;
                if(!cols[col]&&!d1[d1Num]&&!d2[d2Num]){
                    char[] temp=new char[n];
                    Arrays.fill(temp,'.');
                    temp[col]='Q';
                    cols[col]=true;
                    d1[d1Num]=true;
                    d2[d2Num]=true;
                    list.add(new String(temp));
                    helper(row+1,n,cols,d1,d2,list);
                    cols[col]=false;
                    d1[d1Num]=false;
                    d2[d2Num]=false;
                    list.remove(list.size()-1);
                }
            }
        }


}
