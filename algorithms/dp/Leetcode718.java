package dp;

import java.util.HashSet;
import java.util.Set;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: dp
 * @Author: elvis
 * @CreateTime: 2020-09-30 17:12
 * @Description: 最长重复子数组
 * 给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。
 *
 *
 *
 * 示例：
 *
 * 输入：
 * A: [1,2,3,2,1]
 * B: [3,2,1,4,7]
 * 输出：3
 * 解释：
 * 长度最长的公共子数组是 [3, 2, 1] 。
 *
 *
 * 提示：
 *
 * 1 <= len(A), len(B) <= 1000
 * 0 <= A[i], B[i] < 100
 */
public class Leetcode718 {

    /**
     * dp 很容易理解　dp[i][j]代表A前i个字符,B前j个字符的最长交集
     * 每次保存最大值
     */
    public int findLength(int[] A, int[] B) {
        int lenA = A.length;
        int lenB = B.length;
        int[][] dp = new int[lenA + 1][lenB + 1];
        int res = 0;
        for(int i = 1; i <= lenA; i++){
            for(int j = 1; j <= lenB; j++){
                if(A[i - 1] == B[j - 1]){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    res = Math.max(res, dp[i][j]);
                }
            }
        }
        return res;
    }

    public int findLength2(int[] A, int[] B) {
        int left=1;
        int right=Math.min(A.length,B.length)+1;
        digits=new int[Math.min(A.length,B.length)];
        digits[0]=1;
        int R=107;
        for(int i=1; i<digits.length; i++)
            digits[i]=digits[i-1]*R;
        while(left<right){
            int mid=(left+right)>>1;
            if(check(A,B,mid)) left=mid+1;
            else right=mid;
        }
        return left-1;
    }
    int[] digits;
    boolean check(int [] A, int[] B, int len){
        int R=107, hashA=0, hashB=0;
        Set<Integer> set=new HashSet<>(A.length-len+1);
        for(int i=0; i<len; i++)
            hashA=hashA*R+A[i]+1;
        set.add(hashA);
        for(int i=len; i<A.length; i++){
            hashA-=digits[len-1]*(A[i-len]+1);
            hashA=hashA*R+A[i]+1;
            set.add(hashA);
        }
        for(int i=0; i<len; i++)
            hashB=hashB*R+B[i]+1;
        if(set.contains(hashB)) return true;
        for(int i=len; i<B.length; i++){
            hashB-=digits[len-1]*(B[i-len]+1);
            hashB=hashB*R+B[i]+1;
            if(set.contains(hashB)) return true;
        }
        return false;
    }
}
