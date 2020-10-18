package swordmeansoffer;

import java.util.Arrays;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: swordmeansoffer
 * @Author: elvis
 * @CreateTime: 2020-10-07 22:07
 * @Description: 剑指 Offer 66. 构建乘积数组
 * 给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，其中 B 中的元素 B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。
 *
 *
 *
 * 示例:
 *
 * 输入: [1,2,3,4,5]
 * 输出: [120,60,40,30,24]
 *
 *
 * 提示：
 *
 * 所有元素乘积之和不会溢出 32 位整数
 * a.length <= 100000
 */
public class SMO66 {

    /**
     * 统计0的个数　若大于2 则全为0
     * 若为1  记录下标　并对　a[idx]　赋值
     * 若为0  利用全积除以当前元素
     */
    public int[] constructArr(int[] a) {
        int mul = 1;
        int cnt = 0;
        int idx = -1;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == 0) {
                cnt++;
                idx = i;
            } else {
                mul *= a[i];
            }
        }
        if (cnt >= 2) {
            Arrays.fill(a, 0);
            return a;
        }
        if (cnt == 1) {
            Arrays.fill(a, 0);
            a[idx] = mul;
            return a;
        }
        for (int i = 0; i < a.length; i++) a[i] = mul / a[i];
        return a;

    }
}
