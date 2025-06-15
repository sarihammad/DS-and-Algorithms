// dp problem. dp[i] = min. steps needed to reach stair i. we want dp[n] (cost of exitting array). dp[0] and dp[1] are free. Reaching step i takes min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]).
public class MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n + 1];
        dp[0] = 0; // free
        dp[1] = 0; // free
        for (int i = 2; i <= n; i++) {
            dp[i] = Math.min(dp[i - 2] + cost[i - 1], dp[i - 1] + cost[i - 1]);
        }

        return dp[n]; // cost of exiting array
    }
}
