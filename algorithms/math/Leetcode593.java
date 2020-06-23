package math;

import java.util.HashSet;
import java.util.Set;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: math
 * @Author: elvis
 * @CreateTime: 2020-06-20 15:32
 * @Description: 正方形判断
 * 给定二维空间中四点的坐标，返回四点是否可以构造一个正方形。
 *
 * 一个点的坐标（x，y）由一个有两个整数的整数数组表示。
 *
 * 示例:
 *
 * 输入: p1 = [0,0], p2 = [1,1], p3 = [1,0], p4 = [0,1]
 * 输出: True
 *  
 *
 * 注意:
 *
 * 所有输入整数都在 [-10000，10000] 范围内。
 * 一个有效的正方形有四个等长的正长和四个等角（90度角）。
 * 输入点没有顺序。
 */
public class Leetcode593 {

    /**
     * 对于给出的四个坐标　分别计算出6个距离平方k1,k2,k3,k4,k5,k6
     * 若是正方形　应该有其中四个等于a^2 另外两个等于2a^2
     * 所以将6个数据存到set中 若set容量大于2 则不成立
     * 将数据放入数组中　判断两个数组是否成二倍关系
     * @param p1 坐标1
     * @param p2 坐标2
     * @param p3 坐标3
     * @param p4 坐标4
     * @return
     */
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        Set<Integer> set = new HashSet<>();
        int k1 = (p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1]);
        int k2 = (p1[0] - p3[0]) * (p1[0] - p3[0]) + (p1[1] - p3[1]) * (p1[1] - p3[1]);
        int k3 = (p1[0] - p4[0]) * (p1[0] - p4[0]) + (p1[1] - p4[1]) * (p1[1] - p4[1]);
        int k4 = (p2[0] - p3[0]) * (p2[0] - p3[0]) + (p2[1] - p3[1]) * (p2[1] - p3[1]);
        int k5 = (p2[0] - p4[0]) * (p2[0] - p4[0]) + (p2[1] - p4[1]) * (p2[1] - p4[1]);
        int k6 = (p3[0] - p4[0]) * (p3[0] - p4[0]) + (p3[1] - p4[1]) * (p3[1] - p4[1]);
        if (k1 == 0 || k2 == 0 || k3 == 0 || k4 == 0 || k5 == 0 || k6 == 0) return false;
        set.add(k1);
        set.add(k2);
        set.add(k3);
        set.add(k4);
        set.add(k5);
        set.add(k6);
        if (set.size() > 2) return false;
        Integer[] ans = new Integer[2];
        ans = set.toArray(ans);
        return ans[0] > ans[1] ? ans[0] == 2 * ans[1] : ans[1] == 2 * ans[0];
    }
}
