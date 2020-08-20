package pdd;

import java.util.Scanner;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: pdd
 * @Author: elvis
 * @CreateTime: 2020-08-02 19:05
 * @Description:
 */
public class PR02 {
    public static String ans="paradox";
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int k=in.nextInt();
        int n=in.nextInt();
        int ret=0,count=0;
        int i=0;
        for(;i<n;i++){
            int p=in.nextInt();
            ret+=p;
            if(ret>k) {
                ret=2*k-ret;
                count++;
            }
            else if(ret==k) break;
        }
        if(i<n-1) System.out.println(ans);
        System.out.println(k-ret+" "+count);
    }
}
