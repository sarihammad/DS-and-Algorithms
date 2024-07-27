class Solution:
    # bottom up DP.
    def climbStairs(self, n: int) -> int:
        dp = [1, 2]
        for i in range(n-2):
            dp.append(dp[i] + dp[i+1])
        return dp[n-1]

class Solution:
    # top down DP: (combinatorial problem): 1 way from n-2 steps and 1 from n-1. reccurence: F(n) = F(n-2) + F(n-1)
    def climbStairs(self, n: int, memo={}) -> int:
        if n in memo:
            return memo[n]
        if n == 1:
            return 1
        elif n == 2:
            return 2
        memo[n] = self.climbStairs(n-2) + self.climbStairs(n-1)
        return memo[n]

