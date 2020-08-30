package dp;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: dp
 * @Author: elvis
 * @CreateTime: 2020-08-29 17:18
 * @Description: 扰乱字符串
 * 给定一个字符串 s1，我们可以把它递归地分割成两个非空子字符串，从而将其表示为二叉树。
 *
 * 下图是字符串 s1 = "great" 的一种可能的表示形式。
 *
 *     great
 *    /    \
 *   gr    eat
 *  / \    /  \
 * g   r  e   at
 *            / \
 *           a   t
 * 在扰乱这个字符串的过程中，我们可以挑选任何一个非叶节点，然后交换它的两个子节点。
 *
 * 例如，如果我们挑选非叶节点 "gr" ，交换它的两个子节点，将会产生扰乱字符串 "rgeat" 。
 *
 *     rgeat
 *    /    \
 *   rg    eat
 *  / \    /  \
 * r   g  e   at
 *            / \
 *           a   t
 * 我们将 "rgeat” 称作 "great" 的一个扰乱字符串。
 *
 * 同样地，如果我们继续交换节点 "eat" 和 "at" 的子节点，将会产生另一个新的扰乱字符串 "rgtae" 。
 *
 *     rgtae
 *    /    \
 *   rg    tae
 *  / \    /  \
 * r   g  ta  e
 *        / \
 *       t   a
 * 我们将 "rgtae” 称作 "great" 的一个扰乱字符串。
 *
 * 给出两个长度相等的字符串 s1 和 s2，判断 s2 是否是 s1 的扰乱字符串。
 *
 * 示例 1:
 *
 * 输入: s1 = "great", s2 = "rgeat"
 * 输出: true
 * 示例 2:
 *
 * 输入: s1 = "abcde", s2 = "caebd"
 * 输出: false
 *
 */
public class Leetcode87 {
    /**
     * dp动态规划　dp[i][j]表示最短编辑距离　从s1的前i个字符转化为s2的前j个字符所需要的最少次数
     * 初步分析
     * 给定两个字符串 T 和 S，假设 T 是由 S 变换而来
     *
     * 1. 如果 T 和 S 长度不一样，必定不能变来
     * 2. 如果长度一样，顶层字符串 S 能够划分为 S1 S2,同样字符串 T也能够划分为 T1 T2
     *
     * 情况一：没交换，S1 ==> T1, S2==>T2
     *
     * 情况二：交换了，S1 ==> T2, S2==>T1
     *
     * 子问题就是分别讨论两种情况, T1是否是S1得到，T2是否是S2得到
     *
     * 得到状态
     * dp[i][j][k][h] 表示 T[k..h]是否由 S[i..j]变来。由于变换必须长度是一样的，因此这边有个关系 j - i = h - k
     *
     * 可以把四维数组降成三维。dp[i][j][len] 表示从字符串 S 中 i 开始长度为 len 的字符串是否能变换为从字符串 T 中 j开始长度为 len的字符串
     *
     * 转移方程
     *               OR{1<=w<=k-1}　{dp[i][j][w]  &&  dp[i+w][j+w][k−w]}　　S1==>T1 S2==>T2
     * dp[i][j][k]==    或　｜｜
     * 　　　　　　　　OR{1<=w<=k-1}　{dp[i][j+k−w][w]  &&  dp[i+w][j][k−w]}  S1==>T2 S2==>T1
     *
     * 初始条件
     * 对于长度是 1的子串，只有相等才能变过去，相等为 true，不相等为 false
     *
     * 得到答案
     * 还记得我们的定义吗？dp[i][j][len]表示从字符串 S 中 i 开始长度为 len 的字符串是否能变换为从字符串 T中 j 开始长度为 len 的字符串，所以答案是 dp[0][0][n]
     * 时间复杂度 O(N^4) 空间复杂度O(N^3)
     */
    public boolean isScramble(String s1, String s2) {
        char[] chs1 = s1.toCharArray();
        char[] chs2 = s2.toCharArray();
        int n = s1.length();
        int m = s2.length();
        if (n != m) {
            return false;
        }
        boolean[][][] dp = new boolean[n][n][n + 1];
        // 初始化单个字符的情况
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j][1] = chs1[i] == chs2[j];
            }
        }

        // 枚举区间长度 2～n
        for (int len = 2; len <= n; len++) {
            // 枚举 S 中的起点位置
            for (int i = 0; i <= n - len; i++) {
                // 枚举 T 中的起点位置
                for (int j = 0; j <= n - len; j++) {
                    // 枚举划分位置
                    for (int k = 1; k <= len - 1; k++) {
                        // 第一种情况：S1 -> T1, S2 -> T2
                        if (dp[i][j][k] && dp[i + k][j + k][len - k]) {
                            dp[i][j][len] = true;
                            break;
                        }
                        // 第二种情况：S1 -> T2, S2 -> T1
                        // S1 起点 i，T2 起点 j + 前面那段长度 len-k ，S2 起点 i + 前面长度k
                        if (dp[i][j + len - k][k] && dp[i + k][j][len - k]) {
                            dp[i][j][len] = true;
                            break;
                        }
                    }
                }
            }
        }
        return dp[0][0][n];
    }
}
