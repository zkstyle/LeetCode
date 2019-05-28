package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: com.elvis.leetcode.backtracking
 * @Author: Elvis
 * @CreateTime: 2019-05-16 11:54
 * Description:
 * 排列组合
 */
public class Leetcode77 {

    List<List<Integer>> lists = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        back(new ArrayList<>(), n, k, 1);
        return lists;
    }

    private void back(List<Integer> list, int n, int k, int row){
        if (k == list.size()){
            lists.add(new ArrayList<>(list));
            return;
        }

        for( int i = row; i <= n; i++){
            //剩余的数已经不足以k - list.size()(已经添加的数)
            if (n - i + 1 < k - list.size())
                return;
            list.add(i);
            back(list, n, k, i + 1);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        new Leetcode77().combine(4,2);
    }
}
