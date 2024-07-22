class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        dp = {}
        n = len(nums)
        dp[0] = nums[0]
        answer = nums[0]
        for i in range(1, n):
            dp[i] = max(nums[i], dp[i-1] + nums[i])
            answer = max(answer, dp[i])
        return answer
