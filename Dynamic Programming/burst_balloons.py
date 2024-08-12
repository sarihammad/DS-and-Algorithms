class Solution:
    def maxCoins(self, nums: List[int]) -> int:
        nums = [1] + nums + [1]
        n = len(nums)
        dp = [[0] * n for i in range(n)]
        
        for length in range(2, n): 
            for left in range(n - length):
                right = left + length
                for i in range(left + 1, right):
                    # for each subarray, 
                    # dp = max(dp[left][i] + nums[left]*nums[i]*nums[right] + dp[i][right]) for each partition i between left and right
                    # Explanation: each i represents last balloon to be popped, dp[left][right] (best score) is
                    # dp[left][i] plus dp[i][right] (best scores from left and right which are already
                    # calculated) plus the score for popping the last balloon.
                    dp[left][right] = max(dp[left][right], 
                                          dp[left][i] + 
                                          nums[left] * nums[i] * nums[right] + 
                                          dp[i][right])
        
        return dp[0][n - 1]
