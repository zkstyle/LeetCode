package jdk;

import java.io.*;
import java.util.Arrays;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: jdk
 * @Author: Elvis
 * @CreateTime: 2019-06-02 19:13
 * Description
 * Bigbrother is a cute boy who likes to play cards. One day, he gets N cards and every of them has a number Vi . Now, he wants to play a game with you.
 *
 * He has M operations.
 *
 * In the k -th operation, the sum of Vi between intervals [L,R] is S, k×S is the k -th score.
 *
 * You can sort the M operations and get the maximum sum of scores.
 *
 * Input
 * There are multiple tests. The first line contains integer T(1≤T≤10).
 *
 * The second line contains integer N,M(1 ≤ N,M ≤ 100000)
 * The next line contain N numbers V*i*  (1 ≤Vi ≤ 1000) .
 *
 * The following M lines, each line contains two numbers, L,R(1 ≤ L,R ≤ N).
 *
 * Output
 * There are T lines.
 *
 * In every line print a single integer — the answer to the problem.
 *
 * Examples
 * Input
 * 1
 * 4 3
 * 1 2 3 4
 * 1 2
 * 2 4
 * 1 4
 * Output
 * 51
 */
public class ProcK {
    public static StreamTokenizer in;
    public static PrintWriter out;
    static {
        try{
            in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
            out = new PrintWriter(new OutputStreamWriter(System.out));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static int nextInt() throws IOException{ in.nextToken(); return (int)in.nval; }


    public static void main(String[] args) throws IOException {
        int T, N, M, L, R;

      //  while (in.nextToken() != StreamTokenizer.TT_EOF) {
            T = nextInt();
            while (T-- != 0){
                N = nextInt();
                M = nextInt();
                int[] Vi = new int[N];
                long[] sum = new long[N+1];
                sum[0] = 0;
                for (int i = 1; i <= N; i++) {
                    Vi[i-1] = nextInt();
                    if (i != 1){
                        sum[i] += sum[i-1] + Vi[i-1];
                    }else{
                        sum[i] = Vi[i-1];
                    }

                }
                long[] res = new long[M];
                long result = 0l;
                for (int i = 0; i < M; i++) {
                    L = nextInt();
                    R = nextInt();
                    res[i] = sum[R] - sum[L-1];
                }

                Arrays.sort(res);
                for (int i = 0; i < M; i++) {
                    result += res[i] * (i+1);
                }
                out.write(String.valueOf(result));
                out.println();
                out.flush();
            }
        }




}
