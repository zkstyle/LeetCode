package dp;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: dp
 * @Author: elvis
 * @CreateTime: 2020-08-31 12:41
 * @Description: 戳气球
 * 有 n 个气球，编号为0 到 n-1，每个气球上都标有一个数字，这些数字存在数组 nums 中。
 *
 * 现在要求你戳破所有的气球。如果你戳破气球 i ，就可以获得 nums[left] * nums[i] * nums[right] 个硬币。 这里的 left 和 right 代表和 i 相邻的两个气球的序号。注意当你戳破了气球 i 后，气球 left 和气球 right 就变成了相邻的气球。
 *
 * 求所能获得硬币的最大数量。
 *
 * 说明:
 *
 *     你可以假设 nums[-1] = nums[n] = 1，但注意它们不是真实存在的所以并不能被戳破。
 *     0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100
 *
 * 示例:
 *
 * 输入: [3,1,5,8]
 * 输出: 167
 * 解释: nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
 *      coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167
 */
public class Leetcode312 {

    /**
     * 假设这个区间是个开区间，最左边索引 i，最右边索引 j
     * 我这里说 “开区间” 的意思是，我们只能戳爆 i 和 j 之间的气球，i 和 j 不要戳
     *
     * DP思路是这样的，假设最后一个被戳破的气球下标为k
     *
     * 假设 dp[i][j] 表示开区间 (i,j) 内你能拿到的最多金币
     *
     * 你在 (i,j) 开区间得到的金币可以由 dp[i][k] 和 dp[k][j] 进行转移
     *
     * 如果你此刻选择戳爆气球 k，那么你得到的金币数量就是：
     *
     * total=dp[i][k] + val[i] * val[k] * val[j] + dp[k][j]
     *
     * 注：val[i] 表示 i 位置气球的数字
     * 然后 (i,k) 和 (k,j) 也都是开区间
     *
     * 那你可能又想问了，戳爆粉色气球我能获得 val[i]*val[k]*val[j] 这么多金币我能理解(因为戳爆 k 的时候只剩下这三个气球了)，
     * 但为什么前后只要加上 dp[i][k] 和 dp[k][j] 的值就行了呀？
     *
     * 因为 k 是最后一个被戳爆的，所以 (i,j) 区间中 k 两边的东西必然是先各自被戳爆了的，
     *
     * 这就是为什么我们 DP 时要看 “最后一个被戳爆的” 气球，这就是为了让左右两边互不干扰，这大概就是一种分治的思想叭
     *
     * 所以你把 (i,k) 开区间所有气球戳爆，然后把戳爆这些气球的所有金币都收入囊中，金币数量记录在 dp[i][k]
     * 同理，(k,j) 开区间你也已经都戳爆了，钱也拿了，记录在 dp[k][j]
     * 所以你把这些之前已经拿到的钱 dp[i][k]+dp[k][j] 收着，
     * 再加上新赚的钱 val[i]*val[k]*val[j] 不就得到你现在戳爆气球 k 一共手上能拿多少钱了吗
     *
     * 而你在 (i,j) 开区间可以选的 k 是有多个的，见一开头的图，除了粉色之外，你还可以戳绿色和红色
     * 所以你枚举一下这几个 k，从中选择使得 total 值最大的即可用来更新 dp[i][j]
     *
     * 然后呢，你就从 (i,j) 开区间只有三个数字的时候开始计算，储存每个小区间可以得到金币的最大值
     * 然后慢慢扩展到更大的区间，利用小区间里已经算好的数字来算更大的区间
     */
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[][] rec = new int[n + 2][n + 2];
        int[] val = new int[n + 2];
        val[0] = val[n + 1] = 1;
        for (int i = 1; i <= n; i++) {
            val[i] = nums[i - 1];
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 2; j <= n + 1; j++) {
                for (int k = i + 1; k < j; k++) {
                    int sum = val[i] * val[k] * val[j];
                    sum += rec[i][k] + rec[k][j];
                    rec[i][j] = Math.max(rec[i][j], sum);
                }
            }
        }
        return rec[0][n + 1];
    }

    public static void main(String[] args) {
        new Leetcode312().maxCoins(new int[]{3,1,5,8});
    }
}
