package math;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: math
 * @Author: Elvis
 * @CreateTime: 2019-06-06 16:35
 * Description: Easy
 */
public class Leetcode191 {

    public int hammingWeight(int n) {
        if (n == 0) return 0;
        int res = 0;
        while (n != 0){
            res += n & 1;
            n >>>= 1;
        }
        
        return res;
    }

    public static void main(String[] args) {
        new Leetcode191().hammingWeight(2147483646);
    }

}
