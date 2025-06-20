// DP: Subset sum on sum(nums) / 2. if subset exists, we can partition into two equal subsets.
public class PartitionEqualSubsetSum {
	public boolean canPartition(int[] nums) {
		int sum = Arrays.stream(nums).sum();
		if (sum % 2 == 1) return false;
		int target = sum / 2;

		boolean[] dp = new boolean[target + 1];
		dp[0] = true;
		for (int num : nums) {
			for (int i = target; i >= num; i--) { // go backward to avoid reusing num in the subset
				dp[i] = dp[i] || dp[i - num];
			}
		}
		return dp[target];
	}
}
