package com.elvis.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: com.elvis.leetcode.backtracking
 * @Author: Elvis
 * @CreateTime: 2019-05-09 13:19
 * Description:
 */
public class Leetcode60 {

    public String getPermutation(int n, int k) {
        int[] fb = new int[n+1];
        fb[0]=1;
        for(int i=1;i<=n;i++){
            fb[i]=fb[i-1]*i;
        }
        // factorial[] = {1, 1, 2, 6, 24, ... n!}

        List<Integer> num = new ArrayList<>();
        for(int i=1;i<=n;i++){
            num.add(i);
        }

        k--;
        StringBuilder sb = new StringBuilder();
        for(int i=1;i<=n;i++){
            int index=k/fb[n-i];
            sb.append(num.get(index));
            num.remove(index);
            k = k-index*fb[n-i];
        }
        return sb.toString();
    }
}
