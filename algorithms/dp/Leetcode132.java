package dp;

import java.util.Arrays;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: dp
 * @Author: elvis
 * @CreateTime: 2020-08-25 10:31
 * @Description: 分割字符串II
 * 分割回文串 II
 * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
 *
 * 返回符合要求的最少分割次数。
 *
 * 示例:
 *
 * 输入: "aab"
 * 输出: 1
 * 解释: 进行一次分割就可将 s 分割成 ["aa","b"] 这样两个回文子串。
 */
public class Leetcode132 {

    /**
     * rt: 1051ms
     * 动态规划　dp[i]表示前i个字符符合要求的分割的最小次数
     * 故　min(dp[i])=min(dp[j]+1) j=0,1,2,i-1
     */
    public int minCut(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            dp[i] = i - 1;
            for (int j = 0; j < i; j++) {
                String str = s.substring(j, i);
                if (isPalindrome(str)) {
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
        }

        return dp[n];
    }

    private boolean isPalindrome(String str) {
        int l = 0, r = str.length() - 1;
        while (l < r) {
            if (str.charAt(l++) != str.charAt(r--)) return false;
        }
        return true;
    }


    /**
     * rt: 103ms
     * 优化的动态规划　法一中　双重for循环+isPalindrome检测　时间复杂度为o(n^3)
     * 可以将isPalindrome检测结果预存放在数组中　以供查询
     */
    public int minCut2(String s) {
        int n=s.length();
        int[]  dp=new int[n+1];
        boolean[][] palindrome=isPalindrome2(s);
        for (int i = 0; i <= n; i++) {
            dp[i]=i-1;
            for (int j = 0; j < i; j++) {
                if(palindrome[j][i-1]){
                    dp[i]=Math.min(dp[i],dp[j]+1);
                }
            }
        }

        return dp[n];
    }
    private boolean[][] isPalindrome2(String str) {
        int n = str.length();
        boolean[][] ret = new boolean[n][n];
        char[] c = str.toCharArray();
        //检测以i为中心的字符串是否为回文串
        for (int i = 0; i < n; i++) {
            int left = i, right = i;
            while (left >= 0 && right < n && c[left] == c[right]) {
                ret[left--][right++] = true;
            }
        }
        //检测以i,i+1为中心的字符串是否为回文串 如 abba
        for (int i = 0; i < n; i++) {
            int left = i, right = i + 1;
            while (left >= 0 && right < n && c[left] == c[right]) {
                ret[left--][right++] = true;
            }
        }
        return ret;
    }


    /**
     * rt:3ms
     *
     */
    public int minCut3(String s) {
        int[] dp = new int[s.length()];
        Arrays.fill(dp, s.length() - 1);

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            isPalindrome3(chars, i, i, dp);
            isPalindrome3(chars, i, i + 1, dp);
        }

        return dp[s.length() - 1];

    }

    private void isPalindrome3(char[] chars, int i, int j, int[] dp) {
        int len = chars.length;
        while (i >= 0 && j < len && chars[i] == chars[j]) {
            dp[j] = Math.min(dp[j], (i == 0 ? 0 : dp[i - 1] + 1));
            i--;
            j++;
        }
    }

    public static void main(String[] args) {
        new Leetcode132().minCut("aab");
    }
}
