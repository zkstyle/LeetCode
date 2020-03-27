package array;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: array
 * @Author: Elvis
 * @CreateTime: 2019-07-16 13:17
 * Description:给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 *
 * 示例:
 *
 * 输入: 3
 * 输出: [1,3,3,1]
 * 进阶：
 *
 * 你可以优化你的算法到 O(k) 空间复杂度吗？
 */
public class Leetcode119 {

    /**
     * 杨辉三角2 返回第k行
     * 每一次迭代　根据前一行求解下一行
     * 每一次首先将末尾添加一个'1' 应为行末尾为'1'
     * 每一次需要更新的范围 i～1(实际上因为添加了'1' 在kRows中的索引为i-1)
     * @param rowIndex
     * @return
     */
    public List<Integer> getRow(int rowIndex) {
        List<Integer> kRows = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i++)//利用前一行求后一行，第K行要循环K遍
        {
            kRows.add(1);//行末尾为1
            for (int j = i; j > 1; j--)//每一行的更新过程
            {
                int newValue = kRows.get(j - 2) + kRows.get(j - 1);
                kRows.set(j - 1, newValue);
            }
        }
        return kRows;
    }
}
