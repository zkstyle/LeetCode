package math;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: math
 * @Author: Elvis
 * @CreateTime: 2019-07-25 10:41
 * Description:
 * 斐波拉契数列
 */
public class Leetcode509 {

    public int fib(int N) {
        if (N < 2) return N;
        int[] fb = new int[N + 1];
        fb[0] = 0;
        fb[1] = 1;
        for (int i = 2; i <= N; i++) {
            fb[i] = fb[i - 1] + fb[i - 2];
        }
        return fb[N];
    }
}
