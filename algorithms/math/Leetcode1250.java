package math;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: math
 * @Author: elvis
 * @CreateTime: 2020-10-21 12:40
 * @Description: 检查「好数组」
 * 给你一个正整数数组 nums，你需要从中任选一些子集，然后将子集中每一个数乘以一个 任意整数，并求出他们的和。
 *
 * 假如该和结果为 1，那么原数组就是一个「好数组」，则返回 True；否则请返回 False。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [12,5,7,23]
 * 输出：true
 * 解释：挑选数字 5 和 7。
 * 5*3 + 7*(-2) = 1
 * 示例 2：
 *
 * 输入：nums = [29,6,10]
 * 输出：true
 * 解释：挑选数字 29, 6 和 10。
 * 29*1 + 6*(-3) + 10*(-1) = 1
 * 示例 3：
 *
 * 输入：nums = [3,6]
 * 输出：false
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i] <= 10^9
 */
public class Leetcode1250 {

    /**
     * 裴蜀定理：对于 ∀a,b∈Z,gcd(a,b)=1⇔∃x,y∈Z,s.t.ax+by=1.
     * 利用裴蜀定理，自左至右求出最大公因数即可
     * 若最大公因数为1，一定存在两两互质的最大公因数，可以(使用这两个互质的公因数)实现「好数组」
     * 注：最大公因数可以通过有限次乘法运算求出
     * 若最大公因数不为1，所有数都有共同的(大于1的)公因数，不能实现「好数组」
     */
    public boolean isGoodArray(int[] nums) {
        int len = nums.length, res = nums[0];
        for (int i = 1; i < len; i++) {
            res = gcd(res, nums[i]);
        }
        return res == 1;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
