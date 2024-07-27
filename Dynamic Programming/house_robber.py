class Solution:
    # bottom up
    def rob(self, nums: List[int]) -> int:
        dp = {}
        dp[0] = nums[0]
        dp[1] = nums[1]
        n = len(nums)
        for i in range(2, n):
            dp[i] = max(dp[i-2] + nums[i], dp[i-1])
        return dp[n-1]
        
    
class Solution:
    # top down
    def rob(self, nums: List[int]) -> int:
        def dp(i, memo={}):
            if i in memo:
                return memo[i]
            if i == 0:
                memo[i] = nums[i]
            elif i == 1:
                memo[i] = max(nums[i], nums[i-1])
            else:
                memo[i] = max(dp(i-1), dp(i-2) + nums[i])

            return memo[i]

        n = len(nums)
        return dp(n-1)
