package dp;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: dp
 * @Author: elvis
 * @CreateTime: 2020-06-16 14:08
 * @Description: 地下城游戏
 * 一些恶魔抓住了公主（P）并将她关在了地下城的右下角。地下城是由 M x N 个房间组成的二维网格。我们英勇的骑士（K）最初被安置在左上角的房间里，他必须穿过地下城并通过对抗恶魔来拯救公主。
 *
 * 骑士的初始健康点数为一个正整数。如果他的健康点数在某一时刻降至 0 或以下，他会立即死亡。
 *
 * 有些房间由恶魔守卫，因此骑士在进入这些房间时会失去健康点数（若房间里的值为负整数，则表示骑士将损失健康点数）；其他房间要么是空的（房间里的值为 0），要么包含增加骑士健康点数的魔法球（若房间里的值为正整数，则表示骑士将增加健康点数）。
 *
 * 为了尽快到达公主，骑士决定每次只向右或向下移动一步。
 *
 *  
 *
 * 编写一个函数来计算确保骑士能够拯救到公主所需的最低初始健康点数。
 *
 * 例如，考虑到如下布局的地下城，如果骑士遵循最佳路径 右 -> 右 -> 下 -> 下，则骑士的初始健康点数至少为 7。
 *
 * -2 (K)	-3	    3
 * -5	    -10	    1
 * 10	    30	    -5 (P)
 *  
 *
 * 说明:
 *
 * 骑士的健康点数没有上限。
 *
 * 任何房间都可能对骑士的健康点数造成威胁，也可能增加骑士的健康点数，包括骑士进入的左上角房间以及公主被监禁的右下角房间。
 */
public class Leetcode174 {


    /**
     * 解题思路
     * 此题为64题的加强版。但这一题需要逆过来想，从下往上初始化。
     * 此时dp[i][j]的含义为：至少的血量，并且这个血量必须大于1。如果你到这的时候已经是1，那么至少就选1，如果你到这的血量小于1，那么此时的血量必须为1，。
     * 然后当地牢为一格的时候，dp = max(1, 1 - dungeon[0][0]); dungeon为正的时候dp取1，dungeon为负的时候，dp = 1 - dungeon;
     * 然后初始化最右侧和最下侧的地牢。
     * 然后就可以初始化其他层次。
     * dp[i][j] = Math.max(1, Math.min(dp[i+1][j], dp[i][j+1]) - dungeon[i][j]);
     */
    public int calculateMinimumHP(int[][] dungeon) {

        int m = dungeon.length;
        int n = dungeon[0].length;

        int[][] dp = new int[m][n];
        dp[m-1][n-1] = Math.max(1, 1 - dungeon[m-1][n-1]);
        for(int i = m - 2; i >= 0; i--){
            dp[i][n-1] = Math.max(1, dp[i+1][n-1] - dungeon[i][n-1]);
        }
        for(int i = n - 2; i >= 0; i--){
            dp[m-1][i] = Math.max(1, dp[m-1][i+1] - dungeon[m-1][i]);
        }

        for(int i = m - 2; i >= 0; i--){
            for(int j = n - 2; j >= 0; j--){
                int dpmin = Math.min(dp[i+1][j], dp[i][j+1]);
                dp[i][j] = Math.max(1, dpmin - dungeon[i][j]);
            }
        }
        return dp[0][0];
    }
}
