package greed;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: greed
 * @Author: elvis
 * @CreateTime: 2020-09-29 19:45
 * @Description: xx
 */
public class Leetcode435 {


    public int eraseOverlapIntervals(int[][] a) {
        Arrays.sort(a, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]==o2[0]?o1[1]-o2[1]:o1[0]-o2[0];
            }
        });
        int move=0;
        int[] s=a[0];
        for(int i=1;i<a.length;i++){
            if(s[1]<=a[i][0]){
                s=a[i];
            }else {
                move++;
            }
        }
        return move;
    }
}
