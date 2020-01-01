package binarysearch;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: binarysearch
 * @Author: elvis
 * @CreateTime: 2019-08-27 22:03
 * @Description:
 * 给定一个正整数 num，编写一个函数，如果 num 是一个完全平方数，则返回 True，否则返回 False。
 *
 * 说明：不要使用任何内置的库函数，如  sqrt。
 *
 * 示例 1：
 *
 * 输入：16
 * 输出：True
 * 示例 2：
 *
 * 输入：14
 * 输出：False
 *
 */
public class Leetcode367 {

    /**
     * 功能描述: <br>
     * 二分查找法
     * @Param: [num]
     * @Return: boolean
     * @Author: elvis
     * @Date: 19-8-27 下午10:04
     */
    public boolean isPerfectSquare(int num) {
        int left = 1;
        int right = num;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if ((double) mid * mid < num) left = mid + 1;
            else if ((double) mid * mid > num) right = mid - 1;
            else return true;
        }
        return false;
    }


    /**
     * 功能描述: <br>
     * 〈〉牛顿迭代法
     * @Param: [num]
     * @Return: boolean
     * @Author: elvis
     * @Date: 19-8-27 下午10:04
     */
    public boolean isPerfectSquare1(int num) {
        if(1 == num) return true;
        int i = num / 2;
        while((double)i * i > num){
            i = (i + num / i) / 2;
        }
        return i * i == num;
    }
}
