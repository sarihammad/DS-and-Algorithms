class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        answer = []
        def backtrack(curr, i):
            if i == len(nums):
                answer.append(curr)
                return
            backtrack(curr, i+1) # Exclude the current element
            backtrack(curr + [nums[i]], i+1) # Include the current element
        backtrack([], 0)
        return answer

