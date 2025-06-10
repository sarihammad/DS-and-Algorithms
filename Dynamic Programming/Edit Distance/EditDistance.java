// DP. dp[i][j] = min number of operations to convert word1[0..i-1] to word2[0..j-1].
//
// Think in terms of the last chars of each prefix.
// If they match, no operation needed. Cost = dp[i-1][j-1].
//
// If they don't match, consider 3 possible operations to reach the match:
//
// Replace: match word1[0..i-2] to word2[0..j-2], then replace word1[i-1] with word2[j-1]. Cost = dp[i-1][j-1] + 1
// Insert:  match word1[0..i-1] to word2[0..j-2], then insert word2[j-1] into word1. Cost = dp[i][j-1] + 1
// Delete:  match word1[0..i-2] to word2[0..j-1], then delete word1[i-1]. Cost = dp[i-1][j] + 1
//
// dp[i][j] = min of these 3 ops.
class EditDistance {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) dp[i][0] = i;
        for (int i = 0; i <= n; i++) dp[0][i] = i;
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) 
					dp[i][j] = dp[i - 1][j - 1];
                else 
					dp[i][j] = 1 + IntStream.of(dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1]).min().getAsInt();
            }
        }
        return dp[m][n];
    }
}
