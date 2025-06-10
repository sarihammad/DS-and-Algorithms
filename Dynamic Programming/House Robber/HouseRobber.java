// DP. dp[i] is the most we can rob at i. dp[i] = max(dp[i - 1], dp[i - 2] + nums[i]).
//
// Space optimized: Store just last two to calcaulte current best.
public class HouseRobber {
	public static int rob(int[] nums) {
		if (nums.length == 0) return 0;
		if (nums.length == 1) return nums[0];

		int prev2 = nums[0];
		int prev1 = Math.max(nums[0], nums[1]);

		for (int i = 2; i < nums.length; i++) {
			int curr = Math.max(prev1, prev2 + nums[i]);
			prev2 = prev1;
			prev1 = curr;
		}

		return prev1; 
	}
}
