package math;

import java.util.Arrays;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: math
 * @Author: Elvis
 * @CreateTime: 2019-06-04 14:49
 * Description:
 */
public class Leetcode976 {

    public int largestPerimeter(int[] A) {
        Arrays.sort(A);
        int res = 0, l = A.length-1;
        for (int i = l; i >= 2; i--){
            if (A[i] < A[i-1] + A[i-2]){
                res = A[i]+A[i-1]+A[i-2];
                return res;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] A={2,1,2};
        new Leetcode976().largestPerimeter(A);
    }
}
