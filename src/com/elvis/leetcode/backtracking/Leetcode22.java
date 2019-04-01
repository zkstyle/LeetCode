package com.elvis.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: com.elvis.leetcode.backtracking
 * @Author: Elvis
 * @CreateTime: 2019-03-30 11:04
 * Description:
 */
public class Leetcode22 {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        generate(res, "", 0, 0, n);

        return res;
    }
    //count1统计“(”的个数，count2统计“)”的个数
    public void generate(List<String> res , String ans, int count1, int count2, int n){

        if(count1 > n || count2 > n) return;

        if(count1 == n && count2 == n)  res.add(ans);


        if(count1 >= count2){
            String ans1 = new String(ans);
            generate(res, ans+"(", count1+1, count2, n);
            generate(res, ans1+")", count1, count2+1, n);

        }
    }

    public static void main(String[] args) {
        new Leetcode22().generateParenthesis(3);
    }

}
