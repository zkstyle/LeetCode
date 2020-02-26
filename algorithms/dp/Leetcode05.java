package dp;

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

    /**
     * 传统dp算法：　首先定义二维dp数组　转移方程　dp[i][j] = (dp[i-1][j+1] && ch[i] == ch[j-1]）
     * 这一步在做分类讨论（根据头尾字符是否相等），根据上面的分析得到：
     *
     * dp[i][j] = (s[i] == s[j]) and dp[i + 1][j - 1]
     * 分析这个状态转移方程：
     *
     * （1）“动态规划”事实上是在填一张二维表格，i 和 j 的关系是 i <= j ，因此，只需要填这张表的上半部分；
     *
     * （2）看到 dp[i + 1][j - 1] 就得考虑边界情况。
     *
     * 边界条件是：表达式 [j + 1, i - 1] 不构成区间，即长度小于等于 2，即 i - 1 - (j + 1) <= 2 ，整理得 i - j < 3。
     *
     * 这个结论很显然：当子串 s[i, j] 的长度大于或者等于 3 的时候，我其实只需要判断一下头尾两个字符是否相等就可以直接下结论了。
     *
     * 如果子串 s[i + 1, j - 1] 只有 1 或　2个字符，当然是回文；
     * 如果子串 s[i + 1, j - 1] 为空串，那么子串 s[i, j] 一定是回文子串。
     * 因此，在 s[i] == s[j] 成立和 j - i >= 3 的前提下，直接可以下结论，dp[i][j] = true，否则才执行状态转移。
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        int n = s.length();
        if (n == 0) return "";
        boolean[][] dp = new boolean[n][n];
        char[] ch = s.toCharArray();
        int maxlen = 1;
        int start = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                //如果i~j长度小于等于２ 即dp[i][i] = (ch[i]==ch[i]) 或dp[i][i+1] = (ch[i] == ch[i+1])
                if (i - j < 2) {
                    dp[j][i] = (ch[j] == ch[i]);
                } else {
                    //长度大于2 则符合上面转移方程
                    dp[j][i] = (ch[j] == ch[i] && dp[j + 1][i - 1]);
                }
                // 如果dp[j][i]为真　更新maxlen长度　并且更新最长长度起始位置start
                if (dp[j][i] && maxlen < i - j + 1) {
                    maxlen = i - j + 1;
                    start = j;
                }
            }
        }
        return s.substring(start, start + maxlen);
    }

    /**
     * 中心扩展算法: 以当前下标字符为中心　向两侧扩展　寻找最大回文串
     * 除了枚举字符串的左右边界以外，比较容易想到的是枚举可能出现的回文子串的“中心位置”，从“中心位置”尝试尽可能扩散出去，得到一个回文串。
     *
     * 因此中心扩散法的思路是：遍历每一个索引，以这个索引为中心，利用“回文串”中心对称的特点，往两边扩散，看最多能扩散多远。
     *
     * 枚举“中心位置”时间复杂度为 O(N)，从“中心位置”扩散得到“回文子串”的时间复杂度为 O(N)，因此时间复杂度可以降到 O(N^2)
     *
     * 在这里要注意一个细节：回文串在长度为奇数和偶数的时候，“回文中心”的形式是不一样的。
     *
     * 奇数回文串的“中心”是一个具体的字符，例如：回文串 "aba" 的中心是字符 "b"；
     * 偶数回文串的“中心”是位于中间的两个字符的“空隙”，例如：回文串串 "abba" 的中心是两个 "b" 中间的那个“空隙”。
     */
    public String longestPalindrome2(String s) {
        int n = s.length();
        int [] range = new int[2];
        //以每一个字符为中心 向两侧扩散
        for(int i = 0;i<n;i++){
            /**
             * 这里i赋值helper返回的hi值 这里分两种情况　因为如果没有abccba这种情形的　
             * i接收的返回值不变　若是　则返回的是相应的对称下标　如abbbba
             * 传过去的下标是1 返回的下标则是4 因为4个b　利用中心扩展算法后　都会归于一个中心　就是bbbb中间的那个空隙
             * 所以此举简化了不必要的遍历　优化了算法
             */
            i = helper(s, range, i);
        }
        return s.substring(range[0],range[1]);
    }

    public int helper(String s, int[] range, int i) {
        int lo = i;
        int hi = i;
        /**
         * 因为中心可能是在某一个字符　也可能在两个字符中间 所以若是类似于abccba这种
         *  可以将lo high分别指向两个相同的字符　使调整回文串中心
         */
        while (hi < s.length() - 1 && s.charAt(hi) == s.charAt(hi + 1)) {
            hi++;
        }
        int ret = hi;
        //以lo high为中心　向两侧扩展
        while (lo > 0 && hi < s.length() - 1 && s.charAt(lo - 1) == s.charAt(hi + 1)) {
            lo--;
            hi++;
        }
        //每次进行最大长度的比较　并更新
        if (hi - lo + 1 > range[1] - range[0]) {
            range[0] = lo;
            range[1] = hi + 1;
        }
        return ret;
    }

    /**
     * 马拉车算法 Manacher 算法本质上还是中心扩散法，只不过它使用了类似 KMP 算法的技巧，
     * 充分挖掘了已经进行回文判定的子串的特点，在遍历的过程中，记录了已经遍历过的子串的信息，也是典型的以空间换时间思想的体现。
     *  第 1 步：对原始字符串进行预处理（添加分隔符）
     * 首先在字符串的首尾、相邻的字符中插入分隔符，例如 "babad" 添加分隔符 "#" 以后得到 "#b#a#b#a#d#"。
     * 1、分隔符是一个字符，种类也只有一个，并且这个字符一定不能是原始字符串中出现过的字符；
     *
     * 2、加入了分隔符以后，使得“间隙”有了具体的位置，方便后续的讨论，并且新字符串中的任意一个回文子串在原始字符串中的一定能找到唯一的一个回文子串与之对应，因此对新字符串的回文子串的研究就能得到原始字符串的回文子串；
     *
     * 3、新字符串的回文子串的长度一定是奇数；
     *
     * 4、新字符串的回文子串一定以分隔符作为两边的边界，因此分隔符起到“哨兵”的作用。
     */

    public static String Manacher(String s) {
        if (s.length() < 2) {
            return s;
        }
        // 第一步：预处理，将原字符串转换为新字符串
        String t = "$";
        for (int i=0; i<s.length(); i++) {
            t += "#" + s.charAt(i);
        }
        // 尾部再加上字符@，变为奇数长度字符串
        t += "#@";
        // 第二步：计算数组p、起始索引、最长回文半径
        int n = t.length();
        // p数组
        int[] p = new int[n];
        int id = 0, mx = 0;
        // 最长回文子串的长度
        int maxLength = -1;
        // 最长回文子串的中心位置索引
        int index = 0;
        for (int j=1; j<n-1; j++) {
            // 计算半径数组
            p[j] = mx > j ? Math.min(p[2*id-j], mx-j) : 1;
            // 向左右两边延伸，扩展右边界
            while (t.charAt(j+p[j]) == t.charAt(j-p[j])) {
                p[j]++;
            }
            // 如果回文子串的右边界超过了mx，则需要更新mx和id的值
            if (mx < p[j] + j) {
                mx = p[j] + j;
                id = j;
            }
            // 如果回文子串的长度大于maxLength，则更新maxLength和index的值
            if (maxLength < p[j] - 1) {
                // 参看前文第三部分
                maxLength = p[j] - 1;
                index = j;
            }
        }
        // 第三步：截取字符串，输出结果
        // 起始索引的计算参看前文第四部分
        int start = (index-maxLength)/2;
        return s.substring(start, start + maxLength);
    }

}
