package math;

import java.util.HashSet;
import java.util.Set;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: com.elvis.leetcode.math
 * @Author: Elvis
 * @CreateTime: 2019-04-18 11:22
 * Description:
 * 编写一个算法来判断一个数是不是“快乐数”。
 *
 * 一个“快乐数”定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，也可能是无限循环但始终变不到 1。如果可以变为 1，那么这个数就是快乐数。
 *
 * 示例:
 *
 * 输入: 19
 * 输出: true
 * 解释:
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 */
public class Leetcode202 {

    /**
     * 定义一个set存放每一次计算结果　每一次循环结算后判断set中是否包含res 不包含就添加进去
     * 否则返回false
     * @param n
     * @return 是否是快乐数
     */
    public boolean isHappy(int n) {
        int res = 0;
        Set<Integer> set = new HashSet<>();
        set.add(n);
        while (n != 1) {
            res = 0;
            while (n != 0) {
                res += (n % 10) * (n % 10);
                n /= 10;
            }
            n = res;
            if (set.contains(res)) {
                return false;
            }
            set.add(res);
        }
        return true;
    }
}
