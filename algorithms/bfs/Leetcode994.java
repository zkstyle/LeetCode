package bfs;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: bfs
 * @Author: elvis
 * @CreateTime: 2020-03-04 10:27
 * @Description: 腐烂的橘子
 */
public class Leetcode994 {

    int[][] grid;
    int row;
    int column;

    /**
     * 法一　递归bfs
     * @param grid
     * @return
     */
    public int orangesRotting(int[][] grid) {
        this.grid=grid;
        this.row=grid.length;
        this.column=grid[0].length;

        for(int i=0;i<row;i++)
            for(int j=0;j<column;j++)
                if(grid[i][j]==2)
                    bfs(i,j,2);

        int res=0;
        for(int i=0;i<row;i++){
            for(int j=0;j<column;j++){
                if(grid[i][j]==1) return -1;
                res=Math.max(res,grid[i][j]);
            }
        }

        if(res==0) return 0;
        return res-2;
    }
    public void bfs(int i,int j,int val){
        grid[i][j]=val;
        if(i>0&&(grid[i-1][j]==1||grid[i-1][j]-grid[i][j]>1))
            bfs(i-1,j,val+1);

        if(j>0&&(grid[i][j-1]==1||grid[i][j-1]-grid[i][j]>1))
            bfs(i,j-1,val+1);

        if(i<row-1&&(grid[i+1][j]==1||grid[i+1][j]-grid[i][j]>1))
            bfs(i+1,j,val+1);

        if(j<column-1&&(grid[i][j+1]==1||grid[i][j+1]-grid[i][j]>1))
            bfs(i,j+1,val+1);
    }

    class Solution {
        /**
         * 法二　非递归版本　采用队列模拟bfs算法
         * dr[i] dc[i] 四组数　代表四个方向的坐标变换
         */
        int[] dr = new int[]{-1, 0, 1, 0};
        int[] dc = new int[]{0, -1, 0, 1};

        public int orangesRotting(int[][] grid) {
            int R = grid.length, C = grid[0].length;

            // queue : all starting cells with rotten oranges　
            Queue<Integer> queue = new ArrayDeque();
            Map<Integer, Integer> depth = new HashMap();
            for (int r = 0; r < R; ++r)
                for (int c = 0; c < C; ++c)
                    if (grid[r][c] == 2) {
                        int code = r * C + c;
                        queue.add(code);
                        depth.put(code, 0);
                    }

            int ans = 0;
            //队列是先进先出的结构　故先进队列的而第一层坏橘子先遍历　后面被"感染"的坏橘子依次遍历
            while (!queue.isEmpty()) {
                int code = queue.remove();
                int r = code / C, c = code % C;
                for (int k = 0; k < 4; ++k) {
                    //四个方向的依次扩散
                    int nr = r + dr[k];
                    int nc = c + dc[k];
                    if (0 <= nr && nr < R && 0 <= nc && nc < C && grid[nr][nc] == 1) {
                        grid[nr][nc] = 2;
                        int ncode = nr * C + nc;
                        queue.add(ncode);
                        depth.put(ncode, depth.get(code) + 1);
                        ans = depth.get(ncode);
                    }
                }
            }
            //若存在值为1的橘子　说明存在孤立的橘子
            for (int[] row: grid)
                for (int v: row)
                    if (v == 1)
                        return -1;
            return ans;

        }
    }

}
