class Solution:
    def findTargetSumWays(self, nums: List[int], target: int) -> int:
        answer = 0
        def backtrack(curr, i):
            nonlocal answer
            if i == len(nums):
                if curr == 0:
                    answer += 1
                return
            backtrack(curr - nums[i], i + 1)
            backtrack(curr + nums[i], i + 1)
        backtrack(target, 0)
        return answer
        

