package algorithms.dp;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: com.elvis.leetcode.dp
 * @Author: Elvis
 * @CreateTime: 2019-03-11 08:31
 * Description: 最长回文子串
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 *
 * Example 1:
 *
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * Example 2:
 *
 * Input: "cbbd"
 * Output: "bb"
 */
public class Leetcode05 {

    public String longestPalindrome(String s) {
        int n = s.length();
        if (n == 0) return "";
        boolean[][] dp = new boolean[n][n];
        char[] ch = s.toCharArray();
        int maxlen = 0;
        int start = 0;
        for (int i = 0; i < n; i++){
            for (int j = 0; j <= i; j++){
                if (i - j < 2){
                    dp[j][i] = (ch[j] == ch[i]);
                } else{
                    dp[j][i] = (ch[j] == ch[i] && dp[j + 1][i - 1]);
                }

                if (dp[j][i] && maxlen < i - j + 1){
                    maxlen = i - j + 1;
                    start = j;
                }
            }
        }
        return s.substring(start, start + maxlen);
    }

    /**
     * best
     */
    public String longestPalindrome2(String s) {
        int n = s.length();

        int [] range = new int[2];
        for(int i = 0;i<n;i++){
            i = helper(s, range, i);
        }

        return s.substring(range[0],range[1]);
    }

    public int helper(String s,int [] range, int i){
        int lo = i; int hi=i;
        while (hi<s.length()-1 && s.charAt(hi) == s.charAt(hi+1)){
            hi++;
        }

        int ret = hi;
        while (lo>0 && hi<s.length()-1 && s.charAt(lo-1)== s.charAt(hi+1)){
            lo--;
            hi++;
        }

        if(hi-lo +1 > range[1]-range[0]){
            range[0] = lo;
            range[1] = hi+1;
        }

        return ret;
    }

}
