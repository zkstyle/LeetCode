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
     * best
     * @param n
     * @return
     */
    public boolean isHappy1(int n) {
        int x = n;
        int sum = 0;
        if(n == 1) return true;
        while(sum != 1) {
            sum = 0;
            while(x != 0) {
                int y = x % 10;
                sum += y * y;
                x = x / 10;
            }
            if(sum == n) return false;
            if(sum == 4) return false;
            x = sum;
        }
        return true;
    }

    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        return find(n, set);

    }
    private boolean find(int n, Set<Integer> set){
        int sum = 0;
        while (n != 0){
            sum += (n % 10) * (n % 10);
            n /=  10;
        }
        if (sum == 1){
            return true;
        }
        n = sum;
        if(!set.contains(n)){
            set.add(n);
            return find(n, set);
        }
        return false;
    }

    public static void main(String[] args) {
        new Leetcode202().isHappy(19);
    }
}
