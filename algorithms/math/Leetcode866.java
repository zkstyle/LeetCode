package math;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: math
 * @Author: elvis
 * @CreateTime: 2020-07-02 20:18
 * @Description: 回文素数
 */
public class Leetcode866 {

    /**
     * 通过翻转数字和检测回文串依次遍历回文串
     */
    public int primePalindrome(int N) {
        if(N%2==0) N++;
        while (true) {
            if (N == reverse(N) && isPrime(N))
                return N;
            N+=2;
            if (10_000_000 < N && N < 100_000_000)
                N = 100_000_000;
        }
    }

    public boolean isPrime(int N) {
        if (N < 2) return false;
        int R = (int) Math.sqrt(N);
        for (int d = 2; d <= R; ++d)
            if (N % d == 0) return false;
        return true;
    }

    public int reverse(int N) {
        int ans = 0;
        while (N > 0) {
            ans = 10 * ans + (N % 10);
            N /= 10;
        }
        return ans;
    }


    public int primePalindrome2(int N) {
        if (N > 7 && N <= 11) {
            return 11;
        }
        int p = N - 1;
        do {
            p = nextPalindrome(p);
            if (isPrime2(p)) {
                return p;
            }
        } while (true);
    }

    private int nextPalindrome(int n) {
        String s = String.valueOf(n);
        int len = s.length();
        if ((len & 1) == 0) {
            return smallest(len + 1);
        }
        StringBuilder sb = new StringBuilder(s.substring(0, len + 1 >> 1));
        int i = sb.length() - 1;
        for (; i >= 0; --i) {
            char c = sb.charAt(i);
            if (c < '9') {
                sb.setCharAt(i, (char) (c + 1));
                break;
            } else {
                sb.setCharAt(i, '0');
            }
        }
        if (i < 0) {
            return smallest(len + 2);
        }
        for (int j = sb.length() - 2; j >= 0; --j) {
            sb.append(sb.charAt(j));
        }
        return Integer.parseInt(sb.toString());
    }

    private int smallest(int len) {
        StringBuilder sb = new StringBuilder();
        sb.append(1);
        for (int i = 0; i < len - 2; ++i) {
            sb.append(0);
        }
        sb.append(1);
        return Integer.parseInt(sb.toString());
    }

    private boolean isPrime2(int n) {
        if (n < 2) {
            return false;
        }
        if (n == 2) {
            return true;
        }
        if ((n & 1) == 0) {
            return false;
        }
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
