package bfs;

import java.util.LinkedList;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: bfs
 * @Author: elvis
 * @CreateTime: 2020-10-05 10:47
 * @Description: 访问所有节点的最短路径
 * 给出 graph 为有 N 个节点（编号为 0, 1, 2, ..., N-1）的无向连通图。
 *
 * graph.length = N，且只有节点 i 和 j 连通时，j != i 在列表 graph[i] 中恰好出现一次。
 *
 * 返回能够访问所有节点的最短路径的长度。你可以在任一节点开始和停止，也可以多次重访节点，并且可以重用边。
 *
 *
 *
 * 示例 1：
 *
 * 输入：[[1,2,3],[0],[0],[0]]
 * 输出：4
 * 解释：一个可能的路径为 [1,0,2,0,3]
 * 示例 2：
 *
 * 输入：[[1],[0,2,4],[1,3,4],[2],[1,2]]
 * 输出：4
 * 解释：一个可能的路径为 [0,1,4,2,3]
 *
 *
 * 提示：
 *
 * 1 <= graph.length <= 12
 * 0 <= graph[i].length < graph.length
 */
public class Leetcode847 {


    /**
     * 基本思路是宽度优先搜索，终止搜索的条件是已经遍历过所有的节点（但是必须是串联经过所有节点，所以允许重复经过节点）
     * 为了避免陷入循环，需要记录的是状态！比如路径的尾节点i与路径定义为一个状态，
     * 这样如果两次经过节点，由于路径不一样状态就不一样
     * 下面是正常的宽度优先搜索的算法：维护 visited，维护 queue，更新path的长度
     * 技巧1： 使用 1<<i 指示路径中仅有节点i
     * 技巧2： 想在旧的路径中增加新的节点，只需要 old_state | 1<<i 就把i位置变1了
     * 技巧3： 宽度优先搜索的终止条件，全1的二进制数：1<<len(graph) - 1 就是了
     */
    public static int shortestPathLength(int[][] graph) {
        int length = graph.length;
        int target = (1<<length)-1;
        if(graph==null || length==0) return 0;
        boolean[][] visited = new boolean[length][1<<length];

        LinkedList<int[]> queue = new LinkedList<>();
        for(int i=0;i<length;i++){
            queue.add(new int[]{i, (1<<i)});
            //visited[i][(1<<i)] = true;
        }

        int step = 0;
        while(!queue.isEmpty()){
            for(int i=queue.size();i>0;i--){
                int[] cur = queue.poll();
                if(cur[1]==target) return step;
                for(int next:graph[cur[0]]){
                    int state = cur[1]|(1<<next);
                    if(visited[next][state]){
                        continue;
                    }
                    visited[next][state] = true;
                    queue.add(new int[]{next, state});
                }
            }

            step++;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] graph={{1},{0,2,4},{1,3,4},{2},{1,2}};
        shortestPathLength(graph);
    }
}
