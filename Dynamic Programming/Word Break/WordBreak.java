// DP. dp[i] = true if s[:i] can be segmented into words which occurs if dp[j] is true for j < i and s[j:i] is a valid word. return dp[n].
public class WordBreak {
	public boolean wordBreak(String s, List<String> wordDict) {
		int n = s.length();
		Set<String> wordSet = new HashSet<>(wordDict);
		boolean[] dp = new boolean[n + 1];
		dp[0] = true;
		for (int i = 1; i <= n; i++) {
			for (int j = 0; j < i; j++) {
				if (dp[j] && wordSet.contains(s.substring(j, i))) {
					dp[i] = true;
					break;
				}
			}
		}
		return dp[n];
	}
}
