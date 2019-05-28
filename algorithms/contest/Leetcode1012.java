package contest;

import static java.lang.Math.pow;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: com.elvis.leetcode.contest
 * @Author: Elvis
 * @CreateTime: 2019-03-17 10:41
 * Description:
 */
public class Leetcode1012 {
    public int bitwiseComplement(int N) {
        int i = 1;
        while (N + 1 > pow(2, i)) i++;
        int M = (int)pow(2, i) - 1;
        return M ^ N;
    }

}
