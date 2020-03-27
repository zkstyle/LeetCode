package array;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: array
 * @Author: Elvis
 * @CreateTime: 2019-07-16 11:40
 * Description:给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 *
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 *
 * 示例:
 *
 * 输入: 5
 * 输出:
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 */
public class Leetcode118 {

    /**
     * 杨辉三角　两层for循环　外层循环控制行数　内层循环控制列
     *  内层循环判断　若j==0||j==i(第一个元素或最后一个元素)直接添加'1'
     *  否则获取上一层的j-1与j列值之和　添加到当前列
     * @param numRows
     * @return
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> lists = new ArrayList<>();
        if (numRows == 0) return lists;

        for (int i = 0; i < numRows; i++) {
            //申请一个list集合　存放每一层的杨辉三角数
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    list.add(1);
                } else {
                    int add = lists.get(i - 1).get(j - 1) + lists.get(i - 1).get(j);
                    list.add(add);
                }

            }
            lists.add(list);
        }
        return lists;
    }

}
