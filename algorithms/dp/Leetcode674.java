package dp;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: dp
 * @Author: Elvis
 * @CreateTime: 2019-06-27 10:46
 * Description:
 * 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
 *
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被计为是不同的子串。
 *
 * 示例 1:
 *
 * 输入: "abc"
 * 输出: 3
 * 解释: 三个回文子串: "a", "b", "c".
 * 示例 2:
 *
 * 输入: "aaa"
 * 输出: 6
 * 说明: 6个回文子串: "a", "a", "a", "aa", "aa", "aaa".
 *
  */
public class Leetcode674 {

    int res;

    /**
     *
     * @param s
     * @return
     */
    public int countSubstrings(String s) {
        for(int i=0;i<s.length();i++){
            calculate(s,i,i);
            calculate(s,i,i+1);
        }
        return res;
    }
    private void calculate(String s,int i,int j){
        for(int l=i, r=j;l>=0 && r<s.length();l--,r++){
            if(s.charAt(l)!=s.charAt(r)){
                break;
            }
            res++;
        }

    }
}
