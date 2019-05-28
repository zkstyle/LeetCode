package dp;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: com.elvis.leetcode.dp
 * @Author: Elvis
 * @CreateTime: 2019-05-20 09:33
 * Description:
 * 给定一个非负整数 n，计算各位数字都不同的数字 x 的个数，其中 0 ≤ x < 10n 。
 *
 * 示例:
 *
 * 输入: 2
 * 输出: 91
 * 解释: 答案应为除去 11,22,33,44,55,66,77,88,99 外，在 [0,100) 区间内的所有数字。
 */
public class Leetcode357 {
    public int countNumbersWithUniqueDigits(int n) {
        //各位数字都不同。
        //来详解一下
        //dp[i]=dp[i-1]+(dp[i-1]-dp[i-2])*(10-(i-1));
        //加上dp[i-1]没什么可说的，加上之前的数字
        //dp[i-1]-dp[i-2]的意思是我们之前判断各位不重复的数字
        //我们要在这些数字后面填新的数字。当i=2时，说明之前选取的数字只有
        //1位，那么我们只要与这一位不重复即可，所以其实有9(10-1)种情况（比如1，后面可以跟0,2,3,4,5,6,7,8,9）。
        //当i=3时，说明之前选取的数字有2位，那么我们需要与2位不重复，所以剩余的
        //有8（10-2）种（比如12，后面可以跟0,3,4,5,6,7,8,9）
        if(n==0)
            return 1;
        int []dp=new int [n+1];
        dp[0]=1;
        dp[1]=10;
        for(int i=2;i<=n;i++)
        {
            dp[i]=dp[i-1]+(dp[i-1]-dp[i-2])*(10-(i-1));
        }
        return dp[n];
    }
}
