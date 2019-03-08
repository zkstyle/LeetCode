package com.elvis.leetcode.math;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: com.elvis.leetcode.math
 * @Author: Elvis
 * @CreateTime: 2019-03-07 10:15
 * Description: 整数反转
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 *
 * 示例 1:
 *
 * 输入: 123
 * 输出: 321
 *  示例 2:
 *
 * 输入: -123
 * 输出: -321
 * 示例 3:
 *
 * 输入: 120
 * 输出: 21
 * 注意:
 *
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−2^31,  2^31 − 1]
 * 请根据这个假设，如果反转后整数溢出那么就返回 0。
 */
public class Leetcode07 {

    /**
     * 21ms
     * @param x
     * @return
     */
    public int reverse(int x) {
        int max = Integer.MAX_VALUE / 10;
        int min = Integer.MIN_VALUE / 10;
        int maxPop = Integer.MAX_VALUE % 10;
        int minPop = Integer.MIN_VALUE % 10;
        int res = 0;
        while (x != 0){
            int pop = x % 10;
            x = x / 10;
            if (res > max || (res == max && pop > maxPop)){
                return 0;
            }
            if (res < min || (res == min && pop < minPop)){
                return 0;
            }
            res = res * 10 + pop;
        }
        return res;
    }

    /**
     * 22ms
     * @param x
     * @return
     */
    public int reverse_2(int x) {
        int res = 0;
        while (x != 0){
            int pop = x % 10;
            x = x / 10;
            long temp = pop + res * 10;
            if (temp > Integer.MAX_VALUE || temp < Integer.MIN_VALUE){
                return 0;
            }
            res = (int)temp;
        }
        return res;
    }
}
