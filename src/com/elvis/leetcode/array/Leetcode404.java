package com.elvis.leetcode.array;

import java.util.Stack;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: com.elvis.leetcode.array
 * @Author: Elvis
 * @CreateTime: 2019-05-07 21:29
 * Description:
 * 给定一个以字符串表示的非负整数 num，移除这个数中的 k 位数字，使得剩下的数字最小。
 *
 * 注意:
 *
 * num 的长度小于 10002 且 ≥ k。
 * num 不会包含任何前导零。
 * 示例 1 :
 *
 * 输入: num = "1432219", k = 3
 * 输出: "1219"
 * 解释: 移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219。
 * 示例 2 :
 *
 * 输入: num = "10200", k = 1
 * 输出: "200"
 * 解释: 移掉首位的 1 剩下的数字为 200. 注意输出不能有任何前导零。
 * 示例 3 :
 *
 * 输入: num = "10", k = 2
 * 输出: "0"
 * 解释: 从原数字移除所有的数字，剩余为空就是0。
 */
public class Leetcode404 {
    public String removeKdigits(String s, int k) {
        if(k==0) return s;
        char cs[] = s.toCharArray();
        int l = cs.length;
        int p = 0;
        for(char c:cs){
            while(k>0&&p>0&&c<cs[p-1]){
                --p;
                --k;
            }
            if(p>0||c!='0') cs[p++] = c;
        }
        p -= k;
        return p<=0?"0":new String(cs,0,p);
    }

    class Solution {
        public String removeKdigits(String num, int k) {
            int newLength = num.length() - k;
            int length = num.length();
            char[] stack = new char[length];
            int top=0;
            char c;
            for(int i=0;i<length;i++){
                c = num.charAt(i);
                while(top>0&&stack[top-1]>c&&k>0){
                    top -= 1;
                    k -= 1;
                }
                stack[top++] = c;
            }
            top= 0;
            while(top<newLength && stack[top] == '0'){
                top++;
            }
            return top==newLength?"0":new String(stack,top,newLength-top);
        }
    }
}
