package com.elvis.leetcode.array;

import java.util.Arrays;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: com.elvis.leetcode.array
 * @Author: Elvis
 * @CreateTime: 2019-03-21 10:06
 * Description:
 */
public class Leetcode66 {

    public int[] plusOne(int[] digits) {
        int n = digits.length - 1;
        if (digits[n] != 9){
            digits[n]++;
            return digits;
        }
        while (n >= 0 && digits[n] == 9){
            digits[n] = 0;
            n--;
        }
        if (n >= 0){
            digits[n]++;
        }else {
            int[] digits2 = Arrays.copyOf(digits, digits.length + 1);
            digits2[0] = 1;
            return digits2;
        }

        return digits;
    }

    public static void main(String[] args) {
        int[] digits = {9,9};
        new Leetcode66().plusOne(digits);
    }
}
