package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: com.elvis.leetcode.backtracking
 * @Author: Elvis
 * @CreateTime: 2019-03-30 11:04
 * Description:
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 *
 * 例如，给出 n = 3，生成结果为：
 *
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 */
public class Leetcode22 {
    /**
     * 回溯法　遍历所有可能　
     */
    List<String> res = new ArrayList<String>();
    public List<String> generateParenthesis(int n) {
        generate("", n,n);
        return res;
    }
    //count1统计“(”的个数，count2统计“)”的个数
    public void generate(String ans, int count1, int count2){
        //左括号的数量不能少于右括号的数量　否则不符合条件
        if(count1 > count2) return;
        if(count1 == 0 && count2 == 0)  res.add(ans);
        //分别加上左括号与右括号　遍历所有可能　前提剩余括号数量大于0
        if (count1 > 0)generate(ans+"(", count1-1, count2);
        if (count2 > 0)generate(ans+")", count1, count2-1);
        return;
    }

}
