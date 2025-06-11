// Bottom-up DP. Right shift (i >> 1) to get bit count of i / 2, and (i & 1) adds 1 if last bit is 1.
class CountingBits {
    public int[] countBits(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i >> 1] + (i & 1);
        }
        return dp;
    } 
}
