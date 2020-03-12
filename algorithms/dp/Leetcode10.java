package dp;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: com.elvis.leetcode.dp
 * @Author: Elvis
 * @CreateTime: 2019-03-28 10:58
 * Description: 正则表达式匹配
 */
public class Leetcode10 {
    public boolean isMatch1(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        //初始化第0列，除了[0][0]全为false 毋庸置疑　因为空串p只能匹配空串　其他都无法匹配
        /*for (int i = 1; i <= m; i++) {
            dp[i][0] = false;
        }*/
        //初始化第0列　只有X*能匹配空串　如果有* 它的真值一定和p[0][j-2]的相同(略过它之前的符号)
        for (int j = 1; j <= n; j++) {
            dp[0][j] = j > 1 && '*' == p.charAt(j - 1) && dp[0][j - 2];
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n ; j++) {
                if (p.charAt(j - 1) == '*'){
                    dp[i][j] = dp[i][j - 2] || (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.') && dp[i - 1][j];
                }else {
                    //只有当前字符串完全匹配，才有资格传递dp[i-1][j-1]真值
                    dp[i][j] = (p.charAt(j - 1) == '.' || s.charAt(i - 1) == p.charAt(j - 1)) && dp[i -1][j - 1];
                }
            }
        }
        return dp[m][n];
    }

    public boolean isMatch(String s, String p) {
        return isMatchHelper(s, 0, p, 0, new byte[(s.length() + 1) * (p.length() + 1)]);
    }
    private boolean isMatchHelper(String s, int sIndex, String p, int pIndex, byte[] dp){
        if(dp[sIndex * p.length() + pIndex] != 0){
            return dp[sIndex * p.length() + pIndex] == 1;
        }
        if(pIndex == p.length()){
            return sIndex == s.length();
        }
        boolean match;
        boolean firstMatch = sIndex < s.length() && (p.charAt(pIndex) == '.' || p.charAt(pIndex) == s.charAt(sIndex));
        if(pIndex + 1 < p.length() && p.charAt(pIndex + 1) == '*'){
            match = isMatchHelper(s, sIndex, p, pIndex + 2, dp) || (firstMatch && isMatchHelper(s, sIndex + 1, p, pIndex, dp));
        }else{
            match = firstMatch && isMatchHelper(s, sIndex + 1, p, pIndex + 1, dp);
        }
        dp[sIndex * p.length() + pIndex] = (byte) (match ? 1 : 2);
        return match;
    }

    public static void main(String[] args) {
        String s = "mississippi";
        String p = "mis*is*p*.";
        new Leetcode10().isMatch(s, p);
    }
}