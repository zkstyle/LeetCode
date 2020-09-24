package dp;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: dp
 * @Author: elvis
 * @CreateTime: 2020-09-24 23:17
 * @Description: 超级丑数
 * 编写一段程序来查找第 n 个超级丑数。
 *
 * 超级丑数是指其所有质因数都是长度为 k 的质数列表 primes 中的正整数。
 *
 * 示例:
 *
 * 输入: n = 12, primes = [2,7,13,19]
 * 输出: 32
 * 解释: 给定长度为 4 的质数列表 primes = [2,7,13,19]，前 12 个超级丑数序列为：[1,2,4,7,8,13,14,16,19,26,28,32] 。
 *
 * 说明:
 *
 *     1 是任何给定 primes 的超级丑数。
 *      给定 primes 中的数字以升序排列。
 *     0 < k ≤ 100, 0 < n ≤ 106, 0 < primes[i] < 1000 。
 *     第 n 个超级丑数确保在 32 位有符整数范围内。
 */
public class Leetcode313 {

    /**
     * 大家应该都做过丑数的题目。套路就是：为每个质因数建立一个指针，然后再这几个质因数运算的结果中，找出个最小的，然后匹配这个数是由哪个质因数算出来的，把它的指针值+1。
     *
     * 这道题的套路也差不多。只不过，因为我们这次是需要把计算出来的丑数再次和primes里面的质因数结合，算出新的丑数。算出来的丑数放在一个dp数组里。
     *
     * 所以，现在要做的事，怎么能知道每个质因数已经和dp中哪个位置的丑数进行了结合，下一个要结合的位置在哪。就需要建立一个index数组，用来存放每个质因数下一个将要结合的dp的下标，
     *
     * 这个下标是从0开始的，每结合一次就+1。extra：有个细节我会在注释里写一下，就是如果出现不同的质因数相乘，乘出来的结果是相同的，是重复的丑数，这个时候该怎么办呢：应该把这几个质因数下一个要结合的dp下标都加1。因为只把其中一个+1的话，下一次计算的丑数一定会是刚才这个重复的丑数，你的结果中就会有很多重复的数，所以，全都加1的话就会把这个重复数给过滤掉了。
     */
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] dp=new int[n];
        int[] point=new int[primes.length];

        dp[0]=1;
        for(int i=1;i<n;i++){
            int min=Integer.MAX_VALUE;
            for(int j=0;j<primes.length;j++){
                min=Math.min(dp[point[j]]*primes[j],min);
            }
            dp[i]=min;
            for(int k=0;k<point.length;k++){
                if(min==dp[point[k]]*primes[k]) point[k]++;
            }
        }
        return dp[n-1];
    }
}
