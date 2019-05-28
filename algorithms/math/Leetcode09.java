package math;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: com.elvis.leetcode.math
 * @Author: Elvis
 * @CreateTime: 2019-03-06 21:11
 * Description: 回文数
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 *
 * 示例 1:
 *
 * 输入: 121
 * 输出: true
 * 示例 2:
 *
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3:
 *
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 * 进阶:
 *
 * 你能不将整数转为字符串来解决这个问题吗？
 */
public class Leetcode09 {

    /**
     * 107ms 93% solution
     * @param x
     * @return
     */
    public boolean isPalindrome(int x) {
        if (x < 0){
            return false;
        }
        List<Integer> list = new ArrayList<>();
        while (x != 0){
            list.add(x % 10);
            x /= 10;
        }
        for (int i = 0; i < list.size() / 2; i++) {
            if (list.get(i) != list.get(list.size() - 1 - i)){
                return false;
            }
        }
        return true;
    }

    /**
     *
     * @param x
     * @return
     */
    public boolean isPalindrome_String(int x) {
        if(x<0){
            return false;
        }
        String str=String.valueOf(x);
        char []s=str.toCharArray();
        if(s.length==1){
            return true;
        }

        int j=str.length()-1;
        for(int i=0;i<str.length();i++){
            if(s[i]==s[j]){
                j--;
            }else{
                return false;
            }
            if(j<i){
                return true;
            }

        }

        return false;
    }
}
