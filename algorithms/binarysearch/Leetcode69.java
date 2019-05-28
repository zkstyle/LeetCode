package binarysearch;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: com.elvis.leetcode.binarysearch
 * @Author: Elvis
 * @CreateTime: 2019-04-18 11:00
 * Description:
 */
public class Leetcode69 {

    /**
     * best
     * @param x
     * @return
     */
    public int mySqrt1(int x) {
        if (x <= 1) {
            return x;
        }
        int l = 1;
        int h = x;
        while (l < h) {
            int mid = l + (h - l) / 2;
            if (x / mid >= mid) {
                l = mid+1;
            } else {
                h = mid;
            }
        }
        return h-1;
    }

    public int mySqrt(int x) {
        if (x == 0 || x == 1){
            return x;
        }
        return find(x, 0, x);
    }
    private int find(int x, int low, int high){
        while(low <= high){
            int mid = (low + high) / 2;
            if (mid * mid == x){
                return mid;
            }else if (mid * mid > x){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return high;
    }

    public static void main(String[] args) {
        new Leetcode69().mySqrt(8);
    }
}
