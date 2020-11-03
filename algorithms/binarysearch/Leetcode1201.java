package binarysearch;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: binarysearch
 * @Author: elvis
 * @CreateTime: 2020-11-03 12:59
 * @Description: x
 */
public class Leetcode1201 {

    static long lcmAB;
    static long lcmAC;
    static long lcmBC;
    static long lcmABC;

    /**
     * 基础思路
     *
     * 首先，为什么第一时间能想到二分法？
     *
     * 让我们观察题目，可以看到，最终状态(即n)的范围非常大。试图自底向上递推或是按照通常的自顶向下回溯显然会超时(比如动态规划、DFS等方法)
     *
     * 面对这么大的状态空间，二分法的时间复杂度是logN,因此能够大大压缩需要遍历的状态数目
     *
     * 思路剖析
     *
     * 既然已经确定了二分法作为切入点，关键问题来了，如何二分呢？
     *
     * 按照题意，所谓丑数是可以至少被a、b、c三者中的一者整除的，那么对于一个丑数X，我们能够确定它是第几个丑数吗？
     *
     * --答案显然是可以的，我们只需要计算X中包含了多少个丑数因子即可。
     *
     * 即只需要知道在[0,X]范围内,还有多少个丑数即可，而这些丑数，无非就是一些能被a或者b或者c所整除的数。
     *
     * 那么显然，我们直接用X/a、X/b、X/c就能计算出[0,X]范围内有多少数能被a或者b或者c整除，然后把它们加起来就是答案！
     *
     * 但是仔细思考一下，我们是不是重复计算了些什么？如果一个数既能被a整除，又能被b整除，那么实际上该数在先前的计算中就被重复计算了一次(分别是在计算X/a和X/b时)。
     *
     * --好吧，让我们思考所有可能的情况
     *
     * 1.该数只能被a整除 (该数一定是a 的整数倍)
     *
     * 2.该数只能被b整除 (该数一定是b 的整数倍)
     *
     * 3.该数只能被c整除 (该数一定是c 的整数倍)
     *
     * 4.该数只能被a和b同时整除 (该数一定是a、b最小公倍数的整数倍)
     *
     * 5.该数只能被a和c同时整除 (该数一定是a、c最小公倍数的整数倍)
     *
     * 6.该数只能被b和c同时整除 (该数一定是b、c最小公倍数的整数倍)
     *
     * 7.该数只能被a和b和c同时整除（该数一定是a、b、c的最小公倍数的整数倍）
     *
     * 所以，我们只需要分别计算以上七项就能得到结果了！让我们分别来看（用MCM+下标表示最小公倍数）：
     *
     * 情况1 = X/a - 情况4 - 情况5 - 情况7
     * 情况2 = X/b - 情况4 - 情况6 - 情况7
     * 情况3 = X/c - 情况5 - 情况6 - 情况7
     * 情况4 = X/MCM_a_b - 情况7
     * 情况5 = X/MCM_a_c - 情况7
     * 情况6 = X/MCM_b_c - 情况7
     * 情况7 = X/MCM_a_b_c
     *
     * 让我们整理上述方程后也就得到：
     *
     * sum(情况) = X/a + X/b + X/c - X/MCM_a_b - X/MCM_a_c - X/MCM_b_c + X/MCM_a_b_c
     */
    public int nthUglyNumber(int n, int a, int b, int c) {
        long l = 1, r = (long) 2e9;
        lcmAB = lcm(a, b);
        lcmAC = lcm(a, c);
        lcmBC = lcm(b, c);
        lcmABC = lcm(a, lcmBC);
        while (l < r) {
            long mid = l + r >> 1;
            if (count(a, b, c, mid) >= n) r = mid;//这里只能去>=,因为要取从左往右第一个
            else l = mid + 1;
        }
        return (int) l;
    }

    //求<=mid的丑数个数
    private long count(long a, long b, long c, long x) {
        return x / a + x / b + x / c - x / lcmAB - x / lcmBC - x / lcmAC + x / lcmABC;
    }

    //最小公倍数
    private long lcm(long a, long b) {
        return a * b / gcd(a, b);
    }

    //最大公约数
    private long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
