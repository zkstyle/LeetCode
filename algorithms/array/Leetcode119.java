package array;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: array
 * @Author: Elvis
 * @CreateTime: 2019-07-16 13:17
 * Description:
 */
public class Leetcode119 {

    /**
     * 杨辉三角2 返回第k行
     * @param rowIndex
     * @return
     */
    public List<Integer> getRow(int rowIndex) {
        List<Integer> ans = new ArrayList<>(rowIndex + 1);
        long current = 1;
        for (int i = 0; i <= rowIndex; i++) {
            ans.add((int) current);
            current = current * (rowIndex-i)/(i+1);
        }
        return ans;
    }
}
