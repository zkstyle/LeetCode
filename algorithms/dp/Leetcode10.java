package dp;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: com.elvis.leetcode.dp
 * @Author: Elvis
 * @CreateTime: 2019-03-28 10:58
 * Description: 正则表达式匹配
 */
public class Leetcode10 {

    /**
     * 动态规划
     *
     * 题目中的匹配是一个「逐步匹配」的过程：我们每次从字符串 p 中取出一个字符或者「字符 + 星号」的组合，并在 s 中进行匹配。对于 p 中一个字符而言，它只能在 s 中匹配一个字符，
     *
     * 匹配的方法具有唯一性；而对于 p 中字符 + 星号的组合而言，它可以在 s 中匹配任意自然数个字符，并不具有唯一性。因此我们可以考虑使用动态规划，对匹配的方案进行枚举。
     *
     * 我们用 f[i][j]表示 s 的前 i 个字符与 p 中的前 j 个字符是否能够匹配。在进行状态转移时，我们考虑 p 的第 j 个字符的匹配情况：
     *
     * 如果 p 的第 j 个字符是一个小写字母，那么我们必须在 s 中匹配一个相同的小写字母，即
     *
     *             f[i−1][j−1],s[i] = p[j]
     * f[i][j]={
     *              false,s[i] != p[j]
     *
     * 也就是说，如果 s  的第 i 个字符与 p 的第 j  个字符不相同，那么无法进行匹配；否则我们可以匹配两个字符串的最后一个字符，完整的匹配结果取决于两个字符串前面的部分。
     *
     * 如果 p  的第 j  个字符是 *，那么就表示我们可以对 p 的第  j−1 个字符匹配任意自然数次。在匹配 0 次的情况下，我们有
     *
     *      f[i][j] = f[i][j - 2]
     *
     * 也就是我们「浪费」了一个字符 + 星号的组合，没有匹配任何 ss 中的字符。
     *
     * 在匹配 1,2,3, ⋯ 次的情况下，类似地我们有
     *
     * \begin{aligned} & f[i][j] = f[i - 1][j - 2], \quad && \text{if~} s[i] = p[j - 1] \\ & f[i][j] = f[i - 2][j - 2], \quad && \text{if~} s[i - 1] = s[i] = p[j - 1] \\ & f[i][j] = f[i - 3][j - 2], \quad && \text{if~} s[i - 2] = s[i - 1] = s[i] = p[j - 1] \\ & \cdots\cdots & \end{aligned}
     * ​
     *
     * f[i][j]=f[i−1][j−2],if s[i]=p[j−1]
     * f[i][j]=f[i−2][j−2],if s[i−1]=s[i]=p[j−1]
     * f[i][j]=f[i−3][j−2],if s[i−2]=s[i−1]=s[i]=p[j−1]
     * ⋯⋯
     *
     * 如果我们通过这种方法进行转移，那么我们就需要枚举这个组合到底匹配了 s  中的几个字符，会增导致时间复杂度增加，并且代码编写起来十分麻烦。我们不妨换个角度考虑这个问题：字母 + 星号的组合在匹配的过程中，本质上只会有两种情况：
     *
     * 匹配 ss 末尾的一个字符，将该字符扔掉，而该组合还可以继续进行匹配；
     *
     * 不匹配字符，将该组合扔掉，不再进行匹配。
     *
     * 如果按照这个角度进行思考，我们可以写出很精巧的状态转移方程：
     *              f[i−1][j] or f[i][j−2],s[i]=p[j−1]
     * f[i][j]={
     *              f[i][j−2],s[i] != p[j−1]
     *
     *
     * 在任意情况下，只要 p[j] 是 .，那么 p[j]  一定成功匹配 s 中的任意一个小写字母。
     *
     * 最终的状态转移方程如下：
     *                                  f[i−1][j−1],matches(s[i],p[j])
     *              if (p[j] = ‘*’)={
     *                                  false, otherwise
     *
     * f[i][j]={
     * ​                            f[i−1][j] or f[i][j−2],matches(s[i],p[j−1])
     *              otherwise={
     * ​                            f[i][j−2],otherwise
     *
     * 其中 matches(x,y) 判断两个字符是否匹配的辅助函数。只有当 y 是 . 或者 x  和 y 本身相同时，这两个字符才会匹配。
     *
     * 细节
     *
     * 动态规划的边界条件为 f[0][0]=true，即两个空字符串是可以匹配的。最终的答案即为 f[m][n]，其中 m和 n 分别是字符串 s 和 p 的长度。
     *
     * 由于大部分语言中，字符串的字符下标是从 0 开始的，因此在实现上面的状态转移方程时，需要注意状态中每一维下标与实际字符下标的对应关系。
     *
     * 在上面的状态转移方程中，如果字符串 p 中包含一个字符+星号的组合（例如 a*），那么在进行状态转移时，会先将 a 进行匹配（当 p[j] 为 a 时），
     *
     * 再将 a* 作为整体进行匹配（当 p[j] 为 * 时）。然而，在题目描述中，我们必须将 a* 看成一个整体，因此将 a 进行匹配是不符合题目要求的。
     * @param s 给定字符串
     * @param p　匹配通配符字符串
     * @return　boolean
     */
    public boolean isMatch(String s, String p) {
        int sLen = s.length(), pLen = p.length();
        boolean[][] dp = new boolean[sLen + 1][pLen + 1];
        dp[0][0] = true;
        for (int i = 0; i <= sLen; i++)
            for (int j = 1; j <= pLen; j++) {
                if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 2];
                    if (matches(s, p, i, j - 1))
                        dp[i][j] = dp[i][j] || dp[i - 1][j];
                } else {
                    if (matches(s, p, i, j))
                        dp[i][j] = dp[i - 1][j - 1];
                }
            }
        return dp[sLen][pLen];
    }

    private boolean matches(String s,String p,int i,int j){
        if(i==0) return false;
        if(p.charAt(j-1)=='.') return true;
        return p.charAt(j-1)==s.charAt(i-1);
    }

    //递归解法
    public boolean isMatch2(String s, String p) {
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