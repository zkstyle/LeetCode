package array;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: array
 * @Author: Elvis
 * @CreateTime: 2019-07-16 11:40
 * Description:
 */
public class Leetcode118 {

    /**
     * 杨辉三角
     * @param numRows
     * @return
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> lists = new ArrayList<>();
        if (numRows == 0) return lists;

        for (int i = 0; i < numRows; i++){
            List<Integer> list = new ArrayList<>();
            for(int j = 0; j <= i; j++){
                if (j == 0 || j == i){
                    list.add(1);
                }else {
                    int add = lists.get(i-1).get(j-1)+lists.get(i-1).get(j);
                    list.add(add);
                }

            }
            lists.add(list);
        }
        return lists;
    }

    public static void main(String[] args) {
        new Leetcode118().generate(5);
    }
}
