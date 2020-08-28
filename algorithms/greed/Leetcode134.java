package greed;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: greed
 * @Author: elvis
 * @CreateTime: 2020-05-07 08:31
 * @Description: 加油站
 */
public class Leetcode134 {

    /**
     * 常规想法O(N^2)
     * 首先遍历一遍所有加油站 O(n)
     * 对于每一个加油站进行检测是否符合要求
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        for (int i = 0; i < gas.length; i++) {
            if (check(i, gas, cost, 0))
                return i;
        }
        return -1;
    }

    private boolean check(int i, int[] gas, int[] cost, int res) {
        for (int k = i; k < gas.length; k++) {
            if ((res += (gas[k] - cost[k])) < 0) return false;
            if ((k + 1) % gas.length == i) break;
            if (k == gas.length - 1) k = -1;
        }
        return true;
    }

    /**
     * 如果从A站不能到达B站　则A,B间的任何一站都不能到达B站　故从下一站继续开始
     * @param gas 油量
     * @param cost　消耗
     * @return　可以环绕一圈的起始站点
     */
    public int canCompleteCircuit2(int[] gas, int[] cost) {
        int n = gas.length;
        int total_tank = 0;
        int curr_tank = 0;
        int starting_station = 0;
        for (int i = 0; i < n; ++i) {
            total_tank += gas[i] - cost[i];
            curr_tank += gas[i] - cost[i];
            // If one couldn't get here,
            if (curr_tank < 0) {
                // Pick up the next station as the starting one.
                starting_station = i + 1;
                // Start with an empty tank.
                curr_tank = 0;
            }
        }
        return total_tank >= 0 ? starting_station : -1;
    }

}
