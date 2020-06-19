package binarysearch;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: binarysearch
 * @Author: elvis
 * @CreateTime: 2020-06-19 21:21
 * @Description: 排列硬币
 */
public class Leetcode441 {

    /**
     * 依次减1,2,3........
     */
    public int arrangeCoins(int n) {
        int i = 1;
        while (n >= i) {//n小于该行应有的个数则停止
            n -= i;
            i++;
        }
        return i - 1;
    }

    /**
     * 找到1到 n 之间的正数数x，x 的 sum 是最大的小于 n 的数
     * 二分查找　以mid为中心　计算sum=n*(n+1)/2
     *
     */
    public int arrangeCoins2(int n) {
        long low = 1;
        long high = (long) n;
        while (low <= high) {
            long mid = low + (high - low) / 2;
            long sum = mid * (mid + 1) / 2;
            if (sum > n) {
                high = mid - 1;
            } else if (sum == n) {
                return (int) mid;
            } else if (sum < n) {
                low = mid + 1;
            }
        }
        return (int) low - 1;
    }

    /**
     * 数学法　通过公式计算　k*(k+1)/2=n ==> k=?
     */
    public int arrangeCoins3(int n) {
        return (int) (Math.sqrt(2) * Math.sqrt(n + 0.125) - 0.5);
    }
}
