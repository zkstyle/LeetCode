package math;

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
     * 假设给定1234321 依次获取值　res为累加值　x为剩余值　当x<=res时　退出循环
     * res == x || res/10 == x成立则为真　res/10==x是因为　res=1234 x=123
     */
    public boolean isPalindrome(int x) {
        if (x < 0 || (x != 0 && x % 10 == 0)) return false;
        int res = 0;
        while (x > res) {
            res = res * 10 + x % 10;
            x = x / 10;
        }
        return res == x || res/10 == x;
    }

    /**
     * 将x转为字符串　再用两个指针指向首位　遍历判断
     */
    public boolean isPalindrome2(int x) {
        if(x<0) return false;
        String s=String.valueOf(x);
        for(int i =0,j=s.length()-1;i<j;){
            while(s.charAt(i)!=s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}
