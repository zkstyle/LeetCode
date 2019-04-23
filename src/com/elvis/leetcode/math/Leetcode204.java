package com.elvis.leetcode.math;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: com.elvis.leetcode.math
 * @Author: Elvis
 * @CreateTime: 2019-04-23 16:11
 * Description:
 * Count the number of prime numbers less than a non-negative number, n.
 *
 * Example:
 *
 * Input: 10
 * Output: 4
 * Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
 */
public class Leetcode204 {

    public int countPrimes(int n) {
        boolean[] isP = new boolean[n];
        for(int i = 2; i<n;i++){
            isP[i] = true;
        }
        for(int i = 2; i*i<n;i++){
            if(!isP[i]) continue;
            for(int j = i*i;j<n;j+=i){
                isP[j] = false;
            }
        }
        int count = 0;
        for(int i = 2;i<n;i++){
            if(isP[i]) count++;
        }
        return count;
    }

}
