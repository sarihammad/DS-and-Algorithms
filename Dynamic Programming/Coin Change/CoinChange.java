// DP. dp[i] is the minimum number of coins to make up amount i. For any i, dp[i] = 1 + min{dp[i - coin]} for all coins. Return dp[amount].
public class CoinChange {
	public int coinChange(int[] coins, int amount) {
		int[] dp = new int[amount + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;

		for (int coin : coins) {
			for (int i = coin; i <= amount; i++) {
				if (dp[i - coin] != Integer.MAX_VALUE) {
					dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
				}
			}
		}
		return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
	}
}
