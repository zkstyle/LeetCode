package pdd;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: pdd
 * @Author: elvis
 * @CreateTime: 2020-08-02 19:05
 * @Description:
 */
public class PR03 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int M = in.nextInt();
        int T = in.nextInt();

        int[][] lunch = new int[N][2];
        int[] priceL=new int[N];
        Map<Integer, Integer> mapL=new HashMap<>();
        int[][] dinner = new int[M][2];
        int[] priceD=new int[M];
        Map<Integer, Integer> mapD=new HashMap<>();
        for (int i = 0; i < N; i++) {
            lunch[i][0] = in.nextInt();
            lunch[i][1] = in.nextInt();
            priceL[i]=lunch[i][1]/lunch[i][0];
            mapL.put(priceL[i],i);
        }
        for (int j = 0; j < M; j++) {
            dinner[j][0] = in.nextInt();
            dinner[j][1] = in.nextInt();
            priceD[j]=dinner[j][1]/dinner[j][0];
            mapD.put(priceD[j],j);
        }
        Arrays.sort(priceL);
        Arrays.sort(priceD);
        int hot = Integer.MAX_VALUE;
        for (int i = N-1; i >= 0; i--) {
            int t = lunch[mapL.get(priceL[i])][1];
            if (t >= T){
                hot = Math.min(lunch[mapL.get(priceL[i])][0], hot);
                break;
            }

        }

        for (int j = M-1; j >=0; j--) {
            int t = dinner[mapD.get(priceD[j])][1];
            if (t >= T){
                hot = Math.min(dinner[mapD.get(priceD[j])][0], hot);
                break;
            }

        }

        for (int i = N-1; i >=0; i--)
            for (int j = M-1; j >=0; j--) {
                int t = lunch[mapL.get(priceL[i])][1]+dinner[mapD.get(priceD[j])][1];
                if (t >= T){
                    hot = Math.min(lunch[mapL.get(priceL[i])][0]+dinner[mapD.get(priceD[j])][0], hot);
                    break;
                }


            }
        if (T == 0) System.out.println(0);
        else {
            if (hot == Integer.MAX_VALUE) System.out.println(-1);
            else System.out.println(hot);
        }
    }
}
