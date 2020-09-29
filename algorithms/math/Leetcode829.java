package math;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: math
 * @Author: elvis
 * @CreateTime: 2020-09-28 23:03
 * @Description: 连续整数求和
 * 给定一个正整数 N，试求有多少组连续正整数满足所有数字之和为 N?
 *
 * 示例 1:
 *
 * 输入: 5
 * 输出: 2
 * 解释: 5 = 5 = 2 + 3，共有两组连续整数([5],[2,3])求和后为 5。
 * 示例 2:
 *
 * 输入: 9
 * 输出: 3
 * 解释: 9 = 9 = 4 + 5 = 2 + 3 + 4
 * 示例 3:
 *
 * 输入: 15
 * 输出: 4
 * 解释: 15 = 15 = 8 + 7 = 4 + 5 + 6 = 1 + 2 + 3 + 4 + 5
 * 说明: 1 <= N <= 10 ^ 9
 */
public class Leetcode829 {

    /**
     * 首先，最小的两个连续正整数相加1+2=3，大点的就是2+3=5=1+2+2，再大点3+4=7=2+3+2=1+2+(2+2)，
     * 从中可以看出如果存在两个连续正整数之和等于N，那么必然N=1+2+2k(k为正整数)，N-(1+2)可以整除2，即(N-(1+2))%2 == 0.
     * 往下推，n个连续正整数就是，(N-(1+2+...+n))%n == 0
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public int consecutiveNumbersSum(int N) {
        int result = 1;
        int sum = 1;
        //一个连续正整数即N本身，我们从2开始逐一判断，true则加1
        for (int i=2; (sum+=i)<=N; i++) {
            if ((N-sum)%i == 0) {
                result++;
            }
        }
        return result;
    }

    /**
     * N= x+1 + x+2 + ... + x+k = 1/2*k*(2x+k+1)
     * 在 2N=k(2x+k+1) 中，我们可以发现k<2x+k+1，因此有 k < sqrt{2N}
     *  ，即我们只需要枚举 1≤k≤(2N)^1/2 即可，此时通过枚举可以通过本题。
     *
     * 我们还可以继续挖掘一些性质。由于 k 和 2x+k+1 的奇偶性不同，此时将 2N 写成 2^p * M
     *
     * 其中 p 为 2N中因子 2 的个数，MM 为一个奇数。对于 MM 的一种拆分 M = a * b,a≤b，可以将 2N分成奇数 a 和偶数 2^p* b
     *
     * 或者奇数 b 和偶数 2^p * a
     *
     * 每一种分配方法中，将小的那个数给 k，大的那个数给 2x+k+1，就对应了一组解，那么一种拆分方法对应了两组解。
     *
     * 如果不限制 a≤b，那么可以看作一种拆分方法对应了一组解。有一种特殊情况是 a=b，此时这种拆分方法只对应了一组解，但仍然和之前的对应（一对一）相同。
     *
     * 因此，我们只需要求出 M 的拆分方法即可，其中 MM 为 NN 的最大奇因子。MM 的拆分方法等价于 MM 的因子个数。
     *
     */
     public int consecutiveNumbersSum2(int N) {
         while ((N & 1) == 0) N >>= 1;
         int ans = 1, d = 3;

         while (d * d <= N) {
             int e = 0;
             while (N % d == 0) {
                 N /= d;
                 e++;
             }
             ans *= e + 1;
             d += 2;
         }

         if (N > 1) ans <<= 1;
         return ans;
     }
}
